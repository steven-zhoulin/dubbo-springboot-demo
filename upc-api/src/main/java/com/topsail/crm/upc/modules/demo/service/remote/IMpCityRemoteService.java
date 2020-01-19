package com.topsail.crm.upc.modules.demo.service.remote;

import com.baomidou.mybatisplus.extension.service.IService;
import com.topsail.crm.upc.modules.demo.entity.po.MpCity;

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
