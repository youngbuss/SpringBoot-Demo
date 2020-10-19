package com.yang.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yang.demo.dao.DepartmentDao;
import com.yang.demo.dao.DepartmentMapper;
import com.yang.demo.dao.EmployeeDao;
import com.yang.demo.dao.EmployeeMapper;
import com.yang.demo.pojo.Department;
import com.yang.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;


    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employeeList = employeeMapper.queryAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        model.addAttribute("emps",employeeList);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAddpage(Model model){
        //查出部门信息
        List<Department> departmentList = departmentMapper.getDepartments();
        model.addAttribute("dep",departmentList);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String AddEmployee(Employee employee){
        //添加操作
        System.out.println(employee);
        
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toUpdatepage(Model model,@PathVariable("id")Integer id){
        System.out.println(id);
        Employee employee = employeeMapper.queryById(id);
        System.out.println(employee);
        List<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("employee",employee);
        model.addAttribute("dep",departments);
        return "/emp/update";
    }
    @PostMapping("/emp/update")
    public  String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeMapper.updateEmployee(employee);
        return "redirect:/emps";
    }
    @GetMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        System.out.println(id);
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";
    }
}
