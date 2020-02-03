package com.topsail.crm.order.framework.harley.factory;

import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.context.Scene;
import com.topsail.crm.order.framework.harley.interfaces.ISection;
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
public class SectionFactory {

    private static Map<String, ISection> cache = new HashMap<String, ISection>();

    static {
        try {

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
    public static List<ISection> getProcessorPlugins(JobContext jobContext) throws Exception {
        List<ISection> sections = new ArrayList<ISection>();
        Databus databus = DatabusManager.getDatabus();
        String busiItemCode = jobContext.getBusiItemConfig().getBusiItemCode();
        String firstBusiItemCode = databus.getFirstBusiItemCode();
        String channel = databus.getEnvironment().getChannel();
        Scene scene = databus.getScene();

        return sections;
    }
}
