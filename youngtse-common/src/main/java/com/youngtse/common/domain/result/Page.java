package com.youngtse.common.domain.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Youngtse
 * @title Page
 * @date 2023/6/8 17:31
 * @description 分页参数返回值
 */
@ApiModel("分页参数返回值")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

    @ApiModelProperty("当前页数据")
    private List<T> list;

    @ApiModelProperty("总行数")
    private Integer count;

}
