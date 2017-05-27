package com.chinawiserv.dsp.dcs.dcm.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 日期时间工具类
 * Created by zhanf on 2017/5/16.
 */
public class DateTimeUtils {
	public static final DateTimeFormatter MM_DD = DateTimeFormatter.ofPattern("MM-dd");
	public static final DateTimeFormatter YYYY_MM = DateTimeFormatter.ofPattern("yyyy-MM");
	public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final DateTimeFormatter MM_DD_HH_MM = DateTimeFormatter.ofPattern("MM-dd HH:mm");
	public static final DateTimeFormatter MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss");
	public static final DateTimeFormatter YYYY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");

	private DateTimeUtils(){}

	/**
	 * 获取当前时间的毫秒值
	 * @return
	 */
	public static long currentTimeMillis(){
		return Instant.now().toEpochMilli();
	}

	//********************************************
	/**
	 * 将当前时间转化为日期字符，格式为yyyy-MM-dd HH:ss:mm
	 * @return
	 */
	public static String nowToString() {
		return dateTimeToString(LocalDateTime.now());
	}

	/**
	 * 将日期转化为日期字符，格式为yyyy-MM-dd HH:ss:mm
	 * @param date 日期
	 * @return 日期字符串, 失败返回null
	 */
	public static String dateToString(Date date) {
		return dateToString(date, YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 将日期 按照formatter转化为日期字符
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String dateToString(Date date, DateTimeFormatter formatter) {
		checkNotNull(date , "date不能为null");
		checkNotNull(formatter , "formatter不能为null");

		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant() , ZoneId.systemDefault());
		return dateTimeToString(localDateTime , formatter) ;
	}

	/**
	 * 将日期转化为日期字符，格式为yyyy-MM-dd HH:ss:mm
	 * @param localDateTime
	 * @return
	 */
	public static String dateTimeToString(LocalDateTime localDateTime) {
		return dateTimeToString(localDateTime , YYYY_MM_DD_HH_MM_SS) ;
	}

	/**
	 * 将日期 按照formatter转化为日期字符
	 * @param localDateTime
	 * @param formatter
	 * @return
	 */
	public static String dateTimeToString(LocalDateTime localDateTime, DateTimeFormatter formatter) {
		checkNotNull(localDateTime , "localDateTime不能为null");
		checkNotNull(formatter , "formatter不能为null");

		return localDateTime.format(formatter);
	}

}
