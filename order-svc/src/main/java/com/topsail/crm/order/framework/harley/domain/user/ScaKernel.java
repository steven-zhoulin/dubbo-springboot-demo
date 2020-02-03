package com.topsail.crm.order.framework.harley.domain.user;

import com.topsail.crm.order.cell.user.entity.po.UmSubscriber;
import com.topsail.crm.order.framework.harley.domain.acct.Account;
import com.topsail.crm.order.framework.harley.domain.cust.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: crm
 * @description: 三户核心域对象
 * @author: jinnian
 * @create: 2020-01-20 00:37
 **/
@Slf4j
@Component
@Scope("prototype")
public class ScaKernel {

    /**
     * 用户对象
     */
    private UmSubscriber subscriber;

    /**
     * 客户对象
     */
    private Customer customer = new Customer();

    /**
     * 帐户对象
     */
    private Account account;

    /**
     * 获取用户对象
     * @return
     */
    public UmSubscriber getSubscriber() {
        return this.subscriber;
    }

    /**
     * 获取客户对象
     * @return
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * 获取帐户对象
     * @return
     */
    public Account getAccount() {
        return this.account;
    }

    /**
     * 获取用户服务号码
     * @return
     */
    public String getAccessNum() {
        return this.subscriber.getAccessNum();
    }

    /**
     * 获取用户ID
     * @return
     */
    public Long getSubscriberInsId() {
        return this.subscriber.getSubscriberInsId();
    }

    /**
     * 获取客户ID
     * @return
     */
    public Long getCustId() {
        return this.customer.getCustId();
    }

    /**
     * 获取用户归属地州
     * @return
     */
    public String getMgmtDistrict() {
        return this.subscriber.getMgmtDistrict();
    }

    public void setSubscriber(UmSubscriber subscriber) {
        this.subscriber = subscriber;
    }
}
