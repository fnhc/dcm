package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.HandleResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.ListResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.PageResult;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysRoleVo;
import com.chinawiserv.dsp.dcs.dcm.service.system.*;
import com.google.common.collect.Lists;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/role")
public class SysRoleController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 角色服务
     */
    @Autowired
    private ISysRoleService sysRoleService;
    /**
     * 角色用户服务
     */
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    /**
     * 用户服务
     */
    @Autowired
    private ISysUserService sysUserService;
    /**
     * 角色权限服务
     */
    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    @RequiresPermissions("system:role:list")
    @RequestMapping("")
    public String init(HttpServletRequest request, HttpServletResponse response) {
        return "system/role/roleList";
    }

    /**
     * 分页查询角色
     */
    @RequiresPermissions("system:role:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String, Object> paramMap) {
        PageResult pageResult = new PageResult();
        try {
            Page<SysRoleVo> page = sysRoleService.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询角色出错");
            logger.error("分页查询角色出错", e);
        }
        return pageResult;
    }

    /**
     * 新增角色
     */
    @RequiresPermissions("system:role:add")
    @RequestMapping("/add")
    public String add() {
        return "system/role/roleAdd";
    }

    /**
     * 执行新增角色
     */
    @RequiresPermissions("system:role:add")
    @Log("创建角色")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysRoleVo role) {
        HandleResult handleResult = new HandleResult();
        try {
            sysRoleService.insertVO(role);
            handleResult.success("创建角色成功");
        } catch (Exception e) {
            handleResult.error("创建角色失败");
            logger.error("创建角色失败", e);
        }
        return handleResult;
    }

    /**
     * 删除角色
     */
    @RequiresPermissions("system:role:delete")
    @Log("删除角色")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id) {
        HandleResult handleResult = new HandleResult();
        try {
            sysRoleService.deleteRoleById(id);
            handleResult.success("删除角色成功");
        } catch (Exception e) {
            handleResult.error("删除角色失败");
            logger.error("删除角色失败+" + id, e);
        }
        return handleResult;
    }

    /**
     * 批量删除角色
     */
    @RequiresPermissions("system:role:deleteBatch")
    @Log("批量删除角色")
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public HandleResult deleteBatch(@RequestParam("idArr[]") List<String> ids) {
        HandleResult handleResult = new HandleResult();
        try {
            sysRoleService.deleteBatchRoleByIds(ids);
            handleResult.success("批量删除角色成功");
        } catch (Exception e) {
            handleResult.error("批量删除角色失败");
            logger.error("批量删除角色失败", e);
        }
        return handleResult;
    }

    /**
     * 编辑角色
     */
    @RequiresPermissions("system:role:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model) {
        model.addAttribute("roleId", id);
        return "system/role/roleEdit";
    }

    /**
     * 编辑角色
     */
    @RequiresPermissions("system:role:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public HandleResult editLoad(@RequestParam String id) {
        HandleResult handleResult = new HandleResult();
        try {
            SysRoleVo sysRole = sysRoleService.selectVoById(id);
            handleResult.put("vo", sysRole);
        } catch (Exception e) {
            handleResult.error("获取角色信息失败");
            logger.error("获取角色信息失败", e);
        }
        return handleResult;
    }

    /**
     * 执行编辑角色
     */
    @RequiresPermissions("system:role:edit")
    @Log("编辑角色")
    @RequestMapping("/doEdit")
    @ResponseBody
    public HandleResult doEdit(SysRoleVo sysRole) {
        HandleResult handleResult = new HandleResult();
        try {
            sysRoleService.updateVO(sysRole);
            handleResult.success("编辑角色成功");
        } catch (Exception e) {
            handleResult.error("编辑角色失败");
            logger.error("编辑角色失败", e);
        }
        return handleResult;
    }

    /**
     * 权限
     */
    @RequiresPermissions("system:role:auth")
    @RequestMapping("/auth")
    public String auth(@RequestParam String id, Model model) {
        model.addAttribute("id", id);
        return "system/role/roleAuth";
    }

    /**
     * 权限
     */
    @RequiresPermissions("system:role:auth")
    @RequestMapping("/getAuth")
    @ResponseBody
    public ListResult getAuth(@RequestParam String id) {
        ListResult listResult = new ListResult();
        try {
            listResult = sysRoleService.getAuth(id);
        } catch (Exception e) {
            listResult.error("获取角色权限失败");
            logger.error("获取角色权限失败", e);
        }
        return listResult;
    }

    /**
     * 权限
     */
    @RequiresPermissions("system:role:auth")
    @Log("角色授权")
    @RequestMapping("/doAuth")
    @ResponseBody
    public HandleResult doAuth(String roleId, String[] menuIds) {
        sysRoleMenuService.addAuth(roleId, menuIds);
        return new HandleResult().success("角色授权成功");
    }

    /**
     * 获取角色下的所有用户
     */
    @RequestMapping("/getUsers")
    public String getUsers(String roleId, Model model) {

        List<SysUserRole> sysUserRoles = sysUserRoleService.selectList(new EntityWrapper<SysUserRole>().addFilter("role_id = {0}", roleId));

        List<String> userIds = Lists.transform(sysUserRoles, input -> input.getUserId());

        List<SysUser> users = new ArrayList<SysUser>();

        if (userIds.size() > 0) {
            EntityWrapper<SysUser> ew = new EntityWrapper<SysUser>();
            ew.in("id", userIds);
            users = sysUserService.selectList(ew);
        }

        model.addAttribute("users", users);
        return "system/role/users";
    }

    /**
     * 获取指定角色的用户数量
     */
    @RequestMapping("/getCount")
    @ResponseBody
    public String getCount(String roleId) {
        int count = sysUserRoleService.selectCount(new EntityWrapper<SysUserRole>().addFilter("role_id = {0}", roleId));
        return String.valueOf(count);
    }

    @RequestMapping("/checkRoleName")
    @ResponseBody
    public JSONObject checkRoleName(@RequestParam String roleName, String roleId) {
        JSONObject result = new JSONObject();
        try {
            result = sysRoleService.checkRoleName(roleName, roleId);
        } catch (Exception e) {
            result.put("error", "角色名验证失败");
            logger.error("角色名验证失败", e);
        }
        return result;
    }

    @RequestMapping("/getRoleNameList")
    @ResponseBody
    public HandleResult getRoleNameList(String userId) {
        HandleResult handleResult = new HandleResult();
        try {
            List<JSONObject> result = sysRoleService.getRoleNameList(userId);
            handleResult.put("selectData", result);
        } catch (Exception e) {
            handleResult.error("获取角色名称失败");
            logger.error("获取角色名称失败", e);
        }
        return handleResult;
    }


}
