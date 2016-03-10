package com.xiaoshabao.framework.wechat.apiJW.core.req.model.user;

import com.xiaoshabao.framework.wechat.apiJW.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.WeixinReqParam;

/**
 * 分组删除
 * 
 * @author sfli.sir
 * 
 */
@ReqType("groupDelete")
public class GroupDelete extends WeixinReqParam {

	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
}
