package com.chinawiserv.dsp.dcs.dcm.service.system.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.util.CommonUtil;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysLog;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysLogVo;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysLogMapper;
import com.chinawiserv.dsp.dcs.dcm.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysLogService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysLogServiceImpl extends CommonServiceImpl<SysLogMapper , SysLog , SysLogVo> implements ISysLogService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SysLogMapper sysLogMapper ;
	
	@Override
	public void insertLog(String title, SysUser sysUser, String url, String parms) {
		SysLog sysLog  =new SysLog();
		sysLog.setOperator(sysUser.getId());
		sysLog.setOperateTime(new Date());
		//todo
		sysLog.setOperateType("1");
		sysLog.setOperateDesc(title);
		sysLog.setOperateDetail(parms);
		insert(sysLog);
		logger.debug("记录日志:"+sysLog.toString());
	}

	@Override
	public Page<SysLogVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		Page<SysLogVo> page = getPage(paramMap) ;

		if (!paramMap.containsKey("sortName")) {
			page.setOrderByField("create_time");
			page.setAsc(false);
		}

		String dateRange = MapUtils.getString(paramMap , "dateRange");
		//日期查询
		if(StringUtils.isNotBlank(dateRange)){
			String[] dateRangeArr = StringUtils.split(dateRange, "~");
			paramMap.put("create_time_begin" , dateRangeArr[0].trim());
			paramMap.put("create_time_end" , dateRangeArr[1].trim());
		}
		page.setRecords(sysLogMapper.selectVoList(page, paramMap));

		return page;
	}


	@Override
	public boolean insertVO(SysLogVo sysLogVo) throws Exception {
		//todo
		sysLogVo.setId(CommonUtil.get32UUID());
		baseMapper.insert(sysLogVo) ;

		return false;
	}

	@Override
	public boolean updateVO(SysLogVo sysLogVo) throws Exception {
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		return false;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		return 0;
	}

	@Override
	public SysLogVo selectVoById(String id) throws Exception {
		return null;
	}
}
