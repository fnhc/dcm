package com.chinawiserv.dsp.dcs.dcm.common.aspect;

import com.alibaba.fastjson.JSON;
import com.chinawiserv.dsp.dcs.dcm.common.anno.Log;
import com.chinawiserv.dsp.dcs.dcm.common.bean.Token;
import com.chinawiserv.dsp.dcs.dcm.common.util.TokenUtil;
import com.chinawiserv.dsp.dcs.dcm.entity.SysLog;
import com.chinawiserv.dsp.dcs.dcm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
/**
 * 正常业务日志记录
 * @author Administrator
 *
 */
@Aspect
@Component
public class LogAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ISysLogService sysLogService;
	
	@Pointcut("@annotation(com.chinawiserv.dsp.dcs.dcm.common.anno.Log)")
	public void controllerAspect() {
		
	}
	/**
	 * 当方法正常返回是执行
	 * @param joinPoint
	 */
	@AfterReturning("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		Log log =  method.getAnnotation(Log.class);
		Token st = TokenUtil.getToken(request);
		if(log != null){
			SysLog sysLog  =new SysLog();
			sysLog.setCreateTime(new Date());
			sysLog.setTitle(log.value());
			sysLog.setUserId((st != null )? st.getUid() : "systemUserId");
			sysLog.setUserName((st != null )? st.getUname() : "system");
			sysLog.setUrl(request.getRequestURI().toString());
			sysLog.setParams(JSON.toJSONString(request.getParameterMap()));
			sysLogService.insert(sysLog);
			logger.debug("记录日志:"+sysLog.toString());
		}
	}
}
