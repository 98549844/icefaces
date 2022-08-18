package com.icefaces.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname: BeanUtil
 * @Date: 2022/7/25 下午 06:15
 * @Author: kalam_au
 * @Description:
 */

@Component
@Order(99)
public class BeanUtil implements ApplicationContextAware {
    private static final Logger log = LogManager.getLogger(BeanUtil.class.getName());

    public static ApplicationContext applicationContext = null;


    public static List printBeanName(ApplicationContext applicationContext) {
        List beanList = new ArrayList();

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        log.info("total bean: " + applicationContext.getBeanDefinitionCount());
        int i = 0;
        for (String s : beanNames) {
            beanList.add(s);
            log.info(++i + " ,beanName: " + s);
        }
        return beanList;
    }



    public static void printBeanNameByContextLoader() {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        BeanUtil.applicationContext = context;
        String[] beanNames = BeanUtil.applicationContext.getBeanDefinitionNames();
        log.info("total bean: {}  " , BeanUtil.applicationContext.getBeanDefinitionCount());
        int i = 0;
        for (String s : beanNames) {
            log.info(" {},beanName: {} " , ++i , s);
        }
    }

    public static Object getBean(String name) {
        Object object = applicationContext.getBean(name);
        return object;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (BeanUtil.applicationContext == null) {
            BeanUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


}

