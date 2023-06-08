package com.youngtse.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youngtse.domain.result.Result;
import com.youngtse.enums.AuthResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        log.error("occur AuthenticationException:", e);
        Result result = Result.fail(AuthResultEnum.LOGIN_FAIL);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
        writer.flush();
        writer.close();
    }
}
