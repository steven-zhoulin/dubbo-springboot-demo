package com.topsail.crm.upc.cell.demo.service.remote;

import com.topsail.crm.upc.cell.demo.entity.po.PmOfferCell;

import java.util.List;

/**
 * @author Steven
 * @date 2020-01-10
 */
public interface IPmOfferCellRemoteService {
    List<PmOfferCell> listByCellGroupCode(String cellGroupCode);
}
