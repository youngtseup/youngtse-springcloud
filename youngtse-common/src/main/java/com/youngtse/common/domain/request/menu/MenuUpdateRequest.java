package com.youngtse.common.domain.request.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @Title: UpdateMenuRequest
 * @Date 2023/6/11 15:12
 * @Author Youngtse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "修改菜单参数")
public class MenuUpdateRequest {

    @NotEmpty(message = "菜单id不能为空")
    @ApiModelProperty(value = "菜单ID")
    private Long id;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;

    @NotEmpty(message = "路由URL不能为空")
    @ApiModelProperty(value = "路由URL")
    private String routerUrl;

    @ApiModelProperty(value = "菜单描述")
    private String menuRemark;


    @ApiModelProperty(value = "上一级菜单ID", notes = "一级菜单请填入0")
    private Long pid;

    @ApiModelProperty(value = "菜单序号")
    private Integer sortNo;


    @ApiModelProperty(value = "菜单等级")
    private Integer menuLevel;


    @ApiModelProperty(value = "是否可用:0不可用,1可用")
    private Integer enabled;
}
