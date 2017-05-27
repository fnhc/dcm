package com.chinawiserv.dsp.dcs.dcm.service.system.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.util.CommonUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysUserMapper;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysUserRoleMapper;
import com.chinawiserv.dsp.dcs.dcm.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysRoleService;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class SysUserServiceImpl extends CommonServiceImpl<SysUserMapper,SysUser,SysUserVo> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired private SysUserRoleMapper userRoleMapper;

    @Autowired
    private ISysRoleService sysRoleService ;

    public void updateUser(SysUser sysUser) {
        userMapper.updateById(sysUser);
    }
    @Override
    public SysUser login(String userName, String password) {
        return this.selectOne(new EntityWrapper<SysUser>().eq("user_name", userName).eq("password", CommonUtil.string2MD5(password)));
    }

    @Override
    public SysUserVo selectVoById(String id) throws Exception {
        SysUserVo sysUserVo = userMapper.selectVoById(id) ;
        List<JSONObject> roleNameList =  sysRoleService.getRoleNameList(id);

        String roleIdArr[] = null ;
        if (roleNameList != null && !roleNameList.isEmpty()) {
            roleIdArr = new String[roleNameList.size()] ;

            for (int i = 0; i < roleNameList.size(); i++) {
                JSONObject jsonObject = roleNameList.get(i) ;
                String roleId = jsonObject.getString("id") ;
                roleIdArr[i] = roleId ;
             }
        }

        sysUserVo.setRoleIds(roleIdArr);

        return sysUserVo;
    }

    //commonservice中的方法
    @Override
    public void delete(String id) {
        this.deleteById(id);
        userRoleMapper.delete(new EntityWrapper<SysUserRole>().addFilter("user_id = {0}", id));
    }

    @Override
    public boolean insertVO(SysUserVo sysUserVo) throws Exception {
        sysUserVo.setId(CommonUtil.get32UUID());
        sysUserVo.setCreateTime(new Date());
        sysUserVo.setPassword(CommonUtil.string2MD5(sysUserVo.getPassword()));
        //获取当前用户登陆id
        String loginUserId = ShiroUtils.getLoginUserId();
        sysUserVo.setCreateUserId(loginUserId);
        //保存用户
        userMapper.insert(sysUserVo);
        //绑定角色
        String[] roleIds = sysUserVo.getRoleIds();
        if(ArrayUtils.isNotEmpty(roleIds)){
            for(String rid : roleIds){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(sysUserVo.getId());
                sysUserRole.setRoleId(rid);
                userRoleMapper.insert(sysUserRole);
            }
        }
        return true;
    }

    @Override
    public boolean updateVO(SysUserVo sysUserVo) throws Exception {
        //更新用户
        userMapper.updateById(sysUserVo);

        String[] roleIds = sysUserVo.getRoleIds();
        //重新绑定角色
        if(ArrayUtils.isNotEmpty(roleIds)){
            //删除已有权限
            userRoleMapper.delete(new EntityWrapper<SysUserRole>().eq("user_id",sysUserVo.getId()));

            for(String rid : roleIds){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(sysUserVo.getId());
                sysUserRole.setRoleId(rid);
                userRoleMapper.insert(sysUserRole);
            }
        }
        return true;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public Page<SysUserVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<SysUserVo> page = getPage(paramMap);
        //按照创建时间排序
        page.setOrderByField("create_time");
        page.setAsc(false);
        page.setRecords(userMapper.selectVoList(page,paramMap));
        return page;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return 0;
    }

}
