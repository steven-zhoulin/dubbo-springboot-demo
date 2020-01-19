package com.topsail.crm.upc.modules.demo.service.remote;

import com.topsail.crm.upc.modules.demo.entity.po.PmOfferCell;

import java.util.List;

/**
 * @author Steven
 * @date 2020-01-10
 */
public interface IPmOfferCellRemoteService {
    List<PmOfferCell> listByCellGroupCode(String cellGroupCode);
}
