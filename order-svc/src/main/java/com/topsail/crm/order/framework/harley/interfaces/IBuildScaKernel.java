package com.topsail.crm.order.framework.harley.interfaces;

import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;

/**
 * @program: crm
 * @description: 构造SCA接口类
 * @author: jinnian
 * @create: 2020-02-08 23:02
 **/
public interface IBuildScaKernel {

    /**
     * 构造SCA
     * @param request
     * @return
     */
    ScaKernel build(UserRequestDTO request);
}
