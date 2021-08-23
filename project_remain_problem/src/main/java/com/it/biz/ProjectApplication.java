package com.it.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.it.biz.mapper")
@EnableFeignClients
public class ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class,args);
    }
}
