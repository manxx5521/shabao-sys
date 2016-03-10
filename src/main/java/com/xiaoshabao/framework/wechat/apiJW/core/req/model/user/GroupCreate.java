package com.xiaoshabao.framework.wechat.apiJW.core.req.model.user;

import com.xiaoshabao.framework.wechat.apiJW.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.WeixinReqParam;

/**
 * 取多媒体文件
 * 
 * @author sfli.sir
 * 
 */
@ReqType("groupCreate")
public class GroupCreate extends WeixinReqParam {

	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
}
