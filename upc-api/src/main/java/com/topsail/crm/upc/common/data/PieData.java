package com.topsail.crm.upc.common.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 饼图数据对象
 * @author: Steven
 * @create: 2019-11-21 22:34
 **/
@Data
public class PieData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String value;
}
