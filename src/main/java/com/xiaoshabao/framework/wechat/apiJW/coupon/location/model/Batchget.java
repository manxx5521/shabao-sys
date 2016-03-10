package com.xiaoshabao.framework.wechat.apiJW.coupon.location.model;

import com.xiaoshabao.framework.wechat.apiJW.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.WeixinReqParam;

@ReqType("getBatchget")
public class Batchget extends WeixinReqParam{
	//偏移量，0 开始
	private Integer offset ;
	//拉取数量
	private Integer count ;
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
}
