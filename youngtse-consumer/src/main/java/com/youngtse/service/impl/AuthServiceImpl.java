package com.youngtse.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.youngtse.domain.constant.RedisPrefixConstant;
import com.youngtse.domain.request.LoginForm;
import com.youngtse.domain.response.CaptchaResult;
import com.youngtse.enums.AuthResultEnum;
import com.youngtse.exception.BusinessException;
import com.youngtse.service.AuthService;
import com.youngtse.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import util.JwtUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * @Title: AuthServiceImpl
 * @Date 2023/5/17 23:16
 * @Author Youngtse
 * @Description: TODO
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DefaultKaptcha captchaProducer;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${customize.captchaExpirationTime}")
    private Long captchaExpirationTime;

    @Value("${customize.jwtExpirationTime}")
    private Long jwtExpirationTime;


    @Override
    public CaptchaResult getCaptcha(HttpServletRequest request) throws IOException {
        // 生成随机验证码文本
        String captchaText = captchaProducer.createText();
        // 验证码令牌
        String captchaUuid = UuidUtil.randomUUID32();

        String captchaKey = RedisPrefixConstant.CAPTCHA_PREFIX + captchaUuid;

        while (!redisTemplate.opsForValue().setIfAbsent(captchaKey, captchaText, captchaExpirationTime, TimeUnit.MINUTES)) {
            captchaText = captchaProducer.createText();
            captchaUuid = UuidUtil.randomUUID32();
            captchaKey = RedisPrefixConstant.CAPTCHA_PREFIX + captchaUuid;
        }
        log.info("#generateCaptcha生成验证码:{} 存入缓存key:{} value:{} timeout:{}min", captchaText, captchaKey, captchaText, captchaExpirationTime);

        // 将验证码文本保存到Session中，以便后续验证
        HttpSession session = request.getSession();
        session.setAttribute("captcha", captchaText);

        // 创建验证码图片
        BufferedImage captchaImage = captchaProducer.createImage(captchaText);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // 将验证码图片写入流
        ImageIO.write(captchaImage, "jpg", stream);
        stream.flush();
        byte[] imageBytes = stream.toByteArray();
        stream.close();
        String base64String = Base64.getEncoder().encodeToString(imageBytes);
        CaptchaResult captchaResult = new CaptchaResult(base64String, captchaUuid);
        return captchaResult;
    }

    @Override
    public String login(LoginForm loginForm) {
        // 检测验证码
        checkRightCaptcha(loginForm.getCaptcha(), loginForm.getCaptchaUuid());
        // security登录
        String username = loginForm.getUsername();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, loginForm.getPassword());
        authenticationManager.authenticate(authenticationToken);
        String token = null;
        // 存在已登录的用户直接返回对应的Token并更新时间
        boolean hasOnline = false;
        boolean hasToken = false;
        String onlineKey = RedisPrefixConstant.ONLINE_PREFIX + username;
        String oldTokenKey = (String) redisTemplate.opsForValue().get(onlineKey);
        if (StringUtils.isNotEmpty(oldTokenKey)) {
            hasOnline = true;
            String oldSecretKey = (String) redisTemplate.opsForValue().get(oldTokenKey);
            if (StringUtils.isNotEmpty(oldSecretKey)) {
                hasToken = true;
            }
        }
        if (hasOnline && hasToken) {
            redisTemplate.expire(onlineKey, jwtExpirationTime, TimeUnit.MINUTES);
            redisTemplate.expire(oldTokenKey, jwtExpirationTime, TimeUnit.MINUTES);
            token = oldTokenKey.replace(RedisPrefixConstant.TOKEN_PREFIX, "");
        } else {
            //生成JWT
            String secretKey = JwtUtil.generateSecretKey();
            token = JwtUtil.generateToken(username, secretKey);
            // 将Token保存到Redis中
            String tokenKey = RedisPrefixConstant.TOKEN_PREFIX + token;
            redisTemplate.opsForValue().set(onlineKey, tokenKey, jwtExpirationTime, TimeUnit.MINUTES);
            redisTemplate.opsForValue().set(tokenKey, secretKey, jwtExpirationTime, TimeUnit.MINUTES);
        }
        // 删除验证码
        String captchaKey = RedisPrefixConstant.CAPTCHA_PREFIX + loginForm.getCaptchaUuid();
        redisTemplate.delete(captchaKey);

        return token;

    }


    public void checkRightCaptcha(String captcha, String captchaUuid) {
        String captchaKey = RedisPrefixConstant.CAPTCHA_PREFIX + captchaUuid;
        String captchaText = (String) redisTemplate.opsForValue().get(captchaKey);
        if (StringUtils.isEmpty(captchaText)) {
            throw new BusinessException(AuthResultEnum.CAPTCHA_EXPIRATION);
        }
        if (!captcha.equalsIgnoreCase(captchaText)) {
            throw new BusinessException(AuthResultEnum.CAPTCHA_ERROR);
        }
    }

}
