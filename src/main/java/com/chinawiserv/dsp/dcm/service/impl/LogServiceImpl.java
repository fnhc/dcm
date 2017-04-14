package com.chinawiserv.dsp.dcm.service.impl;

import com.chinawiserv.dsp.dcm.entity.Log;
import com.chinawiserv.dsp.dcm.mapper.LogMapper;
import com.chinawiserv.dsp.dcm.service.ILogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-14
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {
	
}
