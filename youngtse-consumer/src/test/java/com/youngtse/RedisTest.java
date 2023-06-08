package com.youngtse;

import io.lettuce.core.RedisURI;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Title: com.youngtse.RedisTest
 * @Date 2023/5/11 21:57
 * @Author Youngtse
 * @Description: TODO
 */
@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setTest() {
        redisTemplate.opsForValue().set("name", "youngtse");
    }

    @Test
    public void getTest() {
        String result = (String) redisTemplate.opsForValue().get("request");
        log.info(result);
    }

    @Test
    public void delTest() {
        redisTemplate.opsForValue().getOperations().delete("name");
        String result = (String) redisTemplate.opsForValue().get("name");
        log.info(result);
    }

    @Test
    public void voidStringTest() {
        String key = "name";
        String value = "youngtse";
        redisTemplate.opsForValue().set(key, value);
        String result = (String) redisTemplate.opsForValue().get(key);
        log.info(result);
    }

    @Test
    public void dbTest() {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) connectionFactory;
        int database = lettuceConnectionFactory.getStandaloneConfiguration().getDatabase();
        log.info("{}", database);
    }
}
