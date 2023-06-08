package com.youngtse.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Title: LoginForm
 * @Date 2023/5/13 2:54
 * @Author Youngtse
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户登录实体类")
public class LoginForm {

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
