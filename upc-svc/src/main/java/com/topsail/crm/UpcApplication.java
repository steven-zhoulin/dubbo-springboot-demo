package com.topsail.crm;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Steven
 * @date 2019-12-16
 */
@EnableDubbo
@SpringBootApplication(exclude = {MybatisPlusAutoConfiguration.class})
@DubboComponentScan(basePackages = "com.topsail.crm.upc")
public class UpcApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpcApplication.class, args);
    }
}
