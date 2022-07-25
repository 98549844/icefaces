package com.icefaces.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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
@ManagedBean(name= "index")
@SessionScope
//@CustomScoped
public class Index implements Serializable {

    private static Logger log = LogManager.getLogger(Index.class.getName());


    private String message = "Hello World! INDEX";


    @PostConstruct
    public void init() {
        message = "Hello World! KALAM";
    }


    public void processAction(ActionEvent event) throws AbortProcessingException {
        final UIComponent component = event.getComponent();
        String id = component.getId();
        log.info("component id: {}", id);
    }






    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

