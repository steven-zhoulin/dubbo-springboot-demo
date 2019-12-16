package com.topsail.crm.upc.modules.product.service.impl;

import com.topsail.crm.upc.modules.product.entity.po.Product;
import com.topsail.crm.upc.modules.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Slf4j
@Component
@Service(interfaceClass = IProductService.class, version = "1.0.0")
public class ProductServiceImpl implements IProductService {

    private static final Map<Long, Product> POOL = new ConcurrentHashMap<>();

    static {
        POOL.put(1L, Product.builder().id(1L).productName("188套餐").productType("V1").build());
        POOL.put(2L, Product.builder().id(2L).productName("288套餐").productType("V2").build());
        POOL.put(3L, Product.builder().id(3L).productName("388套餐").productType("V3").build());
    }

    @Override
    public Product selectById(Long id) {
        Product product = POOL.get(id);
        return product;
    }

}
