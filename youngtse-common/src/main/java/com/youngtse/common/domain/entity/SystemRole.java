package com.youngtse.common.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Youngtse
 * @title SystemRole
 * @date 2023/6/8 14:45
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "系统角色实体类")
public class SystemRole {

    @ApiModelProperty(value = "角色ID")
    private Long id;

    @ApiModelProperty(value = "角色UUID")
    private String roleUuid;

    @ApiModelProperty(value = "角色")
    private String roleSubject;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleRemark;

    @ApiModelProperty(value = "是否可用:0不可用,1可用")
    private Integer enabled;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;
}
