package com.yang.demo.dao;

import com.yang.demo.pojo.Department;
import com.yang.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中数据
    private static Map<Integer, Employee> employees =null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"BuBu","BuBu@163.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"HHH","HHH@163.com",1,new Department(102,"安保部")));
        employees.put(1003,new Employee(1003,"GGB","GGB@163.com",1,new Department(103,"后勤部")));
        employees.put(1004,new Employee(1004,"HRN","HRB@163.com",1,new Department(104,"行政部")));
        employees.put(1005,new Employee(1005,"JTT","JTT@163.com",1,new Department(105,"公关部")));
    }

    //主键自增
    private static  Integer initId= 1006;
    public void add(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }
    public void updateEmployeeById(Integer id,Employee employee){
        deleteEmployeeById(id);
        add(employee);
    }
}
