package com.topsail.crm.order.framework.harley.runtime.workstation;

import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: crm
 * @description: 数据库工位，将订单数据入库
 * @author: jinnian
 * @create: 2020-01-20 10:26
 **/
@Slf4j
public class OrderDatabaseWorkstation implements IWorkstation {

    @Override
    public void operate(OrderRequestDTO request, OrderResponseDTO response) {
        log.debug("-------------订单保存---------------");
    }
}
