package com.topsail.crm.order.modules.user.task;

import com.topsail.crm.upc.modules.demo.entity.po.MpCity;
import com.topsail.crm.upc.modules.demo.entity.po.MpProvince;
import com.topsail.crm.upc.modules.demo.service.IMpCityService;
import com.topsail.crm.upc.modules.demo.service.IMpProvinceService;
import com.topsail.crm.upc.modules.goods.service.IGoodsService;
import com.topsail.crm.upc.modules.product.entity.po.Product;
import com.topsail.crm.upc.modules.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Slf4j
@Component
public class DemoTask {

    @Reference(version = "1.0.0")
    IProductService productService;

    @Reference
    IGoodsService goodsService;

    @Reference
    IMpProvinceService mpProvinceService;

    @Reference
    IMpCityService mpCityService;

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void scheduled() {
        Product product = productService.selectById(RandomUtils.nextLong(1, 4));
        log.info("product: {}", product);

        LocalDateTime now = LocalDateTime.now();
//        Goods goods = Goods.builder().createTime(now).enabled(true).goodClass(1).goodName("xxx").updateTime(now).build();
//        goodsService.saveGoods(goods);
//
//        MpProvince mpProvince = MpProvince.builder().createTime(now).enabled(RandomUtils.nextBoolean()).name(RandomStringUtils.random(8)).updateTime(now).build();
//        mpProvinceService.save(mpProvince);

        String cityName = RandomStringUtils.random(8, "ABCDEFGHI");
        mpCityService.saveRandomCity(cityName);
    }

}
