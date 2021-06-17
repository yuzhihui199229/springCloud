package com.yuzh.springCloud.controller;

import com.yuzh.springCloud.pojo.Dept;
import com.yuzh.springCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/addDept")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/queryById/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/queryAll")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    //
    @GetMapping("/discover")
    public Object discover() {
        List<String> services = client.getServices();
        System.out.println("discover=>service:" + services);

        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
        }
        return this.client;
    }
}
