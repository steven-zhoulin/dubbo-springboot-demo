package com.topsail.crm.upc.cell.demo.service.remote;

import com.topsail.crm.upc.cell.demo.entity.po.MpCity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Steven.zhou
 * @since 2020-01-10
 */
public interface IMpCityRemoteService {

    MpCity selectOneByName(String name);
}
