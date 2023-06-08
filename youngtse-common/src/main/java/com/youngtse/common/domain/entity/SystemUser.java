package com.youngtse.common.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Youngtse
 * @title SystemUser
 * @date 2023/6/8 14:43
 * @description 系统用户实体类
 */
@ApiModel(description = "系统用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser {

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "用户UUID")
    private String userUuid;

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

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "角色表ID")
    private Long roleId;

    @ApiModelProperty(value = "个人信息表ID")
    private Long personalInfoId;

}
