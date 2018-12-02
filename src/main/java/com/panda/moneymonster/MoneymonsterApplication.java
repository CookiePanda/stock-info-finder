package com.panda.moneymonster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.panda.moneymonster.mapper")
public class MoneymonsterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneymonsterApplication.class, args);
    }
}
