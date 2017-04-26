package com.chinawiserv.dsp.dcm.common.bean.response;

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
	private HashMap<String, Object> map;
	
	public HandleResult() {
		this.map = new HashMap<String, Object>();
		this.state = true;
		this.msg = "";
	}

	public HandleResult error(String errorMsg){
		this.state = false;
		this.msg = errorMsg;
		return this;
	}

	public void put(String key, Object value) {
		if (map != null) {
			map.put(key, value);
		}
	}
	
	public Object get(String key) {
		if (map != null) {
			return map.get(key);
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

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
}
