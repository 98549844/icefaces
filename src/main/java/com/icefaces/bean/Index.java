package com.icefaces.bean;


import com.icefaces.util.PropertiesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import java.io.IOException;
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
@SessionScope
//@CustomScoped
public class Index implements Serializable {

    private static Logger log = LogManager.getLogger(Index.class.getName());


    private String message = "message";
    private String title = "title";
    private String version = "version";


    @PostConstruct
    public void init() {
        message = "Hello World! JSF INDEX";
        title = "ACE 4.3 Application";
        try {
            version = PropertiesUtil.getProperty(PropertiesUtil.FILENAME, "version");
        } catch (IOException e) {
            e.printStackTrace();

        }

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

