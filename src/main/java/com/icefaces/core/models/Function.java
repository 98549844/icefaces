package com.icefaces.core.models;

import java.io.Serializable;
import java.util.Date;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table R_FNC_FUNCTION
 *
 * @mbggenerated
 *
 * @author OV Infrastructure Team
 *
 * @version $Id: Function.java 1423 2011-01-26 05:51:49Z kenneth.lu $
 * @version $Name$
 */
public class Function extends FunctionKey implements Serializable {
	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database table MPFA.R_FNC_FUNCTION
	 *
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1534715733162967187L;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_DESC
	 *
	 * @mbggenerated
	 */
	private String description;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_CREATE_DT
	 *
	 * @mbggenerated
	 */
	private Date created;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_CREATE_USER
	 *
	 * @mbggenerated
	 */
	private String createdBy;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_MODIFY_DT
	 *
	 * @mbggenerated
	 */
	private Date lastModified;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_MODIFY_USER
	 *
	 * @mbggenerated
	 */
	private String lastModifiedBy;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_FUNC_TYP
	 *
	 * @mbggenerated
	 */
	private String funcType;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_FUNC_SEQ
	 *
	 * @mbggenerated
	 */
	private Short funcSeq;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_LINK
	 *
	 * @mbggenerated
	 */
	private String link;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_ONCLICK
	 *
	 * @mbggenerated
	 */
	private String onclick;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_SHOWN_ON_MENU
	 *
	 * @mbggenerated
	 */
	private String shownOnMenu;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP
	 *
	 * @mbggenerated
	 */
	private String popUp;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP_WIDTH
	 *
	 * @mbggenerated
	 */
	private Short popUpWidth;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP_HEIGHT
	 *
	 * @mbggenerated
	 */
	private Short popUpHeight;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_PATH
	 *
	 * @mbggenerated
	 */
	private String path;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_PATH_PARAM
	 *
	 * @mbggenerated
	 */
	private String pathParam;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_SCREEN_ID
	 *
	 * @mbggenerated
	 */
	private String screenId;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column MPFA.R_FNC_FUNCTION.FNC_PROG_CLASS
	 *
	 * @mbggenerated
	 */
	private String progClass;

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_DESC
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_DESC
	 *
	 * @mbggenerated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_DESC
	 *
	 * @param description the value for MPFA.R_FNC_FUNCTION.FNC_DESC
	 *
	 * @mbggenerated
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_CREATE_DT
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_CREATE_DT
	 *
	 * @mbggenerated
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_CREATE_DT
	 *
	 * @param created the value for MPFA.R_FNC_FUNCTION.FNC_CREATE_DT
	 *
	 * @mbggenerated
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_CREATE_USER
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_CREATE_USER
	 *
	 * @mbggenerated
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_CREATE_USER
	 *
	 * @param createdBy the value for MPFA.R_FNC_FUNCTION.FNC_CREATE_USER
	 *
	 * @mbggenerated
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_MODIFY_DT
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_MODIFY_DT
	 *
	 * @mbggenerated
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_MODIFY_DT
	 *
	 * @param lastModified the value for MPFA.R_FNC_FUNCTION.FNC_MODIFY_DT
	 *
	 * @mbggenerated
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_MODIFY_USER
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_MODIFY_USER
	 *
	 * @mbggenerated
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_MODIFY_USER
	 *
	 * @param lastModifiedBy the value for MPFA.R_FNC_FUNCTION.FNC_MODIFY_USER
	 *
	 * @mbggenerated
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_FUNC_TYP
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_FUNC_TYP
	 *
	 * @mbggenerated
	 */
	public String getFuncType() {
		return funcType;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_FUNC_TYP
	 *
	 * @param funcType the value for MPFA.R_FNC_FUNCTION.FNC_FUNC_TYP
	 *
	 * @mbggenerated
	 */
	public void setFuncType(String funcType) {
		this.funcType = funcType == null ? null : funcType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_FUNC_SEQ
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_FUNC_SEQ
	 *
	 * @mbggenerated
	 */
	public Short getFuncSeq() {
		return funcSeq;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_FUNC_SEQ
	 *
	 * @param funcSeq the value for MPFA.R_FNC_FUNCTION.FNC_FUNC_SEQ
	 *
	 * @mbggenerated
	 */
	public void setFuncSeq(Short funcSeq) {
		this.funcSeq = funcSeq;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_LINK
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_LINK
	 *
	 * @mbggenerated
	 */
	public String getLink() {
		return link;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_LINK
	 *
	 * @param link the value for MPFA.R_FNC_FUNCTION.FNC_LINK
	 *
	 * @mbggenerated
	 */
	public void setLink(String link) {
		this.link = link == null ? null : link.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_ONCLICK
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_ONCLICK
	 *
	 * @mbggenerated
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_ONCLICK
	 *
	 * @param onclick the value for MPFA.R_FNC_FUNCTION.FNC_ONCLICK
	 *
	 * @mbggenerated
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick == null ? null : onclick.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_SHOWN_ON_MENU
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_SHOWN_ON_MENU
	 *
	 * @mbggenerated
	 */
	public String getShownOnMenu() {
		return shownOnMenu;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_SHOWN_ON_MENU
	 *
	 * @param shownOnMenu the value for MPFA.R_FNC_FUNCTION.FNC_SHOWN_ON_MENU
	 *
	 * @mbggenerated
	 */
	public void setShownOnMenu(String shownOnMenu) {
		this.shownOnMenu = shownOnMenu == null ? null : shownOnMenu.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_POP_UP
	 *
	 * @mbggenerated
	 */
	public String getPopUp() {
		return popUp;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP
	 *
	 * @param popUp the value for MPFA.R_FNC_FUNCTION.FNC_POP_UP
	 *
	 * @mbggenerated
	 */
	public void setPopUp(String popUp) {
		this.popUp = popUp == null ? null : popUp.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP_WIDTH
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_POP_UP_WIDTH
	 *
	 * @mbggenerated
	 */
	public Short getPopUpWidth() {
		return popUpWidth;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP_WIDTH
	 *
	 * @param popUpWidth the value for MPFA.R_FNC_FUNCTION.FNC_POP_UP_WIDTH
	 *
	 * @mbggenerated
	 */
	public void setPopUpWidth(Short popUpWidth) {
		this.popUpWidth = popUpWidth;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP_HEIGHT
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_POP_UP_HEIGHT
	 *
	 * @mbggenerated
	 */
	public Short getPopUpHeight() {
		return popUpHeight;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_POP_UP_HEIGHT
	 *
	 * @param popUpHeight the value for MPFA.R_FNC_FUNCTION.FNC_POP_UP_HEIGHT
	 *
	 * @mbggenerated
	 */
	public void setPopUpHeight(Short popUpHeight) {
		this.popUpHeight = popUpHeight;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_PATH
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_PATH
	 *
	 * @mbggenerated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_PATH
	 *
	 * @param path the value for MPFA.R_FNC_FUNCTION.FNC_PATH
	 *
	 * @mbggenerated
	 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_PATH_PARAM
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_PATH_PARAM
	 *
	 * @mbggenerated
	 */
	public String getPathParam() {
		return pathParam;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_PATH_PARAM
	 *
	 * @param pathParam the value for MPFA.R_FNC_FUNCTION.FNC_PATH_PARAM
	 *
	 * @mbggenerated
	 */
	public void setPathParam(String pathParam) {
		this.pathParam = pathParam == null ? null : pathParam.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_SCREEN_ID
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_SCREEN_ID
	 *
	 * @mbggenerated
	 */
	public String getScreenId() {
		return screenId;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_SCREEN_ID
	 *
	 * @param screenId the value for MPFA.R_FNC_FUNCTION.FNC_SCREEN_ID
	 *
	 * @mbggenerated
	 */
	public void setScreenId(String screenId) {
		this.screenId = screenId == null ? null : screenId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column MPFA.R_FNC_FUNCTION.FNC_PROG_CLASS
	 *
	 * @return the value of MPFA.R_FNC_FUNCTION.FNC_PROG_CLASS
	 *
	 * @mbggenerated
	 */
	public String getProgClass() {
		return progClass;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column MPFA.R_FNC_FUNCTION.FNC_PROG_CLASS
	 *
	 * @param progClass the value for MPFA.R_FNC_FUNCTION.FNC_PROG_CLASS
	 *
	 * @mbggenerated
	 */
	public void setProgClass(String progClass) {
		this.progClass = progClass == null ? null : progClass.trim();
	}

}