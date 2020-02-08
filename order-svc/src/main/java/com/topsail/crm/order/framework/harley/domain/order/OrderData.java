package com.topsail.crm.order.framework.harley.domain.order;

import com.topsail.crm.order.cell.order.entity.po.OmOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: crm
 * @description: 订单数据集
 * @author: jinnian
 * @create: 2020-02-07 15:57
 **/
public class OrderData {

    private OmOrder order;

    private List<LineData> lines;

    /**
     * 构造函数
     */
    public OrderData() {
        this.lines = new ArrayList<LineData>();
        this.order = new OmOrder();
        this.order.setOrderId(new Long(Math.abs(new Random().nextInt(10000000))));
    }

    /**
     * 添加订单行数据集（单个）
     * @param line
     */
    public void addLine(LineData line) {
        this.lines.add(line);
    }

    /**
     * 添加订单行数据集（多条）
     * @param lines
     */
    public void addLines(List<LineData> lines) {
        this.lines.addAll(lines);
    }

    /**
     * 设置订单行数据
     * @param lines
     */
    public void setLines(List<LineData> lines) {
        this.lines = lines;
    }

    /**
     * 获取订单数据
     * @return
     */
    public OmOrder getOrder() {
        return this.order;
    }


    /**
     * 获取订单ID，如果为null，则表示还没有生成订单数据
     * @return
     */
    public Long getOrderId() {
        if (this.order == null) {
            return null;
        }

        return this.order.getOrderId();
    }

    /**
     * 获取订单行数据集合
     * @return
     */
    public List<LineData> getLines() {
        return this.lines;
    }
}
