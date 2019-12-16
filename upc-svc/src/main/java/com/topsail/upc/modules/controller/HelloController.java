package com.topsail.upc.modules.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.topsail.order.modules.user.service.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steven
 * @date 2019-12-16
 */
@RestController
public class HelloController {

    @Reference(version = "1.0.0")
    IHelloService helloService;

    @GetMapping("hello/{name}")
    public void hello(@PathVariable String name) {
        System.out.println("call HelloController.hello() with: " + name);
        String sayHello = helloService.sayHello(name);
        System.out.println("======================================");
        System.out.println("Service return: " + sayHello);
    }

}
