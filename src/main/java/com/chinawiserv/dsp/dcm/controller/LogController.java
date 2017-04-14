package com.chinawiserv.dsp.dcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-14
 */
@Controller
@RequestMapping("/log")
public class LogController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
