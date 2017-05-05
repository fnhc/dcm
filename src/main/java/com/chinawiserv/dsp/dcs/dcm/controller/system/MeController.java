package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.chinawiserv.dsp.dcs.dcm.common.util.CommonUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.chinawiserv.dsp.dcs.dcm.common.util.TokenUtil;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.SysUser;
import com.chinawiserv.dsp.dcs.dcm.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户中心控制器
 * @author Gaojun.Zhou
 * @date 2016年12月16日 下午4:24:04
 */
@Controller
@RequestMapping("/system/me")
public class MeController extends BaseController{

	@Autowired
    private ISysUserService sysUserService;
	
    @RequestMapping("/page")
    public  String page(Model model){
    	SysUser sysUser = ShiroUtils.getLoginUser();
    	model.addAttribute("sysUser", sysUser);
		return "system/me/page";
    } 
    
    /**
     * 修改密码
     */
    @RequestMapping("/doChangePwd")
    public String doChangePwd(String password,String newpassword,String newpassword2,Model model){
    	
    	if(StringUtils.isBlank(password) || StringUtils.isBlank(newpassword) || StringUtils.isBlank(newpassword2)){
    		model.addAttribute("msg","客户端提交数据不能为空.");
    		model.addAttribute("act","2");
    		return "system/me/page";
    	}
    	
    	SysUser user = sysUserService.selectById(TokenUtil.getToken(request).getUid());
    	if(!user.getPassword().equals(CommonUtil.string2MD5(password))){
    		model.addAttribute("msg","旧密码输入错误.");
    		model.addAttribute("act","2");
    		return "system/me/page";
    	}
    	
    	if(!newpassword2.equals(newpassword)){
    		model.addAttribute("msg","两次输入的密码不一致.");
    		model.addAttribute("act","2");
    		return "system/me/page";
    	}
    	
    	user.setPassword(CommonUtil.string2MD5(newpassword));
    	sysUserService.updateById(user);
    	
    	model.addAttribute("info","密码修改成功.");
		model.addAttribute("act","2");
		return "system/me/page";
    }
    
}
