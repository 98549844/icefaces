package com.icefaces.bean;

import org.icefaces.samples.showcase.util.FacesUtils;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = TabServerSideBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class TabServerSideBean implements Serializable {
    public static final String BEAN_NAME = "tabServerSide";
    public String getBeanName() { return BEAN_NAME; }

    private boolean fastTabs = true; // Add delay (large image, backend wait etc.) to tab loading make tabset difference clear

    public String getSlowDownTab() {
        try { Thread.sleep(2000); }
        catch (Exception e) {
            FacesUtils.addErrorMessage("Server-side tab waiting could not finish.");
        }
        return "";
    }

    public void setSlowDownTab(String slowDownTab) {}

    public boolean isFastTabs() {
        return fastTabs;
    }

    public void setFastTabs(boolean fastTabs) {
        this.fastTabs = fastTabs;
    }
}