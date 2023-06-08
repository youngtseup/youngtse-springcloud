package com.youngtse.consumer.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youngtse.common.domain.result.Result;
import com.youngtse.common.enums.AuthResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Title: MyAuthenticationEntryPointHandler
 * @Date 2023/5/24 21:52
 * @Author Youngtse
 * @Description: 处理security认证异常
 */
@Component
@Slf4j
public class MyAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    private static final String errorMessage = "Full authentication is required to access this resource";
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        log.error("MyAuthenticationEntryPointHandler occur AuthenticationException:", e);
        Result result = null;
        if (errorMessage.equals(e.getMessage())) {
            result = Result.fail(AuthResultEnum.ACCESS_FAIL);
        } else {
            result = Result.fail(AuthResultEnum.LOGIN_FAIL);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
        writer.flush();
        writer.close();
    }
}
