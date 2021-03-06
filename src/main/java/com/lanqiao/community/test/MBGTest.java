package com.lanqiao.community.test;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/23 13:41
 * @description
 */
public class MBGTest {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException, XMLParserException, InvalidConfigurationException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String path = GetResource.class.getClassLoader().getResource("mbg.xml").getPath();
        File configFile = new File( path);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
