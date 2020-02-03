package com.topsail.crm.order.framework.harley.context;

/**
 * @program: crm-V0
 * @description: 数据总线管理器
 * @author: jinnian
 * @create: 2019-01-19 13:49
 **/
public class DatabusManager {

    /**
     * 基于线程的数据总线
     */
    private static ThreadLocal<Databus> databusSet = new ThreadLocal<Databus>();

    /**
     * 获取当前线程的数据总线，如果还未创建，则创建一个新的返回
     * @return
     */
    public static Databus getDatabus() {
        Databus databus = databusSet.get();
        if(databus == null) {
            databus = new Databus();
            databusSet.set(databus);
        }
        return databus;
    }

    /**
     * 移除当前线程的数据总线
     */
    public static void remove() {
        databusSet.remove();
    }

}
