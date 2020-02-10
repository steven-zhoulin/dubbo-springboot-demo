package com.topsail.crm.order.framework.harley.factory;

import com.asiainfo.areca.framework.scan.ClassFinder;
import com.asiainfo.areca.framework.scan.IClassGenerator;
import com.asiainfo.areca.framework.util.SpringContextUtils;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.annotation.Processor;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import com.topsail.crm.order.framework.harley.runtime.BaseProcessor;
import com.topsail.crm.order.framework.harley.runtime.ProcessorProxy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: crm-v0
 * @description: 处理器工厂类
 * @author: jinnian
 * @create: 2019-05-31 10:59
 **/
@Slf4j
public class ProcessorFactory {

    private static Map<Class<? extends UserRequestDTO>, IProcessor> dtoMapping =  new HashMap<Class<? extends UserRequestDTO>, IProcessor>();

    private static Map<String, IProcessor> proxyClassCache = new HashMap<String, IProcessor>();

    private static Map<Class<? extends UserRequestDTO>, Class<? extends BaseProcessor>> dtoOriginalMapping = new HashMap<Class<? extends UserRequestDTO>, Class<? extends BaseProcessor>>();

    /**
     * 初始化业务处理器类
     */
    static {
        try {
            SpringContextUtils.getBean(ClassFinder.class).loadClasses("com.topsail.crm.order.business.order", "file:*Processor", new IClassGenerator() {
                @Override
                public void create(String className) throws Exception {
                    if (proxyClassCache.containsKey(className)) {
                        return;
                    }

                    Class clazz = Class.forName(className);
                    if (!BaseProcessor.class.isAssignableFrom(clazz)) {
                        return;
                    }
                    Processor processorAnnotation = (Processor)clazz.getDeclaredAnnotation(Processor.class);
                    if (processorAnnotation == null) {
                        return;
                    }

                    IProcessor instance = (IProcessor) clazz.newInstance();
                    ProcessorProxy proxy = new ProcessorProxy(instance);
                    IProcessor processor = (IProcessor) Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), proxy);

                    proxyClassCache.put(className, processor);

                    Class<? extends UserRequestDTO> dtoClass = processorAnnotation.dto();
                    dtoOriginalMapping.put(dtoClass, clazz);
                    dtoMapping.put(dtoClass, processor);
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
        UserRequestDTO dto = jobContext.getUserRequest();
        return dtoMapping.get(dto.getClass());
    }

    public static Class<? extends BaseProcessor> getOriginalProcessor(JobContext jobContext) {
        UserRequestDTO dto = jobContext.getUserRequest();
        return dtoOriginalMapping.get(dto.getClass());
    }
}