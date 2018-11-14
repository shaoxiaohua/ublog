package com.ysm.ublog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ysm.ublog.mapper")
public class UblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(UblogApplication.class, args);
    }
}
