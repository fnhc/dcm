package com.chinawiserv.dsp.dcs.dcm.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysLog;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysLogVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 日志表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysLogMapper extends BaseMapper<SysLog> {
	List<SysLogVo> selectVoList(Page<SysLogVo> page, Map<String, Object> paramMap)  throws Exception;

}