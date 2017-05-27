package com.chinawiserv.dsp.dcs.dcm.service.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.bean.ZTreeNode;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysMenu;
import com.baomidou.mybatisplus.service.IService;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysMenuVo;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.TreeMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.TreeMenuAllowAccess;
import com.chinawiserv.dsp.dcs.dcm.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysMenuService extends ICommonService<SysMenu, SysMenuVo> {


    /**
     * 获取指定查询条件的菜单
     */
    Page<SysMenuVo> getMenuList(Map<String , Object> paramMap) throws Exception;

    /**
     * 获取某个菜单的详情信息
     */
    SysMenuVo getEditData(String menuId) throws Exception;

    /**
     * 获取目录下拉框中的信息
     */
    List<JSONObject> getSelectDataForCatalog(Map<String , Object> paramMap) throws Exception;

    /**
     * 获取菜单下拉框中的信息(通过功能的id)
     */
    List<JSONObject> getSelectDataForMenuById(Map<String , Object> paramMap) throws Exception;

    /**
     * 获取菜单下拉框中的信息(通过目录的id)
     */
    List<JSONObject> getSelectDataForMenuByPid(Map<String , Object> paramMap) throws Exception;

    /**
     * 获取指定用户拥有的菜单
     */
    List<String> selectMenuIdsByuserId(String uid) throws Exception;
    /**
     * 获取指定用户的菜单
     * @param  menuIds 当前用户所在角色拥有的权限ID集合
     * @param  pid 菜单父ID
     */
    List<TreeMenu> selectTreeMenuByMenuIdsAndPid(List<String> menuIds, String pid);
    /**
     * 获取当前用户的菜单
     */
    List<TreeMenu> selectTreeMenuByUserId(String uid);
    /**
     * 获取指定用户拥有权限
     * @param  menuIds 该角色拥有的权限ID集合
     * @param  pid 菜单父ID
     */
    List<ZTreeNode> selectTreeMenuAllowAccessByMenuIdsAndPid(List<String> menuIds, String pid);
}
