package com.topsail.crm.order.framework.harley.context;

import com.asiainfo.areca.framework.util.ArrayUtils;
import com.asiainfo.areca.framework.util.TimeUtils;
import com.topsail.crm.order.cell.order.entity.po.OmOrder;
import com.topsail.crm.order.framework.harley.Commander;
import com.topsail.crm.order.framework.harley.domain.order.OrderData;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @program: crm-V0
 * @description: 业务受理服务的数据总线
 * @author: jinnian
 * @create: 2020-01-19 19:48
 **/
public class Databus {

    private Environment environment;

    private Scene scene;

    /**
     * 指挥官的堆栈，可以支持多服务重入时可以用来进行最初一次的判断
     */
    private Stack<Commander> commanders;

    /**
     * 核心域对象的容器，本次业务受理时所涉及的用户均放在这个容器内
     */
    private Map<String, ScaKernel> scaContainer = new HashMap<String, ScaKernel>();

    /**
     * 流水线产生的任务列表
     */
    private List<JobContext> jobContexts;

    /**
     * 订单对象
     */
    private OrderData order;

    /**
     * 构造函数，初始化环境
     */
    public Databus() {
        this.environment = new Environment();
        this.commanders = new Stack<Commander>();
        this.jobContexts = new ArrayList<JobContext>();
        order = new OrderData();

    }

    /**
     * 获取环境类
     * @return
     */
    public Environment getEnvironment() {
        return this.environment;
    }

    /**
     * 添加指挥官
     * @param commander
     */
    public void addCommander(Commander commander) {
        this.commanders.push(commander);
    }

    /**
     * 判断当前时刻是否是位于第一个指挥官的控制下
     * @return
     */
    public boolean isFirstCommander() {
        if (this.commanders.size() == 1) {
            return true;
        }

        return false;
    }

    /**
     * 如果指挥官的生命周期已结束，则从栈中弹出
     */
    public void popCommander() {
        if (this.commanders.isEmpty()) {
            return;
        }
        this.commanders.pop();
    }

    /**
     * 为数据总线添加任务上下文
     * @param jobContext
     */
    public void addJobContext(JobContext jobContext) {
        this.jobContexts.add(jobContext);
    }

    /**
     * 获取第一笔接入的业务
     * @return
     */
    public String getFirstBusiItemCode() {
        if (ArrayUtils.isEmpty(jobContexts)) {
            return null;
        }

        return jobContexts.get(0).getBusiItemConfig().getBusiItemCode();
    }

    /**
     * 获取场景
     * @return
     */
    public Scene getScene() {
        return this.scene;
    }

    /**
     * 设置场景
     * @param scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * 获取业务接入时间
     * @return
     */
    public String getAcceptTimeString() {
        return TimeUtils.formatLocalDateTimeToString(this.environment.getAcceptTime(), TimeUtils.TIME_PATTERN);
    }

    /**
     * 获取业务接入时间
     * @return
     */
    public LocalDateTime getAcceptTime() {
        return this.environment.getAcceptTime();
    }

    /**
     * 获取任务上下文列表
     * @return
     */
    public List<JobContext> getJobContexts() {
        return this.jobContexts;
    }

    /**
     * 获取总线ID
     * @return
     */
    public long getOrderId() {
        return this.order.getOrderId();
    }

    /**
     * 获取订单数据对象
     * @return
     */
    public OrderData getOrderData() {
        return this.order;
    }

    public String getBusiCode() {
        return this.order.getOrder().getBusiCode();
    }
}
