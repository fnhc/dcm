package com.chinawiserv.dsp.dcs.dcm.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	List<Map<Object, Object>> selectUserList(Page<Map<Object, Object>> page, @Param("search") String search);
}