package com.xiaoshabao.wxweb.entity;

/**
 * 用户微信账号表
 * <p>
 * 根据用户user_id查找微信的系统id
 * </p>
 */
public class UserAccountEntity {
	/**
	 * 微信帐号在系统对应id
	 */
	private Integer account_id;

	/**
	 * 用户的user_id
	 */
	private Integer user_id;

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}
