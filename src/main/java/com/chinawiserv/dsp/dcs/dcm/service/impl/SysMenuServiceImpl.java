package com.chinawiserv.dsp.dcs.dcm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.dcs.dcm.entity.SysMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.SysRoleMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.TreeMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.TreeMenuAllowAccess;
import com.chinawiserv.dsp.dcs.dcm.mapper.SysMenuMapper;
import com.chinawiserv.dsp.dcs.dcm.mapper.SysRoleMenuMapper;
import com.chinawiserv.dsp.dcs.dcm.service.ISysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chinawiserv.dsp.dcs.dcm.service.ISysRoleMenuService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

	/**
	 * 角色权限服务
	 */
	@Autowired private ISysRoleMenuService sysRoleMenuService;
	/**
	 * 菜单服务
	 */
	@Autowired private SysMenuMapper sysMenuMapper;
	/**
	 * 角色菜单关系服务
	 */
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	

	@Cacheable(value = "permissionCache", key = "#uid")
	@Override
	public List<String> selectMenuIdsByuserId(String uid) {
		return sysMenuMapper.selectMenuIdsByuserId(uid);
	}

	@Override
	public List<TreeMenu> selectTreeMenuByMenuIdsAndPid(final List<String> menuIds,
			String pid) {

		EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
		ew.orderBy("sort", true);
		ew.addFilter("pid = {0} ", pid);
		ew.in("id", menuIds.size() > 0 ? menuIds : Lists.newArrayList(RandomStringUtils.randomNumeric(30)));
		List<SysMenu> sysMenus = this.selectList(ew);
		
		List<TreeMenu> treeMenus = Lists.transform(sysMenus, sysMenu -> {
			TreeMenu treeMenu = new TreeMenu();
			treeMenu.setSysMenu(sysMenu);
			/**
			 * 子节点
			 */
			if(sysMenu.getDeep() < 2){
				treeMenu.setChildren(selectTreeMenuByMenuIdsAndPid(menuIds,sysMenu.getId()));
			}
			return treeMenu;
		});
		return treeMenus;
		
	}
	
	@Cacheable(value = "menuCache", key = "#uid")
	@Override
	public List<TreeMenu> selectTreeMenuByUserId(String uid) {
		/**
		 * 当前用户二级菜单权限
		 */
		List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectRoleMenuByUserId(uid);
		/**
		 * 当前用户菜单主键
		 */
		List<String> menuIds = Lists.transform(sysRoleMenus,sysRoleMenu -> sysRoleMenu.getMenuId());
		return selectTreeMenuByMenuIdsAndPid(menuIds, "0");
	}
	
	@Override
	public List<TreeMenuAllowAccess> selectTreeMenuAllowAccessByMenuIdsAndPid(
			final List<String> menuIds, String pid) {

		EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
		ew.orderBy("sort", true);
		ew.addFilter("pid = {0} ", pid);
		List<SysMenu> sysMenus = this.selectList(ew);
		List<TreeMenuAllowAccess> treeMenuAllowAccesss = Lists.transform(sysMenus, sysMenu -> {
			
			TreeMenuAllowAccess treeMenuAllowAccess = new TreeMenuAllowAccess();
			treeMenuAllowAccess.setSysMenu(sysMenu);
			/**
			 * 是否有权限
			 */
			if(menuIds.contains(sysMenu.getId())){
				treeMenuAllowAccess.setAllowAccess(true);
			}
			/**
			 * 子节点
			 */
			if(sysMenu.getDeep() < 3){
				treeMenuAllowAccess.setChildren(selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds,sysMenu.getId()));
			}
			return treeMenuAllowAccess;
		});
		return treeMenuAllowAccesss;
	}

}
