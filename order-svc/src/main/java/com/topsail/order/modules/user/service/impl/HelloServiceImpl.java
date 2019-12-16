package com.topsail.order.modules.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.topsail.order.modules.user.service.IHelloService;
import org.springframework.stereotype.Component;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Service(interfaceClass = IHelloService.class, version = "1.0.0")
@Component
public class HelloServiceImpl implements IHelloService {

    /**
     * Say Hello
     *
     * @param name 名称
     * @return
     */
    @Override
    public String sayHello(String name) {
        String rtn = "Hello " + name;
        System.out.println("============= " + rtn);
        return rtn;
    }
}
