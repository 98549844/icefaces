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
package com.icefaces.core.models;

import java.io.Serializable;
import java.util.List;

/**
 * Access right for actions
 *
 * @author OV Infrastructure Team
 *
 * @version $Id: AccessRight.java 1069 2010-12-10 09:14:27Z kenneth.ip $
 * @version $Name$
 */
public class AccessRight implements Serializable {

	public static final String _VERSION = "$Id: AccessRight.java 1069 2010-12-10 09:14:27Z kenneth.ip $";

	public static final String _RELEASE = "$Name$";

	private static final long serialVersionUID = 1627853779858531284L;

	private boolean allowSearch;

	private boolean allowAdd;

	private boolean allowEdit;

	private boolean allowDelete;

	private boolean allowApprove;

	private List<String> accessRightList;

	/**
	 * get allowSearch
	 *
	 * @return the allowSearch
	 */
	public boolean isAllowSearch() {
		return allowSearch;
	}

	/**
	 * set allowSearch to given value
	 *
	 * @param allowSearch the allowSearch to set
	 */
	public void setAllowSearch(boolean allowSearch) {
		this.allowSearch = allowSearch;
	}

	/**
	 * get allowAdd
	 *
	 * @return the allowAdd
	 */
	public boolean isAllowAdd() {
		return allowAdd;
	}

	/**
	 * set allowAdd to given value
	 *
	 * @param allowAdd the allowAdd to set
	 */
	public void setAllowAdd(boolean allowAdd) {
		this.allowAdd = allowAdd;
	}

	/**
	 * get allowEdit
	 *
	 * @return the allowEdit
	 */
	public boolean isAllowEdit() {
		return allowEdit;
	}

	/**
	 * set allowEdit to given value
	 *
	 * @param allowEdit the allowEdit to set
	 */
	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	/**
	 * get allowDelete
	 *
	 * @return the allowDelete
	 */
	public boolean isAllowDelete() {
		return allowDelete;
	}

	/**
	 * set allowDelete to given value
	 *
	 * @param allowDelete the allowDelete to set
	 */
	public void setAllowDelete(boolean allowDelete) {
		this.allowDelete = allowDelete;
	}

	/**
	 * get isAllowApprove
	 *
	 * @return the isAllowApprove
	 */
	public boolean isAllowApprove() {
		return allowApprove;
	}

	/**
	 * set allowApprove to given value
	 *
	 * @param allowApprove the allowApprove to set
	 */
	public void setAllowApprove(boolean allowApprove) {
		this.allowApprove = allowApprove;
	}

	public List<String> getAccessRightList() {
		return accessRightList;
	}

	public void setAccessRightList(List<String> accessRightList) {
		this.accessRightList = accessRightList;
	}

	/**
	 * return string buffer for fields value
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(super.toString());
		sb.append(" allowSearch: ");
		sb.append(allowSearch);
		sb.append(" allowAdd: ");
		sb.append(allowAdd);
		sb.append(" allowEdit: ");
		sb.append(allowEdit);
		sb.append(" allowDelete: ");
		sb.append(allowDelete);
		sb.append(" allowApprove: ");
		sb.append(allowApprove);

		return sb.toString();
	}
}
