package com.chinawiserv.dsp.dcs.dcm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.bean.SessionGlobal;
import com.chinawiserv.dsp.dcs.dcm.common.util.HttpUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.google.common.base.CaseFormat;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 基础控制器
 * @author Gaojun.Zhou
 * @date 2016年12月27日 上午11:50:57
 */
public class BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 默认分页大小
	 */
	private static final int DEFAULT_PAGE_SIZE = 15;

	//todo remove
//	@Autowired
//	protected HttpServletRequest request;

//	@Autowired
//	protected HttpServletResponse response;

//	@Autowired
//	protected HttpSession session;

//	@Autowired
//	protected ServletContext application;


	/**
	 * 返回登录 Token
	 */
//	protected SysUser getSSOToken() {
//		SysUser loginUser = ShiroUtils.getLoginUser();
//		if ( loginUser == null ) {
//			throw new RuntimeException("-1,The user does not exist, please relogin.");
//		}
//		return loginUser;
//	}


	/**
	 * 是否为 post 请求
	 */
//	protected boolean isPost() {
//		return HttpUtil.isPost(request);
//	}
//
//
//	/**
//	 * 是否为 get 请求
//	 */
//	protected boolean isGet() {
//		return HttpUtil.isGet(request);
//	}

	/**
	 * <p>
	 * 获取分页对象
	 * </p>
	 *
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	protected <T> Page<T> getPage( int pageNumber,int pageSize) {
		return new Page<T>(pageNumber, pageSize);
	}

	protected <T> Page<T> getPage(Map<String , Object> paramMap) {
		int pageNumber = MapUtils.getIntValue(paramMap , "pageNumber" , 1) ;
		int pageSize = MapUtils.getIntValue(paramMap , "pageSize" , DEFAULT_PAGE_SIZE) ;

		String sortName = MapUtils.getString(paramMap , "sortName");
		String sortOrder = MapUtils.getString(paramMap , "sortOrder");

		Page<T> page = new Page<T>(pageNumber , pageSize);
		if (StringUtils.isNotBlank(sortName)) {
			String sortNameUnderline = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sortName);
			page.setOrderByField(sortNameUnderline);
		}

		if (StringUtils.isNotBlank(sortOrder)) {
			page.setAsc(!"desc".equalsIgnoreCase(sortOrder));
		}

		return page;
	}
	/**
	 * <p>
	 * 获取分页对象
	 * @return
	 */
	//todo remove
	protected <T> Page<T> getPage(HttpServletRequest request) {
		String pageNumberStr = request.getParameter("pageNumber");
		String pageSizeStr = request.getParameter("pageSize");
		String sortName = request.getParameter("sortName");
		String sortOrder = request.getParameter("sortOrder");

		int pageNumber = 1 ;
		if (NumberUtils.isNumber(pageNumberStr)) {
			pageNumber = NumberUtils.toInt(pageNumberStr);
		}

		int pageSize = DEFAULT_PAGE_SIZE;
		if (NumberUtils.isNumber(pageSizeStr)) {
			pageSize = NumberUtils.toInt(pageSizeStr);
		}

		Page<T> page = new Page<T>(pageNumber , pageSize);
		if (StringUtils.isNotBlank(sortName)) {
			String sortNameUnderline = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sortName);
			page.setOrderByField(sortNameUnderline);
		}

		if (StringUtils.isNotBlank(sortOrder)) {
			page.setAsc(!"desc".equalsIgnoreCase(sortOrder));
		}

		return page;
	}


	/**
	 * 重定向至地址 url
	 * 
	 * @param url
	 *            请求地址
	 * @return
	 */
	protected String redirectTo( String url ) {
		StringBuffer rto = new StringBuffer("redirect:");
		rto.append(url);
		return rto.toString();
	}


	/**
	 * 
	 * 返回 JSON 格式对象
	 * 
	 * @param object
	 *            转换对象
	 * @return
	 */
//	protected String toJson( Object object ) {
//		return JSON.toJSONString(object, SerializerFeature.BrowserCompatible);
//	}


	/**
	 * 
	 * 返回 JSON 格式对象
	 * 
	 * @param object
	 *            转换对象
	 * @param format
	 *            序列化特点
	 * @return
	 */
//	protected String toJson( Object object, String format ) {
//		if ( format == null ) {
//			return toJson(object);
//		}
//		return JSON.toJSONStringWithDateFormat(object, format, SerializerFeature.WriteDateUseDateFormat);
//	}


	//************** todo ***********************
	//todo
	/**
	 * 获取回话对象
	 * @return 回话对象
	 */
	protected SessionGlobal getSessionGlobal() {
		SessionGlobal sessionGlobal = null;
		Object obj = ShiroUtils.getSessionAttribute(SessionGlobal.SESSIONGLOBAL);
		if (obj != null && obj instanceof SessionGlobal) {
			sessionGlobal = (SessionGlobal)obj;
		}
		return sessionGlobal;
	}

	/**
	 * 清楚回话信息
	 */
	protected void removeSessionGlobal() {
		ShiroUtils.removeSessionAttribute(SessionGlobal.SESSIONGLOBAL);
	}

	/**
	 * 从 Session 里 取 用户信息关（AccountId）
	 * @return 用户信息关（AccountId）
	 */
	public String getAccountIdFromSession() {
		SessionGlobal sessionGlobal = this.getSessionGlobal();
		if (sessionGlobal != null) {
			return sessionGlobal.getAccountId();
		}
		else {
			return "";
		}
	}

	/**
	 * 从 Session 里 取 部门id（AccountId）
	 * @return
	 */
	public String getDepartmentIdFromSession() {
		SessionGlobal sessionGlobal = this.getSessionGlobal();
		if (sessionGlobal != null) {
			return sessionGlobal.getDepartmentId();
		}
		else {
			return "";
		}
	}

	/**
	 * 从 Session 里 取 用户信息关（LoginName）
	 * @return 用户信息关（LoginName）
	 */
	public String getLoginNameFromSession() {
		SessionGlobal sessionGlobal = this.getSessionGlobal();
		if (sessionGlobal != null) {
			return sessionGlobal.getLoginName();
		}
		else {
			return "";
		}
	}

	/**
	 * 从 Session 里 取 用户信息关（RealName）
	 * @return 用户信息关（RealName）
	 */
	public String getRealNameFromSession() {
		SessionGlobal sessionGlobal = this.getSessionGlobal();
		if (sessionGlobal != null) {
			return sessionGlobal.getRealName();
		}
		else {
			return "";
		}
	}

	/**
	 * 获取请求 当前 URL
	 * @return 当前请求 URL
	 * @author AllenZhang
	 */
	public String getRequestURL(HttpServletRequest request) {
		if (request != null) {
			return request.getRequestURL().toString();
		}
		else {
			return "";
		}
	}

	/**
	 * 获取上下文基础地址
	 * @return 上下文基础地址
	 * @author AllenZhang
	 */
	public String getBasePath(HttpServletRequest request) {
		if (request != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath()).append("/");
			return buffer.toString();
		}
		else {
			return "";
		}
	}

}
