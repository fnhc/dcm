package com.chinawiserv.dsp.dcm.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcm.common.anno.Permission;
import com.chinawiserv.dsp.dcm.controller.BaseController;
import com.chinawiserv.dsp.dcm.entity.SysSetting;
import com.chinawiserv.dsp.dcm.service.ISysSettingService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 系统设置表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/setting")
public class SysSettingController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysSettingService sysSettingService;

    /**
     * 查询系统设置
     */
    @Permission("listSetting")
    @RequestMapping("/page")
    public  String page(Model model){

        List<SysSetting> list =  sysSettingService.selectList(new EntityWrapper<SysSetting>().orderBy("sort",true));
        model.addAttribute("list",list);
        return "system/setting/page";
    }

    @Permission("doSetting")
    @Log("更新系统设置")
    @RequestMapping("/doSetting")
    public String doSetting(String[] id,String[] sysValue,Model model,RedirectAttributes redirectAttributes){

        List<SysSetting> sysSettings = new ArrayList<SysSetting>();
        if(ArrayUtils.isNotEmpty(id)){
            for(int i=0;i<id.length;i++){
                SysSetting setting	= new SysSetting();
                setting.setId(id[i]);
                setting.setSysValue(sysValue[i]);
                sysSettings.add(setting);
            }
        }
        sysSettingService.updateBatchById(sysSettings);
        redirectAttributes.addFlashAttribute("info","OK,更新成功!");
        return redirectTo("/system/setting/page");

    }


}
