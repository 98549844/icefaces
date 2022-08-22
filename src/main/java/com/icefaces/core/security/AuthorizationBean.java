////////////////////////////////////////////////////////////
//----------------------------------------------------------
// Copyright (c) 2010, by Object Valley (Asia Pacific) Ltd.
// All Rights Reserved.
//
//
// THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF OV.
// The copyright notice above does not evidence any
// actual or intended publication of such source code.
//
//----------------------------------------------------------
//
// Author: OV Infrastructure Team
//
// Creation Date: Jun 22, 2010 3:24:26 PM
//
////////////////////////////////////////////////////////////
package com.icefaces.core.security;

//import hk.org.mpfa.core.dao.AuthorizationDAO;
//import hk.org.mpfa.core.model.Function;
//import hk.org.mpfa.util.LoginUserHelper;

import com.icefaces.mapper.AuthorizationMapper;
import com.icefaces.core.models.AccessRight;
import com.icefaces.core.models.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.icefaces.core.constants.MPFAConstants.*;


/**
 * This class is to handle authorization for menu and access control.
 *
 * @author OV Infrastructure Team
 * @version $Name$
 */
@Repository
public class AuthorizationBean {

    public static final String _VERSION = "$Id: AuthorizationBean.java 1635 2011-04-28 11:21:05Z keith.wong $";
    public static final String _RELEASE = "$Name$";

    private static final Logger log = LoggerFactory.getLogger(AuthorizationBean.class);

//	static {
//		hk.org.mpfa.security.ProductManager.check(AuthorizationBean.class);
//	}

    @Autowired
    private AuthorizationMapper authorizationMapper;

    /**
     * get function list based on application Id and user Id
     *
     * @param appId application id
     * @return authorized function list based on the application Id and user Id
     */
    public List<Function> getFunctionList(String appId) {
//        String userId = LoginUserHelper.getUserSecurityName();
        String userId = "USER1";
        return getFunctionList(appId, userId);
    }

    private List<Function> getFunctionList(String appId, String userId) {
        return authorizationMapper.getFunctions(appId, userId);
    }

    /**
     * if the specified function is authorized
     *
     * @param appId  application Id
     * @param funcId function Id
     * @return true if function is authorized, false if not authorized
     */
    public boolean isAuthorized(String appId, String funcId) {
//        String userId = LoginUserHelper.getUserSecurityName();
        String userId = "USER1";
        return isAuthorized(appId, funcId, userId);
    }

    private boolean isAuthorized(String appId, String funcId, String userId) {
        return authorizationMapper.isAuthorized(appId, funcId, userId);
    }

    /**
     * get access control based on specified application Id and class name
     *
     * @param appId     application Id
     * @param className class name defined in R_FNC_FUNCTION.FNC_PROG_CLASS
     * @return accessRight authorized access right
     */
    public AccessRight getAccessRight(String appId, String className) {
//        String userId = LoginUserHelper.getUserSecurityName();
        String userId = "USER1";
        List<Function> functions = authorizationMapper.getAccessRight(appId, className, userId);
        AccessRight accessRight = new AccessRight();
        List<String> accessRightList = new ArrayList<String>();
        final int size = functions.size();

        if (functions != null && size > 0) {
            for (Function func : functions) {
                String parentFuncId = func.getParentFuncId();
                String funcId = func.getFuncId();

                if (funcId.equals(parentFuncId + CONST_ACCESS_SUF_FULL)) {
                    accessRight.setAllowSearch(true);
                    accessRight.setAllowAdd(true);
                    accessRight.setAllowEdit(true);
                    accessRight.setAllowDelete(true);
                    accessRight.setAllowApprove(true);
                    accessRightList.add(CONST_ACCESS_SUF_FULL);

                } else if (funcId.equals(parentFuncId + CONST_ACCESS_SUF_READ)) {
                    accessRight.setAllowSearch(true);
                    accessRightList.add(CONST_ACCESS_SUF_READ);

                } else if (funcId.equals(parentFuncId + CONST_ACCESS_SUF_INS)) {
                    accessRight.setAllowSearch(true);
                    accessRight.setAllowAdd(true);
                    accessRightList.add(CONST_ACCESS_SUF_INS);

                } else if (funcId.equals(parentFuncId + CONST_ACCESS_SUF_UPD)) {
                    accessRight.setAllowSearch(true);
                    accessRight.setAllowEdit(true);
                    accessRightList.add(CONST_ACCESS_SUF_UPD);

                } else if (funcId.equals(parentFuncId + CONST_ACCESS_SUF_DEL)) {
                    accessRight.setAllowSearch(true);
                    accessRight.setAllowDelete(true);
                    accessRightList.add(CONST_ACCESS_SUF_DEL);

                } else if (funcId.equals(parentFuncId + CONST_ACCESS_SUF_APPR)) {
                    accessRight.setAllowSearch(true);
                    accessRight.setAllowApprove(true);
                    accessRightList.add(CONST_ACCESS_SUF_APPR);
                } else if (funcId.equals(parentFuncId)) {
                    accessRightList.add(CONST_MENU);
                }
            }
            accessRight.setAccessRightList(accessRightList);
        }

        if (log.isDebugEnabled()) {
            log.debug("className: " + className + " userId: " + userId + " functions.size: " + size + " accessRight: " + accessRight);
        }

        return accessRight;
    }
}
