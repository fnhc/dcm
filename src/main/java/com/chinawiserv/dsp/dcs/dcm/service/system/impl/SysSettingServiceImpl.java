package com.chinawiserv.dsp.dcs.dcm.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.util.CommonUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysSetting;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysSettingMapper;
import com.chinawiserv.dsp.dcs.dcm.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 系统设置表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysSettingServiceImpl extends CommonServiceImpl<SysSettingMapper, SysSetting, SysSettingVo> implements ISysSettingService {

    @Autowired
    private SysSettingMapper sysSettingMapper;

    @Override
    public Page<SysSettingVo> selectVoPage(Map<String , Object> paramMap) throws Exception{
        final Page<SysSettingVo> page = getPage(paramMap);
        page.setRecords(sysSettingMapper.selectVo(page,paramMap));
        return page;
    }

    @Override
    public boolean insertVO(SysSettingVo sysSettingVo) throws Exception {
        sysSettingVo.setId(CommonUtil.get32UUID());
        sysSettingVo.setSettingType(1);
        sysSettingVo.setStatus(1);
        sysSettingVo.setCreateUserId(ShiroUtils.getLoginUserId());
        sysSettingVo.setCreateTime(new Date());
        baseMapper.insert(sysSettingVo);
        return false;
    }

    @Override
    public boolean updateVO(SysSettingVo sysSettingVo) throws Exception {
        sysSettingVo.setUpdateUserId(ShiroUtils.getLoginUserId());
        sysSettingVo.setUpdateTime(new Date());
        baseMapper.updateById(sysSettingVo);
        return false;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        baseMapper.deleteByMap(paramMap);
        return false;
    }

    @Override
    public SysSettingVo selectVoById(String id) throws Exception {
        return null;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return sysSettingMapper.selectVoCount(paramMap);
    }
}
