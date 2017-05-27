package com.chinawiserv.dsp.dcs.dcm.service.system.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.util.CommonUtil;
import com.chinawiserv.dsp.dcs.dcm.common.util.ShiroUtils;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysDept;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.dcs.dcm.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.dcs.dcm.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
 * 组织机构表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysDeptServiceImpl extends CommonServiceImpl<SysDeptMapper, SysDept, SysDeptVo> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<SysDeptVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<SysDeptVo> sysDeptVos = sysDeptMapper.selectVoPage(page, paramMap);
        page.setRecords(sysDeptVos);
        return page;
    }

    @Override
    public SysDeptVo selectVoById(String id) throws Exception {
        return sysDeptMapper.selectVoById(id);
    }

    @Override
    public JSONObject checkDeptName(String deptName, String deptId) {
        List<SysDept> list;
        JSONObject result = new JSONObject();
        if(StringUtils.isNotBlank(deptId)){
            list = selectList(new EntityWrapper<SysDept>().where("dept_name = {0}", deptName).and("id != {0}", deptId));
        } else {
            list = selectList(new EntityWrapper<SysDept>().addFilter("dept_name = {0}", deptName));
        }
        if(list != null && !list.isEmpty()){
            result.put("error", "该组织机构名称已存在");
        }
        return result;
    }

    @Override
    public JSONArray getDeptSelectDataList() throws Exception {
        JSONArray jsonArray = new JSONArray();
        List<SysDept> list = new ArrayList<SysDept>();

        list = sysDeptMapper.selectList(new EntityWrapper<SysDept>());

        for(SysDept sysDept : list){
            JSONObject obj = new JSONObject();
            obj.put("id",sysDept.getId());
            obj.put("text",sysDept.getDeptName());

            jsonArray.add(obj);
        }
        return jsonArray;
    }

    @Override
    public boolean insertVO(SysDeptVo sysDeptVo) throws Exception {
        sysDeptVo.setId(CommonUtil.get32UUID());
        sysDeptVo.setStatus(1);
        sysDeptVo.setCreateUserId(ShiroUtils.getLoginUserId());
        sysDeptVo.setCreateTime(new Date());
        return insert(sysDeptVo);
    }

    @Override
    public boolean updateVO(SysDeptVo sysDeptVo) throws Exception {
        sysDeptVo.setUpdateUserId(ShiroUtils.getLoginUserId());
        sysDeptVo.setUpdateTime(new Date());
        return updateById(sysDeptVo);
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return sysDeptMapper.selectVoCount(paramMap);
    }
}
