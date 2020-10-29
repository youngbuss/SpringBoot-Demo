package com.yang.demo.dao;

import com.yang.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User queryUserByName(String username);

}
