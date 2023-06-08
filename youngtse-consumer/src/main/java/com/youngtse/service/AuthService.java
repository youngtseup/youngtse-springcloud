package com.youngtse.service;

import com.youngtse.domain.request.LoginForm;
import com.youngtse.domain.response.CaptchaResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Title: AuthService
 * @Date 2023/5/17 23:10
 * @Author Youngtse
 * @Description: TODO
 */
public interface AuthService {

    String login(LoginForm loginForm);

    CaptchaResult getCaptcha(HttpServletRequest request) throws IOException;
}
