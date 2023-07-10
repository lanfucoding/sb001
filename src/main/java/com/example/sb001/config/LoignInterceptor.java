package com.example.sb001.config;

import com.example.sb001.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoignInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String url = request.getRequestURI();

//        if (url.indexOf("login") >= 0 || url.indexOf("regist") >= 0 || url.indexOf("share") >= 0 || url.indexOf("getShareFiles") >= 0 || url.indexOf("download") >= 0 || url.indexOf("loginForApp") >= 0 || url.indexOf("getAppFiles") >= 0|| url.indexOf("uploadForApp") >= 0) {
//            return true;
//        }

        String username = (String) request.getSession().getAttribute(User.NAMESPACE);

        if (username != null) {
            return true;
        }

        response.sendRedirect("user/login");
        return true;
    }

}