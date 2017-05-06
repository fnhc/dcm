package com.chinawiserv.dsp.dcs.dcm.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.SystemConst;
import com.google.common.base.CaseFormat;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 基础控制器
 * @author Gaojun.Zhou
 * @date 2016年12月27日 上午11:50:57
 */
public class BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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

	/**
	 * 获取分页对象
	 * @param paramMap
	 * @param <T>
	 * @return
	 */
	protected <T> Page<T> getPage(Map<String , Object> paramMap) {
		int pageNumber = MapUtils.getIntValue(paramMap , "pageNumber" , 1) ;
		int pageSize = MapUtils.getIntValue(paramMap , "pageSize" , SystemConst.DEFAULT_PAGE_SIZE) ;

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

		int pageSize = SystemConst.DEFAULT_PAGE_SIZE;
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
