package com.chinawiserv.dsp.dcs.dcm.mapper.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysMenuVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 菜单表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenuVo> select(Page<SysMenuVo> page, Map<String, Object> paramMap ) throws Exception;

	List<String> selectMenuIdsByuserId(String uid) throws Exception;

    SysMenuVo selectMenuById(String id) throws Exception;

    SysMenuVo selectCatalogByMenuId(String id) throws Exception;

    SysMenuVo selectCatalogByFunctionId(String id) throws Exception;

    List<SysMenuVo> selectMenusByFunctionId(String id) throws Exception;

}