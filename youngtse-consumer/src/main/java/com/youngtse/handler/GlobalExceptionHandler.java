package com.youngtse.handler;

import com.youngtse.domain.result.Result;
import com.youngtse.enums.AuthResultEnum;
import com.youngtse.enums.BaseResultEnum;
import com.youngtse.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Youngtse
 * @title GlobalExceptionHandler
 * @date 2023/4/28 16:44
 * @description TODO
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public Result doGlobalException(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            log.error("occur BusinessException: {}", businessException.getMessage());
            return Result.fail(businessException.getCode(), businessException.getMessage());
        } else {
            log.error("occur GlobalException:", e);
            return Result.fail(BaseResultEnum.ERROR);
        }
    }

    /**
     * validation 校验
     * @param methodArgumentNotValidException
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result MethodArgumentNotValidHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errorMessage.append(error.getDefaultMessage()).append(";");
        }
        log.error("occur MethodArgumentNotValidException: {}", errorMessage.toString());
        return Result.fail(errorMessage.toString());
    }

    /**
     * GET/POST请求方法错误的拦截器
     * 因为开发时可能比较常见,而且发生在进入controller之前,上面的拦截器拦截不到这个错误
     * 所以定义了这个拦截器
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodHandler() {
        log.error("occur HttpRequestMethodNotSupportedException: 请求方法错误");
        return Result.fail(BaseResultEnum.REQUEST_METHOD_ERROR);
    }

    /**
     * 处理SpringSecurity的认证异常
     */
    @ExceptionHandler(AuthenticationException.class)
    public Result authenticationExceptionHandler(AuthenticationException e) {
        log.error("occur AuthenticationException:", e);
        return Result.fail(AuthResultEnum.ACCESS_FAIL.getCode(), e.getMessage());
    }

    /**
     * 处理SpringSecurity的授权异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result accessDeniedExceptionHandler(AccessDeniedException e) {
        log.error("occur AccessDeniedException:", e);
        return Result.fail(AuthResultEnum.ACCESS_FAIL.getCode(), e.getMessage());
    }

}
