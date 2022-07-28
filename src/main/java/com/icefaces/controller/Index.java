package com.icefaces.controller;


import com.icefaces.util.PropertyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
//import javax.faces.bean.CustomScoped;


/**
 * @Classname: Index
 * @Date: 2022/7/25 下午 05:12
 * @Author: kalam_au
 * @Description:
 */


//sample code http://icefaces-showcase.icesoft.org/showcase.jsf?grp=ace:textEntry

@SuppressWarnings("deprecation")
@ManagedBean(name = "index")
@ViewScoped
//@CustomScoped
public class Index implements Serializable {

    private static Logger log = LogManager.getLogger(Index.class.getName());


    private String message = "Hello World! INDEX";
    private String title;
    private String version;


    @Autowired
    private PropertyUtil propertyUtil;

    @PostConstruct
    public void init() {
        message = "Hello World! JSF INDEX";
        title = "ACE 4.3 Application";
        version = propertyUtil.getVersion();

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

