package com.youngtse.common.domain.request.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * @author Youngtse
 * @title UpdateUserRequest
 * @date 2023/6/9 15:35
 */
public class UserUpdateRequest {

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "用户id不能为空")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "账户是否过期:0已过期,1未过期")
    private Integer accountNonExpired;

    @ApiModelProperty(value = "账户是否锁定:0已锁定,1未锁定")
    private Integer accountNonLocked;

    @ApiModelProperty(value = "密码是否过期:0已过期,1未过期")
    private Integer credentialsNonExpired;

    @ApiModelProperty(value = "账户是否可用:0不可用,1可用")
    private Integer enabled;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "个人信息ID")
    private Long personalInfoId;
}
