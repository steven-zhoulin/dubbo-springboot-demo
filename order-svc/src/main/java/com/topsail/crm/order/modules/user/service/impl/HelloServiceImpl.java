package com.topsail.crm.order.modules.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.topsail.crm.order.modules.user.entity.po.User;
import com.topsail.crm.order.modules.user.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Service(interfaceClass = IUserService.class, version = "1.0.0")
@Component
public class HelloServiceImpl implements IUserService {

    /**
     * Say Hello
     *
     * @param name 名称
     * @return
     */
    @Override
    public User sayHello(String name) {
        return User.builder().id(1L).age(37).name("张三丰").build();
    }
}
