package com.topsail.crm.order;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Steven
 * @date 2019-12-16
 */
@EnableScheduling
//@SpringBootApplication(exclude = {MybatisPlusAutoConfiguration.class, XADataSourceAutoConfiguration.class, DataSourceAutoConfiguration.class})
//@EnableDubbo
@SpringBootApplication(
    exclude = {MybatisPlusAutoConfiguration.class},
    scanBasePackages = {"com.asiainfo.areca.framework", "com.topsail.crm.order"}
)
//@DubboComponentScan(basePackages = "com.topsail.crm.order")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
