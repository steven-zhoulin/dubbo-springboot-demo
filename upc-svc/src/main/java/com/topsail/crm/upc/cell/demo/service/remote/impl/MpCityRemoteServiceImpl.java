package com.topsail.crm.upc.cell.demo.service.remote.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.topsail.crm.upc.cell.demo.entity.po.MpCity;
import com.topsail.crm.upc.cell.demo.service.local.IMpCityService;
import com.topsail.crm.upc.cell.demo.service.remote.IMpCityRemoteService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Steven
 * @date 2020-01-10
 */
@Service(interfaceClass = IMpCityRemoteService.class)
public class MpCityRemoteServiceImpl implements IMpCityRemoteService {

    @Autowired
    IMpCityService mpCityService;

    @Override
    public MpCity selectOneByName(String name) {
        MpCity mpCity = mpCityService.getOne(
            Wrappers.<MpCity>lambdaQuery().eq(MpCity::getName, name)
        );
        return mpCity;
    }

}
