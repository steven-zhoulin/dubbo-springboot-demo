package com.topsail.crm.order.framework.harley;

import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.Scene;
import com.topsail.crm.order.framework.harley.runtime.Workshop;

/**
 * @program: CRM-V0
 * @description: 指挥官，业务受理完整过程的执行者，负责指挥生产线有条不紊的工作，业务的流程串接，调度，装配
 * @author: jinnian
 * @create: 2020-01-19
 **/
public class Commander {

    /**
     * 订单提交的数据集，如果是多用户订单，就会有多条
     */
    private OrderRequestDTO request;

    /**
     * 订单输出对象
     */
    private OrderResponseDTO response;

    /**
     * 构造函数，直接传入入参与VO映射的对象，与第一个构造函数意义相同，只是表现形式不同
     * @param request
     * @throws Exception
     */
    public Commander(OrderRequestDTO request) {
        this.request = request;
        this.response = new OrderResponseDTO();
    }

    /**
     * 业务执行入口
     * @return
     */
    public OrderResponseDTO execute() {
        try {
            this.init();

            this.doWork();

            this.complete();

            this.finalDone();

        } catch(Exception e) {
            throw e;
        } finally {
            this.finalDone();
        }

        return this.response;
    }

    /**
     * 初始化环境
     */
    public void init() {
        //初始化线程数据总线
        Databus databus = DatabusManager.getDatabus();
        databus.addCommander(this);
        Scene scene = new Scene();
        databus.setScene(scene);
    }

    /**
     * 任务开始，业务执行过程
     */
    public void doWork() {
        Workshop workshop = new Workshop();
        workshop.startProduce(this.request, this.response);
    }

    /**
     * 业务执行完毕，设置返回
     */
    public void complete() {

    }


    /**
     * 不管业务、事务成功与否都会执行的处理，主要是对总线的一些清理动作
     */
    public void finalDone() {
        Databus databus = DatabusManager.getDatabus();
        //如果是最开始就接入的指令，则清空线程数据总线
        //如果不是，则证明用服务调用的方式创建了多个指挥者，非第一个指挥者运行完毕后，则进行弹出
        if (databus.isFirstCommander()) {
            DatabusManager.remove();
        } else {
            databus.popCommander();
        }
    }

}
