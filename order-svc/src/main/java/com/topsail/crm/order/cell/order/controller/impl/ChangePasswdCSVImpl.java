package com.topsail.crm.order.cell.order.controller.impl;

import com.asiainfo.areca.framework.error.Asserts;
import com.asiainfo.areca.framework.scan.ClassFinder;
import com.asiainfo.areca.framework.scan.IClassGenerator;
import com.topsail.crm.order.cell.order.controller.ChangePasswdError;
import com.topsail.crm.order.cell.order.controller.interfaces.IChangePasswdCSV;
import com.topsail.crm.order.cell.order.dto.OrderDTO;
import com.topsail.crm.order.cell.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

/**
 * CSF的服务实现类<p>
 * 1. 查询用户 curl -H "Content-Type: application/json" -X POST -d '{"ACCESS_NUM":100}' "http://127.0.0.1:8080/api/order/changepasswd/queryUser"<p>
 * 2. 生成订单 curl -H "Content-Type: application/json" -X POST -d '{"USER_ID": "123", "ACCESS_NUM":100, "USER_PSWD":1}' "http://127.0.0.1:8080/api/order/changepasswd/createOrder"<p>
 * <p>
 * liaosheng@asiainfo.com
 * 2020/1/29 3:28 下午
 */
@Slf4j
@RestController
@RequestMapping("/api/order/changepasswd")
public class ChangePasswdCSVImpl implements IChangePasswdCSV {

    @PostMapping("/queryUser")
    @Override
    public UserDTO queryUser(@RequestBody UserDTO user) {
        log.info("user info {}", user.toString());

        Asserts.notNull(user.getAccessNum(), ChangePasswdError.ACCESS_NUM_NOTNULL);

        try {
            ClassFinder.getInstance().loadClasses("com.topsail", "file:*CSV", new IClassGenerator() {
                @Override
                public void create(String className) throws Exception {
                    log.info("find class:{}", className);
                }

                /**
                 * 指定模糊匹配的jar文件名，开发模式不需要
                 * @return
                 */
                @Override
                public String[] getJars() {
                    return null;
                }
            });
        } catch (Exception e) {
            Asserts.error(e, ChangePasswdError.CLASS_FINDER_ERROR, "CSV");
        }


        Asserts.notNumeric(user.getAccessNum(), ChangePasswdError.ACCESS_NUM_NOTNUM);

        user.setUserId(112233L);
        user.setAccessNum("13787135441");
        return user;
    }

    @PostMapping("/createOrder")
    @Override
    public OrderDTO createOrder(@RequestBody UserDTO user) {
        log.info("user info {}", user.toString());

        OrderDTO order = new OrderDTO();
        order.setUserId(System.currentTimeMillis());
        order.setOrderId("112233");
        order.setLines(new String[] {"112233", "445566"});

        return order;
    }
}
