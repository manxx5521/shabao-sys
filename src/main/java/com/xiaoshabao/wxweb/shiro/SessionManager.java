package com.xiaoshabao.wxweb.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.xiaoshabao.wxweb.entity.SessionUserInfo;

public class SessionManager {
	private static SessionManager instance = new SessionManager();

	/**
	 * 私有默认构造子
	 */
	private SessionManager() {
 
	}

	/**
	 * 静态工厂方法
	 */
	public static SessionManager getInstance() {
		return instance;
	}

	/**
	 * 获取Shiro的用户session信息
	 */
	public SessionUserInfo getSeesionInfo() {
		Session session = SecurityUtils.getSubject().getSession();
		Object obj = session.getAttribute("userSession");
		if (obj != null) {
			return (SessionUserInfo) obj;
		} else {
			return null;
		}
	}
	
	/**
	 * 获取Shiro的用户userId信息
	 */
	public Integer getUser_id() {
		return this.getSeesionInfo().getUser_id();
	}
}
