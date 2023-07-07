package com.example.sb001.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RemoveActionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();

        // 去除后缀 ".action"
        if (requestURI.endsWith(".action")) {
            String newURI = requestURI.substring(0, requestURI.length() - 7); // 去除 ".action"
            request.getRequestDispatcher(newURI).forward(request, response);
            return false; // 终止后续的处理
        }

        return true; // 继续后续的处理
    }


}