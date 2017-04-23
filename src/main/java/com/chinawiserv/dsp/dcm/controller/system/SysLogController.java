package com.chinawiserv.dsp.dcm.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcm.common.anno.Permission;
import com.chinawiserv.dsp.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcm.entity.SysLog;
import com.chinawiserv.dsp.dcm.service.ISysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/log")
public class SysLogController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysLogService sysLogService;

    /**
     * 分页查询日志
     */
    @Permission("listLog")
    @RequestMapping("/list/{pageNumber}")
    public  String list(@PathVariable Integer pageNumber, @RequestParam(defaultValue="15") Integer pageSize, String search, String daterange, Model model){

        Page<SysLog> page = getPage(pageNumber,pageSize);
        page.setOrderByField("create_time");
        page.setAsc(false);
        model.addAttribute("pageSize", pageSize);
        // 查询分页
        EntityWrapper<SysLog> ew = new EntityWrapper<SysLog>();
        if(StringUtils.isNotBlank(search)){
            ew.where("(user_name like CONCAT('%',{0},'%')", search)
                    .or("title like CONCAT('%',{0},'%'))", search);
            model.addAttribute("search", search);
        }
        //日期查询
        if(StringUtils.isNotBlank(daterange)){
            model.addAttribute("daterange", daterange);
            String[] dateranges = StringUtils.split(daterange, "-");
            ew.addFilter(" create_time >= {0}", dateranges[0].trim().replaceAll("/","-") + " 00:00:00");
            ew.addFilter(" create_time <= {0}", dateranges[1].trim().replaceAll("/","-") + " 23:59:59");
        }
        Page<SysLog> pageData = sysLogService.selectPage(page, ew);
        model.addAttribute("pageData", pageData);
        return "system/log/list";
    }

    @RequestMapping("/listData/{pageNumber}")
    @ResponseBody
    public String listData(@PathVariable Integer pageNumber, @RequestParam(defaultValue="15") Integer pageSize, String search, String daterange, Model model){

        Page<SysLog> page = getPage(pageNumber,pageSize);
        page.setOrderByField("create_time");
        page.setAsc(false);
        model.addAttribute("pageSize", pageSize);
        // 查询分页
        EntityWrapper<SysLog> ew = new EntityWrapper<SysLog>();
        if(StringUtils.isNotBlank(search)){
            ew.where("(user_name like CONCAT('%',{0},'%')", search)
                    .or("title like CONCAT('%',{0},'%'))", search);
            model.addAttribute("search", search);
        }
        //日期查询
        if(StringUtils.isNotBlank(daterange)){
            model.addAttribute("daterange", daterange);
            String[] dateranges = StringUtils.split(daterange, "-");
            ew.addFilter(" create_time >= {0}", dateranges[0].trim().replaceAll("/","-") + " 00:00:00");
            ew.addFilter(" create_time <= {0}", dateranges[1].trim().replaceAll("/","-") + " 23:59:59");
        }
        Page<SysLog> pageData = sysLogService.selectPage(page, ew);
        model.addAttribute("pageData", pageData);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data" , pageData.getRecords());

        //todo
        return jsonObject.toString();
    }

    /**
     * 获取参数
     */
    @RequestMapping("/params/{id}")
    @ResponseBody
    public String params(@PathVariable String id,Model model){
        SysLog sysLog = sysLogService.selectById(id);
        return sysLog.getParams();
    }
}
