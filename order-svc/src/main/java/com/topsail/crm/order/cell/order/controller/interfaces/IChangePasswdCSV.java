package com.topsail.crm.order.cell.order.controller.interfaces;

import com.topsail.crm.order.cell.order.dto.OrderDTO;
import com.topsail.crm.order.cell.user.dto.UserDTO;

/**
 * CSF定义
 * <p>
 * liaosheng@asiainfo.com
 * 2020/1/29 3:09 下午
 */
public interface IChangePasswdCSV {


    /**
     * 根据用户ID查询用户信息
     * @param user
     * @return
     */
    UserDTO queryUser(UserDTO user);

    /**
     * 修改用户密码，返回订单信息
     * @param user
     * @return
     */
    OrderDTO createOrder(UserDTO user);

}
