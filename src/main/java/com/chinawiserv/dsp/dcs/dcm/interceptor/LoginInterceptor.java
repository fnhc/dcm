package com.chinawiserv.dsp.dcs.dcm.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinawiserv.dsp.dcs.dcm.entity.SysSetting;
import com.chinawiserv.dsp.dcs.dcm.entity.SysUser;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.TreeMenu;
import com.chinawiserv.dsp.dcs.dcm.service.ISysMenuService;
import com.chinawiserv.dsp.dcs.dcm.service.ISysSettingService;
import com.chinawiserv.dsp.dcs.dcm.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Login;
import com.chinawiserv.dsp.dcs.dcm.common.bean.Token;
import com.chinawiserv.dsp.dcs.dcm.common.enums.Action;
import com.chinawiserv.dsp.dcs.dcm.common.util.HttpUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.SpringUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.TokenUtil;
/**
 * 登录拦截器
 * @author Gaojun.Zhou
 * @date 2016年12月27日 上午11:52:56
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private ISysSettingService sysSettingService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (handler instanceof HandlerMethod) {
			
			/**
			 * 加载全局非登录访问常量
			 */
			List<SysSetting> list =  sysSettingService.selectList(new EntityWrapper<SysSetting>().orderBy("sort",true));
			for(SysSetting setting : list){
				request.setAttribute(setting.getSysKey(),setting.getSysValue());
			}
			
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Login login = method.getAnnotation(Login.class);
			if (login != null) {
				if (login.action() == Action.Skip) {
					return true;
				}
			}

			/**
			 * 正常执行
			 */
			Token token = TokenUtil.getToken(request);
			if (token == null) {
				if (HttpUtil.isAjax(request)) {
					HttpUtil.ajaxStatus(response, 302, "session expires.");
					return false;
				} else {
					TokenUtil.clearRedirectLogin(request, response);
					return false;
				}
			} else {
				/**
				 * 保存登录信息
				 */
				SysUser me = SpringUtil.getBean(ISysUserService.class).selectById(token.getUid());
				me.setPassword("");
				request.setAttribute("me", me);
				/**
				 * 资源和当前选中菜单
				 */
				String res = request.getParameter("res");
				if (StringUtils.isNotBlank(res)) {
					request.getSession().setAttribute("res", res);
				}
				String cur = request.getParameter("cur");
				if (StringUtils.isNotBlank(cur)) {
					request.getSession().setAttribute("cur", cur);
				}
				/**
				 * 获取当前用户的菜单
				 */
				List<TreeMenu> treeMenus = SpringUtil.getBean(ISysMenuService.class).selectTreeMenuByUserId(token.getUid());
				request.setAttribute("treeMenus", treeMenus);
				
				/**
				 * 获取当前用户的权限列表,用于控制页面功能按钮是否显示
				 */
				List<String> list2 = SpringUtil.getBean(ISysMenuService.class).selectMenuIdsByuserId(token.getUid());
				String[] permissions = list2.toArray(new String[list2.size()]);
				request.setAttribute("permissions", permissions);
			}
		}

		/**
		 * 通过拦截
		 */
		return true;
	}

}
