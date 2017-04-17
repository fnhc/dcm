package com.chinawiserv.dsp.dcm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcm.common.util.CommonUtil;
import com.chinawiserv.dsp.dcm.entity.SysUser;
import com.chinawiserv.dsp.dcm.entity.SysUserRole;
import com.chinawiserv.dsp.dcm.mapper.SysUserMapper;
import com.chinawiserv.dsp.dcm.mapper.SysUserRoleMapper;
import com.chinawiserv.dsp.dcm.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired private SysUserRoleMapper userRoleMapper;

    @Override
    public void insertUser(SysUser user, String[] roleIds) {
        // TODO Auto-generated method stub
        user.setCreateTime(new Date());
        user.setPassword(CommonUtil.MD5(user.getPassword()));
        //保存用户
        userMapper.insert(user);
        //绑定角色
        if(ArrayUtils.isNotEmpty(roleIds)){
            for(String rid : roleIds){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(user.getId());
                sysUserRole.setRoleId(rid);
                userRoleMapper.insert(sysUserRole);
            }
        }

    }

    @Override
    public void updateUser(SysUser sysUser, String[] roleIds) {
        // TODO Auto-generated method stub
        sysUser.setPassword(null);
        //更新用户
        userMapper.updateById(sysUser);
        //删除已有权限
        userRoleMapper.delete(new EntityWrapper<SysUserRole>().eq("user_id",sysUser.getId()));
        //重新绑定角色
        if(ArrayUtils.isNotEmpty(roleIds)){
            for(String rid : roleIds){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(sysUser.getId());
                sysUserRole.setRoleId(rid);
                userRoleMapper.insert(sysUserRole);
            }
        }
    }

    @Override
    public SysUser login(String userName, String password) {
        return this.selectOne(new EntityWrapper<SysUser>().eq("user_name", userName).eq("password", CommonUtil.MD5(password)));
    }

    @Override
    public Page<Map<Object, Object>> selectUserPage(Page<Map<Object, Object>> page, String search) {
        page.setRecords(userMapper.selectUserList(page, search));
        return page;
    }

    @Override
    public void delete(String id) {
        this.deleteById(id);
        userRoleMapper.delete(new EntityWrapper<SysUserRole>().addFilter("user_id = {0}", id));
    }

}
