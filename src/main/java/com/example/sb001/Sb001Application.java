package com.example.sb001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/sb001/mapper")
public class Sb001Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb001Application.class, args);
    }

}
