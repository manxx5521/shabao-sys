package com.xiaoshabao.framework.wechat.apiJW.coupon.location.model;

import com.xiaoshabao.framework.wechat.apiJW.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.WeixinReqParam;

@ReqType("getLocationInfo")
public class LocationInfo extends WeixinReqParam {
	// 图片地址
	private String filePathName;

	public String getFilePathName() {
		return filePathName;
	}

	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}


	
}
