package com.topsail.crm.order.modules.user.controller;

import com.topsail.crm.upc.modules.product.entity.po.Product;
import com.topsail.crm.upc.modules.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Slf4j
@RestController("api/user")
public class UserController {

    @Reference(version = "1.0.0")
    IProductService productService;

    @GetMapping("selectById/{id}")
    public Product selectById(@PathVariable Long id) {
        log.info("UserController.selectById({})", id);
        Product product = productService.selectById(id);
        return product;
    }

}
