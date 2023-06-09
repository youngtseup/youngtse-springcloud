package com.youngtse.common.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Youngtse
 * @title SystemMenu
 * @date 2023/6/8 14:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "系统菜单实体类")
public class SystemMenu {

    @ApiModelProperty(value = "菜单ID")
    private Long id;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;

    @ApiModelProperty(value = "路由URL")
    private String routerUrl;

    @ApiModelProperty(value = "菜单描述")
    private String menuRemark;

    @ApiModelProperty(value = "上一级菜单ID")
    private Long pid;

    @ApiModelProperty(value = "菜单序号")
    private Integer sortNo;

    @ApiModelProperty(value = "菜单等级")
    private Integer menuLevel;

    @ApiModelProperty(value = "是否可用:0不可用,1可用")
    private Integer enabled;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;
}
