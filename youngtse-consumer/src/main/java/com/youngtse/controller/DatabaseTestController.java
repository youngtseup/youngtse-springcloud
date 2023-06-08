package com.youngtse.controller;

import com.youngtse.domain.entity.SlaveTest;
import com.youngtse.domain.result.Result;
import com.youngtse.mapper.slave.SlaveTestMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: DatabaseTestController
 * @Date 2023/4/30 1:59
 * @Author Youngtse
 * @Description: TODO
 */
@RestController
@Api(tags = "数据库测试模块")
public class DatabaseTestController {

    @Autowired
    private SlaveTestMapper slaveTestMapper;

    @PostMapping("/db/slaveTest/insert")
    @ApiOperation(value = "新增SlaveTest")
    public Result testInsertSlaveTest(@RequestBody SlaveTest slaveTest) {
        slaveTestMapper.insertSlaveTest(slaveTest);
        return Result.success();
    }

    @GetMapping("/db/slaveTest/query")
    @ApiOperation(value = "查询SlaveTest")
    public Result testGetSlaveTestById(@RequestParam("id") int id) {
        SlaveTest resultSlaveTest = slaveTestMapper.getSlaveTestById(id);
        return Result.success(resultSlaveTest);
    }

    @PostMapping("/db/slaveTest/update")
    @ApiOperation(value = "更新SlaveTest")
    public Result testUpdateSlaveTest(@RequestBody SlaveTest slaveTest) {
        slaveTestMapper.updateSlaveTest(slaveTest);
        return Result.success();
    }

    @PostMapping("/db/slaveTest/delete")
    @ApiOperation(value = "删除SlaveTest")
    public Result testDeleteSlaveTest(@RequestParam("id") int id) {
        slaveTestMapper.deleteSlaveTest(id);
        return Result.success();
    }
}
