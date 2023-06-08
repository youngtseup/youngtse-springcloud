package com.youngtse.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Youngtse
 * @title User
 * @date 2023/4/28 10:51
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User 用户信息")
public class User {

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "年龄", required = true)
    private int age;
}
