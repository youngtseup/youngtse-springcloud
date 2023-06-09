package com.youngtse.common.domain.request.user;

import com.youngtse.common.domain.request.PageRequest;
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
@ApiModel("用户查询参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageRequest extends PageRequest {

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

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
