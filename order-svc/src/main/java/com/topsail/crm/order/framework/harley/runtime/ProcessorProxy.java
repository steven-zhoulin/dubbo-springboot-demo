package com.topsail.crm.order.framework.harley.runtime;

import com.asiainfo.areca.framework.util.ArrayUtils;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.factory.PlusFactory;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import com.topsail.crm.order.framework.harley.interfaces.IPlus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @program: crm-V0
 * @description: 动态代理对象，除执行核心业务逻辑后，在其后增加对插件的处理
 * @author: jinnian
 * @create: 2019-05-31 11:33
 **/
public class ProcessorProxy implements InvocationHandler {

    private IProcessor processor;

    public ProcessorProxy(IProcessor processor) {
        this.processor = processor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(this.processor, args);

        JobContext jobContext = (JobContext)args[0];
        List<IPlus> sections = PlusFactory.getProcessorPlugins(jobContext);

        if (ArrayUtils.isEmpty(sections)) {
            return null;
        }

        for (IPlus section : sections) {
            section.execute(jobContext);
        }
        return null;
    }
}
