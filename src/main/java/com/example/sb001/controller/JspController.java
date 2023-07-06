package com.example.sb001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    @RequestMapping("/jsp")
    public String jsp(Model model){
        return "index";
    }
}