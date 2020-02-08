package com.topsail.crm.order.business.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;

/**
 * @program: crm
 * @description: 用户订单相关业务服务
 * @author: jinnian
 * @create: 2020-01-20 14:38
 **/
public interface ISubscriberOrderService {

    OrderResponseDTO changePassword(OrderRequestDTO orderRequestDTO);
}
