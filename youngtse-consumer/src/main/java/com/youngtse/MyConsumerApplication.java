package com.youngtse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Youngtse
 * @title MyConsumerApplication
 * @date 2023/4/27 18:19
 * @description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MyConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyConsumerApplication.class, args);
    }
}
