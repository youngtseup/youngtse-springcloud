package com.youngtse.consumer.controller;

import com.youngtse.common.domain.request.menu.MenuAddRequest;
import com.youngtse.common.domain.request.menu.MenuPageRequest;
import com.youngtse.common.domain.request.menu.MenuUpdateRequest;
import com.youngtse.common.domain.result.Result;
import com.youngtse.consumer.service.MenuService;
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
 * @Title: MenuController
 * @Date 2023/6/11 14:57
 * @Author Youngtse
 */
@RestController
@Api(tags = "菜单模块")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/menu/add")
    @ApiOperation("新增菜单")
    public Result addMenu(@Validated @RequestBody MenuAddRequest menuAddRequest) {
        menuService.addMenu(menuAddRequest);
        return Result.success();
    }

    @PostMapping("/menu/delete/{menuId}")
    @ApiOperation("删除菜单")
    public Result deleteMenu(@PathVariable("menuId") @NotEmpty(message = "菜单id不能为空") Long menuId) {
        menuService.deleteMenu(menuId);
        return Result.success();
    }

    @PostMapping("/menu/modify")
    @ApiOperation("修改菜单")
    public Result modifyMenu(@Validated @RequestBody MenuUpdateRequest menuUpdateRequest) {
        menuService.modifyMenu(menuUpdateRequest);
        return Result.success();
    }

    @PostMapping("/menu/query")
    @ApiOperation("查询菜单")
    public Result queryMenu(@Validated @RequestBody MenuPageRequest menuPageRequest) {
        menuService.queryMenu(menuPageRequest);
        return Result.success();
    }
}
