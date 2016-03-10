package com.xiaoshabao.framework.wechat.apiJW.core.handler;

import com.xiaoshabao.framework.wechat.apiJW.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.WeixinReqParam;

/**
 * 获取微信接口的信息
 * @author liguo
 *
 */
public interface WeiXinReqHandler {
	
	public String doRequest(WeixinReqParam weixinReqParam) throws WexinReqException;
	
}
