package com.xiaoshabao.wxweb.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 系统配置类<br>
 * 记录系统常用配置信息
 */
@Component("config")
public class ConfigBean {
	/**
	 * 网站URL
	 */
	@Value("${domain}")
	private String domain;

	/**
	 * 后台管理最上级菜单
	 */
	@Value("${parent_menu_admin}")
	private String parent_menu_admin;
	
	
	/**
	 * 后台管理左侧菜单分组
	 */
	@Value("${group_id_admin}")
	private String group_id_admin;

	/**
	 * 微信账号id
	 */
	@Value("${appid}")
	private String appid;

	/**
	 * 微信帐号密钥
	 */
	@Value("${appsecret}")
	private String appsecret;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getParent_menu_admin() {
		return parent_menu_admin;
	}

	public void setParent_menu_admin(String parent_menu_admin) {
		this.parent_menu_admin = parent_menu_admin;
	}

	public String getGroup_id_admin() {
		return group_id_admin;
	}

	public void setGroup_id_admin(String group_id_admin) {
		this.group_id_admin = group_id_admin;
	}
	
}
