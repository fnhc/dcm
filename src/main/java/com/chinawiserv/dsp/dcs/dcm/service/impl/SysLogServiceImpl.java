package com.chinawiserv.dsp.dcs.dcm.service.impl;

import com.chinawiserv.dsp.dcs.dcm.entity.SysLog;
import com.chinawiserv.dsp.dcs.dcm.entity.SysUser;
import com.chinawiserv.dsp.dcs.dcm.mapper.SysLogMapper;
import com.chinawiserv.dsp.dcs.dcm.service.ISysLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void insertLog(String title, SysUser sysUser, String url, String parms) {
		SysLog sysLog  =new SysLog();
		sysLog.setCreateTime(new Date());
		sysLog.setTitle(title);
		sysLog.setUserId(sysUser.getId());
		sysLog.setUserName(sysUser.getUserName());
		sysLog.setUrl(url);
		sysLog.setParams(parms);
		super.insert(sysLog);
		logger.debug("记录日志:"+sysLog.toString());
	}


}
