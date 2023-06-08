package com.youngtse.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: UserAccount
 * @Date 2023/5/13 2:00
 * @Author Youngtse
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户账号实体类")
public class UserAccount {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "uuid", required = true)
    private String uuid;

    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "修改时间", required = true)
    private Date modifyTime;

    @ApiModelProperty(value = "角色表id")
    private Long roleId;
}
