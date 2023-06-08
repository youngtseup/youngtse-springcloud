package com.youngtse.consumer.controller;

import com.youngtse.common.domain.entity.SystemUser;
import com.youngtse.common.domain.request.SystemUserRequest;
import com.youngtse.common.domain.response.SystemUserResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.domain.result.Result;
import com.youngtse.consumer.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Youngtse
 * @title SystemUserController
 * @date 2023/6/8 18:52
 * @description 用户模块
 */
@Api(tags = "用户模块")
@RestController
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    @PostMapping("/user/queryByCondition")
    @ApiOperation("用户查询")
    public Result queryByCondition(@RequestBody SystemUserRequest systemUserRequest) {
        Page<SystemUserResponse> page = systemUserService.querySystemUser(systemUserRequest);
        return Result.success(page);
    }
}
