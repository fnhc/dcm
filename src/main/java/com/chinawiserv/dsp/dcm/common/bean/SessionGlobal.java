package com.chinawiserv.dsp.dcm.common.bean;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Session 对象
 */
public class SessionGlobal implements Serializable {
	
	private static final long serialVersionUID = 7506887334057350480L;

	/**
	 * Session的Key值
	 */
	public static final String SESSIONGLOBAL = "SessionGlobal";
	
	/**
	 * 当前用户Id  
	 */
	private String accountId;
	
	/**
	 * 当前部门Id
	 */
	private String departmentId;
	
	/**
	 * 用户真实名称
	 */
	private String realName;
	
	/**
	 * 用户登录名称
	 */
	private String loginName;
	
	/**
	 * 最后访问该Session的IP 
	 */
	private String lastAccessedIP;
	
	private String uistyle;

	private HttpSession session;
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getLastAccessedIP() {
		return lastAccessedIP;
	}

	public void setLastAccessedIP(String lastAccessedIP) {
		this.lastAccessedIP = lastAccessedIP;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUistyle() {
		return uistyle;
	}

	public void setUistyle(String uistyle) {
		this.uistyle = uistyle;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
}