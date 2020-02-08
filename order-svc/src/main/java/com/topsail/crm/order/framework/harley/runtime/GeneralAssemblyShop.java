package com.topsail.crm.order.framework.harley.runtime;

import com.asiainfo.areca.framework.util.ArrayUtils;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: crm
 * @description: 订单总装车间，负责生产一条完整的订单数据
 * @author: jinnian
 * @create: 2020-01-20 09:53
 **/
@Component
public class GeneralAssemblyShop {

    /**
     * 开始生产工作，订单输入数据即为生产的原材料
     * @param request
     */
    public void startProduce(OrderRequestDTO request, OrderResponseDTO response) {
        this.startMainWork(request);

        //当主要订单数据完成后，开启弹性流水线的装配加工工作
        AssemblyLine assemblyLine = new AssemblyLine();
        assemblyLine.startFlexWork(request, response);
    }

    /**
     * 开始主生产车间的主要工作
     * @param request
     */
    public void startMainWork(OrderRequestDTO request) {
        List<UserRequestDTO> userRequests = request.getUserRequests();

        if (ArrayUtils.isNotEmpty(userRequests)) {
            for (UserRequestDTO userRequest : userRequests) {
                CoreProcedure workshop = new CoreProcedure();
                workshop.startProcess(userRequest);
            }
        }
    }
}
