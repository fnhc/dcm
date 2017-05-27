package com.chinawiserv.dsp.dcs.dcm.service.system.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.SystemConst;
import com.chinawiserv.dsp.dcs.dcm.common.bean.ZTreeNode;
import com.chinawiserv.dsp.dcs.dcm.common.enums.system.Menu;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysRoleMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysMenuVo;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.TreeMenu;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysMenuMapper;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysRoleMenuMapper;
import com.chinawiserv.dsp.dcs.dcm.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysMenuService;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysRoleMenuService;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysMenuServiceImpl extends CommonServiceImpl<SysMenuMapper, SysMenu, SysMenuVo> implements ISysMenuService {

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



    /*public Page<SysMenuVo> getMenuList(Page<SysMenuVo> page, Map<String, Object> paramMap){
        String searchKey = MapUtils.getString(paramMap, "searchKey");
        EntityWrapper<SysMenu> ew = new EntityWrapper<>();
        if(StringUtils.isNotBlank(searchKey)){
            ew.like("menu_name", searchKey);
        }
        List<SysMenu> pageList = sysMenuMapper.selectPage(page , ew);
        page.setRecords(pageList);
        page.setTotal(pageList == null ? 0 : pageList.size());
        return page;
    }*/

    @Override
    public Page<SysMenuVo> getMenuList(Map<String, Object> paramMap) throws Exception{
        Page<SysMenuVo> page = getPage(paramMap);
        List<SysMenuVo> pageList = sysMenuMapper.select(page, paramMap);
        for(SysMenuVo menu : pageList){
            if(menu.getPid() == null || menu.getMenuType() !=3){
                menu.setMenuName(StringUtils.join("<i class='fa fa-folder-open'></i> ",menu.getMenuName()));
            }else{
                menu.setMenuName(StringUtils.join("<i class='fa fa-file'></i> ",menu.getMenuName()));
            }
            for(int i=1;i<menu.getMenuType();i++){
                menu.setMenuName(StringUtils.join("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",menu.getMenuName()));
            }

        }
        page.setRecords(pageList);
        return page;
    }

    @Override
    public SysMenuVo getEditData(String menuId) throws Exception{
        return sysMenuMapper.selectMenuById(menuId);
    }

    @Override
    public List<JSONObject> getSelectDataForCatalog(Map<String , Object> paramMap) throws Exception{
        List<JSONObject> selectDataList = null;
        String menuId = MapUtils.getString(paramMap, "id");
        String menuType = MapUtils.getString(paramMap, "menuType");
        Map<String , Object> params = new HashMap<>();
        params.put("menuType", menuType);
        List<SysMenuVo> catalogList = sysMenuMapper.select(new Page<>(), params);
        if(!ObjectUtils.isEmpty(catalogList)) {
            selectDataList = converToSelectData(catalogList);
        }
        if(!ObjectUtils.isEmpty(menuId) && !ObjectUtils.isEmpty(selectDataList)){
            SysMenuVo obj = sysMenuMapper.selectMenuById(menuId);
            int objMenuType = obj.getMenuType();
            //这个时候有两种情况，一种是菜单页面获取目录信息，一种是功能页面获取目录信息，层级不一样
            SysMenuVo catalog = null;
            if(objMenuType == SystemConst.SYS_MENU_TYPE_MENU){
                catalog = sysMenuMapper.selectCatalogByMenuId(menuId);
            }else if(objMenuType == SystemConst.SYS_MENU_TYPE_FUNCTION){
                catalog = sysMenuMapper.selectCatalogByFunctionId(menuId);
            }
            //设置选中项
            if(!ObjectUtils.isEmpty(catalog)){
                String catalogId = catalog.getId();
                for(JSONObject data : selectDataList){
                    String dataId = data.getString("id");
                    if(dataId.equals(catalogId)){
                        data.put("selected","selected");
                    }
                }
            }
        }
        return selectDataList;
    }

    @Override
    public List<JSONObject> getSelectDataForMenuById(Map<String , Object> paramMap) throws Exception{
        List<JSONObject> selectDataList = null;
        String functionId = MapUtils.getString(paramMap, "id");
        if(!ObjectUtils.isEmpty(functionId)){
            List<SysMenuVo> menuVoList = sysMenuMapper.selectMenusByFunctionId(functionId);
            if(!ObjectUtils.isEmpty(menuVoList)){
                selectDataList = converToSelectData(menuVoList);
                SysMenuVo functionObj =sysMenuMapper.selectMenuById(functionId);
                String menuId = functionObj.getPid();
                for(JSONObject data : selectDataList){
                    String dataId = data.getString("id");
                    if(dataId.equals(menuId)){
                        data.put("selected","selected");
                    }
                }
            }
        }
        return selectDataList;
    }

    @Override
    public List<JSONObject> getSelectDataForMenuByPid(Map<String , Object> paramMap) throws Exception{
        List<JSONObject> selectDataList = null;
        List<SysMenuVo> menuVoList = sysMenuMapper.select(new Page<>(), paramMap);
        if(!ObjectUtils.isEmpty(menuVoList)){
            selectDataList = converToSelectData(menuVoList);
        }
        return selectDataList;
    }

    @Cacheable(value = "permissionCache", key = "#uid")
	@Override
	public List<String> selectMenuIdsByuserId(String uid) throws Exception{
		return sysMenuMapper.selectMenuIdsByuserId(uid);
	}

	@Override
	public List<TreeMenu> selectTreeMenuByMenuIdsAndPid(final List<String> menuIds,
			String pid) {

		EntityWrapper<SysMenu> ew = new EntityWrapper<>();
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
			if(sysMenu.getMenuType() < 2){
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
	public List<ZTreeNode> selectTreeMenuAllowAccessByMenuIdsAndPid(
			final List<String> menuIds, String pid) {

		EntityWrapper<SysMenu> ew = new EntityWrapper<>();
		ew.orderBy("sort", true);
		ew.addFilter("pid = {0} ", pid);
		List<SysMenu> sysMenus = this.selectList(ew);
		List<ZTreeNode> zTreeNodeList = Lists.transform(sysMenus, sysMenu -> {

			ZTreeNode zTreeNode = generateBasicNode(sysMenu.getMenuName() , true);
			zTreeNode.setId(sysMenu.getId());
			zTreeNode.setPId(sysMenu.getPid());

			/**
			 * 是否有权限
			 */
			if(menuIds.contains(sysMenu.getId())){
				zTreeNode.setChecked(true);
			}
			/**
			 * 子节点
			 */
			if(sysMenu.getMenuType() < 3){
				zTreeNode.setIsParent(true);
				zTreeNode.setChildren(selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds,sysMenu.getId()));
			}
			return zTreeNode;
		});

		return zTreeNodeList;
	}

	private ZTreeNode generateBasicNode(String nodeName,boolean isOpen){
		ZTreeNode basicNode = new ZTreeNode();
		basicNode.setId("0");
		basicNode.setCode("0");
		basicNode.setName(nodeName);
		basicNode.setOpen(isOpen);
		basicNode.setChecked(false);
//        basicNode.setNocheck(true);
		basicNode.setIsParent(false);
		return basicNode;
	}

    @Override
    public boolean insertVO(SysMenuVo sysMenuVo) throws Exception {
        sysMenuVo.setId(UUID.randomUUID().toString());
        sysMenuVo.setCreateUserId(ShiroUtils.getLoginUserId());
        sysMenuVo.setCreateTime(new Date());
        sysMenuVo.setStatus(SystemConst.SYS_STATUS_NORMAL);
        return insert(sysMenuVo);
    }

    @Override
    public boolean updateVO(SysMenuVo sysMenuVo) throws Exception {
        sysMenuVo.setUpdateUserId(ShiroUtils.getLoginUserId());
        sysMenuVo.setUpdateTime(new Date());
        return updateById(sysMenuVo);
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        boolean deleteResult = false;
        String id = MapUtils.getString(paramMap, "id");
        if(!ObjectUtils.isEmpty(id)){
            SysMenuVo sysMenuVo = sysMenuMapper.selectMenuById(id);
            if(!ObjectUtils.isEmpty(sysMenuVo)){
                sysMenuVo.setUpdateUserId(ShiroUtils.getLoginUserId());
                sysMenuVo.setUpdateTime(new Date());
                sysMenuVo.setStatus(SystemConst.SYS_STATUS_DELETE);
                deleteResult = updateById(sysMenuVo);
            }
        }
        return deleteResult;
    }

	@Override
	public SysMenuVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<SysMenuVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

	@Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return 0;
    }


    private List<JSONObject> converToSelectData(List<SysMenuVo> menuList){
        List<JSONObject> jsonList = null;
        if(!ObjectUtils.isEmpty(menuList)){
            jsonList = new ArrayList<>();
            for(SysMenu menu : menuList){
                JSONObject obj = new JSONObject();
                obj.put("id",menu.getId());
                obj.put("text",menu.getMenuName());
                jsonList.add(obj);
            }
        }
        return jsonList;
    }

}
