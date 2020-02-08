package com.topsail.crm.order.framework.harley.context;

import com.asiainfo.areca.framework.data.BaseEntity;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.framework.harley.config.BusiItemConfig;
import com.topsail.crm.order.framework.harley.domain.order.LineData;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;

import java.util.List;

/**
 * @program: crm-V0
 * @description: 任务上下文，保存任务的输入(request)和输出(订单子表数据)
 * @author: jinnian
 * @create: 2020-01-19 17:33
 **/
public class JobContext<T extends BaseEntity, K extends UserRequestDTO> {

    private K userRequest;

    private LineData lineData;

    private ScaKernel sca;

    private BusiItemConfig busiItemConfig;

    /**
     * 根据用户业务请求对象构造任务上下文
     * @param userRequest
     */
    public JobContext(K userRequest) {
        this.userRequest = userRequest;
        this.lineData = new LineData();
    }

    /**
     * 获取用户业务请求对象
     * @return
     */
    public K getUserRequest() {
        return this.userRequest;
    }

    /**
     * 获取任务作用的三户核心域对象
     * @return
     */
    public ScaKernel getSca() {
        return this.sca;
    }

    /**
     * 设置三户核心域
     * @param sca
     */
    public void setSca(ScaKernel sca) {
        this.sca = sca;
    }

    /**
     * 获取用户业务请求对应的业务类型配置数据
     * @return
     */
    public BusiItemConfig getBusiItemConfig() {
        return this.busiItemConfig;
    }

    /**
     * 设置业务类型配置
     * @param busiItemConfig
     */
    public void setBusiItemConfig(BusiItemConfig busiItemConfig) {
        this.busiItemConfig = busiItemConfig;
    }

    /**
     * 添加具体的订单子表信息，默认取VO上的sca
     * @param orderItem
     * @throws Exception
     */
    public void add(T orderItem) {
        this.lineData.add(orderItem);
    }

    /**
     * 添加具体的多条订单子表信息，默认取VO上的sca
     * @param orderItems
     * @throws Exception
     */
    public void add(List<T> orderItems) {
        this.lineData.add(orderItems);
    }

    /**
     * 获取已经添加的订单子表数据
     * @param className
     * @return
     */
    public List<T> getOrderItems(String className) {
        return this.lineData.get(className);
    }

    /**
     * 获取已经添加的订单子表数据
     * @param clazz
     * @return
     */
    public List<T> getOrderItems(Class<? extends BaseEntity> clazz) {
        return this.lineData.get(clazz);
    }

    /**
     * 获取以订单行为基本单位的订单子表数据
     * @return
     */
    public LineData getLineData() {
        return this.lineData;
    }

    public Long getOrderLineId() throws Exception {
        return this.lineData.getOrderLineId();
    }
}
