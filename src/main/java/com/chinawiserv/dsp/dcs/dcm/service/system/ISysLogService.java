package com.chinawiserv.dsp.dcs.dcm.service.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysLog;
import com.baomidou.mybatisplus.service.IService;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysLogVo;
import com.chinawiserv.dsp.dcs.dcm.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysLogService extends ICommonService<SysLog , SysLogVo> {

	/**
	 * 记录日志
	 * @param title
	 * @param sysUser
	 * @param url
	 * @param parms
	 */
	void insertLog(String title, SysUser sysUser, String url, String parms);

}
