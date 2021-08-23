package api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * 作者: xin.tu
 * 日期: 2020/08/13 15:07
 * 描述: 生成实体DAO等类
 */
public class CodeGenerator {

    private Properties p   ;

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public CodeGenerator() throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("filter/dev.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        this.p = properties;
    }

    public Properties getP() {
        return p;
    }

    public static void main(String[] args) throws IOException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("C:/Users/jiangwei23879/Desktop");
        gc.setAuthor("jiangwei");
        gc.setDateType(DateType.ONLY_DATE);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setOpen(false);
        gc.setIdType(IdType.ID_WORKER);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
/*        dsc.setUrl("jdbc:mysql://192.168.146.100:3306/kirin-hr?characterEncoding=utf8");
        dsc.setUsername("twbpm");
        dsc.setPassword("twbpm2015");*/
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8&serverTimezone=UTC");
        dsc.setUsername("root");
        dsc.setPassword("23931106wode");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.it.biz");
        pc.setEntity("model");
        mpg.setPackageInfo(pc);

        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/src/main/resources/mapper/"
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setSuperMapperClass("com.it.tools.core.base.BaseMapper");
        strategy.setSuperServiceImplClass("com.it.tools.core.base.BaseServiceImpl");
        strategy.setSuperServiceClass("com.it.tools.core.base.IBaseService");
        strategy.setSuperControllerClass("com.it.tools.core.base.AbstractController");
        strategy.setSuperEntityClass("com.it.tools.core.base.BaseModel");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(scanner("表名"));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityColumnConstant(true);
        strategy.setRestControllerStyle(false);
//        strategy.setVersionFieldName("lock_version");
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("logic_del");
        strategy.entityTableFieldAnnotationEnable(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

//        TemplateConfig tc = new TemplateConfig();
//        tc.setEntity("/template/entity.groovy");
//        tc.setMapper("/template/mapper.groovy");
//        tc.setService("/template/service.groovy");
//        tc.setServiceImpl("/template/serviceImpl.groovy");
//        tc.setXml("/template/mapper.xml");
//        tc.setController("/template/controller.groovy");
//        mpg.setTemplate(tc);
        mpg.execute();
    }

}
