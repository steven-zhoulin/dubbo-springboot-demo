package com.topsail.crm.order.framework.harley.runtime;

import com.asiainfo.areca.framework.util.ArrayUtils;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.Scene;
import com.topsail.crm.order.framework.harley.factory.WorkstationFactory;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: crm
 * @description: 订单总装车间，负责生产一条完整的订单数据
 * @author: jinnian
 * @create: 2020-01-20 09:53
 **/
@Component
public class Workshop {

    /**
     * 开始生产工作，订单输入数据即为生产的原材料
     * @param request
     */
    public void startProduce(OrderRequestDTO request, OrderResponseDTO response) {
        List<UserRequestDTO> userRequests = request.getUserRequests();

        if (ArrayUtils.isNotEmpty(userRequests)) {
            for (UserRequestDTO userRequest : userRequests) {
                AssemblyLine line = new AssemblyLine();
                line.startWork(userRequest);
            }
        }

        //可装配工位的处理
        Databus databus = DatabusManager.getDatabus();
        Scene scene = databus.getScene();
        List<IWorkstation> workstations = WorkstationFactory.getSceneWorkstations(scene);
        if (ArrayUtils.isEmpty(workstations)) {
            return;
        }

        for (IWorkstation workstation : workstations) {
            workstation.operate(request, response);
        }

    }
}
