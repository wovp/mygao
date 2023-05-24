package com.gao.mygao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 11
 */
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@MapperScan(basePackages = "com.gao.mygao.mapper")
public class MygaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MygaoApplication.class, args);
    }

}
