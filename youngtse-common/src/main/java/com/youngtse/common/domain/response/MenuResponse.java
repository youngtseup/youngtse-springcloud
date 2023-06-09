package com.youngtse.common.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: MenuResponse
 * @Date 2023/6/11 15:19
 * @Author Youngtse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("菜单查询返回实体类")
public class MenuResponse {

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
