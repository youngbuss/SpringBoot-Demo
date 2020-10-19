package com.yang.demo.dao;

import com.yang.demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public  interface EmployeeMapper {

    List<Employee> queryAll();

    Employee queryById(int id);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int id);
}
