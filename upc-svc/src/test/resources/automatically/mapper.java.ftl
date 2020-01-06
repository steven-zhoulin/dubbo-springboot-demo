package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import com.topsail.crm.framework.annotation.Storage;
import com.topsail.crm.framework.mybatis.DataSourceKey;
import com.topsail.crm.framework.mybatis.annotation.DataSource;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Storage
@DataSource(DataSourceKey.${cfg.DS_NAME})
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
