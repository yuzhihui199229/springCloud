package com.yuzh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.yuzh.springcloud.mapper")
@EnableEurekaClient//auto register after the com.yuzh.springcloud.service start
@EnableDiscoveryClient
public class DeptApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptApplication8002.class, args);
    }
}
