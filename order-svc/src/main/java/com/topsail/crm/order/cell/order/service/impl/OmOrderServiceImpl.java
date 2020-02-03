package com.topsail.crm.order.cell.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.topsail.crm.order.cell.order.entity.po.OmOrder;
import com.topsail.crm.order.cell.order.mapper.OmOrderMapper;
import com.topsail.crm.order.cell.order.service.IOmOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Slf4j
@Component
//@Service
public class OmOrderServiceImpl extends ServiceImpl<OmOrderMapper, OmOrder> implements IOmOrderService {

}
