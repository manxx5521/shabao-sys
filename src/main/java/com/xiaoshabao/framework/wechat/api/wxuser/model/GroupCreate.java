package com.xiaoshabao.framework.wechat.api.wxuser.model;

import com.xiaoshabao.framework.wechat.api.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;


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
