package com.chinawiserv.dsp.dcm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.dcm.entity.SysRoleMenu;
import com.chinawiserv.dsp.dcm.mapper.SysRoleMenuMapper;
import com.chinawiserv.dsp.dcm.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

	@Override
	public void addAuth(String roleId, String[] menuIds) {
		// TODO Auto-generated method stub
		
		/**
		 * 删除原有权限
		 */
		this.delete(new EntityWrapper<SysRoleMenu>().eq("roleId",roleId));
		/**
		 * 重新授权
		 */
		if(ArrayUtils.isNotEmpty(menuIds)){
			for(String menuId : menuIds){
				SysRoleMenu sysRoleMenu2 = new SysRoleMenu();
				sysRoleMenu2.setRoleId(roleId);
				sysRoleMenu2.setMenuId(menuId);
				this.insert(sysRoleMenu2);
			}
		}
	}

	@Override
	public List<SysRoleMenu> selectByRole(String roleId) {
		// TODO Auto-generated method stub
		
		EntityWrapper<SysRoleMenu> ew = new EntityWrapper<SysRoleMenu>();
		ew.addFilter("roleId = {0}", roleId);
		return this.selectList(ew);
		
	}


}
