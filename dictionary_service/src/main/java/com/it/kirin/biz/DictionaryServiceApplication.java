package com.it.kirin.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.it.kirin.biz.mapper")
@EnableCaching
public class DictionaryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictionaryServiceApplication.class,args);
    }
}
