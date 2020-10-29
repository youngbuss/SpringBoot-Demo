package com.yang.demo.controller;

import com.yang.demo.dao.UserMapper;
import com.yang.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String name, @RequestParam("password") String pwd, HttpSession session, RedirectAttributes redirectAttributes){

        User user = userMapper.queryUserByName(name);
        if(user!=null){
            if(user.getPassword().equals(pwd)){
                session.setAttribute("loginUser",name);
                return "redirect:/main.html";
            }else {
                redirectAttributes.addFlashAttribute("mess","密码错误！");
                System.out.println("密码错误");
                return "redirect:/index.html";
            }
        }else {
            redirectAttributes.addFlashAttribute("mess","登录用户不存在！");
            System.out.println("用户不存在");
            return "redirect:/index.html";
        }


    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
