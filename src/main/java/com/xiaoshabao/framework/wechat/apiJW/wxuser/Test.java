package com.xiaoshabao.framework.wechat.apiJW.wxuser;

import com.xiaoshabao.framework.wechat.apiJW.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxtoken.TokenAPI;
import com.xiaoshabao.framework.wechat.apiJW.wxuser.user.JwUserAPI;

public class Test {

	public static void main(String[] args) {
		try {
			String s = 	TokenAPI.getAccessToken("??","????");
			System.out.println(JwUserAPI.getWxuser(s, "????").getNickname());
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
	}
}
