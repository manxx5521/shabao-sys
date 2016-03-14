package com.xiaoshabao.framework.wechat.apice.wxmedia;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.apiJW.core.common.WxstoreUtils;
import com.xiaoshabao.framework.wechat.apice.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.apice.core.req.WeiXinReqService;
import com.xiaoshabao.framework.wechat.apice.core.req.model.media.DownloadTempMedia;
import com.xiaoshabao.framework.wechat.apice.core.req.model.media.UploadTempMedia;
import com.xiaoshabao.framework.wechat.apice.core.util.WeiXinReqUtil;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxArticlesRequest;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxArticlesRequestByMaterial;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxArticlesRespponseByMaterial;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxCountResponse;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxDescriptionRequest;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxDwonload;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxMediaForMaterial;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxMediaForMaterialResponse;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxNews;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxUpdateArticle;
import com.xiaoshabao.framework.wechat.apice.wxmedia.model.WxUpload;
import com.xiaoshabao.framework.wechat.apice.wxsendmsg.SendMessageAPI;
import com.xiaoshabao.framework.wechat.apice.wxsendmsg.model.WxArticle;
import com.xiaoshabao.framework.wechat.apice.wxsendmsg.model.WxArticlesResponse;


/**
 * 微信-素材接口
 */
public class MediaAPI {
	private static Logger logger = LoggerFactory.getLogger(MediaAPI.class);

	// 新增永久图文素材
	private static String material_add_news_url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
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
	 * 微信--上传临时文件接口
	 * 
	 * @param accessToken
	 * @param type
	 *            媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb） 。<br>
	 *            可以使用
	 *            {@link com.xiaoshabao.framework.wechat.apice.wxmedia.MediaType}
	 *            提供的类型
	 * @param fileNamePath
	 *            上传的文件目录
	 * @return
	 * @throws WexinReqException
	 */
	public static WxUpload uploadTempMedia(String accessToken, String type,
			String fileNamePath) throws WexinReqException {
		UploadTempMedia uploadMedia = new UploadTempMedia();
		uploadMedia.setAccess_token(accessToken);
		uploadMedia.setFilePathName(fileNamePath);
		uploadMedia.setType(type);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				uploadMedia);
		WxUpload wxMedia = null;
		wxMedia = JSON.toJavaObject(result, WxUpload.class);
		return wxMedia;
	}
	
	/**
	 * 下载-临时多媒体
	 * 
	 * @param accessToken
	 * @param media_id
	 * @param filePath 路径格式为 E:\\test 无需加最后一个分割符号
	 * @return
	 * @throws WexinReqException
	 */
	public static WxDwonload downTempMedia(String accessToken, String media_id,
			String filePath) throws WexinReqException {
		DownloadTempMedia downloadMedia = new DownloadTempMedia();
		downloadMedia.setAccess_token(accessToken);
		downloadMedia.setFilePath(filePath);
		downloadMedia.setMedia_id(media_id);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				downloadMedia);
		WxDwonload wxMedia = JSON.toJavaObject(result, WxDwonload.class);
		return wxMedia;
	}

	/**
	 * 新增-永久图文素材
	 * 
	 * @param accesstoken
	 * @param wxArticles
	 *            图文集合，数量不大于10
	 * @return WxArticlesResponse 上传图文消息素材返回结果
	 * @throws WexinReqException
	 */
	public static WxArticlesResponse uploadNews(
			String accesstoken, List<WxArticle> wxArticles)
			throws WexinReqException {
		WxArticlesResponse wxArticlesResponse = null;
		if (wxArticles.size() == 0) {
			logger.error("没有上传的图文消息");
		} else if (wxArticles.size() > 10) {
			logger.error("图文消息最多为10个图文");
		} else {
			if (accesstoken != null) {
				String requestUrl = material_add_news_url.replace(
						"ACCESS_TOKEN", accesstoken);

				for (WxArticle article : wxArticles) {
					if (article.getFileName() != null
							&& article.getFileName().length() > 0) {
						try {
							String mediaId = SendMessageAPI.getFileMediaId(
									accesstoken, article);
							article.setThumb_media_id(mediaId);

						} catch (Exception e) {
							throw new WexinReqException(e);
						}
					}
				}
				WxArticlesRequest wxArticlesRequest = new WxArticlesRequest();
				wxArticlesRequest.setArticles(wxArticles);
				String jsonString = JSON.toJSONString(wxArticlesRequest);
				JSONObject result = WxstoreUtils.httpRequest(requestUrl,
						"POST", jsonString);
				// System.out.println("微信返回的结果：" + result.toString());
				if (result.containsKey("errcode")) {
					logger.error("上传图文消息失败！errcode="
							+ result.getString("errcode") + ",errmsg = "
							+ result.getString("errmsg"));
					throw new WexinReqException("上传图文消息失败！errcode="
							+ result.getString("errcode") + ",errmsg = "
							+ result.getString("errmsg"));
				} else {

					wxArticlesResponse = new WxArticlesResponse();
					wxArticlesResponse
							.setMedia_id(result.getString("media_id"));
					wxArticlesResponse.setType(result.getString("type"));
					wxArticlesResponse.setCreated_at(new Date(result
							.getLong("created_at") * 1000));
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
	public static WxCountResponse getMediaCount(String accesstoken)
			throws WexinReqException {
		WxCountResponse wxCountResponse = null;
		if (accesstoken != null) {
			String requestUrl = material_get_materialcount_url.replace(
					"ACCESS_TOKEN", accesstoken);

			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST",
					null);
			// System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode")) {
				logger.error("上传图文消息失败！errcode=" + result.getString("errcode")
						+ ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("上传图文消息失败！errcode="
						+ result.getString("errcode") + ",errmsg = "
						+ result.getString("errmsg"));
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
	public static WxArticlesRespponseByMaterial getArticlesByMaterial(
			String accesstoken, String mediaId) throws WexinReqException {
		WxArticlesRespponseByMaterial wxArticlesRespponseByMaterial = null;

		if (accesstoken != null) {
			String requestUrl = material_get_material_url.replace(
					"ACCESS_TOKEN", accesstoken);
			WxArticlesRequestByMaterial wxArticlesRequestByMaterial = new WxArticlesRequestByMaterial();
			wxArticlesRequestByMaterial.setMediaId(mediaId);
			String jsonString = JSON.toJSONString(wxArticlesRequestByMaterial);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST",
					jsonString);
			// System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode")) {
				logger.error("获得消息失败！errcode=" + result.getString("errcode")
						+ ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("获得消息失败！errcode="
						+ result.getString("errcode") + ",errmsg = "
						+ result.getString("errmsg"));
			} else {
				wxArticlesRespponseByMaterial = JSON.toJavaObject(result,
						WxArticlesRespponseByMaterial.class);
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
	public static void deleteArticlesByMaterial(String accesstoken,
			String mediaId) throws WexinReqException {
		if (accesstoken != null && StringUtils.isNotEmpty(mediaId)) {
			String requestUrl = material_get_material_url.replace(
					"ACCESS_TOKEN", accesstoken);
			WxArticlesRequestByMaterial wxArticlesRequestByMaterial = new WxArticlesRequestByMaterial();
			wxArticlesRequestByMaterial.setMediaId(mediaId);
			String jsonString = JSON.toJSONString(wxArticlesRequestByMaterial);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST",
					jsonString);
			// System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode") && result.get("errcode") != "0") {
				logger.error("删除消息失败！errcode=" + result.getString("errcode")
						+ ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("删除消息失败！errcode="
						+ result.getString("errcode") + ",errmsg = "
						+ result.getString("errmsg"));
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
	public static void updateArticlesByMaterial(String accesstoken,
			WxUpdateArticle wxUpdateArticle) throws WexinReqException {
		if (accesstoken != null) {
			String requestUrl = material_update_news_url.replace(
					"ACCESS_TOKEN", accesstoken);

			String jsonString = JSON.toJSONString(wxUpdateArticle);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST",
					jsonString);
			// System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode") && result.get("errcode") != "0") {
				logger.error("消息失败！errcode=" + result.getString("errcode")
						+ ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("消息消息失败！errcode="
						+ result.getString("errcode") + ",errmsg = "
						+ result.getString("errmsg"));
			}
		}
	}

	/**
	 * 获取素材列表
	 * 
	 * @param accesstoken
	 *            ,type,offset,count
	 * @param WxNews
	 * @throws WexinReqException
	 */
	public static WxNews queryArticlesByMaterial(String accesstoken,
			String type, int offset, int count) throws WexinReqException {
		WxNews wn = null;
		if (accesstoken != null) {
			String requestUrl = material_batchget_material_url.replace(
					"ACCESS_TOKEN", accesstoken);

			JSONObject obj = new JSONObject();
			obj.put("type", type);
			obj.put("offset", offset);
			obj.put("count", count);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST",
					obj.toString());
			// System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode") && result.get("errcode") != "0") {
				logger.error("消息失败！errcode=" + result.getString("errcode")
						+ ",errmsg = " + result.getString("errmsg"));
				throw new WexinReqException("消息消息失败！errcode="
						+ result.getString("errcode") + ",errmsg = "
						+ result.getString("errmsg"));
			} else {
				wn = JSON.toJavaObject(result, WxNews.class);
			}
		}
		return wn;
	}

	/**
	 * 新增永久图文素材
	 * 
	 * @param accesstoken
	 * @param wxArticles
	 * @return
	 * @throws WexinReqException
	 */
	public static String getMediaIdByMaterial(String accesstoken,
			List<WxArticle> wxArticles) throws WexinReqException {

		WxArticlesResponse response = uploadNews(accesstoken,
				wxArticles);
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
	public static WxMediaForMaterialResponse uploadMediaFileByMaterial(
			String accesstoken, WxMediaForMaterial wx) throws WexinReqException {
		WxMediaForMaterialResponse mediaResource = null;
		if (accesstoken != null) {
			String requestUrl = material_add_material_url.replace(
					"ACCESS_TOKEN", accesstoken);

			File file = new File(wx.getFilePath() + wx.getFileName());
			String contentType = WeiXinReqUtil.getFileContentType(wx
					.getFileName().substring(
							wx.getFileName().lastIndexOf(".") + 1));
			JSONObject result = WxstoreUtils.uploadMediaFile(requestUrl, file,
					contentType);
			if ("video" == wx.getType()) {
				WxDescriptionRequest wr = new WxDescriptionRequest();
				wr.setDescription(wx.getWxDescription());
				String jsonString = JSON.toJSONString(wr);
				WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
			}

			// System.out.println("微信返回的结果：" + result.toString());
			if (result.containsKey("errcode")) {
				logger.error("上传媒体资源失败！errcode=" + result.getString("errcode")
						+ ",errmsg = " + result.getString("errmsg"));
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

	/**
	 * 永久获取多媒体资源的mediaId
	 * 
	 * @param accesstoken
	 * @param wxMedia
	 * @return
	 * @throws WexinReqException
	 */
	public static String getMediaIdForMaterial(String accesstoken,
			WxMediaForMaterial wxMediaForMaterial) throws WexinReqException {

		WxMediaForMaterialResponse response = uploadMediaFileByMaterial(
				accesstoken, wxMediaForMaterial);
		if (response == null) {
			throw new WexinReqException("获取多媒体资源的mediaId失败");
		}
		return response.getMedia_id();

	}

}
