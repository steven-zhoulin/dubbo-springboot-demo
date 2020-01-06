package com.topsail.crm.upc.common.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 饼图数据通用对象
 * @author: Steven
 * @create: 2019-11-21 21:26
 **/
@Data
public class PieChart implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String itemTitle;

    private List<String> itemNames;

    private List<PieData> datas;

    public List<String> getItemNames() {
        if (this.itemNames != null) {
            return itemNames;
        }

        if (this.datas == null || this.datas.size() <= 0) {
            return null;
        }

        this.itemNames = new ArrayList<String>();
        for (PieData data : datas) {
            this.itemNames.add(data.getName());
        }

        return this.itemNames;
    }
}
