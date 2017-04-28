package com.chinawiserv.dsp.dcs.dcm.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.chinawiserv.dsp.dcs.dcm.entity.SysUser;
import com.chinawiserv.dsp.dcs.dcm.service.ISysLogService;
import com.chinawiserv.dsp.dcs.dcm.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Login;
import com.chinawiserv.dsp.dcs.dcm.common.bean.Token;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.common.enums.Action;
import com.chinawiserv.dsp.dcs.dcm.common.util.IpUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.TokenUtil;
/**
 * 登录控制器
 * @author Gaojun.Zhou
 * @date 2016年12月14日 下午2:54:01
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	/**
	 * 用户服务
	 */
	@Autowired private ISysUserService sysUserService;
	/**
	 * 日志服务
	 */
	@Autowired private ISysLogService sysLogService;
	
	/**
	 * 登录页面
	 * @throws UnsupportedEncodingException 
	 */
	@Login(action=Action.Skip)
	@RequestMapping(value={"","/","/index"})
	public String login(String return_url,Model model) throws UnsupportedEncodingException{
		String index = "/index";
		model.addAttribute("return_url", StringUtils.isNotBlank(return_url)?URLDecoder.decode(return_url,"UTF-8"):index);
		return "login";
	}
	
	/**
	 * 执行登录
	 */
	@Login(action=Action.Skip)
    @RequestMapping(value = "/doLogin",method=RequestMethod.POST)  
    public  String doLogin(String userName,String password, String captcha,String return_url,Model model){
		//todo 打开验证码
//		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password) ||  StringUtils.isBlank(captcha)){
//			model.addAttribute("error", "用户名/密码/验证码不能为空.");
//			return "login";
//		}
//
//		String sessionCaptcha = new KaptchaExtend().getGeneratedKey(request);
//		if(StringUtils.isBlank(sessionCaptcha)){
//			model.addAttribute("error", "验证码已过期,请重新输入.");
//			return "login";
//		}
//		if(!captcha.toLowerCase().equals(sessionCaptcha.toLowerCase())){
//			model.addAttribute("error", "验证码错误.");
//			return "login";
//		}
		SysUser sysUser = sysUserService.login(userName,password);
		if(sysUser==null){
			model.addAttribute("error", "用户名或密码错误.");
			return "login";
		}
		/**
		 * 登录成功
		 */
		Token token = new Token();
		token.setUid(sysUser.getId());
		token.setUname(sysUser.getUserName());
		token.setIp(IpUtil.getIpAddr(request));
		TokenUtil.addToken(token, request);
		/**
		 * 记录登录日志
		 */
		sysLogService.insertLog("用户登录成功",sysUser,request.getRequestURI(),"******");
		if(StringUtils.isNotBlank(return_url)){
			return redirectTo(return_url);
		}
		return redirectTo("/index");
    }  
	
	/**
	 * 退出系统
	 * @return
	 * @throws IOException 
	 */
	@Login(action=Action.Skip)
    @RequestMapping(value = "/logout")  
    public void logout(HttpServletResponse response) throws IOException{
		Token st = TokenUtil.getToken(request);

		SysUser sysUser = new SysUser();
		sysUser.setId(st.getUid());
		sysUser.setUserName(st.getUname());

		TokenUtil.clearLogin(request, response);
		response.sendRedirect("/login");
		sysLogService.insertLog("用户退出系统",sysUser,request.getRequestURI(),"******");
    }  
    
    /**
     * 验证码
     */
	@Login(action=Action.Skip)
    @RequestMapping("/captcha")
	@ResponseBody
    public  void captcha(HttpServletResponse response) throws ServletException, IOException{
		KaptchaExtend kaptchaExtend =  new KaptchaExtend();
		kaptchaExtend.captcha(request, response);
    }
}
