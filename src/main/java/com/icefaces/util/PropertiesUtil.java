package com.icefaces.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Classname: PropertyUtil
 * @Date: 2022/7/28 下午 02:40
 * @Author: kalam_au
 * @Description:
 */

//@Component
//@PropertySource(value = "classpath:properties/messages.properties", encoding = "UTF-8", name = "messages.properties")
public class PropertiesUtil {
    private static final Logger log = LogManager.getLogger(PropertiesUtil.class.getName());


    //src/main/resources/properties/messages.properties
    public static String FILENAME = "properties/messages.properties";

    public static String getProperty(String filename, String key) throws IOException {
        Properties properties = new Properties();
        InputStream inStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(filename);
        properties.load(inStream);
        System.out.println(properties.get(key));

        return (String) properties.get(key);
    }

    public static void main(String[] args) throws IOException {
        getProperty(FILENAME, "version");
    }


//    @Value("${version}")
//    private String version;
//
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }


}

