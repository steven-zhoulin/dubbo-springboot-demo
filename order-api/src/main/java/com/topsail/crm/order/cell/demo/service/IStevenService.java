package com.topsail.crm.order.cell.demo.service;

import com.topsail.crm.order.cell.demo.entity.po.Steven;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
public interface IStevenService extends IService<Steven> {

    /**
     * 创建
     *
     * @param steven
     */
    boolean createOrder(Steven steven);
}
