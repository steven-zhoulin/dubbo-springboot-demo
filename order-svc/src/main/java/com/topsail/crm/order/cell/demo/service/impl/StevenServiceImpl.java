package com.topsail.crm.order.cell.demo.service.impl;

import com.asiainfo.areca.framework.database.service.IDualService;
import com.asiainfo.areca.framework.threadlocal.RequestTimeHolder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.topsail.crm.order.cell.demo.entity.po.Steven;
import com.topsail.crm.order.cell.demo.mapper.StevenMapper;
import com.topsail.crm.order.cell.demo.service.IStevenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Slf4j
@Service
public class StevenServiceImpl extends ServiceImpl<StevenMapper, Steven> implements IStevenService {

    @Autowired
    private IDualService dualService;

    @Override
    public boolean createOrder(Steven steven) {

        // 获取序列，指定数据源名称 + 序列名
        Long nextval = dualService.nextval("crm1", "OM_ORDER$SEQ");
        Long id = Long.parseLong(RequestTimeHolder.getRequestTime("yyyyMMdd") + nextval);

        log.info("id: {}", id);

        steven.setId(id);
        return save(steven);
    }
}
