package com.icefaces.bean;

//import org.apache.commons.lang.StringUtils;

import com.icefaces.core.models.Function;
import com.icefaces.core.security.AuthorizationBean;
import org.apache.commons.lang3.StringUtils;
import org.icefaces.ace.component.menuitem.MenuItem;
import org.icefaces.ace.component.submenu.Submenu;
import org.icefaces.ace.model.DefaultMenuModel;
import org.icefaces.ace.model.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.icefaces.core.constants.MPFAConstants.*;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

//import static org.apache.commons.collections.CollectionUtils.isNotEmpty;


public class MenuBean implements ActionListener {

    private MenuModel menuModel43 = new DefaultMenuModel();

    public static final String _VERSION = "$Id: MenuBean.java 1577 2011-03-23 01:29:43Z ken.chan $";

    public static final String _RELEASE = "$Name$";

    private static final Logger log = LoggerFactory.getLogger(MenuBean.class);

    private boolean initialized = false;

    private List<MenuItem> menuModel;

    private Map<String, Function> menuFuncMap;

    private Map<String, String> menuPathMap;

    private String applId = "GLOBAL";

    private String menuIdPrefix = CONST_MENU;

    @Autowired
    private AuthorizationBean authorizationBean;

    private String currentMenuId;

    private Function currentFunc = new Function();

    private String currentMenuPath;

    /**
     * get authorization bean
     *
     * @return authorizationBean Authorization Bean
     */
    public AuthorizationBean getAuthorizationBean() {
        return authorizationBean;
    }

    /**
     * set authorization bean
     *
     * @param authorizationBean Authorization Bean
     */
    public void setAuthorizationBean(AuthorizationBean authorizationBean) {
        this.authorizationBean = authorizationBean;
    }

    /**
     * reset the menu model and current menu path
     */
    public void reset() {
        setMenuModel(null);
        currentFunc = new Function();
        setCurrentMenuPath(null);
    }

    private void setMenuModel(List<MenuItem> menuModel) {
        this.menuModel = menuModel;
    }

    /**
     * get menu model for current login user
     *
     * @return MenuItem list
     */
    public List<MenuItem> getMenuModel() {

        if (!initialized) {
            init();
        }

        if (log.isDebugEnabled()) {
            log.debug("getMenuModel " + menuModel);
        }

        return menuModel;
    }

    /**
     * get application Id
     *
     * @return applId application Id
     */
    public String getApplId() {
        return applId;
    }

    /**
     * set application Id
     *
     * @param applId application Id
     */
    public void setApplId(String applId) {
        this.applId = applId;
    }

    private void initBuildModel(MenuModel model) {

        Submenu sm1 = new Submenu();
        sm1.setId("sm1");
        sm1.setLabel("Submenu 1");

        Submenu sm2 = new Submenu();
        sm2.setId("sm2");
        sm2.setLabel("Submenu 2");

        Submenu sm3 = new Submenu();
        sm3.setId("sm3");
        sm3.setLabel("Submenu 3");

        Submenu sm4 = new Submenu();
        sm4.setId("sm4");
        sm4.setLabel("Submenu 4");

        MenuItem m1 = new MenuItem();
        m1.setId("m1");
        m1.setValue("MenuItem 1");

        MenuItem m2 = new MenuItem();
        m2.setId("m2");
        m2.setValue("MenuItem 2");

        MenuItem m3 = new MenuItem();
        m3.setId("m3");
        m3.setValue("MenuItem 3");
        m3.setHelpText("MenuItem 3");

        MenuItem m4 = new MenuItem();
        m4.setId("m4");
        m4.setValue("MenuItem 4");

        sm1.getChildren().add(sm2);
        sm2.getChildren().add(sm3);
        sm3.getChildren().add(sm4);

        sm3.getChildren().add(m1);
        sm3.getChildren().add(m2);
        sm3.getChildren().add(m3);


        sm4.getChildren().add(m4);

        model.addSubmenu(sm1);

    }

    private void init() {

        final String applId = getApplId();
        final boolean isDebugEnabled = log.isDebugEnabled();

        if (isDebugEnabled) {
            log.debug("applId: " + applId);
        }

        List<Function> functions = authorizationBean.getFunctionList(applId);
        functions = filterNonMenu(functions);

        if (isDebugEnabled) {
            log.debug("No of functions after filtering: " + functions.size());
        }

        MenuModel initMenuModel = new DefaultMenuModel();
        List<MenuItem> menuModel = new ArrayList<MenuItem>();
        menuFuncMap = new HashMap<String, Function>();
        menuPathMap = new HashMap<String, String>();

        if (isNotEmpty(functions)) {
            Map<String, List<Function>> map = new HashMap<String, List<Function>>();

            for (Function func : functions) {
                String parentFuncId = func.getParentFuncId();
                List<Function> children = null;

                if (isDebugEnabled) {
                    log.debug("Process funcId: " + func.getFuncId() + " parentFuncId: " + parentFuncId);
                }

                if (map.containsKey(parentFuncId)) {
                    children = map.get(parentFuncId);
                } else {
                    children = new ArrayList<Function>();
                    map.put(parentFuncId, children);
                }

                addToMenu(children, func);
            }

            List<Function> topMenuItems = map.get(applId);

            if (topMenuItems != null && topMenuItems.size() > 0) {
                for (Function func : topMenuItems) {
                    if (isDebugEnabled) {
                        log.debug("Build top menu: " + func.getFuncId());
                    }

                    MenuItem topLevelMenu = prepareMenuItem(menuIdPrefix, "", map, func);
                    menuModel.add(topLevelMenu);

                    prepareMenu(menuIdPrefix, "", map, func, null, initMenuModel);

                }
            }
        }

        initBuildModel(initMenuModel);

        this.menuModel = menuModel;
        this.menuModel43 = initMenuModel;

        initialized = true;
    }

    /**
     * TODO
     * 1.add submenu abd menuItem icon
     * 2.add submenu background
     * 3.add menu help text
     *
     * @param idPrefix
     * @param menuPathPrefix
     * @param map
     * @param func
     * @param parentMenu
     * @param menuModel
     */
    private void prepareMenu(String idPrefix, String menuPathPrefix, Map<String, List<Function>> map, Function func, Submenu parentMenu, MenuModel menuModel) {
        final boolean isDebugEnabled = log.isDebugEnabled();
        final String appId = func.getApplId();
        final String parentFuncId = func.getParentFuncId();
        final String funcId = func.getFuncId();
        final String desc = func.getDescription();
        final String funcType = func.getFuncType();
        final String popUp = func.getPopUp();
        final String funcOnclick = func.getOnclick();

        if (isDebugEnabled) {
            log.debug("Prepare menu item for function " + funcId);
            log.debug("Prepare menu item for funcOnclick " + funcOnclick);
        }

        String id = idPrefix + "_" + appId + "_" + parentFuncId + "_" + funcId;
        String menuPath = "";

        if ("".equals(menuPathPrefix)) {
            menuPath = desc;
        } else {
            menuPath = menuPathPrefix + " > " + desc;
        }

        menuFuncMap.put(id, func);
        menuPathMap.put(id, menuPath);

        if (CONST_PROGRAM.equals(funcType)) {

            MenuItem menu = new MenuItem();
            menu.setId(id);
            menu.setValue(desc);
            //menu.setTitle(desc);
            menu.setImmediate(true); // Disable mandatory checking when click menu item.
            menu.addActionListener(this);
            menu.setHelpText(desc);


            // Skip icon for first level menu
            if (!idPrefix.equals(CONST_MENU)) {
//				menu.setIcon(CONST_ICON_URL);
            }

            if (CONST_FNC_POPUP.equals(popUp)) {
                String onclick = "";

                if (StringUtils.isNotEmpty(funcOnclick)) {
                    onclick = funcOnclick;
                    onclick += "; ";
                }
                onclick += "window.open('" + func.getLink() + "', 'self', 'modal=yes,width=" + func.getPopUpWidth() + ",height=" + func.getPopUpHeight() + ",toolbars=0,resizable=0'); return true;";

                if (isDebugEnabled) {
                    log.debug("id: " + id + " onclick: " + onclick);
                }

                menu.setOnclick(onclick);

            } else {
                if (StringUtils.isNotEmpty(funcOnclick)) {
                    String onclick = funcOnclick;
                    onclick += "; ";
                    menu.setOnclick(onclick);
                }
                FacesContext context = FacesContext.getCurrentInstance();
                ExpressionFactory factory = context.getApplication().getExpressionFactory();
                MethodExpression mexp = factory.createMethodExpression(context.getELContext(), func.getPath(), String.class, new Class[0]);
                menu.setActionExpression(mexp);
            }

            if (parentMenu != null) {
                parentMenu.getChildren().add(menu);
            } else {
                menuModel.addMenuItem(menu);
            }

        } else if (CONST_MENU.equals(funcType) && map.containsKey(funcId)) {

            Submenu menu = new Submenu();
            menu.setId(id);
            menu.setLabel(desc);
            menu.setValue(desc);
            //menu.setTitle(desc);
            menu.setImmediate(true); // Disable mandatory checking when click menu item.
            menu.addActionListener(this);

            // Skip icon for first level menu
            if (!idPrefix.equals(CONST_MENU)) {
//				menu.setIcon(CONST_ICON_URL);
            }

            if (parentMenu == null) {
                menuModel.addSubmenu(menu);
            } else {
                parentMenu.getChildren().add(menu);
            }

            List<Function> children = map.get(funcId);
            for (Function c : children) {
                prepareMenu(id, menuPath, map, c, menu, menuModel);
            }
        }

    }

    private List<Function> filterNonMenu(List<Function> functions) {
        List<Function> result = new ArrayList<Function>();

        if (isNotEmpty(functions)) {
            for (Function func : functions) {
                String funcType = func.getFuncType();
                boolean matchedType = CONST_MENU.equalsIgnoreCase(funcType) || CONST_PROGRAM.equalsIgnoreCase(funcType);
                boolean shown = CONST_SHOWONMENU.equalsIgnoreCase(func.getShownOnMenu());

                if (matchedType && shown) {
                    result.add(func);
                }
            }
        }

        return result;
    }

    private MenuItem prepareMenuItem(String idPrefix, String menuPathPrefix, Map<String, List<Function>> map, Function func) {

        final boolean isDebugEnabled = log.isDebugEnabled();
        final String appId = func.getApplId();
        final String parentFuncId = func.getParentFuncId();
        final String funcId = func.getFuncId();
        final String desc = func.getDescription();
        final String funcType = func.getFuncType();
        final String popUp = func.getPopUp();
        final String funcOnclick = func.getOnclick();

        if (isDebugEnabled) {
            log.debug("Prepare menu item for function " + funcId);
        }

        String id = idPrefix + "_" + appId + "_" + parentFuncId + "_" + funcId;
        String menuPath = "";

        if ("".equals(menuPathPrefix)) {
            menuPath = desc;
        } else {
            menuPath = menuPathPrefix + " > " + desc;
        }

        menuFuncMap.put(id, func);
        menuPathMap.put(id, menuPath);

        MenuItem menu = new MenuItem();

        menu.setId(id);
        menu.setValue(desc);
        //menu.setTitle(desc);
        menu.setImmediate(true); // Disable mandatory checking when click menu item.
        menu.addActionListener(this);
        // Skip icon for first level menu
        if (!idPrefix.equals(CONST_MENU)) {
            menu.setIcon(CONST_ICON_URL);
        }

        if (CONST_PROGRAM.equals(funcType)) {
            if (CONST_FNC_POPUP.equals(popUp)) {
                String onclick = "";

                if (StringUtils.isNotEmpty(funcOnclick)) {
                    onclick = funcOnclick;
                    onclick += "; ";
                }
                onclick += "window.open('" + func.getLink() + "', 'self', 'modal=yes,width=" + func.getPopUpWidth() + ",height=" + func.getPopUpHeight() + ",toolbars=0,resizable=0'); return true;";

                if (isDebugEnabled) {
                    log.debug("id: " + id + " onclick: " + onclick);
                }

                menu.setOnclick(onclick);

            } else {
                if (StringUtils.isNotEmpty(funcOnclick)) {
                    String onclick = funcOnclick;
                    onclick += "; ";
                    menu.setOnclick(onclick);
                }
                FacesContext context = FacesContext.getCurrentInstance();
                ExpressionFactory factory = context.getApplication().getExpressionFactory();
                MethodExpression mexp = factory.createMethodExpression(context.getELContext(), func.getPath(), String.class, new Class[0]);
                menu.setActionExpression(mexp);
            }
        } else if (CONST_MENU.equals(funcType) && map.containsKey(funcId)) {
            List<Function> children = map.get(funcId);
            for (Function c : children) {
                MenuItem mi = prepareMenuItem(id, menuPath, map, c);
                menu.getChildren().add(mi);

            }
        }

        if (isDebugEnabled) {
            log.debug("menu.id: " + menu.getId());
        }

        return menu;
    }


    private void addToMenu(List<Function> children, Function func) {
        int pos = 0;

        while (pos < children.size()) {
            Function c = children.get(pos);
            if (compare(func.getFuncSeq(), c.getFuncSeq()) < 0) {
                break;
            }
            pos++;
        }

        children.add(pos, func);
    }

    private int compare(Short a, Short b) {
        if (a == null && b == null) {
            return 0;
        } else if (a == null) {
            return -1;
        } else if (b == null) {
            return 1;
        } else {
            return a.compareTo(b);
        }
    }

    /**
     * process action when menu item is clicked
     *
     * @param event action event for process action
     */
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        final UIComponent component = event.getComponent();
        String id = component.getId();

        if (log.isDebugEnabled()) {
            log.debug("Menu is clicked. event: " + event + " event.class: " + event.getClass() + " event.component.class: " + component.getClass() + " event.component.id: " + id);
        }

        setCurrentMenuId(id);
    }

    /**
     * default menu process
     *
     * @return return link that set in R_FNC_FUNCTION.FNC_PATH
     */
    public String process() {
        final boolean isDebugEnabled = log.isDebugEnabled();

        if (isDebugEnabled) {
            log.debug("Menu.process is called.");
        }

        String link = "";

        if (currentFunc != null) {
            link = currentFunc.getLink();
        }

        if (isDebugEnabled) {
            log.debug("Go to link: " + link);
        }

        return link;
    }

    /**
     * get the prefix for menu id
     *
     * @return menu id prefix
     */
    public String getMenuIdPrefix() {
        return menuIdPrefix;
    }

    /**
     * set prefix for menu id
     *
     * @param menuIdPrefix menu id prefix
     */
    public void setMenuIdPrefix(String menuIdPrefix) {
        this.menuIdPrefix = menuIdPrefix;
    }

    /**
     * get current menu path
     *
     * @return current menu path
     */
    public String getCurrentMenuPath() {
        return currentMenuPath;
    }

    /**
     * set current menu path
     *
     * @param currentMenuPath current menu path
     */
    public void setCurrentMenuPath(String currentMenuPath) {
        this.currentMenuPath = currentMenuPath;
    }

    /**
     * get current function
     *
     * @return currentFunc current function
     */
    public Function getCurrentFunc() {
        return currentFunc;
    }

    /**
     * set current function
     *
     * @param currentFunc current function
     */
    public void setCurrentFunc(Function currentFunc) {
        this.currentFunc = currentFunc;
    }

    /**
     * get current menu id
     *
     * @return currentMenuId current menu id
     */
    public String getCurrentMenuId() {
        return currentMenuId;
    }

    /**
     * set current menu ID
     *
     * @param currentMenuId current menu id
     */
    public void setCurrentMenuId(String currentMenuId) {

        if (!initialized) {
            init();
        }

        Function func = menuFuncMap.get(currentMenuId);

        if (func != null && !CONST_FNC_POPUP.equals(func.getPopUp())) {
            this.currentMenuId = currentMenuId;
            currentFunc = func;
            currentMenuPath = menuPathMap.get(currentMenuId);
        }

        if (log.isDebugEnabled()) {
            log.debug("currentMenuId: " + currentMenuId + " currentMenuPath: " + currentMenuPath);
        }
    }

    public MenuModel getMenuModel43() {
        if (!initialized) {
            init();
        }
        return menuModel43;
    }

    public void setMenuModel43(MenuModel menuModel43) {
        this.menuModel43 = menuModel43;
    }

}
