package com.youngtse.common.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Youngtse
 * @title PageRequest
 * @date 2023/6/8 17:32
 * @description 分页查询参数
 */
@ApiModel(description = "分页查询参数")
@Data
public abstract class PageRequest {
    @ApiModelProperty(value = "当前页数", notes = "默认为1")
    private Integer page = 1;

    @ApiModelProperty(value = "每页行数", notes = "默认为20")
    private Integer row = 20;

    @ApiModelProperty(value = "起始值", hidden = true)
    private Integer offset;

    public Integer getOffset() {
        return (page - 1) * row;
    }

}
