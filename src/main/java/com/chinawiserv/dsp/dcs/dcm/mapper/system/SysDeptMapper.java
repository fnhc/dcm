package com.chinawiserv.dsp.dcs.dcm.mapper.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysDept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysDeptVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 组织机构表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    List<SysDeptVo> selectVoPage(Page<SysDeptVo> page, Map<String, Object> paramMap);

    SysDeptVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

}