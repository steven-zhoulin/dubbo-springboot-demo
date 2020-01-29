package com.topsail.crm.upc.cell.demo.service.remote.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.topsail.crm.upc.cell.demo.entity.po.PmOfferCell;
import com.topsail.crm.upc.cell.demo.service.local.IPmOfferCellService;
import com.topsail.crm.upc.cell.demo.service.remote.IPmOfferCellRemoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Steven
 * @date 2020-01-10
 */
//@Service(interfaceClass = IPmOfferCellRemoteService.class)
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