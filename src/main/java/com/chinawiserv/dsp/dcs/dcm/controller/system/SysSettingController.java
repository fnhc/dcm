package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.HandleResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.PageResult;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysSetting;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysSettingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;


/**
 * <p>
 * 系统设置表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/setting")
public class SysSettingController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysSettingService sysSettingService;

    @RequiresPermissions("system:setting:list")
    @RequestMapping("")
    public  String init(HttpServletRequest request, HttpServletResponse response){
        return "system/setting/settingList";
    }

    /**
     * 查询系统设置
     */
    @RequiresPermissions("system:setting:list")
    @RequestMapping("/list")
    @ResponseBody
    public  PageResult list(@RequestParam Map<String , Object> paramMap){
        final PageResult pageResult = new PageResult();
        try {
            final Page<SysSettingVo> pageData = sysSettingService.selectVoPage(paramMap);
            pageResult.setPage(pageData);
        }catch (Exception e){
            pageResult.error("分页查询系统配置出错");
            logger.error("分页查询系统配置出错", e);
        }
        return pageResult;
    }

    /**
     * 新增组织机构
     */
//    @RequiresPermissions("addSetting")
    @RequestMapping("/add")
    public  String add(){
        return "system/setting/settingAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("addSetting")
    @Log("创建系统配置")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysSettingVo sysSettingVo){
        try {
            sysSettingService.insertVO(sysSettingVo);
        }catch (Exception e){
            logger.error("创建系统配置出错", e);
        }
        return new HandleResult().success("创建系统配置成功");
    }

    /**
     * 编辑系统配置
     */
    @RequiresPermissions("system:setting:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id,Model model){
        model.addAttribute("settingId",id);
        return "system/setting/settingEdit";
    }

    /**
     * 编辑系统配置
     */
    @RequiresPermissions("system:setting:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            SysSetting setting = sysSettingService.selectById(id);
            handleResult.put("vo", setting);
        }catch (Exception e){
            logger.error("加载系统配置出错", e);
        }
        return handleResult;
    }

    @RequiresPermissions("system:setting:edit")
    @Log("更新系统设置")
    @RequestMapping("/doEdit")
    @ResponseBody
    public HandleResult doSetting(SysSettingVo sysSettingVo){
        try {
            sysSettingVo.setUpdateUserId(ShiroUtils.getLoginUserId());
            sysSettingVo.setUpdateTime(new Date());
            sysSettingService.updateById(sysSettingVo);
        }catch (Exception e){
            logger.error("编辑系统配置出错", e);
        }
        return new HandleResult().success("编辑系统配置成功");
    }

    /**
     * 删除系统设置
     */
//    @RequiresPermissions("deleteSetting")
    @Log("删除系统设置")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
        try {
            sysSettingService.deleteById(id);
        }catch (Exception e){
            logger.error("删除系统配置出错", e);
        }
        return new HandleResult().success("删除成功");
    }
}
