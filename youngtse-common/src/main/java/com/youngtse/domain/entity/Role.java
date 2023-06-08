package com.youngtse.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: Role
 * @Date 2023/5/18 23:04
 * @Author Youngtse
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "角色实体类")
public class Role {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "角色名")
    private String roleName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;
}
