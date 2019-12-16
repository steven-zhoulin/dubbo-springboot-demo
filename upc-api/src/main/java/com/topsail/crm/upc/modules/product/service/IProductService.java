package com.topsail.crm.upc.modules.product.service;

import com.topsail.crm.upc.modules.product.entity.po.Product;

/**
 * @author Steven
 * @date 2019-12-16
 */
public interface IProductService {

    /**
     * 根据Id查产品
     *
     * @param id ID
     * @return 产品
     */
    Product selectById(Long id);

}
