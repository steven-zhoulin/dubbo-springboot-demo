package com.topsail.crm.upc.cell.demo.mapper;

import com.topsail.crm.upc.cell.demo.entity.po.MpCity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.asiainfo.areca.framework.annotation.Storage;
import com.asiainfo.areca.framework.mybatis.DataSourceKey;
import com.asiainfo.areca.framework.mybatis.annotation.DataSource;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Steven.zhou
 * @since 2020-01-10
 */
@Storage
@DataSource(DataSourceKey.UPC)
public interface MpCityMapper extends BaseMapper<MpCity> {

}
