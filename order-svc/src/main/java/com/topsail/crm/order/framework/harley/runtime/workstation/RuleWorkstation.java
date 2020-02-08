package com.topsail.crm.order.framework.harley.runtime.workstation;

import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.framework.harley.annotation.Workstation;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: crm
 * @description: 规则工位
 * @author: jinnian
 * @create: 2020-01-20 10:24
 **/
@Slf4j
@Workstation
public class RuleWorkstation implements IWorkstation {

    @Override
    public void operate(OrderRequestDTO request, OrderResponseDTO response) {
        log.info("-------------规则调用---------------");
    }
}
