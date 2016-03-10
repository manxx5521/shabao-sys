package com.xiaoshabao.framework.wechat.apiJW.core.req.model.kfaccount;

import com.xiaoshabao.framework.wechat.apiJW.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.WeixinReqParam;

/**
 * 取多媒体文件
 * 
 * @author sfli.sir
 * 
 */
@ReqType("kfaccountDel")
public class KfaccountDel extends WeixinReqParam {

	private String kf_account;
	
	private String nickname;
	
	private String password;

	public String getKf_account() {
		return kf_account;
	}

	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}