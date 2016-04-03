package com.xiaoshabao.framework.wechat.api.wxuser.model;

import com.xiaoshabao.framework.wechat.api.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;


/**
 * 获得用户分组id
 */
@ReqType("setUserRemark")
public class UserRemarkSet extends WeixinReqParam {
	private String openid;
	/**
	 * 新的备注名，长度必须小于30字符
	 */
	private String remark;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRemark() {
		return remark;
	}
	/**
	 * 新的备注名，长度必须小于30字符
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
