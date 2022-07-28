package com.icefaces.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ResourceBundle;

/**
 * @Classname: PropertyUtil
 * @Date: 2022/7/28 下午 02:40
 * @Author: kalam_au
 * @Description:
 */

@Component
@PropertySource(value = "classpath:properties/messages.properties", encoding = "UTF-8", name = "messages.properties")
public class PropertyUtil {
    private static final Logger log = LogManager.getLogger(PropertyUtil.class.getName());


    @Value("${version}")
    private String version;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static void main(String[] args) {

        PropertyUtil p = new PropertyUtil();
        System.out.println("version: " + p.getVersion());
    }
}

