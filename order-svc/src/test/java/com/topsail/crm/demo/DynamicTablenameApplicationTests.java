package com.topsail.crm.demo;

import com.topsail.crm.order.OrderApplication;
import com.topsail.crm.order.cell.demo.entity.po.Steven;
import com.topsail.crm.order.cell.demo.mapper.StevenMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Steven
 * @date 2020-01-20
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DynamicTablenameApplicationTests {

    @Autowired
    private StevenMapper stevenMapper;

    @Test
    public void test() {
        // 自己去观察打印 SQL 目前随机访问 user_2018  user_2019 表
        for (int i = 0; i < 6; i++) {
            Steven steven = stevenMapper.selectById(1);
            System.err.println(steven.getName());
        }
    }
}
