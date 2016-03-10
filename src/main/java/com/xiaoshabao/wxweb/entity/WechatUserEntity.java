package com.xiaoshabao.wxweb.entity;

import java.sql.Timestamp;

/**
 * 微信帐号对应关注用户表
 */
public class WechatUserEntity {
	/** 微信帐号userId */
	private Integer wx_user_id;

	/** 微信帐号对应系统id */
	private Integer account_id;

	/** 微信用户的openId */
	private String openId;

	/** 更新时间 */
	private Timestamp update_time;

	public Integer getWx_user_id() {
		return wx_user_id;
	}

	public void setWx_user_id(Integer wx_user_id) {
		this.wx_user_id = wx_user_id;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

}
