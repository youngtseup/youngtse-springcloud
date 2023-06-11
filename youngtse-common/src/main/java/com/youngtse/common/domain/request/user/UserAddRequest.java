package com.youngtse.common.domain.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author Youngtse
 * @title AddUserRequest
 * @date 2023/6/9 15:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("新增用户参数")
public class UserAddRequest {

    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "账户是否锁定:0已过期,1未过期")
    @NotEmpty(message = "账户是否过期不能为空")
    @Max(value = 1, message = "账户是否锁定不能为0或1之外的值")
    @Min(value = 0, message = "账户是否锁定不能为0或1之外的值")
    private Integer accountNonExpired;

    @ApiModelProperty(value = "账户是否锁定:0已锁定,1未锁定")
    @NotEmpty(message = "账户是否锁定不能为空")
    @Max(value = 1, message = "账户是否锁定不能为0或1之外的值")
    @Min(value = 0, message = "账户是否锁定不能为0或1之外的值")
    private Integer accountNonLocked;

    @ApiModelProperty(value = "密码是否过期:0已过期,1未过期")
    @NotEmpty(message = "密码是否过期不能为空")
    @Max(value = 1, message = "密码是否过期不能为0或1之外的值")
    @Min(value = 0, message = "密码是否过期不能为0或1之外的值")
    private Integer credentialsNonExpired;

    @ApiModelProperty(value = "账户是否可用:0不可用,1可用")
    @NotEmpty(message = "账户是否可用不能为空")
    @Max(value = 1, message = "账户是否可用不能为0或1之外的值")
    @Min(value = 0, message = "账户是否可用不能为0或1之外的值")
    private Integer enabled;

    @ApiModelProperty(value = "角色id")
    @NotEmpty(message = "角色id不能为空")
    private Long roleId;

}
