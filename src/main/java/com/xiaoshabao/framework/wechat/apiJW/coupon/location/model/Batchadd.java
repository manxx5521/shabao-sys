package com.xiaoshabao.framework.wechat.apiJW.coupon.location.model;

import java.util.List;

import com.xiaoshabao.framework.wechat.apiJW.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.WeixinReqParam;

@ReqType("getBatchadd")
public class Batchadd extends WeixinReqParam{
	//门店信息
	private List<LocationList> location_list;

	public List<LocationList> getLocation_list() {
		return location_list;
	}

	public void setLocation_list(List<LocationList> location_list) {
		this.location_list = location_list;
	}

	
	
}
