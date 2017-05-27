package com.chinawiserv.dsp.dcs.dcm.entity.vo.system;

import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysSetting;

/**
 * Created by ZS on 2017/5/12.
 */
public class SysSettingVo extends SysSetting {

    private String createUserName;

    private String updateUserName;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
}
