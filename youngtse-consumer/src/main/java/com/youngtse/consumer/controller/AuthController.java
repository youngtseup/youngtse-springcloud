package com.youngtse.consumer.controller;

import com.youngtse.common.domain.request.LoginRequest;
import com.youngtse.common.domain.response.CaptchaResponse;
import com.youngtse.common.domain.result.Result;
import com.youngtse.consumer.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

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
        CaptchaResponse captchaResponse = authService.getCaptcha(request);
        return Result.success(captchaResponse);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("请求login参数：{}", loginRequest);
        String token = authService.login(loginRequest);
        return Result.success(token);
    }


}
