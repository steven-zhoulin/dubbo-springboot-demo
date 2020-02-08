package com.topsail.crm.order.framework.harley.factory;

import com.asiainfo.areca.framework.scan.ClassFinder;
import com.asiainfo.areca.framework.scan.IClassGenerator;
import com.topsail.crm.order.framework.harley.annotation.Plus;
import com.topsail.crm.order.framework.harley.annotation.Workstation;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.context.Scene;
import com.topsail.crm.order.framework.harley.interfaces.IPlus;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: crm-V0
 * @description: 插件工厂类
 * @author: jinnian
 * @create: 2020-01-19 18:40
 **/
@Slf4j
@Component
public class PlusFactory {

    private static Map<String, IPlus> cache = new HashMap<String, IPlus>();

    static {
        try {
            ClassFinder.getInstance().loadClasses("com.topsail.crm.order", "file:*Plus", new IClassGenerator() {
                @Override
                public void create(String className) throws Exception {
                    if (cache.containsKey(className)) {
                        return;
                    }

                    Class clazz = Class.forName(className);
                    if (!IPlus.class.isAssignableFrom(clazz)) {
                        return;
                    }
                    Plus plusAnnotation = (Plus)clazz.getDeclaredAnnotation(Plus.class);
                    if (plusAnnotation == null) {
                        return;
                    }

                    IPlus instance = (IPlus) clazz.newInstance();
                    cache.put(className, instance);
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
            log.error("section config load error", e);
        }

    }

    /**
     * 获取处理器运行之后的插件
     * @param jobContext
     * @return
     * @throws Exception
     */
    public static List<IPlus> getProcessorPlugins(JobContext jobContext) throws Exception {
        List<IPlus> sections = new ArrayList<IPlus>();
        Databus databus = DatabusManager.getDatabus();
        String busiItemCode = jobContext.getBusiItemConfig().getBusiItemCode();
        String firstBusiItemCode = databus.getFirstBusiItemCode();
        String channel = databus.getEnvironment().getChannel();
        Scene scene = databus.getScene();

        return sections;
    }
}
