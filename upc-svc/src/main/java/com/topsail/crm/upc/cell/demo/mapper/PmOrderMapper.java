package com.topsail.crm.upc.cell.demo.mapper;

import com.topsail.crm.upc.cell.demo.entity.po.PmOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.asiainfo.areca.framework.annotation.Storage;
import com.asiainfo.areca.framework.mybatis.DataSourceKey;
import com.asiainfo.areca.framework.mybatis.annotation.DataSource;

/**
 * <p>
 * the modifycation of every operation on the web page will recorded in this table. Mapper 接口
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Storage
@DataSource(DataSourceKey.UPC)
public interface PmOrderMapper extends BaseMapper<PmOrder> {

}
