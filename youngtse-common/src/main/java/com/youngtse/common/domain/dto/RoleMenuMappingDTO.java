package com.youngtse.common.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Youngtse
 * @title RoleMenuMappingDto
 * @date 2023/6/12 17:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("角色菜单映射关系实体类")
public class RoleMenuMappingDTO {

    @ApiModelProperty(value = "菜单ID")
    private Long id;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;

    @ApiModelProperty(value = "路由URL")
    private String routerUrl;

    @ApiModelProperty(value = "上一级菜单ID")
    private Long pid;

    @ApiModelProperty(value = "菜单序号")
    private Integer sortNo;

    @ApiModelProperty(value = "菜单等级")
    private Integer menuLevel;

}
