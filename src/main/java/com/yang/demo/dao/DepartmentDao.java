package com.yang.demo.dao;

import com.yang.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    //模拟数据库中数据
    private static Map<Integer,Department> departments = null;

    static {
        departments = new HashMap<>(); //创建一个部门表

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"安保部"));
        departments.put(103,new Department(103,"后勤部"));
        departments.put(104,new Department(104,"行政部"));
        departments.put(105,new Department(105,"公关部"));
    }

    //模拟数据库
    //获取所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //通过id获取部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
