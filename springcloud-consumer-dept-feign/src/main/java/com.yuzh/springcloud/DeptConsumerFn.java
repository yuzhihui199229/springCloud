package com.yuzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class DeptConsumerFn {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFn.class, args);
    }
}
