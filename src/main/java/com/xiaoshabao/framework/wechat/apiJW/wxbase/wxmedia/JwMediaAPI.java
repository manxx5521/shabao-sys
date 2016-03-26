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
	 * 
	 * @param accessToke
	 * @param type  媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param fileNamePath  上传的文件目录
	 * @return
	 * @throws WexinReqException
	 */
	public static WxUpload uploadMedia(String accessToke,String type,String fileNamePath) throws WexinReqException{
		UploadMedia uploadMedia = new UploadMedia();
		uploadMedia.setAccess_token(accessToke);
		uploadMedia.setFilePathName(fileNamePath);
		uploadMedia.setType(type);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(uploadMedia);
		Object error = result.get(WeiXinConstant.RETURN_ERROR_INFO_CODE);
		WxUpload wxMedia = null;
		wxMedia = JSON.toJavaObject(result, WxUpload.class);
		return wxMedia;
	}
	
	
	/**
	 * 下载多媒体
	 * @param accessToke
	 * @param media_id
	 * @param filePath
	 * @return
	 * @throws WexinReqException
	 */
	public static WxDwonload downMedia(String accessToke,String media_id,String filePath) throws WexinReqException{
		DownloadMedia downloadMedia = new DownloadMedia();
		downloadMedia.setAccess_token(accessToke);
		downloadMedia.setFilePath(filePath);
		downloadMedia.setMedia_id(media_id);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(downloadMedia);
		Object error = result.get(WeiXinConstant.RETURN_ERROR_INFO_CODE);
		WxDwonload wxMedia = null;
		wxMedia = JSON.toJavaObject(result, WxDwonload.class);
		return wxMedia;
	}
	
	
	
	/**
	 * 上传新增永久图文素材
	 * 
	 * @param accesstoken
	 * @param wxArticles
	 *            图文集合，数量不大于10
	 * @return WxArticlesResponse 上传图文消息素材返回结果
	 * @throws WexinReqException
	 */
	public static WxArticlesResponse uploadArticlesByMaterial(String accesstoken, List<WxArticle> wxArticles) throws WexinReqException {
		WxArticlesResponse wxArticlesResponse = null;
		if (wxArticles.size() == 0) {
			logger.error("没有上传的图文消息");
		} else if (wxArticles.size() > 10) {
			logger.error("图文消息最多为10个图文");
		} else {
			if (accesstoken != null) {
				String requestUrl = material_add_news_url.replace("ACCESS_TOKEN", accesstoken);

				for (WxArticle article : wxArticles) {
					if (article.getFileName() != null && article.getFileName().length() > 0) {
						try {
							String mediaId = JwSendMessageAPI.getFileMediaId(accesstoken, article);
							article.setThumb_media_id(mediaId);

						} catch (Exception e) {
							throw new WexinReqException(e);
						}
					}
				}
				WxArticlesRequest wxArticlesRequest = new WxArticlesRequest();
				wxArticlesRequest.setArticles(wxArticles);
				String jsonString =JSON.toJSONString(wxArticlesRequest);
				JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
				//System.out.println("微信返回的结果：" + result.toString());
				if (result.containsKey("errcode")) {
					logger.error("上传图文消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
					throw new WexinReqException("上传图文消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
				} else {

					wxArticlesResponse = new WxArticlesResponse();
					wxArticlesResponse.setMedia_id(result.getString("media_id"));
					wxArticlesResponse.setType(result.getString("type"));
					wxArticlesResponse.setCreated_at(new Date(result.getLong("created_at") * 1000));
				}

			}
		}

		return wxArticlesResponse;
	}
	
	
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
	/**
	 * 新增永久图文素材
	 * @param accesstoken
	 * @param wxArticles
	 * @return
	 * @throws WexinReqException
	 */
	public static String getMediaIdByMaterial(String accesstoken, List<WxArticle> wxArticles) throws WexinReqException {

		WxArticlesResponse response = uploadArticlesByMaterial(accesstoken, wxArticles);
		if (response == null) {
			throw new WexinReqException("获取图文的mediaId失败");
		}
		return response.getMedia_id();
	}
	/**
	 * 新增其他类型永久素材
	 * 
	 * @param filePath
	 * @param fileName
	 * @param type
	 *            媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @return
	 * @throws Exception
	 */
	public static WxMediaForMaterialResponse uploadMediaFileByMaterial(String accesstoken, WxMediaForMaterial wx) throws WexinReqException {
		WxMediaForMaterialResponse mediaResource = null;
		if (accesstoken != null) {
			String requestUrl = material_add_material_url.replace("ACCESS_TOKEN", accesstoken);

			File file = new File(wx.getFilePath() + wx.getFileName());
			String contentType = WeiXinReqUtil.getFileContentType(wx.getFileName().substring(wx.getFileName().lastIndexOf(".") + 1));
			JSONObject result = WxstoreUtils.uploadMediaFile(requestUrl, file, contentType);
			if("video"==wx.getType()){
				WxDescriptionRequest wr = new WxDescriptionRequest();
				wr.setDescription(wx.getWxDescription());
				String jsonString =JSON.toJSONString(wr);
				WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
			}
			
			//System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode")) {
				logger.error("上传媒体资源失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
			} else {
				// {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
				mediaResource = new WxMediaForMaterialResponse();
				mediaResource.setMedia_id(result.getString("media_id"));
				mediaResource.setUrl(result.getString("url"));
			}
			// return mediaResource;
		}
		return mediaResource;
	}
	public static void main(String[] args){
		 
		try {
			WxMediaForMaterial bean=new WxMediaForMaterial();
			bean.setFilePath("E:\\test\\");
			bean.setType("image");
			bean.setFileName("img01.jpg");
			WxMediaForMaterialResponse resp= JwMediaAPI.uploadMediaFileByMaterial(
					"iczd2hHC2us50RAZDCpjY7hkb7QU-XFdr8LQTxV1WNPfu4-ZtbApxQX8UbY6FbHrfMS6V_sO7-It4NzcnJANBUP7rOKZnHjaRCE_asgvnHJ_4J2WIN0fKjoV6VGswPAmOAIfAFAYKS",
					bean);
			System.out.println(resp.getMedia_id());
		} catch (WexinReqException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 永久获取多媒体资源的mediaId
	 * 
	 * @param accesstoken
	 * @param wxMedia
	 * @return
	 * @throws WexinReqException
	 */
	public static String getMediaIdForMaterial(String accesstoken, WxMediaForMaterial wxMediaForMaterial) throws WexinReqException {

		WxMediaForMaterialResponse response = uploadMediaFileByMaterial(accesstoken, wxMediaForMaterial);
		if (response == null) {
			throw new WexinReqException("获取多媒体资源的mediaId失败");
		}
		return response.getMedia_id();

	}

}
