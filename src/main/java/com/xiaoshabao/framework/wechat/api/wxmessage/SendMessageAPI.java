package com.xiaoshabao.framework.wechat.api.wxmessage;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.util.WeiXinReqService;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.Article;
import com.xiaoshabao.framework.wechat.api.wxmessage.model.MessageFilter;
import com.xiaoshabao.framework.wechat.api.wxmessage.model.MessageNews;
import com.xiaoshabao.framework.wechat.api.wxmessage.model.SendNewsByGroup;
import com.xiaoshabao.framework.wechat.api.wxmessage.result.MessageUploadResult;

public class SendMessageAPI {
	/**
	 * 上传群发图文消息素材
	 * @param articles 图文消息，一个图文消息支持1到8条图文
	 * @return
	 * @throws WexinReqException 
	 */
	public static MessageUploadResult uploadNews(String accessToken,List<Article> articles) throws WexinReqException{
		MessageNews upload =new MessageNews();
		upload.setAccess_token(accessToken);
		upload.setArticles(articles);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(upload);
		return JSONObject.toJavaObject(result, MessageUploadResult.class);
	}
	
	/**
	 * 群发图文消息-通过分组
	 * @param accessToken
	 * @param media_id
	 * @param group_id 要发送到的分组
	 * @return
	 * @throws WexinReqException
	 */
	public static void sendMessByGroup(String accessToken,String media_id,String group_id) throws WexinReqException{
		SendNewsByGroup upload =new SendNewsByGroup();
		upload.setAccess_token(accessToken);
		upload.setFilter(new MessageFilter (group_id));
		upload.setMpnews("media_id", media_id);
		upload.setMsgtype("mpnews");
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(upload);
		System.out.println(result.toJSONString());
	}
}
