package com.topsail.crm.order.cell.order.service.impl;

import com.topsail.crm.order.cell.order.entity.po.OmOrder;
import com.topsail.crm.order.cell.order.mapper.OmOrderMapper;
import com.topsail.crm.order.cell.order.service.IOmOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

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
@Service
public class OmOrderServiceImpl extends ServiceImpl<OmOrderMapper, OmOrder> implements IOmOrderService {

}
