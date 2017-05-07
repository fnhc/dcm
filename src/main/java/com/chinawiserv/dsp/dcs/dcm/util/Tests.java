package com.chinawiserv.dsp.dcs.dcm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinawiserv.dsp.dcs.dcm.entity.SysUser;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/16.
 */
public class Tests {
    private static Logger logger = LoggerFactory.getLogger(Tests.class);

    @Test
    public void testToJSONString() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("className", "dasfds");
        map.put("methodName", "method");

        Object arr[] = new Object[] {"fdsf" , "dsafds"};

        map.put("args", JSON.toJSONString(arr, SerializerFeature.BrowserCompatible));
        map.put("errorMsg","errorM");

        logger.error(map.toString());
        logger.error(JSON.toJSONString(map));
    }

    @Test
    public void testOptional(){
        Optional.of(2);

        List<SysUser> sysUserList = Lists.newArrayList();

    }























}
