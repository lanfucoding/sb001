package com.example.sb001.controller;

import com.example.sb001.model.User;
import com.example.sb001.service.FileService;
import com.example.sb001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    static final String pre = "WEB-INF/jsp";

    @Autowired
    UserService userService;

    @Autowired
    FileService fileService;


    @RequestMapping("/regist.action")
    public String regist(HttpServletRequest request, HttpServletResponse response, User user) throws Exception{
        System.out.println(user.getUsername()+"-------"+user.getPassword());
        if(user.getUsername() == null || user.getPassword() == null||user.getUsername().equals("")||user.getPassword().equals("")){
            request.setAttribute("msg", "请输入用户名和密码");
            return pre + "/regist";
        }else{
            boolean isSuccess = userService.addUser(user);
            if(isSuccess){
                fileService.addNewNameSpace(request, user.getUsername());
                return pre + "/login";
            }else{
                request.setAttribute("msg", "注册失败");
                return pre + "/regist";
            }
        }
    }
}
