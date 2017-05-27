package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.HandleResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.PageResult;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 组织机构表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptService sysDeptService;

    @RequiresPermissions("system:dept:list")
    @RequestMapping("")
    public  String init(HttpServletRequest request, HttpServletResponse response){

        return "system/dept/deptList";
    }

    /**
     * 分页查询组织机构
     */
    @RequiresPermissions("system:dept:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<SysDeptVo> page = sysDeptService.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询组织机构出错");
            logger.error("分页查询角色出错", e);
        }
        return pageResult;
    }

    /**
     * 新增组织机构
     */
    @RequiresPermissions("system:dept:add")
    @RequestMapping("/add")
    public  String add(){
        return "system/dept/deptAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("system:dept:add")
    @Log("创建组织机构")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysDeptVo dept){
        HandleResult handleResult = new HandleResult();
        try {
            sysDeptService.insertVO(dept);
            handleResult.success("创建组织机构成功");
        } catch (Exception e) {
            handleResult.error("创建组织机构失败");
            logger.error("创建组织机构失败", e);
        }
        return handleResult;
    }
    /**
     * 删除组织机构
     */
    @RequiresPermissions("system:dept:delete")
    @Log("删除组织机构")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
        sysDeptService.deleteById(id);
        return new HandleResult().success("删除成功");
    }

    /**
     * 编辑组织机构
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
        model.addAttribute("deptId",id);
        return "system/dept/deptEdit";
    }

    /**
     * 编辑角色
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            SysDeptVo sysDeptVos = sysDeptService.selectVoById(id);
            handleResult.put("vo", sysDeptVos);
        } catch (Exception e) {
            handleResult.error("获取组织机构信息失败");
            logger.error("获取组织机构信息失败", e);
        }
        return handleResult;
    }

    /**
     * 执行编辑
     */
    @RequiresPermissions("system:dept:edit")
    @Log("编辑组织机构")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysDeptVo dept){
        HandleResult handleResult = new HandleResult();
        try {
            sysDeptService.updateVO(dept);
            handleResult.success("编辑组织机构成功");
        } catch (Exception e) {
            handleResult.error("编辑组织机构失败");
            logger.error("编辑组织机构失败", e);
        }
        return handleResult;
    }

    @RequestMapping("/checkDeptName")
    @ResponseBody
    public JSONObject checkRoleName(@RequestParam String deptName, String deptId){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = sysDeptService.checkDeptName(deptName, deptId);
        } catch (Exception e) {
            jsonObject.put("error", "角色名验证失败");
            logger.error("角色名验证失败", e);
        }
        return jsonObject;
    }

    /**
     * 组织机构的下拉数据
     * @param userId
     * @return
     */
    @RequestMapping("/getDeptSelectDataList")
    @ResponseBody
    public HandleResult getDeptSelectDataList(String userId) {
        HandleResult handleResult = new HandleResult();
        try {
            JSONArray result = sysDeptService.getDeptSelectDataList();
            handleResult.put("selectData", result);
        } catch (Exception e) {
            handleResult.error("获取角色名称失败");
            logger.error("获取角色名称失败", e);
        }
        return handleResult;
    }

}
