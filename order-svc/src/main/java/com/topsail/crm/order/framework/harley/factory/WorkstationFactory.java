package com.topsail.crm.order.framework.harley.factory;

import com.asiainfo.areca.framework.scan.ClassFinder;
import com.asiainfo.areca.framework.scan.IClassGenerator;
import com.asiainfo.areca.framework.util.ArrayUtils;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.annotation.Processor;
import com.topsail.crm.order.framework.harley.annotation.Workstation;
import com.topsail.crm.order.framework.harley.constants.SceneTypeConst;
import com.topsail.crm.order.framework.harley.context.Scene;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;
import com.topsail.crm.order.framework.harley.runtime.BaseProcessor;
import com.topsail.crm.order.framework.harley.runtime.ProcessorProxy;
import com.topsail.crm.order.framework.harley.runtime.workstation.OrderDatabaseWorkstation;
import com.topsail.crm.order.framework.harley.runtime.workstation.RuleWorkstation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @program: crm-jzh
 * @description: 流水线上工位的构造工厂类，根据业务场景来进行装配
 * @author: jinnian
 * @create: 2019-05-29 14:56
 **/
@Slf4j
public class WorkstationFactory {

    private static Map<String, IWorkstation> workstationCache = new HashMap<>();

    static {
        try {
            ClassFinder.getInstance().loadClasses("com.topsail.crm.order", "file:*Workstation", new IClassGenerator() {
                @Override
                public void create(String className) throws Exception {
                    if (workstationCache.containsKey(className)) {
                        return;
                    }

                    Class clazz = Class.forName(className);
                    if (!IWorkstation.class.isAssignableFrom(clazz)) {
                        return;
                    }
                    Workstation workstationAnnotation = (Workstation)clazz.getDeclaredAnnotation(Workstation.class);
                    if (workstationAnnotation == null) {
                        return;
                    }

                    IWorkstation instance = (IWorkstation) clazz.newInstance();
                    workstationCache.put(className, instance);
                }

                /**
                 * 指定模糊匹配的jar文件名，开发模式不需要
                 * @return
                 */
                @Override
                public String[] getJars() {
                    return null;
                }
            });
        } catch (Exception e) {
            log.error("workstation config error", e);
        }

    }

    /**
     * 根据业务场景通过配置获取所需要的流水线工位
     * @param scene
     * @return
     * @throws Exception
     */
    public static List<IWorkstation> getSceneWorkstations(Scene scene) {
        String sceneType = scene.getSceneType();

        Collection<IWorkstation> workstations = workstationCache.values();
        if (workstations == null || workstations.size() <= 0) {
            return null;
        }

        for (IWorkstation workstation : workstations) {
            //todo 计算匹配场景的工位
        }


        return Arrays.asList(workstations.toArray(new IWorkstation[0]));
    }
}
