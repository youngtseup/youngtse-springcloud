package com.youngtse.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Youngtse
 * @title MyConsumerApplication
 * @date 2023/4/27 18:19
 * @description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.youngtse.common.mapper")
public class MyConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyConsumerApplication.class, args);
    }
}
