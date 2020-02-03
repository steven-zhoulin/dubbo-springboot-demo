package com.topsail.crm.order.framework.harley.factory;

import com.topsail.crm.order.business.order.changepassword.ChangePasswordProcessor;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: crm-jzh
 * @description: 处理器工厂类
 * @author: jinnian
 * @create: 2019-05-31 10:59
 **/
@Slf4j
public class ProcessorFactory {

    private static Map<String, IProcessor> cache =  new HashMap<String, IProcessor>();

    private static Map<Class, IProcessor> classCache = new HashMap<Class, IProcessor>();

    /**
     * 初始化业务处理器类
     */
    static {
        try {


        } catch (Exception e) {
            log.error("load assembly line processor config error", e);
        }
    }

    /**
     * 获取业务处理主要工序类
     * @param jobContext
     * @return
     * @throws Exception
     */
    public static IProcessor getProcessor(JobContext jobContext) {
        IProcessor processor = new ChangePasswordProcessor();
        return processor;
    }
}
