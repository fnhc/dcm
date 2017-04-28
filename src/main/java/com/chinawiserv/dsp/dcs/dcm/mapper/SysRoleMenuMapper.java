package com.chinawiserv.dsp.dcs.dcm.mapper;

import com.chinawiserv.dsp.dcs.dcm.entity.SysRoleMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 角色菜单关联表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

	/**
	 * 根据用户Id获取用户所在角色的权限
	 */
	public List<SysRoleMenu> selectRoleMenuByUserId(String uid);
	
}