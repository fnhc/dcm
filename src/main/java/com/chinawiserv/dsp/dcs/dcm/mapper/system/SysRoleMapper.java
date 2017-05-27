package com.chinawiserv.dsp.dcs.dcm.mapper.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysRoleVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 系统角色表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-05-08
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVo> selectVoPage(Page<SysRoleVo> page, Map<String, Object> paramMap);

    SysRoleVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    Integer deleteBatchRoleByIds(List<String> ids);
}