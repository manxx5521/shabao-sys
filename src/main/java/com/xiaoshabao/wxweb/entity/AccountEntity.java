package com.xiaoshabao.wxweb.entity;

import java.sql.Timestamp;

/**
 * 微信帐号信息<br/>
 * 获得token用的实体是AccessToken
 * 
 */
public class AccountEntity {
	/**
	 * 这个微信下的应用id
	 */
	private Integer account_id;

	/**
	 * 微信帐号的id
	 */
	private String appid;
	/**
	 * 微信给的加密
	 */
	private String appsecret;

	/**
	 * 同一个appid下的应用id
	 */
	private String id;
	
	/**
	 * 微信应用的名字
	 */
	private String app_name;

	/**
	 * 凭证
	 */
	private String access_token;
	/**
	 * 凭证有效时间(秒)
	 */
	private int expires_in;
	/**
	 * 更新时间
	 */
	private Timestamp update_time;

	/**
	 * js凭证
	 */
	private String jsaccess_token;
	/**
	 * js凭证有效时间
	 */
	private int jsexpires_in;

	/**
	 * js更新时间
	 */
	private Timestamp jsupdate_time;

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public String getJsaccess_token() {
		return jsaccess_token;
	}

	public void setJsaccess_token(String jsaccess_token) {
		this.jsaccess_token = jsaccess_token;
	}

	public int getJsexpires_in() {
		return jsexpires_in;
	}

	public void setJsexpires_in(int jsexpires_in) {
		this.jsexpires_in = jsexpires_in;
	}

	public Timestamp getJsupdate_time() {
		return jsupdate_time;
	}

	public void setJsupdate_time(Timestamp jsupdate_time) {
		this.jsupdate_time = jsupdate_time;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	
}
