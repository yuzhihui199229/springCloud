package com.yuzh.springCloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuzh.springCloud.DeptApplication;
import com.yuzh.springCloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper extends BaseMapper<Dept> {
    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
