package com.yuzh.springcloud.controller;

import com.yuzh.springCloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
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

    //wo men zhe li de di zhi shi yi ge bian liang
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/queryById/"+id, Dept.class);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/addDept", dept, Boolean.class);
    }

    @RequestMapping(value = "/list",method=RequestMethod.GET)
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/queryAll", List.class);
    }
}
