package com.chinawiserv.dsp.dcs.dcm.service;

import com.chinawiserv.dsp.dcs.dcm.common.bean.Token;

/**
 * 权限服务接口
 *  Created by Gaojun.Zhou 2017年3月11日
 */
public interface IPermissionService{
	
	/**
	 * 判断某个用户是否拥有指定权限
	 */
	boolean hasPermission(Token token,String ermission);
	
	
}