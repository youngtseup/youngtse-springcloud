package com.youngtse.consumer.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youngtse.common.domain.result.Result;
import com.youngtse.common.enums.AuthResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Title: MyAccessDeniedHandler
 * @Date 2023/5/24 21:54
 * @Author Youngtse
 * @Description: 处理security授权异常
 */
@Component
@Slf4j
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        log.error("MyAccessDeniedHandler occur AccessDeniedException:", e);
        Result result = Result.fail(AuthResultEnum.ACCESS_FAIL);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
        writer.flush();
        writer.close();
    }
}
