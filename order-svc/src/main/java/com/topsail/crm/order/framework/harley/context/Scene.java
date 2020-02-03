package com.topsail.crm.order.framework.harley.context;

import com.topsail.crm.order.framework.harley.constants.SceneTypeConst;
import lombok.Data;

/**
 * @program: crm-V0
 * @description: 业务场景
 * @author: jinnian
 * @create: 2020-01-19 16:06
 **/
@Data
public class Scene {

    /**
     * 场景类型 0-正常业务 1-返销业务 2-取消业务 3-批量业务，具体可参看SceneTypeConst.java
     */
    private String sceneType;

    /**
     * 是否预受理校验
     */
    private boolean preCheck;

    /**
     * 是否购物车
     */
    private boolean shoppingCart;

    /**
     * 是否预受理
     */
    private boolean preSubmit;

    /**
     * 是否二次确认
     */
    private boolean twoSmsConfirm;

    /**
     * 是否二次确认回复
     */
    private boolean twoSmsReply;

    /**
     * 默认构造函数
     */
    public Scene() {
        this.sceneType = SceneTypeConst.NORMAL;
    }
}
