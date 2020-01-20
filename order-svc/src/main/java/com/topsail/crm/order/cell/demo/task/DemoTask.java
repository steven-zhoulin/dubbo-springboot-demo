package com.topsail.crm.order.cell.demo.task;

import com.topsail.crm.upc.cell.demo.entity.po.PmOfferCell;
import com.topsail.crm.upc.cell.demo.service.remote.IPmOfferCellRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Steven
 * @date 2020-01-20
 */
@Component
@Slf4j
public class DemoTask {

    @Reference
    private IPmOfferCellRemoteService pmOfferCellRemoteService;

    @Scheduled(cron = "*/5 * * * * *")
    public void execute() {
        List<PmOfferCell> pmOfferCells = pmOfferCellRemoteService.listByCellGroupCode("212");
        System.out.println(pmOfferCells);
    }
}
