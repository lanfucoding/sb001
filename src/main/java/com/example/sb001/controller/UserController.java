package com.example.sb001.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.sb001.model.FileCustom;
import com.example.sb001.model.Result;
import com.example.sb001.model.User;
import com.example.sb001.service.FileService;
import com.example.sb001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    static final String pre = "WEB-INF/jsp/";

    @Autowired
    UserService userService;

    @Autowired
    FileService fileService;


    @RequestMapping("/regist")
    public String regist(HttpServletRequest request, HttpServletResponse response, User user) throws Exception{
        System.out.println(user.getUsername()+"-------"+user.getPassword());
        if(user.getUsername() == null || user.getPassword() == null||user.getUsername().equals("")||user.getPassword().equals("")){
            request.setAttribute("msg", "请输入用户名和密码");
            return pre + "regist";
        }else{
            boolean isSuccess = userService.addUser(user);
            if(isSuccess){
                fileService.addNewNameSpace(request, user.getUsername());
                return pre + "login";
            }else{
                request.setAttribute("msg", "注册失败");
                return pre + "regist";
            }
        }
    }


    @RequestMapping("/searchFile")
    public @ResponseBody Result<List<FileCustom>> searchFile(String reg, String currentPath, String regType, HttpServletRequest request) {
        try {
            List<FileCustom> searchFile = fileService.searchFile(request,
                    currentPath, reg, regType);
            Result<List<FileCustom>> result = new Result<>(376, true, "查找成功");
            result.setData(searchFile);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(371, false, "查找失败");
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,User user){
        if(user.getUsername() ==null || user.getUsername().equals("") || user.getPassword() == null || user.getPassword().equals("")){
            return pre + "login";
        }
        User exsitUser = userService.findOne(user);
        if(exsitUser != null){
            HttpSession session = request.getSession();
            session.setAttribute(User.NAMESPACE,exsitUser.getUsername());
            session.setAttribute("totalSize",exsitUser.getTotalsize());
            return pre + "index";
        }else {
            request.setAttribute("msg","用户名或密码错误");
            return pre + "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/user/login";
    }
}
