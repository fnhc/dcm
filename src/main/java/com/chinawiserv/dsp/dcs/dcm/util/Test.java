package com.chinawiserv.dsp.dcs.dcm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/16.
 */
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("className", "dasfds");
        map.put("methodName", "method");

        Object arr[] = new Object[] {"fdsf" , "dsafds"};

        map.put("args", JSON.toJSONString(arr, SerializerFeature.BrowserCompatible));
        map.put("errorMsg","errorM");

        logger.error(map.toString());
        logger.error(JSON.toJSONString(map));
    }
}
