package com.chinawiserv.dsp.dcs.dcm.entity.vo.system;

import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;

/**
 * Created by jacky on 2017/5/11.
 */
public class SysUserVo extends SysUser {
    private String deptName;
    private String createName;
    private String[] roleIds;

    public String getDeptName() {
        return deptName;
    }

    public String getCreateName() {
        return createName;
    }



    public String[] getRoleIds() { return roleIds;}

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public void setRoleIds(String[] roleIds) { this.roleIds = roleIds;}
}
