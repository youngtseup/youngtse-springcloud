package com.youngtse.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youngtse.domain.constant.RedisPrefixConstant;
import com.youngtse.domain.result.Result;
import com.youngtse.enums.AuthResultEnum;
import com.youngtse.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @Title: JwtFilter
 * @Date 2023/5/24 21:55
 * @Author Youngtse
 * @Description: TODO
 */
@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${customize.jwtExpirationTime}")
    private Long jwtExpirationTime;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorization.replace("Bearer", "").trim();
        if (StringUtils.isEmpty(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        // 查询Token
        String tokenKey = RedisPrefixConstant.TOKEN_PREFIX + token;
        String secretKey = (String) redisTemplate.opsForValue().get(tokenKey);
        if (StringUtils.isEmpty(secretKey)) {
            buildExceptionResponse(response);
            return;
        }
        String username = JwtUtil.getUsername(token, secretKey);
        String onlineKey = RedisPrefixConstant.ONLINE_PREFIX + username;
        String oldTokenKey = (String) redisTemplate.opsForValue().get(onlineKey);
        if (StringUtils.isEmpty(oldTokenKey)) {
            buildExceptionResponse(response);
            return;
        }
        // 更新Token过期时间
        redisTemplate.expire(onlineKey, jwtExpirationTime, TimeUnit.MINUTES);
        redisTemplate.expire(tokenKey, jwtExpirationTime, TimeUnit.MINUTES);

        // 添加SecurityContextHolder的认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, token, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }

    private void buildExceptionResponse(HttpServletResponse response) throws IOException {
        Result result = Result.fail(AuthResultEnum.TOKEN_EXPIRATION);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
        writer.flush();
        writer.close();
    }
}