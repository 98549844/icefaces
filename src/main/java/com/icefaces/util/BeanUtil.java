package com.icefaces.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname: BeanUtil
 * @Date: 2022/7/25 下午 06:15
 * @Author: kalam_au
 * @Description:
 */

public class BeanUtil {
    private static final Logger log = LogManager.getLogger(BeanUtil.class.getName());



    public static List printBeanName(ApplicationContext applicationContext) {
        List beanList = new ArrayList();

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        log.info("total bean: " + applicationContext.getBeanDefinitionCount());
        int i = 0;
        for (String s : beanNames) {
            beanList.add(s);
            log.info(++i + ",beanName: " + s);
        }
        return beanList;
    }
}

