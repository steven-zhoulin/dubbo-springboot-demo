package com.topsail.crm.order.framework.harley.interfaces;

import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;

/**
 * @program: crm-V0
 * @description: 工位处理（不同工位可以对应于不同作业施工
 * @author: jinnian
 * @create: 2019-05-24 11:13
 **/
public interface IWorkstation {

    void operate(OrderRequestDTO request, OrderResponseDTO response);
}
