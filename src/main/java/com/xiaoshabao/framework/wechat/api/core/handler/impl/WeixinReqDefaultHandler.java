package com.xiaoshabao.framework.wechat.api.core.handler.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.api.core.config.WeiXinConstant;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.handler.WeiXinReqHandler;
import com.xiaoshabao.framework.wechat.api.core.http.HttpClientManager;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqConfig;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;

/**
 * 默认的处理微信请求handler
 * <p>
 * 方法使用HttpClient来发送请求，使用HTTPS方式
 * </p>
 */
public class WeixinReqDefaultHandler implements WeiXinReqHandler {

	private static Logger logger = Logger
			.getLogger(WeixinReqDefaultHandler.class);
	
	/**
	 * 默认的请求方法，使用HTTPS方式
	 */
	@Override
	public String doRequest(WeixinReqParam weixinReqParam,WeixinReqConfig objConfig)
			throws WexinReqException {
		logger.info("使用WeixinReqDefaultHandler 处理请求");
		
		try {
			String reqUrl = objConfig.getUrl();
			String method = objConfig.getMethod();
			String datatype = objConfig.getDataType();

			// 处理JSON请求
			if (WeiXinConstant.DATA_TYPE_JSON.equalsIgnoreCase(datatype)) {
				String jsonData = JSONObject.toJSONString(weixinReqParam);
				if (WeiXinConstant.REQUEST_POST.equalsIgnoreCase(method)) {
					return HttpClientManager.getInstance().doPostSSLByJSON(reqUrl,weixinReqParam.getAccess_token(),
							jsonData);
				}
				Map<String, Object> params = JSONObject.parseObject(jsonData);
				return HttpClientManager.getInstance().doGetSSL(reqUrl, params);
			}

			// 处理字符串请求
			if (WeiXinConstant.DATA_TYPE_STRING.equalsIgnoreCase(datatype)) {
				if (WeiXinConstant.REQUEST_POST.equalsIgnoreCase(method)) {
					return HttpClientManager.getInstance().doPostSSL(reqUrl,
							weixinReqParam.toParams());
				}
				return HttpClientManager.getInstance().doGet(
						reqUrl + "&" + weixinReqParam.toParams());
			}

			// 使用Map方式解析
			String jsonData = JSONObject.toJSONString(weixinReqParam, true);
			Map<String, Object> params = JSONObject.parseObject(jsonData);
			if (WeiXinConstant.REQUEST_POST.equalsIgnoreCase(method)) {
				return HttpClientManager.getInstance().doPostSSL(reqUrl, params);
			}
			return HttpClientManager.getInstance().doGetSSL(reqUrl, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WexinReqException("WeixinReqDefaultHandler 进行操作是出现未知异常");
		}
	}

}
