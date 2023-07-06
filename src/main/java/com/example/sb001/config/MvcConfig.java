//package com.example.sb001.config;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
///**
// * @author liuyanzhao
// */
//@Slf4j
//@Configuration
//@EnableWebMvc
//public class MvcConfig implements WebMvcConfigurer {
//
//    @Bean
//    public InternalResourceViewResolver setupViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//
//}