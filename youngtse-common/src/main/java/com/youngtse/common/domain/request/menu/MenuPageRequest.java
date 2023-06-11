package com.youngtse.common.domain.request.menu;

import com.youngtse.common.domain.request.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: MenuPageRequest
 * @Date 2023/6/11 15:12
 * @Author Youngtse
 */
@ApiModel("菜单查询参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPageRequest extends PageRequest {

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "上一级菜单ID")
    private Long pid;

    @ApiModelProperty(value = "菜单等级")
    private Integer menuLevel;

    @ApiModelProperty(value = "是否可用:0不可用,1可用")
    private Integer enabled;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
