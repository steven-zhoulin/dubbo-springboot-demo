package com.topsail.crm.order.config;

import com.asiainfo.areca.framework.interceptor.SqlPerformanceInterceptor;
import com.asiainfo.areca.framework.mybatis.DataSourceKey;
import com.asiainfo.areca.framework.mybatis.MyGlobalConfig;
import com.asiainfo.areca.framework.mybatis.MySqlSessionTemplate;
import com.asiainfo.areca.framework.util.PackageUtils;
import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.topsail.crm.order.framework.harley.aop.OrderAutoSetMetaObjectAdvice;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.*;

/**
 * @author Steven
 * @date 2019-12-19
 */
@EnableTransactionManagement
@Slf4j
@Configuration
@MapperScan(basePackages = {"com.asiainfo.areca.framework.**.mapper", "com.topsail.crm.order.cell.**.mapper"}, sqlSessionTemplateRef = "sqlSessionTemplate")
public class MyBatisPlusConfig {

    @Autowired(required = false)
    private OptimisticLockerInterceptor optimisticLockerInterceptor;

    @Autowired(required = false)
    private PaginationInterceptor paginationInterceptor;

    @Autowired(required = false)
    private SqlExplainInterceptor sqlExplainInterceptor;

    @Autowired(required = false)
    private SqlPerformanceInterceptor sqlPerformanceInterceptor;

    @Autowired
    private OrderAutoSetMetaObjectAdvice orderAutoSetMetaObjectAdvice;

    @Bean
    public IKeyGenerator keyGenerator(){
        return new OracleKeyGenerator();
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.atomikos.base")
    public AtomikosNonXADataSourceBean baseDataSource() {
        return DataSourceBuilder.create().type(AtomikosNonXADataSourceBean.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.atomikos.crm1")
    public AtomikosNonXADataSourceBean crm1DataSource() {
        return DataSourceBuilder.create().type(AtomikosNonXADataSourceBean.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.atomikos.crm2")
    public AtomikosNonXADataSourceBean crm2DataSource() {
        return DataSourceBuilder.create().type(AtomikosNonXADataSourceBean.class).build();
    }

    @Bean(name = "sqlSessionTemplate")
    public MySqlSessionTemplate customSqlSessionTemplate() throws Exception {
        Map<String, SqlSessionFactory> sqlSessionFactoryMap = new HashMap<String, SqlSessionFactory>(3) {{
            put(DataSourceKey.BASE, createSqlSessionFactory(baseDataSource()));
            put(DataSourceKey.CRM1, createSqlSessionFactory(crm1DataSource()));
//            put(DataSourceKey.CRM2, createSqlSessionFactory(crm2DataSource()));
        }};
        MySqlSessionTemplate sqlSessionTemplate = new MySqlSessionTemplate(sqlSessionFactoryMap.get(DataSourceKey.BASE));
        sqlSessionTemplate.setTargetSqlSessionFactories(sqlSessionFactoryMap);
        return sqlSessionTemplate;
    }

    /**
     * 创建数据源
     *
     * @param dataSource
     * @return
     */
    private SqlSessionFactory createSqlSessionFactory(AtomikosNonXADataSourceBean dataSource) throws Exception {

        log.info("初始化数据源: {}", dataSource.getUser());
        dataSource.init();

        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/**/*.xml"));
        sqlSessionFactory.setVfs(SpringBootVFS.class);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(true);

        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(fetchInterceptors());

        // 重写了 GlobalConfig 的 MyGlobalConfig 注入到 sqlSessionFactory 使其生效
        MyGlobalConfig globalConfig = new MyGlobalConfig();
        globalConfig.setBanner(false);
        log.info("元数据自动填充: {}", orderAutoSetMetaObjectAdvice);
        globalConfig.setMetaObjectHandler(orderAutoSetMetaObjectAdvice);

        // 注册序列生成器
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setKeyGenerator(keyGenerator());
        globalConfig.setDbConfig(dbConfig);

        sqlSessionFactory.setGlobalConfig(globalConfig);
        sqlSessionFactory.afterPropertiesSet();

        return sqlSessionFactory.getObject();
    }

    /**
     * 各类拦截器
     */
    private Interceptor[] fetchInterceptors() {

        List<Interceptor> interceptors = new ArrayList<>();

        if (null != optimisticLockerInterceptor) {
            interceptors.add(optimisticLockerInterceptor);
        }

        if (null != paginationInterceptor) {
            interceptors.add(paginationInterceptor);
        }

        if (null != sqlExplainInterceptor) {
            interceptors.add(sqlExplainInterceptor);
        }

        if (null != sqlPerformanceInterceptor) {
            interceptors.add(sqlPerformanceInterceptor);
        }

        for (Interceptor interceptor : interceptors) {
            log.info("添加拦截器: {}", PackageUtils.compactPackage(interceptor.getClass()));
        }

        return interceptors.toArray(new Interceptor[0]);
    }

    /**
     * 乐观锁拦截器
     *
     * @return 返回乐观锁拦截器
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        OptimisticLockerInterceptor optimisticLockerInterceptor = new OptimisticLockerInterceptor();
        return optimisticLockerInterceptor;
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

//        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
//        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {{
//            put("STEVEN", (metaObject, sql, tableName) -> {
//                // metaObject 可以获取传入参数，这里实现你自己的动态规则
//                String year = "_2018";
//                int random = new Random().nextInt(10);
//                if (random % 2 == 1) {
//                    year = "_2019";
//                }
//                return tableName + year;
//            });
//        }});
//        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));

        return paginationInterceptor;
    }

    /**
     * 利用攻击 SQL 阻断解析器，来防止 "全表更新"，"全表删除" 等高危操作。
     *
     * @return
     */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();

        List<ISqlParser> sqlParserList = new ArrayList<>();
        sqlParserList.add(new BlockAttackSqlParser());

        sqlExplainInterceptor.setSqlParserList(sqlParserList);
        return sqlExplainInterceptor;
    }

    /**
     * 性能分析拦截器，用于输出每条 SQL 语句及其执行时间，仅开发、测试环境使用，生产环境不推荐。
     */
    @Bean
//    @Profile({"dev", "test"})
    public SqlPerformanceInterceptor performanceInterceptor() {
        SqlPerformanceInterceptor sqlPerformanceInterceptor = new SqlPerformanceInterceptor();
        // SQL 格式化开关
        sqlPerformanceInterceptor.setFormat(false);
        // SQL 最长执行时间，超过自动停止运行，单位毫秒
        sqlPerformanceInterceptor.setMaxTime(5000);
        // SQL 告警时间，超过在控制台以红色打印，单位毫秒
        sqlPerformanceInterceptor.setWarnTime(80);
        return sqlPerformanceInterceptor;
    }

}