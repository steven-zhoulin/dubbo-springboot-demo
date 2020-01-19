package com.topsail.crm.upc.modules.demo.mapper;

import com.topsail.crm.upc.modules.demo.entity.po.PmOfferCell;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.asiainfo.areca.framework.annotation.Storage;
import com.asiainfo.areca.framework.mybatis.DataSourceKey;
import com.asiainfo.areca.framework.mybatis.annotation.DataSource;

/**
 * <p>
 * describe relationship between offering and base station group Mapper 接口
 * </p>
 *
 * @author Steven
 * @since 2020-01-10
 */
@Storage
@DataSource(DataSourceKey.UPC)
public interface PmOfferCellMapper extends BaseMapper<PmOfferCell> {

}
