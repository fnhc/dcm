package com.chinawiserv.dsp.dcs.dcm.service.system;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysDept;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.dcs.dcm.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysDeptService extends ICommonService<SysDept, SysDeptVo> {

    Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception;

    SysDeptVo selectVoById(String id) throws Exception;

    JSONObject checkDeptName(String deptName, String deptId) throws Exception;

    JSONArray getDeptSelectDataList() throws Exception;
}
