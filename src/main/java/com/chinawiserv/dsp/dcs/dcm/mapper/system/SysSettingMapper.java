package com.chinawiserv.dsp.dcs.dcm.mapper.system;

import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysSetting;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysSettingVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 系统设置表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysSettingMapper extends BaseMapper<SysSetting> {

    public List<SysSettingVo> selectVo(RowBounds rowBounds, Map<String , Object> paramMap);

    public int selectVoCount(Map<String , Object> paramMap);
}