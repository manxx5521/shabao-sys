package com.xiaoshabao.framework.wechat.api.wxuser.model;

import com.xiaoshabao.framework.wechat.api.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;


/**
 * 更新分组
 */
@ReqType("groupUpdate")
public class GroupUpdate extends WeixinReqParam {
	
	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	
}
