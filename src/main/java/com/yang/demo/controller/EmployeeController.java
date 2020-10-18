package com.yang.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yang.demo.dao.DepartmentDao;
import com.yang.demo.dao.EmployeeDao;
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

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAddpage(Model model){
        //查出部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dep",departments);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String AddEmployee(Employee employee){
        //添加操作
        System.out.println(employee);
        employeeDao.add(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toUpdatepage(Model model,@PathVariable("id")Integer id){
        System.out.println(id);
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("employee",employee);
        model.addAttribute("dep",departments);
        return "/emp/update";
    }
    @PostMapping("/emp/update")
    public  String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.updateEmployeeById(employee.getId(),employee);
        return "redirect:/emps";
    }
    @GetMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        System.out.println(id);
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}
