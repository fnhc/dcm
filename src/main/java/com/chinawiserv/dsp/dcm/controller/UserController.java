package com.chinawiserv.dsp.dcm.controller;

import com.chinawiserv.dsp.dcm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-14
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping("/{userId}")
    @ResponseBody
    public String ts(@PathVariable Integer userId){
        return  userService.selectById("4754f010ef344c59b728ea60809ab926").toString() ;
    }
}
