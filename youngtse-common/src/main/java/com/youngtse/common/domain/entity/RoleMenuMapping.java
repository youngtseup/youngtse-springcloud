package com.youngtse.common.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Youngtse
 * @title RoleMenuMapping
 * @date 2023/6/8 14:50
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "角色菜单映射实体类")
public class RoleMenuMapping {

    @ApiModelProperty(value = "映射ID")
    private Long id;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
