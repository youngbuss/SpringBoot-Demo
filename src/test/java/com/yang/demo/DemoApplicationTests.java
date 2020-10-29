package com.yang.demo;

import com.yang.demo.dao.DepartmentMapper;
import com.yang.demo.dao.UserMapper;
import com.yang.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DepartmentMapper mapper;
    @Test
    void contextLoads() {
        User bubu = userMapper.queryUserByName("bubu");
        System.out.println(bubu);
        List<HashMap> getcounts = mapper.getcounts();

        Map<String,Long> counts = new HashMap<>();
        for (HashMap getcount : getcounts) {
            System.out.println(getcount);
            counts.put((String) getcount.get("departmentName"),(Long) getcount.get("c"));
        }
        System.out.println(counts.keySet());
        //System.out.println(getcounts.keySet());
    }

}
