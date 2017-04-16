package com.chinawiserv.dsp.dcm.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * 异常日志记录
 * 只有系统发生异常后执行这个类的方法,用于记录系统异常日志
 * @author Administrator
 *
 */
@Aspect
@Component
public class ExceptionLogAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void doAfterThrowing() {
		
	}

	/**
	 * 当系统抛出异常后执行
	 * @param jp
	 * @param e
	 * @throws Throwable
	 */
	@AfterThrowing( value = "doAfterThrowing()",throwing = "e")
	public void doAfterThrowing(JoinPoint jp, Throwable e)  throws Throwable{
		
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		Method method = methodSignature.getMethod();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("className", jp.getTarget().getClass().getName());
		map.put("methodName", method.getName());
		map.put("args",JSON.toJSONString(jp.getArgs(), SerializerFeature.BrowserCompatible));
		map.put("errorMsg",e.getMessage());
		logger.error(map.toString());
	}
}
