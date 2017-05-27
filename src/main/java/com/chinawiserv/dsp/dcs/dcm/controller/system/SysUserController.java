package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.HandleResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.PageResult;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysDept;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysRole;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysDeptService;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysRoleService;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysUserRoleService;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysUserService;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * 初始化用户列表
     */
    @RequiresPermissions("system:user:list")
    @RequestMapping("")
    public String init(HttpServletRequest request, HttpServletResponse response){
        return "system/user/userList";
    }
    /**
     * 分页查询用户
     */
      @RequiresPermissions("system:user:list")
      @RequestMapping("/list")
      @ResponseBody
      public PageResult list(@RequestParam Map<String , Object> paramMap){
          PageResult pageResult = new PageResult();
          try {
              Page<SysUserVo> pageData = sysUserService.selectVoPage(paramMap);
              pageResult.setPage(pageData);
          } catch (Exception e) {
              e.printStackTrace();
              pageResult.error("查询用户列表出错");
          }
          return pageResult;
      }
    /**
     * 新增用户
     */
      @RequiresPermissions("system:user:add")
      @RequestMapping("/add")
      public  String add(){
        return "system/user/userAdd";
    }

    /**
     * 执行新增
     */
    @Log("创建用户")
    @RequiresPermissions("system:user:add")
    @RequestMapping("/doAdd")
    @ResponseBody
    public  HandleResult doAdd(SysUserVo user){
        HandleResult result = new HandleResult();
        try {
            sysUserService.insertVO(user);
        } catch (Exception e) {
            e.printStackTrace();
             return result.error("创建用户失败");
        }
        return result.success("创建用户成功");
    }
    /**
     * 删除用户
     */
    @Log("删除用户")
    @RequiresPermissions("system:user:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(String id){
        sysUserService.delete(id);
        return new HandleResult().success("删除用户成功");
    }

    /**
     * 编辑用户
     */
    @RequiresPermissions("system:user:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
        model.addAttribute("id",id);
        return "system/user/userEdit";
    }
    /**
     * 加载编辑用户数据
     */
    @RequiresPermissions("system:user:edit")
    @RequestMapping("/loadEditData")
    @ResponseBody
    public HandleResult loadEditData(@RequestParam String id,Model model){
        HandleResult result = new HandleResult();
        SysUserVo userVo = null;
        try {
            userVo = sysUserService.selectVoById(id);
            result.put("user",userVo);
        } catch (Exception e) {
            result.error("加载用户信息出错");
            e.printStackTrace();
        }

        return result;
    }
    /**
     * 执行编辑
     */
    @RequiresPermissions("system:user:edit")
    @Log("编辑用户")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysUserVo user,Model model){
        HandleResult result = new HandleResult();
        try {
            sysUserService.updateVO(user);
        } catch (Exception e) {
            e.printStackTrace();
            result.error("编辑用户失败");
        }
        return result.success("编辑用户成功");
    }

    /**
     * 验证注册用户名是否已存在
     */
    @RequestMapping("/insertCheckName")
    @ResponseBody
    public String insertCheckName(String userName){

        List<SysUser> list = sysUserService.selectList(new EntityWrapper<SysUser>().addFilter("user_name = {0}", userName));
        if(list.size() > 0){
            return "{\"error\":\" "+userName+" 用户名已存在,请换一个尝试.\"}";
        }
        return "{\"ok\":\"用户名很棒.\"}";
    }
    /**
     * 验证编辑用户名是否已存在
     */
    @RequestMapping("/editCheckName")
    @ResponseBody
    public String editCheckName(String userName,HttpServletRequest request) {
        String id = request.getParameter("userId");
        if (StringUtils.isNotBlank(id)) {
            SysUser user = sysUserService.selectById(id);
            String originalName = user.getUserName();
            if (StringUtils.equals(originalName, userName)) {
                return "{\"ok\":\"\"}";
            } else {
                List<SysUser> list = sysUserService.selectList(new EntityWrapper<SysUser>().addFilter("user_name = {0}", userName));
                if (list.size() > 0) {
                    return "{\"error\":\" " + userName + " 用户名已存在,请换一个尝试.\"}";
                }
                return "{\"ok\":\"新用户名很棒.\"}";
            }

        }
        else {
            return "{\"error\":\"验证失败\"}";
        }
    }

}




//    public  String edit(@PathVariable String id,Model model){
//        SysUser sysUser = sysUserService.selectById(id);
//
//        List<SysRole> sysRoles = sysRoleService.selectList(null);
//        EntityWrapper<SysUserRole> ew = new EntityWrapper<SysUserRole>();
//        ew.addFilter("user_id = {0} ", id);
//        List<SysUserRole> mySysUserRoles = sysUserRoleService.selectList(ew);
//        List<String> myRolds = Lists.transform(mySysUserRoles, input -> input.getRoleId());
//
//        model.addAttribute("sysUser",sysUser);
//        model.addAttribute("sysRoles",sysRoles);
//        model.addAttribute("myRolds",myRolds);
//        model.addAttribute("deptList", sysDeptService.selectList(null));
//        return "system/user/edit";
//    }

//    @Log("编辑用户")
//    @RequiresPermissions("editUser")
//    @RequestMapping("/doEdit")
//    public  String doEdit(SysUser sysUser,String[] roleId,Model model){
//        sysUserService.updateUser(sysUser,roleId);
//        return redirectTo("/system/user/list/1");
//    }