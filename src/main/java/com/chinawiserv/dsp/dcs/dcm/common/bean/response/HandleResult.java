package com.chinawiserv.dsp.dcs.dcm.common.bean.response;

import java.io.Serializable;
import java.util.HashMap;

public class HandleResult implements Serializable {
	private static final long serialVersionUID = -225799839622760757L;
	/**
	 * 返回结果状态
	 */
	private boolean state;
	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * 返回具体内容
	 */
	private HashMap<String, Object> content;
	
	public HandleResult() {
		this.content = new HashMap<String, Object>();
		this.state = true;
		this.msg = "";
	}

	public HandleResult success(String msg){
		this.state = true;
		this.msg = msg;
		return this;
	}

	public HandleResult error(String errorMsg){
		this.state = false;
		this.msg = errorMsg;
		return this;
	}

	public void put(String key, Object value) {
		if (content != null) {
			content.put(key, value);
		}
	}
	
	public Object get(String key) {
		if (content != null) {
			return content.get(key);
		}
		else {
			return null;
		}
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HashMap<String, Object> getContent() {
		return content;
	}

	public void setContent(HashMap<String, Object> content) {
		this.content = content;
	}
}
