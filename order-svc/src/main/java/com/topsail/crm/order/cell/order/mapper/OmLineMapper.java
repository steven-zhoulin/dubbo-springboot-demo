package com.topsail.crm.order.cell.order.mapper;

import com.topsail.crm.order.cell.order.entity.po.OmLine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.asiainfo.areca.framework.annotation.Storage;
import com.asiainfo.areca.framework.mybatis.DataSourceKey;
import com.asiainfo.areca.framework.mybatis.annotation.DataSource;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Storage
@DataSource(DataSourceKey.CRM1)
public interface OmLineMapper extends BaseMapper<OmLine> {

}
