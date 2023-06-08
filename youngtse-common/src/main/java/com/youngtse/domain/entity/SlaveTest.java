package com.youngtse.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: MasterTest
 * @Date 2023/4/30 1:43
 * @Author Youngtse
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("SlaveTest slave数据库测试信息")
public class SlaveTest {

    @ApiModelProperty(value = "主键")
    private int id;

    @ApiModelProperty(value = "slave内容")
    private String slaveContent;

}
