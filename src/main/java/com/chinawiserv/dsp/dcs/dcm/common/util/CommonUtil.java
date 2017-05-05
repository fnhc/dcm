package com.chinawiserv.dsp.dcs.dcm.common.util;

import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
/**
 * 通用工具类
 * @author Gaojun.Zhou
 * @date 2016年12月27日 上午11:51:21
 */
public class CommonUtil {
	
	private final static Pattern pat = Pattern.compile("-");
	/**
	 * UUID生成方法
	 * 
	 * @return
	 */
	public static String UUID() {
		UUID uid = UUID.randomUUID();
		return pat.matcher(uid.toString()).replaceAll("").toLowerCase();
	}
	/**
	 * 格式化异常
	 */
	public static String formatException(Exception e) {

		String message = e.getMessage();

		if (StringUtils.isBlank(message)) {

			return "系统繁忙,请稍后重试";
		}

		String runtimeStr = "java.lang.RuntimeException: ";
		message = message.replaceAll(runtimeStr, "");
		return message;
	}

	/***
	 * MD5加码 生成32位md5码
	 */
	public static String string2MD5(String inStr){
		return MD5.encode(inStr , "UTF-8");
	}

	/**
	 * 文件重命名
	 * @param fileName
	 * @return
	 */
	public static String renameFile(String fileName) {
		String now = formatDate(new Date(),"yyyyMMdd");
		String ext = fileName.substring(fileName.lastIndexOf("."));
		return now + File.separator+ RandomStringUtils.randomAlphanumeric(32) + ext;
	}
	/**
	 * 日期格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 过滤非法字符
	 */
	public static String filterValidateChar(String str) {  
		
		if(StringUtils.isBlank(str)){
			return "";
		}
		str = str.toLowerCase().trim();//统一转为小写  
        
		String badStr = "'|exec|execute|insert|select|delete|update|drop|*|%|master|truncate|" +  
                "declare|sitename|net user|xp_cmdshell" ;
        String[] badStrs = badStr.split("\\|");  
        for (int i = 0; i < badStrs.length; i++) {  
            if (str.contains(badStrs[i])) {  
                str = str.replaceAll(badStrs[i], "");
            }  
        }  
        return str;  
    }
	/**
	 * 转换逻辑符号
	 * @param where
	 * @return
	 */
	public static String formatWhereSQL(String where) {
		if(StringUtils.isBlank(where)){
			return "";
		}
		where = where.replaceAll("eq", " = ");
		where = where.replaceAll("nq", " != ");
		where = where.replaceAll("lt", " < ");
		where = where.replaceAll("lq", " <= ");
		where = where.replaceAll("gt", " > ");
		where = where.replaceAll("gq", " >= ");
		
		return where;
	} 
}
