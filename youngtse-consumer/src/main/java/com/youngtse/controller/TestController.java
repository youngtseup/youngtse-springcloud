package com.youngtse.controller;

import com.youngtse.domain.User;
import com.youngtse.domain.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @author Youngtse
 * @title TestController
 * @date 2023/4/27 18:20
 * @description TODO
 */
@Api(tags = "测试模块")
@RestController
@Slf4j
public class TestController {

    @ApiOperation(value = "get测试")
    @GetMapping("/api/getTest")
    public Result getTest(@RequestParam int id) {
        log.info("TestController#getTest params={}", id);
        return Result.success(String.format("你输入的id是%s", id));
    }

    @ApiOperation(value = "path测试")
    @GetMapping("/api/pathTest/{id}")
    public Result getTest(@PathVariable("id") String id) {
        return Result.success();
    }

    @ApiOperation(value = "post测试")
    @PostMapping("/api/postTest")
    public Result postTest(@RequestBody User user) {
        return Result.success(user);
    }
}
