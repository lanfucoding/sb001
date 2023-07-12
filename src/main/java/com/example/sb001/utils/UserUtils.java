package com.example.sb001.utils;



import com.example.sb001.model.User;

import javax.servlet.http.HttpServletRequest;


public class UserUtils {
    public static String getUsername(HttpServletRequest request){
        return (String) request.getSession().getAttribute(User.NAMESPACE);
    }
}
