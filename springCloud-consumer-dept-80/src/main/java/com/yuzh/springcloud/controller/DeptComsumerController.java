package com.yuzh.springcloud.controller;

import com.yuzh.springCloud.pojo.Dept;
import com.yuzh.springcloud.DeptConsumerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptComsumerController {
    //消费者：不应该有service层
    //restTemplate
    @Autowired
    private RestTemplate restTemplate;//提供多种间接访问http的方法，简单的restful服务模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/queryById/"+id, Dept.class);
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/addDept", dept, Boolean.class);
    }

    @RequestMapping("/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/queryAll", List.class);
    }
}
