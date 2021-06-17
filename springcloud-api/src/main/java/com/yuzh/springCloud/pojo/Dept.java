package com.yuzh.springCloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {//实体类   orm    mysql-->dept
    private Long deptno;//主键
    private String dname;//名称
    private String dbSource;//这个数据库存在那个数据库的字段，一个服务对应一个数据库，同一个信息 可能在不同的数据库

    public Dept(String dname) {
        this.dname = dname;
    }
}
