package com.youngtse.consumer.service;

import com.youngtse.common.domain.request.LoginRequest;
import com.youngtse.common.domain.response.CaptchaResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Title: AuthService
 * @Date 2023/5/17 23:10
 * @Author Youngtse
 */
public interface AuthService {

    String login(LoginRequest loginRequest);

    CaptchaResponse getCaptcha(HttpServletRequest request) throws IOException;
}
