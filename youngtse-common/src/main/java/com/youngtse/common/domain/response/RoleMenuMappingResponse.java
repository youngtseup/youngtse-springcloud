package com.youngtse.common.domain.response;

import com.youngtse.common.domain.RoleMenuMappingDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Youngtse
 * @title RoleMenuMappingResponse
 * @date 2023/6/12 17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("角色菜单映射返回实体类")
public class RoleMenuMappingResponse {

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色菜单映射")
    private List<RoleMenuMappingDto> menuList;
}
