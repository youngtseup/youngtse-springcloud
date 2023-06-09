package com.youngtse.consumer.controller;

import com.youngtse.common.domain.request.user.UserPageRequest;
import com.youngtse.common.domain.request.user.UserAddRequest;
import com.youngtse.common.domain.request.user.UserUpdateRequest;
import com.youngtse.common.domain.response.UserResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.domain.result.Result;
import com.youngtse.consumer.service.UserService;
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
 * @title SystemUserController
 * @date 2023/6/8 18:52
 * @description 用户模块
 */
@Api(tags = "用户模块")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping("/user/add")
    public Result addRole(@Validated @RequestBody UserAddRequest userAddRequest) {
        userService.addSystemUser(userAddRequest);
        return Result.success();
    }

    @ApiOperation("修改用户")
    @PostMapping("/user/modify")
    public Result modifyRole(@Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        userService.modifyUserByUserId(userUpdateRequest);
        return Result.success();
    }

    @ApiOperation("删除用户")
    @PostMapping("/user/delete/{userId}")
    public Result deleteRole(@PathVariable("userId") @NotEmpty(message = "用户id不能为空") Long userId) {
        userService.deleteUserByUserId(userId);
        return Result.success();
    }
    
    @PostMapping("/user/queryByCondition")
    @ApiOperation("用户查询")
    public Result queryByCondition(@RequestBody UserPageRequest userPageRequest) {
        Page<UserResponse> page = userService.querySystemUser(userPageRequest);
        return Result.success(page);
    }
    
}
