package com.topsail.crm.order.framework.harley.runtime;

import com.asiainfo.areca.framework.util.SpringContextUtils;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;
import com.topsail.crm.order.framework.harley.exception.ArgumentException;
import com.topsail.crm.order.framework.harley.factory.ProcessorFactory;
import com.topsail.crm.order.framework.harley.factory.ScaKernelFactory;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: crm-V0
 * @description: 流水线，生产线上有核心处理和可配置的插件，每个步骤执行自己特定的有业务意义的工序动作
 * @author: jinnian
 * @create: 2020-01-19 16:02
 **/
public class AssemblyLine {

    /**
     * 启动流水线，其中processor可以看成是一个特殊的工位，是必须经过的核心处理
     * @throws Exception
     */
    public void startWork(UserRequestDTO userRequest) {
        //流水线核心工位处理，负责完成map->vo,vo->order的标准处理过程
        Databus databus = DatabusManager.getDatabus();
        JobContext jobContext = new JobContext(userRequest);
        databus.addJobContext(jobContext);

        //第一步，初始化
        ScaKernel sca = this.initSca(userRequest);
        jobContext.setSca(sca);

        //第二步，处理，使用动态代理模式，处理器之后叠加可以配置的插件
        IProcessor processor = ProcessorFactory.getProcessor(jobContext);
        processor.process(jobContext);
    }

    /**
     * 初始化Sca的过程
     * @param userRequest
     * @return
     * @throws Exception
     */
    public ScaKernel initSca(UserRequestDTO userRequest) {
        Long subscriberInsId = userRequest.getSubscriberInsId();
        ScaKernelFactory scaKernelFactory = SpringContextUtils.getBean(ScaKernelFactory.class);
        if (subscriberInsId != null) {
            return scaKernelFactory.getScaKernel(subscriberInsId);
        }

        String accessNum = userRequest.getAccessNum();
        String subscriberStatus = userRequest.getSubscriberStatus();
        if (StringUtils.isNotBlank(accessNum)) {
            return scaKernelFactory.getScaKernel(accessNum, subscriberStatus);
        } else {
            throw new ArgumentException(ArgumentException.ArgumentErrorEnum.IS_MUST);
        }
    }
}
