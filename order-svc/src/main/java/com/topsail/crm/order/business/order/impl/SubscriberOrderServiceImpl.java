package com.topsail.crm.order.business.order.impl;

import com.topsail.crm.order.business.order.ISubscriberOrderService;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.framework.harley.Commander;
import org.springframework.stereotype.Component;

/**
 * @program: crm
 * @description:
 * @author: jinnian
 * @create: 2020-01-20 16:00
 **/
@Component
public class SubscriberOrderServiceImpl implements ISubscriberOrderService {
    @Override
    public OrderResponseDTO changePassword(OrderRequestDTO orderRequestDTO) {
        return new Commander(orderRequestDTO).execute();
    }
}
