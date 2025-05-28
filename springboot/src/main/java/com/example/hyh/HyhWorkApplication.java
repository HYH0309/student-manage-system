package com.example.hyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@MapperScan("com.example.hyh.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HyhWorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(HyhWorkApplication.class, args);
    }

}