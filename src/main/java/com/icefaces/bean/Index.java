package com.icefaces.bean;


import com.icefaces.models.RFncFunction;
import com.icefaces.models.RUpfUserProfile;
import com.icefaces.models.UserProfile;
import com.icefaces.service.RFncFunctionService;
import com.icefaces.service.RUpfUserProfileService;
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

    private String profile = "select profile fail";
    private String rUpfUserProfile = "select RUpfUserProfile fail";
    private String fncFunction = "select FncFunction fail";

    @Autowired
    private AutoCompleteEntryBean autoCompleteEntryBean;
    private UsersService usersService;

    private RFncFunctionService rFncFunctionService;
    private RUpfUserProfileService rUpfUserProfileService;

    @PostConstruct
    public void init() {
        message = "Hello World! JSF INDEX";
        title = "ACE 4.3 Application";
        try {
            version = PropertiesUtil.getProperty(PropertiesUtil.FILENAME, "version");
            StringBuilder sb1 = new StringBuilder("--: ");
            StringBuilder sb2 = new StringBuilder("--: ");
            StringBuilder sb3 = new StringBuilder("--: ");

            usersService = (UsersService) BeanUtil.getBean("usersService");
            rFncFunctionService = (RFncFunctionService) BeanUtil.getBean("rFncFunctionService");
            rUpfUserProfileService = (RUpfUserProfileService) BeanUtil.getBean("rUpfUserProfileService");

            List<UserProfile> users = usersService.findAllMpfaDemoUsers();
            List<RFncFunction> rFncFunctionLs = rFncFunctionService.findAll();
            List<RUpfUserProfile> rUpfUserProfileLs = rUpfUserProfileService.selectAll();


            for (int i = 0; i < users.size(); i++) {
                System.out.println("MPFA USER:   " + users.get(i).getEnglishFirstName());
                sb1.append(users.get(i).getEnglishFirstName() + "; ");
            }
            System.out.println("-----------------------------");
            for (int i = 0; i < rFncFunctionLs.size(); i++) {
                System.out.println("R_FNC_FUNCTION:   " + rFncFunctionLs.get(i).getFncDesc());
                sb2.append(rFncFunctionLs.get(i).getFncDesc() + "; ");
            }
            System.out.println("-----------------------------");
            for (int i = 0; i < rUpfUserProfileLs.size(); i++) {
                System.out.println("R_UPF_USER_PROFILE:   " + rUpfUserProfileLs.get(i).getUpfEngName());
                sb3.append(rUpfUserProfileLs.get(i).getUpfEngName() + "; ");
            }


            profile = sb1.toString();
            rUpfUserProfile = sb2.toString();
            fncFunction = sb3.toString();
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
        return rUpfUserProfile;
    }

    public void setData(String data) {
        this.rUpfUserProfile = data;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getrUpfUserProfile() {
        return rUpfUserProfile;
    }

    public void setrUpfUserProfile(String rUpfUserProfile) {
        this.rUpfUserProfile = rUpfUserProfile;
    }

    public String getFncFunction() {
        return fncFunction;
    }

    public void setFncFunction(String fncFunction) {
        this.fncFunction = fncFunction;
    }
}

