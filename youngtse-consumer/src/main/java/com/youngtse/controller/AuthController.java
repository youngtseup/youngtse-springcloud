package com.youngtse.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.youngtse.domain.constant.RedisPrefixConstant;
import com.youngtse.domain.request.LoginForm;
import com.youngtse.domain.response.CaptchaResult;
import com.youngtse.domain.result.Result;
import com.youngtse.service.AuthService;
import com.youngtse.util.UuidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * @Title: AuthController
 * @Date 2023/5/12 0:51
 * @Author Youngtse
 * @Description: TODO
 */
@RestController
@Slf4j
@Api(tags = "用户认证模块")
public class AuthController {

    @Autowired
    private AuthService authService;


    @ApiOperation(value = "获取验证码", notes = "验证码有效时长为5分钟")
    @GetMapping("/captcha")
    public Result generateCaptcha(HttpServletRequest request) throws IOException {
        CaptchaResult captchaResult = authService.getCaptcha(request);
        return Result.success(captchaResult);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@Valid @RequestBody LoginForm loginForm) {
        log.info("请求login参数：{}", loginForm);
        String token = authService.login(loginForm);
        return Result.success(token);
    }


}
