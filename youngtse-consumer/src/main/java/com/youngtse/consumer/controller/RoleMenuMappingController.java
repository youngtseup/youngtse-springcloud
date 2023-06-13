package com.youngtse.consumer.controller;

import com.youngtse.common.domain.request.menu.mapping.RoleMenuMappingRequest;
import com.youngtse.common.domain.response.RoleMenuMappingResponse;
import com.youngtse.common.domain.result.Result;
import com.youngtse.consumer.service.RoleMenuMappingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * @author Youngtse
 * @title RoleMenuMappingController
 * @date 2023/6/12 17:55
 */
@RestController
@Api(tags = "角色菜单映射模块")
public class RoleMenuMappingController {

    @Autowired
    private RoleMenuMappingService roleMenuMappingService;

    @ApiOperation(value = "更新角色菜单")
    @PostMapping("/role/menu/mapping/update")
    public Result updateRoleMenuMapping(@Validated @RequestBody RoleMenuMappingRequest roleMenuMappingRequest) {
        roleMenuMappingService.updateRoleMenuMapping(roleMenuMappingRequest);
        return Result.success();
    }

    @PostMapping("/role/menu/mapping/delete/{roleId}")
    @ApiOperation(value = "删除角色菜单")
    public Result deleteRoleMenuMapping(@PathVariable("roleId") @NotEmpty(message = "角色id不能为空") Long roleId) {
        roleMenuMappingService.deleteRoleMenuMapping(roleId);
        return Result.success();
    }

    @PostMapping("/role/menu/mapping/query/{roleId}")
    @ApiOperation(value = "查询角色菜单")
    public Result queryRoleMenuMapping(@PathVariable("roleId") @NotEmpty(message = "角色id不能为空") Long roleId) {
        RoleMenuMappingResponse roleMenuMappingResponse = roleMenuMappingService.queryRoleMenuMapping(roleId);
        return Result.success(roleMenuMappingResponse);
    }
}
