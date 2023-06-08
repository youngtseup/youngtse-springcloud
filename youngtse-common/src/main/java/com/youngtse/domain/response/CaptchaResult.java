package com.youngtse.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: CaptchaResult
 * @Date 2023/5/17 23:24
 * @Author Youngtse
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "验证码返回实体类")
public class CaptchaResult {
    @ApiModelProperty(value = "验证码", notes = "base64编码")
    private String captcha;

    @ApiModelProperty(value = "验证码令牌")
    private String captchaUuid;
}
