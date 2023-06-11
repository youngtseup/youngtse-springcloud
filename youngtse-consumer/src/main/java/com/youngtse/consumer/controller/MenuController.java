package com.youngtse.consumer.controller;

import com.youngtse.common.domain.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: MenuController
 * @Date 2023/6/11 14:57
 * @Author Youngtse
 */
@RestController
@Api(tags = "菜单模块")
public class MenuController {


    @PostMapping("/menu/add")
    @ApiOperation("新增菜单")
    public Result addMenu() {
        return Result.success();
    }

    @PostMapping("/menu/delete/{menuId}")
    @ApiOperation("删除菜单")
    public Result deleteMenu(@PathVariable("menuId") Long menuId) {
        return Result.success();
    }

    @PostMapping("/menu/modify")
    @ApiOperation("修改菜单")
    public Result modifyMenu() {
        return Result.success();
    }

    @PostMapping("/menu/query")
    @ApiOperation("查询菜单")
    public Result queryMenu() {
        return Result.success();
    }
}
