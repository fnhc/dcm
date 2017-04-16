package com.chinawiserv.dsp.dcm.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcm.common.anno.Permission;
import com.chinawiserv.dsp.dcm.common.bean.Response;
import com.chinawiserv.dsp.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcm.entity.SysDept;
import com.chinawiserv.dsp.dcm.service.ISysDeptService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>
 * 部门表 前端控制器
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

    /**
     * 分页查询部门
     */
    @Permission("listDept")
    @RequestMapping("/list/{pageNumber}")
    public  String list(@PathVariable Integer pageNumber, @RequestParam(defaultValue="15") Integer pageSize, String search, Model model){

        Page<SysDept> page = getPage(pageNumber,pageSize);
        model.addAttribute("pageSize", pageSize);
        // 查询分页
        EntityWrapper<SysDept> ew = new EntityWrapper<SysDept>();
        if(StringUtils.isNotBlank(search)){
            ew.like("deptName",search);
            model.addAttribute("search",search);
        }
        Page<SysDept> pageData = sysDeptService.selectPage(page, ew);
        model.addAttribute("pageData", pageData);
        return "system/dept/list";
    }

    /**
     * 新增部门
     */
    @Permission("addDept")
    @RequestMapping("/add")
    public  String add(Model model){
        return "system/dept/add";
    }

    /**
     * 执行新增
     */
    @Permission("addDept")
    @Log("创建部门")
    @RequestMapping("/doAdd")
    public  String doAdd(SysDept dept,String[] roleId){

        sysDeptService.insert(dept);
        return redirectTo("/system/dept/list/1.html");
    }
    /**
     * 删除部门
     */
    @Permission("deleteDept")
    @Log("删除部门")
    @RequestMapping("/delete")
    @ResponseBody
    public Response delete(String id){
        sysDeptService.deleteById(id);
        return new Response().success();
    }

    /**
     * 编辑部门
     */
    @Permission("editDept")
    @RequestMapping("/edit/{id}")
    public  String edit(@PathVariable String id,Model model){
        SysDept dept = sysDeptService.selectById(id);

        model.addAttribute("dept",dept);
        return "system/dept/edit";
    }
    /**
     * 执行编辑
     */
    @Permission("editDept")
    @Log("编辑部门")
    @RequestMapping("/doEdit")
    public  String doEdit(SysDept dept,Model model){
        sysDeptService.updateById(dept);
        return redirectTo("/system/dept/list/1.html");
    }


}
