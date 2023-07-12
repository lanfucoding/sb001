package com.example.sb001.controller;

import com.example.sb001.model.User;
import com.example.sb001.service.UserService;
import com.example.sb001.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static com.example.sb001.controller.UserController.pre;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    /**
     * 主页面页面
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        String username = UserUtils.getUsername(request);
        String countSize = userService.getCountSize(username);
        request.setAttribute("countSize", countSize);
        return pre + "index";
    }
}