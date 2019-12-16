package com.topsail.upc;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Steven
 * @date 2019-12-16
 */
@EnableDubboConfiguration
@SpringBootApplication
public class UpcApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpcApplication.class, args);
    }
}
