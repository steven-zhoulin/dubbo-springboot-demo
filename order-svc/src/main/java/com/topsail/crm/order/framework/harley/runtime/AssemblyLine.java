package com.topsail.crm.order.framework.harley.runtime;

import com.asiainfo.areca.framework.util.ArrayUtils;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.Scene;
import com.topsail.crm.order.framework.harley.factory.WorkstationFactory;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;

import java.util.List;

/**
 * @program: crm
 * @description: 总装车间流水线
 * @author: jinnian
 * @create: 2020-02-07 15:58
 **/
public class AssemblyLine {

    /**
     * 柔性流水线工作，灵活装配工位进行数据加工
     * @param request
     * @param response
     */
    public void startFlexWork(OrderRequestDTO request, OrderResponseDTO response) {
        //可装配主线工位的处理
        Databus databus = DatabusManager.getDatabus();
        if (!databus.isFirstCommander()) {
            //如果不是入口指挥官，则所有工位先不处理
            return;
        }
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
