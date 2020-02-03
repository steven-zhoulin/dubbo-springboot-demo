package com.topsail.crm.order.framework.harley.context;

import com.asiainfo.areca.framework.data.BaseEntity;
import com.asiainfo.areca.framework.util.ArrayUtils;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import com.topsail.crm.order.cell.order.entity.po.OmLine;
import com.topsail.crm.order.framework.harley.config.BusiItemConfig;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: crm-V0
 * @description: 任务上下文，保存任务的输入(request)和输出(订单子表数据)
 * @author: jinnian
 * @create: 2020-01-19 17:33
 **/
public class JobContext<T extends BaseEntity, K extends UserRequestDTO> {

    private K userRequest;

    private Map<String, List<T>> orderLineData;

    private ScaKernel sca;

    private BusiItemConfig busiItemConfig;

    /**
     * 根据用户业务请求对象构造任务上下文
     * @param userRequest
     */
    public JobContext(K userRequest) {
        this.userRequest = userRequest;
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
     * 添加具体的订单子表信息，默认取VO上的sca
     * @param orderItem
     * @throws Exception
     */
    public void add(T orderItem) {
        ScaKernel sca = this.getSca();

        String accessNum = "";
        if (sca != null) {
            accessNum = sca.getAccessNum();
        }

        this.add(accessNum, orderItem);
    }

    /**
     * 添加具体的订单子表数据，之所以需要accessNum，是因为需要根据accessNum找到sca，以便于做sca资料的future运算
     * @param accessNum
     * @param orderItem
     * @throws Exception
     */
    public void add(String accessNum, T orderItem) {
        String className = orderItem.getClass().getName();

        List<T> orderItems = this.orderLineData.get(className);
        if (orderItems == null) {
            orderItems = new ArrayList<T>();
            this.orderLineData.put(className, orderItems);
        }

        orderItems.add(orderItem);
    }

    /**
     * 获取已经添加的订单子表数据
     * @param className
     * @return
     */
    public List<T> getOrderItems(String className) {
        return this.orderLineData.get(className);
    }

    /**
     * 获取已经添加的订单子表数据
     * @param clazz
     * @return
     */
    public List<T> getOrderItems(Class<? extends BaseEntity> clazz) {
        String className = clazz.getName();
        return this.orderLineData.get(className);
    }

    /**
     * 获取以订单行为基本单位的订单子表数据
     * @return
     */
    public Map<String, List<T>> getOrderLineData() {
        return this.orderLineData;
    }

    public long getOrderLineId() {
        List<T> lines = this.getOrderItems(OmLine.class);
        if (ArrayUtils.isEmpty(lines)) {
            return -1;
        }

        OmLine line = (OmLine)lines.get(0);
        return line.getOrderLineId();
    }
}
