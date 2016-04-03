package com.xiaoshabao.framework.wechat.api.wxuser.model;

import com.xiaoshabao.framework.wechat.api.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;


/**
 * 获得用户分组id
 */
@ReqType("groupsGetid")
public class GroupGetId extends WeixinReqParam {
	private String openid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
