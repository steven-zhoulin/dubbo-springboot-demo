package com.topsail.crm.order.framework.harley.domain.order;

import com.asiainfo.areca.framework.data.BaseEntity;
import com.asiainfo.areca.framework.util.ArrayUtils;
import com.topsail.crm.order.cell.order.entity.po.OmLine;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;

import javax.sound.sampled.Line;
import java.util.*;

/**
 * @program: crm
 * @description: 订单行数据集
 * @author: jinnian
 * @create: 2020-02-07 15:58
 **/
public class LineData<T extends BaseEntity> {

    private Map<String, List<T>> orderItems;

    /**
     * 构造函数
     */
    public LineData() {
        this.orderItems = new HashMap<String, List<T>>();
        OmLine line = new OmLine();
        this.setLine(line);
    }

    /**
     * 设置订单行数据
     * @param line
     */
    private void setLine(OmLine line) {
        Databus databus = DatabusManager.getDatabus();
        OrderData orderData = databus.getOrderData();
        line.setOrderId(orderData.getOrderId());
        line.setOrderLineId(new Long(Math.abs(new Random().nextInt(10000000))));

        List<T> lines = new ArrayList<T>();
        lines.add((T)line);
        this.orderItems.put(line.getClass().getName(), lines);
    }

    /**
     * 获取订单行数据
     * @return
     */
    public OmLine getLine() {
        List<T> lines = this.orderItems.get(OmLine.class.getName());
        if (ArrayUtils.isEmpty(lines)) {
            return null;
        }

        T line = lines.get(0);
        return (OmLine)line;
    }

    /**
     * 添加订单子表数据（单条）
     * @param orderItem
     */
    public void add(T orderItem) {
        String className = orderItem.getClass().getName();

        List<T> items = this.orderItems.get(className);
        if (items == null) {
            items = new ArrayList<T>();
            this.orderItems.put(className, items);
        }

        items.add(orderItem);
    }

    /**
     * 添加订单子数据（多条）
     * @param items
     */
    public void add(List<T> items) {
        if (ArrayUtils.isEmpty(items)) {
            return;
        }

        String className = items.get(0).getClass().getName();
        List<T> storages = orderItems.get(className);
        if (storages == null) {
            storages = new ArrayList<T>();
            this.orderItems.put(className, storages);
        }

        storages.addAll(items);
    }

    /**
     * 获取订单子表数据
     * @param className
     * @return
     */
    public List<T> get(String className) {
        return this.get(className);
    }

    /**
     * 获取订单子表数据
     * @param clazz
     * @return
     */
    public List<T> get(Class<T> clazz) {
        String className = clazz.getName();
        return this.get(className);
    }

    /**
     * 获取订单行的所有订单子表数据的集合（包含订单行数据）
     * @return
     */
    public Map<String, List<T>> getOrderItems() {
        return this.orderItems;
    }

    /**
     * 获取订单行ID，如果为-1，表示还没有生成订单行数据
     * @return
     */
    public Long getOrderLineId() {
        OmLine line = this.getLine();
        if (line == null) {
            return null;
        }

        return line.getOrderLineId();
    }
}
