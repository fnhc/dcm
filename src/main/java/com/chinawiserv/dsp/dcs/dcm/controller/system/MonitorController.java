package com.chinawiserv.dsp.dcs.dcm.controller.system;

import com.chinawiserv.dsp.dcs.dcm.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 监控
 * @author Gaojun.Zhou
 * @date 2017年2月5日 下午3:38:19
 */
@Controller
@RequestMapping("/system/monitor")
public class MonitorController extends BaseController{
	
	/**
	 * 系统监控列表
	 */
	@RequiresPermissions("system:monitor")
    @RequestMapping("")
    public  String list(Model model){
		return "system/monitor/monitorList";
    } 
}
