package com.topsail.crm.order.modules.user.service;

import com.topsail.crm.order.modules.user.entity.po.User;

/**
 * @author Steven
 * @date 2019-12-16
 */
public interface IUserService {

    /**
     * Say Hello
     *
     * @param name 名称
     * @return
     */
    User sayHello(String name);
}
