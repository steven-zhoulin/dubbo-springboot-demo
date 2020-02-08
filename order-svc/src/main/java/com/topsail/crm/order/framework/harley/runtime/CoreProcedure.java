package com.topsail.crm.order.framework.harley.runtime;

import com.asiainfo.areca.framework.util.SpringContextUtils;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.annotation.Processor;
import com.topsail.crm.order.framework.harley.config.BusiItemConfig;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.domain.order.OrderData;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;
import com.topsail.crm.order.framework.harley.exception.ArgumentException;
import com.topsail.crm.order.framework.harley.factory.ProcessorFactory;
import com.topsail.crm.order.framework.harley.factory.ScaKernelFactory;
import com.topsail.crm.order.framework.harley.interfaces.IBuildScaKernel;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: crm-V0
 * @description: 核心工序
 * @author: jinnian
 * @create: 2020-01-19 16:02
 **/
@Slf4j
public class CoreProcedure {

    private static Map<String, IBuildScaKernel> buildScaCache = new HashMap<String, IBuildScaKernel>();

    /**
     * 启动主要生产工作
     * @throws Exception
     */
    public void startProcess(UserRequestDTO userRequest) {
        //核心工序处理，负责完成dto->order的标准处理过程
        Databus databus = DatabusManager.getDatabus();
        JobContext jobContext = new JobContext(userRequest);
        OrderData orderData = databus.getOrderData();
        orderData.addLine(jobContext.getLineData());

        Class<? extends BaseProcessor> processorClass = ProcessorFactory.getOriginalProcessor(jobContext);
        Processor processorAnnotation = processorClass.getDeclaredAnnotation(Processor.class);
        String busiItemCode = "";
        int fetchType = processorAnnotation.fetchType();
        if (fetchType == 1) {
            busiItemCode = processorAnnotation.busiItemCode();
        } else if (fetchType == 2) {
            busiItemCode = userRequest.getBusiItemCode();
        }

        if (StringUtils.isBlank(busiItemCode)) {
            //todo 抛错
        }

        BusiItemConfig busiItemConfig = new BusiItemConfig(busiItemCode);
        jobContext.setBusiItemConfig(busiItemConfig);

        String busiCode = orderData.getOrder().getBusiCode();
        if (StringUtils.isBlank(busiCode)) {
            orderData.getOrder().setBusiCode(busiItemCode);
        }

        databus.addJobContext(jobContext);

        //第二步，初始化sca
        ScaKernel sca = this.initSca(userRequest, processorAnnotation);
        jobContext.setSca(sca);

        //第三步，处理，使用动态代理模式，处理器之后叠加可以配置的插件
        IProcessor processor = ProcessorFactory.getProcessor(jobContext);
        processor.process(jobContext);
    }

    /**
     * 初始化Sca的过程
     * @param userRequest
     * @return
     * @throws Exception
     */
    public ScaKernel initSca(UserRequestDTO userRequest, Processor processorAnnotation) {
        Class<? extends IBuildScaKernel> clazz = processorAnnotation.buildSca();
        String className = clazz.getName();
        IBuildScaKernel builder = null;
        if (buildScaCache.containsKey(className)) {
            builder = buildScaCache.get(className);
        } else {
            try {
                builder = clazz.newInstance();
                buildScaCache.put(className, builder);
            } catch (InstantiationException | IllegalAccessException e) {
                log.error("build sca class load error", e);
            }
        }

        return builder.build(userRequest);
    }
}
