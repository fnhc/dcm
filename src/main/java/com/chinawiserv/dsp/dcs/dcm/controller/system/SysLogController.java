package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dcs.dcm.common.bean.response.PageResult;
import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcs.dcm.entity.SysLog;
import com.chinawiserv.dsp.dcs.dcm.service.ISysLogService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


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


    @RequiresPermissions("listLog")
    @RequestMapping("")
    public  String init(Model model){
        return "system/log/logList";
    }

    /**
     * 分页查询日志
     */
    @RequiresPermissions("listLog")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        Page<SysLog> page = getPage(paramMap);

        if (!paramMap.containsKey("sortName")) {
            page.setOrderByField("create_time");
            page.setAsc(false);
        }

        String searchKey = MapUtils.getString(paramMap , "searchKey");
        String dateRange = MapUtils.getString(paramMap , "dateRange");
        // 查询分页
        EntityWrapper<SysLog> ew = new EntityWrapper<SysLog>();
        if(StringUtils.isNotBlank(searchKey)){
            ew.where("(user_name like CONCAT('%',{0},'%')", searchKey)
                    .or("title like CONCAT('%',{0},'%'))", searchKey);
        }
        //日期查询
        if(StringUtils.isNotBlank(dateRange)){
            String[] dateRangeArr = StringUtils.split(dateRange, "~");
            ew.addFilter(" create_time >= {0}", dateRangeArr[0].trim().replaceAll("/","-") + " 00:00:00");
            ew.addFilter(" create_time <= {0}", dateRangeArr[1].trim().replaceAll("/","-") + " 23:59:59");
        }
        Page<SysLog> pageData = sysLogService.selectPage(page, ew);

        return new PageResult(pageData);
    }

    /**
     * 获取参数
     */
    @RequestMapping("/params/{id}")
    @ResponseBody
    public String params(@PathVariable String id){
        SysLog sysLog = sysLogService.selectById(id);
        return sysLog.getParams();
    }
}
