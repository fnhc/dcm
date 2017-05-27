package com.chinawiserv.dsp.dcs.dcm.service.system.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.bean.ZTreeNode;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.ListResult;
import com.chinawiserv.dsp.dcs.dcm.common.util.CommonUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysRole;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysRoleMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysRoleVo;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysRoleMapper;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysRoleMenuMapper;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysUserRoleMapper;
import com.chinawiserv.dsp.dcs.dcm.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysMenuService;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysRoleServiceImpl extends CommonServiceImpl<SysRoleMapper, SysRole, SysRoleVo> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    public Page<SysRoleVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<SysRoleVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<SysRoleVo> sysRoleVos = sysRoleMapper.selectVoPage(page, paramMap);
        page.setRecords(sysRoleVos);//同时得到条数
        String loginUserId = ShiroUtils.getLoginUserId();
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(loginUserId);
        sysUserRole = sysUserRoleMapper.selectOne(sysUserRole);
        //非超级管理员不传递角色id
        if(sysUserRole != null && !"737933bffef640329a4f864c4e2746ba".equals(sysUserRole.getRoleId())){
            if(page != null && page.getRecords() != null && !page.getRecords().isEmpty()) {
                for (SysRole sysRole : page.getRecords()) {
                    sysRole.setId("");
                }
            }
        }
        return page;
    }

    @Override
    public SysRoleVo selectVoById(String id) throws Exception {
        return sysRoleMapper.selectVoById(id);
    }

    @Override
    public ListResult getAuth(String id) throws Exception {
        SysRole sysRole = selectById(id);
        if(sysRole == null){
            throw new RuntimeException("该角色不存在");
        }
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectList(new EntityWrapper<SysRoleMenu>().addFilter("role_id = {0}", id));
        List<String> menuIds = Lists.transform(sysRoleMenus, input -> input.getMenuId());
        List<ZTreeNode> zTreeNodes = sysMenuService.selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds, "0");
        ListResult<ZTreeNode> listResult = new ListResult<ZTreeNode>();
        listResult.addAll(zTreeNodes);
        return listResult;
    }

    @Override
    public JSONObject checkRoleName(String roleName, String roleId) throws Exception {
        List<SysRole> list;
        JSONObject result = new JSONObject();
        if(StringUtils.isNotBlank(roleId)){
            list = selectList(new EntityWrapper<SysRole>().where("role_name = {0}", roleName).and("id != {0}", roleId).and("delete_flag = {0}", 0));//todo
        } else {
            list = selectList(new EntityWrapper<SysRole>().where("role_name = {0}", roleName).and("delete_flag = {0}", 0));//todo
        }
        if(list != null && !list.isEmpty()){
            result.put("error", "该角色名已存在");
        }
        return result;
    }

    @Override
    public List<JSONObject> getRoleNameList(String userId) throws Exception {
        List<JSONObject> result = new ArrayList<JSONObject>();
        List<SysRole> list = new ArrayList<SysRole>();
        if(StringUtils.isNotBlank(userId)){
            List<SysUserRole> userRoleList = sysUserRoleMapper.selectList(new EntityWrapper<SysUserRole>().addFilter("user_id={0}",userId));
            for(SysUserRole sysUserRole : userRoleList){
                SysRole sysRole = sysRoleMapper.selectById(sysUserRole.getRoleId());
                list.add(sysRole);
            }
        }else{
            list = sysRoleMapper.selectList(new EntityWrapper<SysRole>());
        }
        for(SysRole sysRole : list){
            JSONObject obj = new JSONObject();
            obj.put("id",sysRole.getId());
            obj.put("text",sysRole.getRoleName());
            result.add(obj);
        }
        return result;
    }

    @Override
    public boolean deleteRoleById(String id) throws Exception {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setDeleteFlag(1);
        return updateById(sysRole);
    }

    @Override
    public boolean deleteBatchRoleByIds(List<String> ids) throws Exception {
        return retBool(sysRoleMapper.deleteBatchRoleByIds(ids));
    }

    @Override
    public boolean insertVO(SysRoleVo sysRoleVo) throws Exception {
        sysRoleVo.setId(CommonUtil.get32UUID());
        sysRoleVo.setCreateTime(new Date());
        sysRoleVo.setCreateUserId(ShiroUtils.getLoginUserId());
        //todo 角色类型
        sysRoleVo.setRoleType(1);
        return insert(sysRoleVo);
    }

    @Override
    public boolean updateVO(SysRoleVo sysRoleVo) throws Exception {
        sysRoleVo.setUpdateUserId(ShiroUtils.getLoginUserId());
        sysRoleVo.setUpdateTime(new Date());
        return updateById(sysRoleVo);
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return sysRoleMapper.selectVoCount(paramMap);
    }
}
