package com.youngtse.common.enums;

import com.youngtse.common.enums.common.CommonResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: AuthResultEnum
 * @Date 2023/5/13 2:31
 * @Author Youngtse
 * @Description: TODO
 */
@AllArgsConstructor
@Getter
public enum AuthResultEnum implements CommonResultEnum {
    LOGIN_FAIL("1000", "授权失败"),
    ACCESS_FAIL("1001", "认证失败"),
    USERNAME_IS_EMPTY("1002", "用户名不能为空"),
    PASSWORD_IS_EMPTY("1003", "密码不能为空"),
    CAPTCHA_IS_EMPTY("1004", "验证码不能为空"),
    CAPTCHA_EXPIRATION("1005", "验证码已失效"),
    CAPTCHA_ERROR("1006", "验证码错误"),
    TOKEN_EXPIRATION("1007", "身份已失效，请重新登录"),
    ;

    private String code;

    private String message;
}
