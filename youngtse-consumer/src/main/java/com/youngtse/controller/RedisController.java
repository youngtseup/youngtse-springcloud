package com.youngtse.controller;

import com.youngtse.domain.request.RedisKeyValue;
import com.youngtse.domain.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Title: RedisController
 * @Date 2023/4/30 16:30
 * @Author Youngtse
 * @Description: TODO
 */
@RestController
@Api(tags = "redis测试")
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("保存key-value")
    @PostMapping("/redis/save/keyValue")
    public Result saveRedis(@RequestBody RedisKeyValue redisKeyValue) {
        log.info("RedisController#saveRedis param={}", redisKeyValue);
        redisTemplate.opsForValue().set(redisKeyValue.getKey(), redisKeyValue.getValue(), 1, TimeUnit.MINUTES);
        return Result.success();
    }

    @ApiOperation("获取value")
    @GetMapping("/redis/getValue")
    public Result getRedis(@RequestParam("key") String key) {
        log.info("RedisController#getRedis param={}", key);
        String value = (String) redisTemplate.opsForValue().get(key);
        RedisKeyValue redisKeyValue = new RedisKeyValue(key, value);
        return Result.success(redisKeyValue);
    }
}
