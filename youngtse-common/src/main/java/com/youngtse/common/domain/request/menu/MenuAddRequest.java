package com.youngtse.common.domain.request.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @Title: AddMenuRequest
 * @Date 2023/6/11 15:11
 * @Author Youngtse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "新增菜单参数")
public class MenuAddRequest {

    @NotEmpty(message = "菜单名称不能为空")
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;

    @NotEmpty(message = "路由URL不能为空")
    @ApiModelProperty(value = "路由URL")
    private String routerUrl;

    @ApiModelProperty(value = "菜单描述")
    private String menuRemark;

    @NotEmpty(message = "上一级菜单ID不能为空")
    @ApiModelProperty(value = "上一级菜单ID", notes = "一级菜单请填入0")
    private Long pid;

    @ApiModelProperty(value = "菜单序号")
    private Integer sortNo;

    @NotEmpty(message = "菜单等级不能为空")
    @ApiModelProperty(value = "菜单等级")
    private Integer menuLevel;

    @NotEmpty(message = "菜单是否可用不能为空")
    @ApiModelProperty(value = "是否可用:0不可用,1可用")
    private Integer enabled;

}
