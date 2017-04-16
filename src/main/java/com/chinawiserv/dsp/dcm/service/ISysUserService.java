package com.chinawiserv.dsp.dcm.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcm.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 分页查询用户
     */
    Page<Map<Object, Object>> selectUserPage(Page<Map<Object, Object>> page, String search);

    /**
     * 保存用户
     */
    void insertUser(SysUser user, String[] roleId);
    /**
     * 更新用户
     */
    void updateUser(SysUser sysUser, String[] roleId);
    /**
     * 登录
     */
    SysUser login(String userName, String password);

    /**
     * 删除用户
     */
    void delete(String id);
}
