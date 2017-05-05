package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.HandleResult;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.PageResult;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.SysDept;
import com.chinawiserv.dsp.dcs.dcm.service.ISysDeptService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Map;


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
//todo 将所有的XXX修改为真实值
public class SysDeptController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptService sysDeptService;

    @RequiresPermissions("listDept")
    @RequestMapping("")
    public  String init(HttpServletRequest request, HttpServletResponse response){
        return "system/dept/deptList";
    }

    /**
     * 分页查询部门
     */
    @RequiresPermissions("listDept")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        Page<SysDept> page = getPage(paramMap);
        String searchKey = MapUtils.getString(paramMap , "searchKey");
        // 查询分页
        EntityWrapper<SysDept> ew = new EntityWrapper<SysDept>();
        if(StringUtils.isNotBlank(searchKey)){
            ew.like("dept_name", searchKey);
        }
        Page<SysDept> pageData = sysDeptService.selectPage(page, ew);

        return new PageResult(pageData);
    }

    /**
     * 新增部门
     */
    @RequiresPermissions("addDept")
    @RequestMapping("/add")
    public  String add(){
        return "system/dept/deptAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("addDept")
    @Log("创建部门")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysDept dept){
        //todo 设置创建人，创建时间
        sysDeptService.insert(dept);
        return new HandleResult().success("创建部门成功");
    }
    /**
     * 删除部门
     */
    @RequiresPermissions("deleteDept")
    @Log("删除部门")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
        //todo 设置更新人，更新时间
        sysDeptService.deleteById(id);
        return new HandleResult().success("删除成功");
    }

    /**
     * 编辑部门
     */
    @RequiresPermissions("editDept")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
        SysDept dept = sysDeptService.selectById(id);

        model.addAttribute("dept",dept);
        return "system/dept/deptEdit";
    }
    /**
     * 执行编辑
     */
    @RequiresPermissions("editDept")
    @Log("编辑部门")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysDept dept,Model model){
        //todo 设置更新人，更新时间
        sysDeptService.updateById(dept);
        return new HandleResult().success("编辑部门成功");
    }


}
