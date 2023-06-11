package com.youngtse.consumer.controller;

import com.youngtse.common.domain.request.role.RoleAddRequest;
import com.youngtse.common.domain.request.role.RolePageRequest;
import com.youngtse.common.domain.request.role.RoleUpdateRequest;
import com.youngtse.common.domain.response.RoleResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.domain.result.Result;
import com.youngtse.consumer.service.RoleService;
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
 * @title RoleController
 * @date 2023/6/9 09:40
 * @description 角色模块
 */
@RestController
@Api(tags = "角色模块")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("新增角色")
    @PostMapping("/role/add")
    public Result addRole(@Validated @RequestBody RoleAddRequest roleAddRequest) {
        roleService.addSystemRole(roleAddRequest);
        return Result.success();
    }

    @ApiOperation("修改角色")
    @PostMapping("/role/modify")
    public Result modifyRole(@Validated @RequestBody RoleUpdateRequest roleUpdateRequest) {
        roleService.modifyRoleByRoleId(roleUpdateRequest);
        return Result.success();
    }

    @ApiOperation("删除角色")
    @PostMapping("/role/delete/{roleId}")
    public Result deleteRole(@PathVariable("roleId") @NotEmpty(message = "角色id不能为空") Long roleId) {
        roleService.deleteRoleByRoleId(roleId);
        return Result.success();
    }

    @ApiOperation("查询角色")
    @PostMapping("/role/query")
    public Result queryRoleList(@RequestBody RolePageRequest rolePageRequest) {
        Page<RoleResponse> page = roleService.queryList(rolePageRequest);
        return Result.success(page);
    }
}
