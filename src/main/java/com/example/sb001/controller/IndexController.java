package com.example.sb001.controller;

import com.example.sb001.model.User;
import com.example.sb001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        String username = (String) request.getSession().getAttribute(User.NAMESPACE);
        return "index";
    }
}