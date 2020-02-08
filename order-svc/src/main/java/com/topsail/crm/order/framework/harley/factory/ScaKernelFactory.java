package com.topsail.crm.order.framework.harley.factory;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.topsail.crm.order.cell.user.entity.po.UmSubscriber;
import com.topsail.crm.order.cell.user.service.IUmSubscriberService;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: crm-V0
 * @description: 核心域三户模型构造工厂
 * @author: jinnian
 * @create: 2019-05-30 16:56
 **/
@Component
public class ScaKernelFactory {

    @Autowired
    private IUmSubscriberService subscriberService;

    public ScaKernel getScaKernel(String accessNum, String subscriberStatus) {
        ScaKernel sca = new ScaKernel();

        UmSubscriber subscriber = this.subscriberService.getOne(new QueryWrapper<UmSubscriber>().lambda().eq(UmSubscriber::getAccessNum, "3145870250"));
        sca.setSubscriber(subscriber);
        return sca;
    }

    public ScaKernel getScaKernel(Long subscriberInsId)  {
        ScaKernel sca = new ScaKernel();
        UmSubscriber subscriber = this.subscriberService.getById(subscriberInsId);
        sca.setSubscriber(subscriber);
        return sca;
    }

}
