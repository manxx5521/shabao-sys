package com.xiaoshabao.framework.web.springmvc.util;


public class DateUtil {
	
	/**
	 * 获得当前时间
	 * @return Timestamp
	 */
	public static java.sql.Timestamp getTimestamp(){
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}
	
	/**
	 * 获得当前时间戳
	 * @return long 返回16位数字
	 */
	public static long getTime(){
		return new java.util.Date().getTime();
	}
}
