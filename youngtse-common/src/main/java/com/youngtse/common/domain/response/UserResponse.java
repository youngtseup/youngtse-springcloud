package com.youngtse.common.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Youngtse
 * @title SystemUserResponse
 * @date 2023/6/8 19:09
 */
@ApiModel("用户查询返回实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "账户是否过期:0已过期,1未过期")
    private Integer accountNonExpired;

    @ApiModelProperty(value = "账户是否锁定:0已锁定,1未锁定")
    private Integer accountNonLocked;

    @ApiModelProperty(value = "密码是否过期:0已过期,1未过期")
    private Integer credentialsNonExpired;

    @ApiModelProperty(value = "账户是否可用:0不可用,1可用")
    private Integer enabled;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "修改时间")
    private String modifyTime;

}
