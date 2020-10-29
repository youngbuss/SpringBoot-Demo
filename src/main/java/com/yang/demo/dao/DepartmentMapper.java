package com.yang.demo.dao;

import com.yang.demo.pojo.Department;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DepartmentMapper {

     List<Department> getDepartments();

     Department  getDepartmentById(Integer id);


     List getcounts();
}
