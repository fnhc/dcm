package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.SystemConst;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.HandleResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.ListResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.PageResult;
import com.chinawiserv.dsp.dcs.dcm.common.enums.system.Menu;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysDept;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysMenuVo;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysRoleVo;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysMenuService;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 菜单服务
     */
    @Autowired
    private ISysMenuService sysMenuService;

    @RequestMapping("")
    public  String init(){
        return "system/menu/menuList";
    }

    /**
     * 分页查询菜单
     */
    @RequiresPermissions("system:menu:list")
    @RequestMapping("/list")
    @ResponseBody
    public  PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<SysMenuVo> page = sysMenuService.getMenuList(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            logger.error("查询菜单列表时出错",e.getMessage());
            e.printStackTrace();
            pageResult.error("查询菜单列表时出错");
        }
        return pageResult;
    }

    /**
     * 增加菜单
     */
    @RequiresPermissions("system:menu:add")
    @RequestMapping("/add")
    public String add(){
        return "system/menu/menuAdd";

    }
    /**
     * 添加目录
     */
    /*@RequiresPermissions("addMenu")
    @Log("新增菜单")
    @RequestMapping("/doAddDir")
    public String doAddDir(SysMenuVo sysMenu,Model model){

        sysMenu.setPid("0");
        sysMenu.setMenuType(1);
        sysMenuService.insert(sysMenu);
        return redirectTo("/system/menu/list/1.html");
    }*/

    /**
     * 添加菜单
     */
    @RequiresPermissions("system:menu:add")
    @Log("新增菜单")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAddMenu(SysMenuVo sysMenu){
        HandleResult handleResult = new HandleResult();
        try {
            boolean result = sysMenuService.insertVO(sysMenu);
            if(result){
                handleResult.success("新增菜单信息成功");
            }else{
                handleResult.error("新增菜单信息失败");
            }
        } catch (Exception e) {
            handleResult.error("新增菜单信息失败");
            logger.error("新增菜单信息失败", e);
        }
        return handleResult;
    }


    /**
     * 获取菜单类型的下拉框信息列表(由枚举类转换成下拉框格式数据)
     */
    @RequiresPermissions("system:menu:add")
    @RequestMapping("/menuTypeList")
    @ResponseBody
    public HandleResult getMenuTypeList(){
        HandleResult handleResult = new HandleResult();
        try {
            handleResult.put("menuType",Menu.MenuType.getEnumList());
        } catch (Exception e) {
            handleResult.error("获取菜单类型信息失败");
            logger.error("获取菜单类型信息失败", e);
        }
        return handleResult;
    }

    /**
     * 编辑菜单
     */
    @RequiresPermissions("system:menu:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id,Model model){
        model.addAttribute("id", id);
        SysMenu sysMenu =sysMenuService.selectById(id);
        if(sysMenu.getMenuType() == SystemConst.SYS_MENU_TYPE_CATALOG){
            return  "system/menu/editCatalog";
        }else if(sysMenu.getMenuType() == SystemConst.SYS_MENU_TYPE_MENU){
            return "system/menu/editMenu";
        }else{
            return  "system/menu/editFunction";
        }
    }

    /**
     * 获取要编辑菜单的数据内容
     */
    @RequiresPermissions("system:menu:edit")
    @RequestMapping("/editData")
    @ResponseBody
    public HandleResult getEditData(@RequestParam String id){
        HandleResult result = new HandleResult();
        try {
            SysMenuVo sysMenuVo = sysMenuService.getEditData(id);
            result.put("sysMenu",sysMenuVo);
        } catch (Exception e) {
            e.printStackTrace();
            result.error("获取菜单的基本信息出错");
        }
        return result;
    }

    /**
     * 获取下拉框中菜单的内容(封装成json数组的格式)
     */
    @RequiresPermissions("system:menu:list")
    @RequestMapping("/menuSelect")
    @ResponseBody
    public HandleResult getSelectData(@RequestParam Map<String , Object> paramMap){
        HandleResult result = new HandleResult();
        List<JSONObject> selectDataList;
        try {
            String menuType = MapUtils.getString(paramMap, "menuType");
            if(!ObjectUtils.isEmpty(menuType)){
                selectDataList = sysMenuService.getSelectDataForCatalog(paramMap);
            }else{
                String pid = MapUtils.getString(paramMap, "pid");
                if(!ObjectUtils.isEmpty(pid)){
                    selectDataList = sysMenuService.getSelectDataForMenuByPid(paramMap);
                }else{
                    selectDataList = sysMenuService.getSelectDataForMenuById(paramMap);
                }
            }
            result.put("selectData",selectDataList);
        } catch (Exception e) {
            e.printStackTrace();
            result.error("获取菜单下拉框的信息列表出错");
        }
        return result;
    }


    /**
     * 保存菜单的修改
     */
    @RequiresPermissions("system:menu:edit")
    @Log("编辑菜单")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysMenuVo sysMenu){
        HandleResult handleResult = new HandleResult();
        try {
            sysMenuService.updateVO(sysMenu);
            handleResult.success("修改菜单信息成功");
        } catch (Exception e) {
            handleResult.error("修改菜单信息失败");
            logger.error("修改菜单信息失败", e);
        }
        return handleResult;
    }

    /**
     * 执行编辑菜单
     */
    @RequiresPermissions("system:menu:delete")
    @Log("删除菜单")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam Map<String, Object> param){
        HandleResult handleResult = new HandleResult();
        try {
            boolean result = sysMenuService.deleteByQuery(param);
            if(result){
                handleResult.success("删除菜单信息成功");
            }else{
                handleResult.success("删除菜单信息失败");
            }
        } catch (Exception e) {
            handleResult.error("删除菜单信息失败");
            logger.error("删除菜单信息失败", e);
        }
        return handleResult;
    }



    /**
     * 根据父节点获取子菜单
     */
    @RequestMapping("/json")
    @ResponseBody
    public ListResult json(String pid){
        EntityWrapper<SysMenu> ew = new EntityWrapper<>();
        ew.orderBy("sort");
        ew.addFilter("pid = {0} ", pid);
        List<SysMenu> list = sysMenuService.selectList(ew);

        List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
        for(SysMenu m : list){
            Map<String, Object> map = Maps.newHashMap();
            map.put("id", m.getId());
            map.put("text",m.getMenuName());
            listMap.add(map);
        }
        //todo
        ListResult listResult = new ListResult<Map<String, Object>>();
        listResult.addAll(listMap);
        return listResult ;
//        return new Response().success(listMap);
    }


    /**
     * 验证菜单资源名称是否存在
     */
    @RequestMapping("/checkMenuResource")
    @ResponseBody
    public String checkMenuResource(String resource){

        List<SysMenu> list = sysMenuService.selectList(new EntityWrapper<SysMenu>().addFilter("resource = {0}", resource));
        if(list.size() > 0){
            return "{\"error\":\" "+resource+" 资源已存在,请换一个尝试.\"}";
        }
        return "{\"ok\":\"资源名称很棒.\"}";
    }

    @RequiresPermissions("system:menu:add")
    @Log("新增功能菜单")
    @RequestMapping("/doAddAction")
    public String doAddAction(SysMenuVo sysMenu,Model model){
        sysMenu.setMenuType(3);
        sysMenuService.insert(sysMenu);
        return redirectTo("/system/menu/list/1.html");
    }

}
