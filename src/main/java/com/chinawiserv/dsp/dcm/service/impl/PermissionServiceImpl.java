package com.chinawiserv.dsp.dcm.service.impl;

import com.chinawiserv.dsp.dcm.common.bean.Token;
import com.chinawiserv.dsp.dcm.service.IPermissionService;
import com.chinawiserv.dsp.dcm.service.ISysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限service实现
 *  Created by Gaojun.Zhou 2017年3月11日
 */
@Service
public class PermissionServiceImpl  implements IPermissionService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ISysMenuService sysMenuService;
	
	@Override
	public boolean hasPermission(Token token, String permission) {
		// TODO Auto-generated method stub
		
		if(token == null){
			throw new RuntimeException("非法的用户");
		}
		
		List<String> permissionList =  sysMenuService.selectMenuIdsByuserId(token.getUid());
		
		if(permissionList.contains(permission)){
			return true;
		}
		
		logger.warn(String.format("无[%s]访问权限,uid:%s",permission,token.getUid()));
		
		return false;
	}

}