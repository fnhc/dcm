package com.chinawiserv.dsp.dcs.dcm.service.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysSetting;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.dcs.dcm.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 系统设置表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysSettingService extends ICommonService<SysSetting,SysSettingVo> {

    public Page<SysSettingVo> selectVoPage(Map<String , Object> paramMap) throws Exception;
}
