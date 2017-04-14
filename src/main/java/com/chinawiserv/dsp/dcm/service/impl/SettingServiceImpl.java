package com.chinawiserv.dsp.dcm.service.impl;

import com.chinawiserv.dsp.dcm.entity.Setting;
import com.chinawiserv.dsp.dcm.mapper.SettingMapper;
import com.chinawiserv.dsp.dcm.service.ISettingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统设置表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-14
 */
@Service
public class SettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements ISettingService {
	
}
