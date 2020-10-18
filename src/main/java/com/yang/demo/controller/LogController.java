package com.yang.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LogController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String name, @RequestParam("password") String pwd, Model model, HttpSession session){
        if(name.equals("bubu")&&pwd.equals("123")){
            session.setAttribute("loginUser",name);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","登录名或者密码错误！");
            return "redirect:/index.html";
        }

    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
