package com.youngtse.common.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @Title: LoginForm
 * @Date 2023/5/13 2:54
 * @Author LoginRequest
 * @Description: 登录请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("LoginRequest 用户登录参数")
public class LoginRequest {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "验证码", required = true)
    @NotEmpty(message = "验证码不能为空")
    private String captcha;

    @ApiModelProperty(value = "验证码令牌", required = true)
    @NotEmpty(message = "验证码令牌不能为空")
    private String captchaUuid;
}
