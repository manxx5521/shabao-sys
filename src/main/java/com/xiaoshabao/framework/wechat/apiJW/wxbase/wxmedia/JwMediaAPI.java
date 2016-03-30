package com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.apiJW.core.common.WxstoreUtils;
import com.xiaoshabao.framework.wechat.apiJW.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.apiJW.core.req.WeiXinReqService;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.DownloadMedia;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.UploadMedia;
import com.xiaoshabao.framework.wechat.apiJW.core.util.WeiXinConstant;
import com.xiaoshabao.framework.wechat.apiJW.core.util.WeiXinReqUtil;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxArticlesRequest;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxArticlesRequestByMaterial;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxArticlesRespponseByMaterial;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxCountResponse;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxDescriptionRequest;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxDwonload;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxMediaForMaterial;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxMediaForMaterialResponse;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxNews;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxUpdateArticle;
import com.xiaoshabao.framework.wechat.apiJW.wxbase.wxmedia.model.WxUpload;
import com.xiaoshabao.framework.wechat.apiJW.wxsendmsg.JwSendMessageAPI;
import com.xiaoshabao.framework.wechat.apiJW.wxsendmsg.model.WxArticle;
import com.xiaoshabao.framework.wechat.apiJW.wxsendmsg.model.WxArticlesResponse;

/**
 * 微信--token信息
 * 
 * @author lizr
 * 
 */
public class JwMediaAPI {
	private static Logger logger = LoggerFactory.getLogger(JwMediaAPI.class);
	// 新增永久图文素材
	private static String material_add_news_url ="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	// 新增其他类型永久素材
	private static String material_add_material_url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
	// 获取永久素材
	private static String material_get_material_url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	// 获取素材总数
	private static String material_get_materialcount_url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	// 修改永久图文素材
	private static String material_update_news_url = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
	// 获取素材列表
	private static String material_batchget_material_url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	/**
	 * 获取素材总数
	 * 
	 * @param accesstoken
	 * @param accesstoken
	 *           
	 * @return WxCountResponse 素材数目返回结果
	 * @throws WexinReqException
	 */
	public static WxCountResponse getMediaCount(String accesstoken) throws WexinReqException {
		WxCountResponse wxCountResponse = null;
		if (accesstoken != null) {
			String requestUrl = material_get_materialcount_url.replace("ACCESS_TOKEN", accesstoken);

			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST",null);
			//System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode")) {
				logger.error("上传图文消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("上传图文消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
			} else {

				wxCountResponse = new WxCountResponse();
				wxCountResponse.setImage_count(result.getString("image_count"));
				wxCountResponse.setNews_count(result.getString("news_count"));
				wxCountResponse.setVideo_count(result.getString("video_count"));
				wxCountResponse.setVoice_count(result.getString("voice_count"));
			}
		}
		return wxCountResponse;
	}
	
	/**
	 * 获取永久素材
	 * 
	 * @param accesstoken
	 * @param wxArticles
	 *            图文集合，数量不大于10
	 * @return WxArticlesResponse 上传图文消息素材返回结果
	 * @throws WexinReqException
	 */
	public static WxArticlesRespponseByMaterial getArticlesByMaterial(String accesstoken,String mediaId) throws WexinReqException {
		WxArticlesRespponseByMaterial wxArticlesRespponseByMaterial = null;
		
			if (accesstoken != null) {
				String requestUrl = material_get_material_url.replace("ACCESS_TOKEN", accesstoken);
				WxArticlesRequestByMaterial wxArticlesRequestByMaterial = new WxArticlesRequestByMaterial();
				wxArticlesRequestByMaterial.setMediaId(mediaId);
				String jsonString =JSON.toJSONString(wxArticlesRequestByMaterial);
				JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
				//System.out.println("微信返回的结果：" + result.toString());
				if (result.containsKey("errcode")) {
					logger.error("获得消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
					throw new WexinReqException("获得消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
				} else {
					wxArticlesRespponseByMaterial = JSON.toJavaObject(result,WxArticlesRespponseByMaterial.class);
				}
		}

		return wxArticlesRespponseByMaterial;
	}
	
	/**
	 * 删除永久素材
	 * 
	 * @param accesstoken
	 * @param mediaId
	 *            图文集合，数量不大于10
	 * @return WxArticlesRespponseByMaterial 上传图文消息素材返回结果
	 * @throws WexinReqException
	 */
	public static void deleteArticlesByMaterial(String accesstoken,String mediaId) throws WexinReqException {
			if (accesstoken != null&&StringUtils.isNotEmpty(mediaId)) {
				String requestUrl = material_get_material_url.replace("ACCESS_TOKEN", accesstoken);
				WxArticlesRequestByMaterial wxArticlesRequestByMaterial = new WxArticlesRequestByMaterial();
				wxArticlesRequestByMaterial.setMediaId(mediaId);
				String jsonString =JSON.toJSONString(wxArticlesRequestByMaterial);
				JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
				//System.out.println("微信返回的结果：" + result.toString());
				if (result.containsKey("errcode")&&result.get("errcode")!="0") {
					logger.error("删除消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
					throw new WexinReqException("删除消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
				} 
		}
	}
	
	/**
	 * 修改永久素材
	 * 
	 * @param accesstoken
	 * @param wxUpdateArticle
	 * @throws WexinReqException
	 */
	public static void updateArticlesByMaterial(String accesstoken,WxUpdateArticle wxUpdateArticle) throws WexinReqException {
		if (accesstoken != null) {
			String requestUrl = material_update_news_url.replace("ACCESS_TOKEN", accesstoken);
			
			String jsonString =JSON.toJSONString(wxUpdateArticle);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
			//System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode")&&result.get("errcode")!="0") {
				logger.error("消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("消息消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
			} 
		}
	}
	
	/**
	 * 获取素材列表
	 * 
	 * @param accesstoken,type,offset,count
	 * @param WxNews
	 * @throws WexinReqException
	 */
	public static WxNews queryArticlesByMaterial(String accesstoken,String type,int offset,int count) throws WexinReqException {
		WxNews wn = null;
		if (accesstoken != null) {
			String requestUrl = material_batchget_material_url.replace("ACCESS_TOKEN", accesstoken);
			
			JSONObject obj = new JSONObject();
			obj.put("type", type);
			obj.put("offset", offset);
			obj.put("count", count);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", obj.toString());
			//System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode")&&result.get("errcode")!="0") {
				logger.error("消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("消息消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
			} else{
				wn = JSON.toJavaObject(result, WxNews.class);
			}
		}
		return wn;
	}

}
