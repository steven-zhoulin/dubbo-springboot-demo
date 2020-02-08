package com.topsail.crm.order.framework.harley.annotation;

import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.interfaces.IBuildScaKernel;
import com.topsail.crm.order.framework.harley.runtime.BaseBuildScaKernel;

import java.lang.annotation.*;

/**
 * @program: crm
 * @description: 处理器注解
 * @author: jinnian
 * @create: 2020-02-07 14:08
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@Documented
public @interface Processor {

    /**
     * 业务类型
     * @return
     */
    String busiItemCode() default "-1";

    /**
     * 取业务类型的方式，1-从注解获取，2-从入参获取
     * @return
     */
    int fetchType() default 1;

    /**
     * 可以处理的DTO对象
     * @return
     */
    Class<? extends UserRequestDTO> dto();

    Class<? extends IBuildScaKernel> buildSca() default BaseBuildScaKernel.class;
}
