package com.yang.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.demo.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class UserController {

    @Autowired
    DepartmentMapper departmentMapper;
    @RequestMapping("/echarts")
    public String echarts(Model model){
        model.addAttribute("cap", "帽子");
        model.addAttribute("nums", 20);
        return "other/echart";
    }

    @RequestMapping("/echart")
    public String queryconut(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap> getcounts = departmentMapper.getcounts();
        String value = mapper.writeValueAsString(getcounts);

        Map<String,Long> counts = new HashMap<>();
        for (HashMap getcount : getcounts) {
            counts.put((String) getcount.get("departmentName"),(Long)getcount.get("c"));
        }
        model.addAttribute("value",counts);
        return "other/echart";
    }
}
