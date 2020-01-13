package com.topsail.crm.order.modules.user.task;

import com.topsail.crm.upc.modules.demo.entity.po.MpCity;
import com.topsail.crm.upc.modules.demo.entity.po.PmOfferCell;
import com.topsail.crm.upc.modules.demo.service.remote.IMpCityRemoteService;
import com.topsail.crm.upc.modules.demo.service.remote.IPmOfferCellRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Slf4j
@Component
public class DemoTask {

    @Reference
    IPmOfferCellRemoteService pmOfferCellRemoteService;

    @Reference
    IMpCityRemoteService mpCityRemoteService;

    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void scheduled() {
        List<PmOfferCell> pmOfferCells = pmOfferCellRemoteService.listByCellGroupCode("222");
        log.info("===========================");
        pmOfferCells.forEach(System.out::println);

        MpCity mpCity = mpCityRemoteService.selectOneByName("edaeec");
        log.info("通过远程服务查询: mpCity: {}", mpCity);
    }

}
