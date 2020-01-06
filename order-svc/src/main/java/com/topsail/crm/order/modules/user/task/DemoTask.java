package com.topsail.crm.order.modules.user.task;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.topsail.crm.upc.modules.goods.entity.po.Goods;
import com.topsail.crm.upc.modules.goods.service.IGoodsService;
import com.topsail.crm.upc.modules.product.entity.po.Product;
import com.topsail.crm.upc.modules.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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

    @Scheduled(initialDelay = 10000, fixedRate = 20000)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void scheduled() {
        Product product = productService.selectById(RandomUtils.nextLong(1, 4));
        log.info("product: {}", product);

        LocalDateTime now = LocalDateTime.now();
        Goods goods = Goods.builder().createTime(now).enabled(true).goodClass(1).goodName("xxx").updateTime(now).build();
        goodsService.save(goods);

        Goods one = goodsService.getOne(
            Wrappers.<Goods>lambdaQuery().eq(Goods::getId, 1)
        );

        String content = "188";
        List<Goods> list = goodsService.list(
            Wrappers.<Goods>lambdaQuery()
                .like(StringUtils.isNotBlank(content), Goods::getGoodName, content)
                .gt(Goods::getCreateTime, LocalDateTime.now())
                .eq(Goods::getEnabled, true)

        );



    }

}
