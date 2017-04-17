package com.chinawiserv.dsp.dcm.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcm.common.anno.Permission;
import com.chinawiserv.dsp.dcm.common.bean.Response;
import com.chinawiserv.dsp.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcm.entity.SysRole;
import com.chinawiserv.dsp.dcm.entity.SysUser;
import com.chinawiserv.dsp.dcm.entity.SysUserRole;
import com.chinawiserv.dsp.dcm.service.ISysDeptService;
import com.chinawiserv.dsp.dcm.service.ISysRoleService;
import com.chinawiserv.dsp.dcm.service.ISysUserRoleService;
import com.chinawiserv.dsp.dcm.service.ISysUserService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysUserService sysUserService;
    @Autowired private ISysRoleService sysRoleService;
    @Autowired private ISysUserRoleService sysUserRoleService;
    @Autowired private ISysDeptService sysDeptService;

    /**
     * 分页查询用户
     */
    @Permission("listUser")
    @RequestMapping("/list/{pageNumber}")
    public  String list(@PathVariable Integer pageNumber, @RequestParam(defaultValue="15") Integer pageSize, String search, Model model){
        if(StringUtils.isNotBlank(search)){
            model.addAttribute("search", search);
        }
        Page<Map<Object, Object>> page = getPage(pageNumber,pageSize);
        model.addAttribute("pageSize", pageSize);
        Page<Map<Object, Object>> pageData = sysUserService.selectUserPage(page, search);
        model.addAttribute("pageData", pageData);
        return "system/user/list";
    }
    /**
     * 新增用户
     */
    @Permission("addUser")
    @RequestMapping("/add")
    public  String add(Model model){
        model.addAttribute("roleList", sysRoleService.selectList(null));
        model.addAttribute("deptList", sysDeptService.selectList(null));
        return "system/user/add";
    }

    /**
     * 执行新增
     */
    @Log("创建用户")
    @Permission("addUser")
    @RequestMapping("/doAdd")
    public  String doAdd(SysUser user,String[] roleId){

        sysUserService.insertUser(user,roleId);
        return redirectTo("/system/user/list/1");
    }
    /**
     * 删除用户
     */
    @Log("删除用户")
    @Permission("deleteUser")
    @RequestMapping("/delete")
    @ResponseBody
    public Response delete(String id){
        sysUserService.delete(id);
        return new Response().success();
    }

    /**
     * 编辑用户
     */
    @RequestMapping("/edit/{id}")
    @Permission("editUser")
    public  String edit(@PathVariable String id,Model model){
        SysUser sysUser = sysUserService.selectById(id);

        List<SysRole> sysRoles = sysRoleService.selectList(null);
        EntityWrapper<SysUserRole> ew = new EntityWrapper<SysUserRole>();
        ew.addFilter("user_id = {0} ", id);
        List<SysUserRole> mySysUserRoles = sysUserRoleService.selectList(ew);
        List<String> myRolds = Lists.transform(mySysUserRoles, input -> input.getRoleId());

        model.addAttribute("sysUser",sysUser);
        model.addAttribute("sysRoles",sysRoles);
        model.addAttribute("myRolds",myRolds);
        model.addAttribute("deptList", sysDeptService.selectList(null));
        return "system/user/edit";
    }
    /**
     * 执行编辑
     */
    @Log("编辑用户")
    @Permission("editUser")
    @RequestMapping("/doEdit")
    public  String doEdit(SysUser sysUser,String[] roleId,Model model){
        sysUserService.updateUser(sysUser,roleId);
        return redirectTo("/system/user/list/1");
    }

    /**
     * 验证用户名是否已存在
     */
    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(String userName){

        List<SysUser> list = sysUserService.selectList(new EntityWrapper<SysUser>().addFilter("user_name = {0}", userName));
        if(list.size() > 0){
            return "{\"error\":\" "+userName+" 用户名已存在,请换一个尝试.\"}";
        }
        return "{\"ok\":\"用户名很棒.\"}";
    }


}
