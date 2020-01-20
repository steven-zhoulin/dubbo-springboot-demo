package com.topsail.crm.automatic;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 模板代码生成器
 *
 * @author Steven
 * @since 2019-04-24
 */
@Slf4j
public class MySQLGenerator {

    /**
     * 以下是代码生成前需要修改的部分:
     */
    private static String url = "jdbc:mysql://127.0.0.1:3306/upc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String schemaName = "upc";
    private static String username = "root";

    private static String parentPackage = "com.topsail.crm.upc.modules";


    private static void switchDatabase(String database) {
        if ("ord".equals(database)) {
            url = "jdbc:mysql://127.0.0.1:3306/upc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            schemaName = "upc";
            username = "root";
        }
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        String help = tip + ": ";
        System.out.println(help);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static void generateApi(AutoGenerator autoGenerator, String projectPath, String author, String password, String moduleName, String databaseName, List<TableFill> tableFillList, String[] tables) {
        String outPutDirApi = projectPath + "/upc-api/src/main/java";
        log.info("样板代码输出路径: " + outPutDirApi);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(outPutDirApi);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setSchemaName(schemaName);
        dataSourceConfig.setDriverName(driver);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(moduleName);
        packageConfig.setParent(parentPackage);
        packageConfig.setEntity("entity.po");
        autoGenerator.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("DS_NAME", databaseName.toUpperCase());
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/automatically/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/upc-svc/src/main/resources/mapper/" + packageConfig.getModuleName()
                    + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;

            }
        });


        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);
        autoGenerator.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTableFillList(tableFillList);
        if ("ins".equals(databaseName)) {
            strategy.setTablePrefix("ins");
        } else {
            strategy.setTablePrefix("sys");
        }

        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tables);
        strategy.setRestControllerStyle(true);
        strategy.setSuperEntityClass("com.topsail.crm.upc.common.data.BaseEntity");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setService("/automatically/service.java");
        templateConfig.setServiceImpl(null);
        templateConfig.setEntity("/automatically/entity.java");
        templateConfig.setMapper(null);
        templateConfig.setXml(null);

        autoGenerator.setTemplate(templateConfig);

        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    private static void generateSvc(AutoGenerator autoGenerator, String projectPath, String author, String password, String moduleName, String databaseName, List<TableFill> tableFillList, String[] tables) {
        String outPutDirSvc = projectPath + "/upc-svc/src/main/java";
        log.info("样板代码输出路径: " + outPutDirSvc);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(outPutDirSvc);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setSchemaName(schemaName);
        dataSourceConfig.setDriverName(driver);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(moduleName);
        packageConfig.setParent(parentPackage);
        packageConfig.setEntity("entity.po");
        autoGenerator.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("DS_NAME", databaseName.toUpperCase());
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/automatically/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/upc-svc/src/main/resources/mapper/" + packageConfig.getModuleName()
                    + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;

            }
        });


        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);
        autoGenerator.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTableFillList(tableFillList);
        if ("ins".equals(databaseName)) {
            strategy.setTablePrefix("ins");
        } else {
            strategy.setTablePrefix("sys");
        }

        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tables);
        strategy.setRestControllerStyle(true);
        strategy.setSuperEntityClass("com.topsail.crm.upc.common.data.BaseEntity");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl("/automatically/serviceImpl.java");
        templateConfig.setEntity(null);
        templateConfig.setMapper("/automatically/mapper.java");
        templateConfig.setXml(null);

        autoGenerator.setTemplate(templateConfig);

        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    public static void main(String[] args) {
        System.out.println("数据源: " + schemaName);
        String moduleName = scanner("请输入本次构建的模块名");
        String databaseName = scanner("请输入本次构建连接的数据库");
        String password = scanner("请输入数据库密码");
        String author = scanner("请输入开发者名字");
        switchDatabase(databaseName);
        String[] tables = scanner("请输入本次构建的表名(多个表明用英文逗号隔开)").split(",");

        log.info("本次构建的模块路径为: {}.{}", parentPackage, moduleName);
        log.info("本次构建的表: ");
        for (String table : tables) {
            log.info(" -> " + table);
        }

        String answer = scanner("是否继续? (Y/N)");
        if (!"Y".equalsIgnoreCase(answer)) {
            System.exit(0);
        }

        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("create_time", FieldFill.INSERT));
        tableFillList.add(new TableFill("create_user_id", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("update_user_id", FieldFill.INSERT_UPDATE));

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        String projectPath = System.getProperty("user.dir").replace('\\', '/');

        // 生成 API
        generateApi(new AutoGenerator(), projectPath, author, password, moduleName, databaseName, tableFillList, tables);

        // 生成 SVC
        generateSvc(new AutoGenerator(), projectPath, author, password, moduleName, databaseName, tableFillList, tables);

    }

}
