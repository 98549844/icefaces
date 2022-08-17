package com.icefaces.bean;


import com.icefaces.models.UserProfile;
import com.icefaces.models.Users;
import com.icefaces.service.UsersService;
import com.icefaces.util.BeanUtil;
import com.icefaces.util.PropertiesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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
//@CustomScoped(value = "#{window}")
public class Index implements Serializable {

    private static Logger log = LogManager.getLogger(Index.class.getName());


    private String message = "message";
    private String title = "title";
    private String version = "version";

    private String data = "default no records";

    @Autowired
    private AutoCompleteEntryBean autoCompleteEntryBean;
    private UsersService usersService;

    @PostConstruct
    public void init() {
        message = "Hello World! JSF INDEX";
        title = "ACE 4.3 Application";
        try {
            version = PropertiesUtil.getProperty(PropertiesUtil.FILENAME, "version");
            StringBuilder sb = new StringBuilder("--: ");

            usersService = (UsersService) BeanUtil.getBean("usersService");
            List<UserProfile> users = usersService.findAllMpfaDemoUsers();

            for (int i = 0; i < users.size(); i++) {
                System.out.println("MPFA USER:   " + users.get(i).getEnglishFirstName());
                sb.append(users.get(i).getEnglishFirstName() + "; ");
            }
            data = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String getMessage() {
        if (autoCompleteEntryBean != null && autoCompleteEntryBean.getSelectedText() != null) {
            message = autoCompleteEntryBean.getSelectedText();
        }
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

