package com.topsail.crm.order.framework.harley.factory;

import com.topsail.crm.order.framework.harley.constants.SceneTypeConst;
import com.topsail.crm.order.framework.harley.context.Scene;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;
import com.topsail.crm.order.framework.harley.runtime.workstation.OrderDatabaseWorkstation;
import com.topsail.crm.order.framework.harley.runtime.workstation.RuleWorkstation;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: crm-jzh
 * @description: 流水线上工位的构造工厂类，根据业务场景来进行装配
 * @author: jinnian
 * @create: 2019-05-29 14:56
 **/
public class WorkstationFactory {

    /**
     * 根据业务场景通过配置获取所需要的流水线工位
     * @param scene
     * @return
     * @throws Exception
     */
    public static List<IWorkstation> getSceneWorkstations(Scene scene) {

        List<IWorkstation> workstations = new ArrayList<>();

        String sceneType = scene.getSceneType();

        if(StringUtils.equals(SceneTypeConst.NORMAL, sceneType)) {

            RuleWorkstation ruler = new RuleWorkstation();
            workstations.add(ruler);

            OrderDatabaseWorkstation orderSaver = new OrderDatabaseWorkstation();
            workstations.add(orderSaver);
        }
        return workstations;
    }
}
