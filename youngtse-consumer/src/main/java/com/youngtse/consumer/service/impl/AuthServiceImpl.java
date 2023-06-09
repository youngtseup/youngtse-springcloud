package com.youngtse.consumer.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.youngtse.common.domain.constant.RedisPrefixConstant;
import com.youngtse.common.domain.request.LoginRequest;
import com.youngtse.common.domain.response.CaptchaResponse;
import com.youngtse.common.enums.AuthResultEnum;
import com.youngtse.common.exception.BusinessException;
import com.youngtse.consumer.service.AuthService;
import com.youngtse.common.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.youngtse.consumer.util.JwtUtil;

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
    public CaptchaResponse getCaptcha(HttpServletRequest request) throws IOException {
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
        CaptchaResponse captchaResponse = new CaptchaResponse(base64String, captchaUuid);
        return captchaResponse;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        // 检测验证码
        checkRightCaptcha(loginRequest.getCaptcha(), loginRequest.getCaptchaUuid());
        // security登录
        String username = loginRequest.getUsername();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword());
        authenticationManager.authenticate(authenticationToken);
        //生成JWT
        String onlineKey = RedisPrefixConstant.ONLINE_PREFIX + username;
        String secretKey = JwtUtil.generateSecretKey();
        String token = JwtUtil.generateToken(username, secretKey);
        // 将Token保存到Redis中
        String tokenKey = RedisPrefixConstant.TOKEN_PREFIX + token;
        redisTemplate.opsForValue().set(onlineKey, tokenKey, jwtExpirationTime, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(tokenKey, secretKey, jwtExpirationTime, TimeUnit.MINUTES);
        // 删除验证码
        String captchaKey = RedisPrefixConstant.CAPTCHA_PREFIX + loginRequest.getCaptchaUuid();
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
