package com.chinawiserv.dsp.dcs.dcm.service.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.dcs.dcm.service.common.ICommonService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysUserService extends ICommonService<SysUser,SysUserVo> {
    /**
     * 根据id查找vo用户
     */
    SysUserVo selectVoById(String id) throws Exception;
    /**
     * 登录
     */
    SysUser login(String userName, String password);

    /**
     * 删除用户
     */
    void delete(String id);
}
