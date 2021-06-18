package com.yuzh.springCloud.service;

import com.yuzh.springCloud.pojo.Dept;

public interface DeptClientService {
    Dept queryById(Long id);

    Dept queryAll();

    
}
