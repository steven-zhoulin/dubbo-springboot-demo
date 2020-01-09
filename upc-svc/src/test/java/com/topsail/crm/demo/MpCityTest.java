package com.topsail.crm.demo;

import com.topsail.crm.UpcApplication;
import com.topsail.crm.upc.modules.demo.entity.po.MpCity;
import com.topsail.crm.upc.modules.demo.mapper.MpCityMapper;
import com.topsail.crm.upc.modules.demo.service.IMpCityService;
import com.topsail.crm.upc.modules.demo.service.impl.MpCityServiceImpl;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author Steven
 * @date 2020-01-08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UpcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MpCityTest {

    @Autowired
    private MpCityServiceImpl mpCityService;

    @Autowired
    private MpCityMapper mpCityMapper;

    @Test
    public void testSaveRandomCity() {
        LocalDateTime now = LocalDateTime.now();
        String cityName = RandomStringUtils.random(8, "ABCDEFGHIJKL");
        Boolean enabled = RandomUtils.nextBoolean();
        MpCity mpCity = MpCity.builder().createTime(now).updateTime(now).name(cityName).enabled(enabled).provinceId(1L).build();
        log.info("mpCity: {}", mpCity);
        boolean b = mpCityService.save(mpCity);
        //int b = mpCityMapper.insert(mpCity);
        log.info("插入随机城市名: [{}], {}", cityName, b);
    }

}
