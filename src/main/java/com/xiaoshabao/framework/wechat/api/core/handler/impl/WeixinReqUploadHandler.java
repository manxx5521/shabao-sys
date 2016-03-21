package com.xiaoshabao.framework.wechat.api.core.handler.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.xiaoshabao.framework.web.springmvc.util.StringUtil;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.handler.WeiXinReqHandler;
import com.xiaoshabao.framework.wechat.api.core.http.HttpClientManager;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqConfig;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinUploadParam;

/**
 * 微信上传文件方法<br>
 * 此方法使用https
 */
public class WeixinReqUploadHandler implements WeiXinReqHandler {

	private static Logger logger = Logger.getLogger(WeixinReqUploadHandler.class);

	public String doRequest(WeixinReqParam weixinReqParam,
			WeixinReqConfig objConfig) throws WexinReqException {
		logger.info("使用WeixinUploadHandler 处理上传文件");
		WeixinUploadParam upParams=(WeixinUploadParam)weixinReqParam;
		List<String> pathList =upParams.getFilePathName();
		if(pathList.isEmpty()){
			throw new WexinReqException("文件为空");
		}
		List<File> fileList=new ArrayList<File>();
		for(String path:pathList){
			fileList.add(new File(path));
		}
		Map<String,Object> map=upParams.getParams();
		if(map==null||map.isEmpty()){
			map=new HashMap<String, Object>();
		}
		map.put("access_token", upParams.getAccess_token());
		String type=upParams.getType();
		if(StringUtil.isNotEmpty(type)){
			map.put("type", upParams.getType());
		}
		return HttpClientManager.getInstance().doPostSSL(objConfig.getUrl(),map, fileList);
		
	}

}
