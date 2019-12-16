package com.topsail.crm.upc;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Steven
 * @date 2019-12-16
 */
@EnableDubbo
@SpringBootApplication
public class UpcApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpcApplication.class, args);
    }
}
