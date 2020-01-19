package com.topsail.crm.upc.modules.demo.service.remote.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.topsail.crm.upc.modules.demo.entity.po.PmOfferCell;
import com.topsail.crm.upc.modules.demo.service.remote.IPmOfferCellRemoteService;
import com.topsail.crm.upc.modules.demo.service.local.IPmOfferCellService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Steven
 * @date 2020-01-10
 */
@Service(interfaceClass = IPmOfferCellRemoteService.class)
public class PmOfferCellRemoteServiceImpl implements IPmOfferCellRemoteService {

    @Autowired
    private IPmOfferCellService pmOfferCellService;

    @Override
    public List<PmOfferCell> listByCellGroupCode(String cellGroupCode) {
        List<PmOfferCell> pmOfferCells = pmOfferCellService.list(
            Wrappers.<PmOfferCell>lambdaQuery().eq(PmOfferCell::getCellGroupCode, cellGroupCode)
        );
        return pmOfferCells;
    }

}