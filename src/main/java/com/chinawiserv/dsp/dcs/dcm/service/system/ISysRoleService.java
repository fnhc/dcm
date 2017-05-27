package com.chinawiserv.dsp.dcs.dcm.service.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.ListResult;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysRole;
import com.baomidou.mybatisplus.service.IService;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysRoleVo;
import com.chinawiserv.dsp.dcs.dcm.service.common.ICommonService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysRoleService extends ICommonService<SysRole, SysRoleVo> {

    Page<SysRoleVo> selectVoPage(Map<String, Object> paramMap) throws Exception;

    SysRoleVo selectVoById(String id) throws Exception;

    ListResult getAuth(String id) throws Exception;

    JSONObject checkRoleName(String roleName, String roleId) throws Exception;

    List<JSONObject> getRoleNameList(String userId) throws Exception;

    boolean deleteRoleById(String id) throws Exception;

    boolean deleteBatchRoleByIds(List<String> ids) throws Exception;

}
