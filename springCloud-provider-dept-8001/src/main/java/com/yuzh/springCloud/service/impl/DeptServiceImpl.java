package com.yuzh.springCloud.service.impl;

import com.yuzh.springCloud.mapper.DeptMapper;
import com.yuzh.springCloud.pojo.Dept;
import com.yuzh.springCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptMapper.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
//        return deptMapper.selectList(null);
        return deptMapper.queryAll();
    }

}
