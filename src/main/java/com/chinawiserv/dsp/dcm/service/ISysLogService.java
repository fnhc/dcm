package com.chinawiserv.dsp.dcm.service;

import com.chinawiserv.dsp.dcm.entity.SysLog;
import com.baomidou.mybatisplus.service.IService;
import com.chinawiserv.dsp.dcm.entity.SysUser;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysLogService extends IService<SysLog> {

	/**
	 * 记录日志
	 * @param title
	 * @param sysUser
	 * @param url
	 * @param parms
	 */
	void insertLog(String title, SysUser sysUser, String url, String parms);


}
