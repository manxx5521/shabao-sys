package com.xiaoshabao.framework.web.springmvc.util;

/**
 * 字符串工具类
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param s
	 *            要判断的字符串
	 * @return 为空返回真
	 */
	public static boolean isEmpty(String s) {
		if (s == null)
			return true;
		if (s.equals(""))
			return true;
		return false;
	}
	/**
	 * 判断字符串不为为空
	 * 
	 * @param s
	 *            要判断的字符串
	 * @return 为空返回真
	 */
	public static boolean isNotEmpty(String s) {
		if (s == null)
			return false;
		if (s.equals(""))
			return false;
		return true;
	}

}
