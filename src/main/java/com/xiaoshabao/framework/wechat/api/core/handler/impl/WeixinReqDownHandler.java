package com.xiaoshabao.framework.wechat.api.core.handler.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.handler.WeiXinReqHandler;
import com.xiaoshabao.framework.wechat.api.core.http.HttpClientManager;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinDownParam;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqConfig;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;

public class WeixinReqDownHandler implements WeiXinReqHandler {

	private static Logger logger = Logger.getLogger(WeixinReqDownHandler.class);
	
	@Override
	public String doRequest(WeixinReqParam weixinReqParam,
			WeixinReqConfig objConfig) throws WexinReqException {
		logger.info("使用WeixinReqDownHandler 下载文件文件");
		WeixinDownParam upParams=(WeixinDownParam)weixinReqParam;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("media_id", upParams.getMedia_id());
		params.put("access_token", upParams.getAccess_token());
		
		String fileName= HttpClientManager.getInstance().getFileGetSSL(objConfig.getUrl(), params, upParams.getFilePath());
		Map<String,String> result=new HashMap<String, String>();
		result.put("fileName", fileName);
		result.put("filePath", upParams.getFilePath());
		return JSONObject.toJSONString(result);
	}

}
