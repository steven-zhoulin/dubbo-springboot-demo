package com.topsail.crm.upc.common.data;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 通用树节点对象
 * @author: Steven
 * @create: 2019-09-08 15:32
 **/
@Data
public class TreeNode<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String parentId;

    T node;

    private boolean spread;

    private String path;

    /**
     * 子节点
     */
    private List<TreeNode> children;

    /**
     * 当前节点携带的值
     */
    private AtomicLong bag = new AtomicLong(0L);


}
