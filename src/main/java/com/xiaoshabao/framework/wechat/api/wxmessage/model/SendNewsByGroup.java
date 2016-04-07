package com.xiaoshabao.framework.wechat.api.wxmessage.model;

import java.util.HashMap;
import java.util.Map;

import com.xiaoshabao.framework.wechat.api.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;

/**
 * 群发图文消息
 */
@ReqType("sendMessage")
public class SendNewsByGroup extends WeixinReqParam{
	private MessageFilter filter;
	private Map<String,String> mpnews=new HashMap<String,String> ();
	private String msgtype;
	
	/**
	 * 给mpnews 设置值
	 * @param key
	 * @param value
	 */
	public void setMpnews(String key,String value) {
		mpnews.put(key, value);
	}
	
	public MessageFilter getFilter() {
		return filter;
	}
	public void setFilter(MessageFilter filter) {
		this.filter = filter;
	}
	public Map<String, String> getMpnews() {
		return mpnews;
	}
	public void setMpnews(Map<String, String> mpnews) {
		this.mpnews = mpnews;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
