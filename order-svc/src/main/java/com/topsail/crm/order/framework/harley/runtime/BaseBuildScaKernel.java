package com.topsail.crm.order.framework.harley.runtime;

import com.asiainfo.areca.framework.util.SpringContextUtils;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;
import com.topsail.crm.order.framework.harley.exception.ArgumentException;
import com.topsail.crm.order.framework.harley.factory.ScaKernelFactory;
import com.topsail.crm.order.framework.harley.interfaces.IBuildScaKernel;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: crm
 * @description: 常用构建sca的方法
 * @author: jinnian
 * @create: 2020-02-09 00:52
 **/
public class BaseBuildScaKernel implements IBuildScaKernel {
    @Override
    public ScaKernel build(UserRequestDTO request) {
        Long subscriberInsId = request.getSubscriberInsId();
        ScaKernelFactory scaKernelFactory = SpringContextUtils.getBean(ScaKernelFactory.class);
        if (subscriberInsId != null) {
            return scaKernelFactory.getScaKernel(subscriberInsId);
        }

        String accessNum = request.getAccessNum();
        String subscriberStatus = request.getSubscriberStatus();
        if (StringUtils.isNotBlank(accessNum)) {
            return scaKernelFactory.getScaKernel(accessNum, subscriberStatus);
        } else {
            throw new ArgumentException(ArgumentException.ArgumentErrorEnum.IS_MUST);
        }
    }
}
