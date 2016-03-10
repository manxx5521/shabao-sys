package com.xiaoshabao.framework.wechat.api.core.handler.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import com.xiaoshabao.framework.wechat.api.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.handler.WeiXinReqHandler;
import com.xiaoshabao.framework.wechat.api.core.req.model.WeixinReqConfig;
import com.xiaoshabao.framework.wechat.api.core.req.model.WeixinReqParam;
import com.xiaoshabao.framework.wechat.api.core.req.model.media.DownloadMedia;
import com.xiaoshabao.framework.wechat.api.core.util.HttpRequestProxy;
import com.xiaoshabao.framework.wechat.api.core.util.WeiXinReqUtil;



public class WeixinReqMediaDownHandler implements WeiXinReqHandler {

	private static Logger logger = Logger.getLogger(WeixinReqMediaDownHandler.class);
	
	public String doRequest(WeixinReqParam weixinReqParam) throws WexinReqException {
		String strReturnInfo = "";
		if(weixinReqParam.getClass().isAnnotationPresent(ReqType.class)){
			DownloadMedia downloadMedia = (DownloadMedia) weixinReqParam;
			ReqType reqType = weixinReqParam.getClass().getAnnotation(ReqType.class);
			WeixinReqConfig objConfig = WeiXinReqUtil.getWeixinReqConfig(reqType.value());
			if(objConfig != null){
				String reqUrl = objConfig.getUrl();
				String filePath = downloadMedia.getFilePath();
				Map<String, Object> parameters = WeiXinReqUtil.getWeixinReqParam(weixinReqParam);
				parameters.remove("filePathName");
				strReturnInfo = HttpRequestProxy.downMadGet(reqUrl, parameters, "UTF-8",filePath,downloadMedia.getMedia_id());
			}
		}else{
			logger.info("没有找到对应的配置信息");
		}
		return strReturnInfo;
	}

}
