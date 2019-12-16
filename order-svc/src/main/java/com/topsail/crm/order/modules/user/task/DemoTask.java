package com.topsail.crm.order.modules.user.task;

import com.topsail.crm.upc.modules.product.entity.po.Product;
import com.topsail.crm.upc.modules.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Slf4j
@Component
public class DemoTask {

    @Reference(version = "1.0.0")
    IProductService productService;

    @Scheduled(initialDelay = 10000, fixedRate = 20000)
    public void scheduled() {
        Product product = productService.selectById(RandomUtils.nextLong(1, 4));
        log.info("product: {}", product);
    }

}
