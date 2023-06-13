package com.youngtse.common.domain.request.menu.mapping;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Youngtse
 * @title RoleMenuMappingRequest
 * @date 2023/6/12 17:35
 */
@ApiModel("新增或修改角色菜单映射参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenuMappingRequest {

    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Long roleId;

    @ApiModelProperty(value = "菜单id")
    @NotEmpty(message = "菜单id不能为空")
    private List<Integer> menuIdList;

}
