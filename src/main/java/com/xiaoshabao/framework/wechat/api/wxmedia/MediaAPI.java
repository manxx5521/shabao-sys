package com.xiaoshabao.framework.wechat.api.wxmedia;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.util.WeiXinReqService;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.Article;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.DownloadTempMedia;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadMedia;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadNews;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadNewsImg;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadTempMedia;
import com.xiaoshabao.framework.wechat.api.wxmedia.result.DwonloadResult;
import com.xiaoshabao.framework.wechat.api.wxmedia.result.UploadMediaResult;
import com.xiaoshabao.framework.wechat.api.wxmedia.result.UploadTempMediaResult;

/**
 * 微信-素材接口
 */
public class MediaAPI {
	// private static Logger logger = LoggerFactory.getLogger(MediaAPI.class);

	/**
	 * 微信--上传临时文件接口
	 * 
	 * @param accessToken
	 * @param type
	 *            媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb） 。<br>
	 *            可以使用
	 *            {@link com.xiaoshabao.framework.wechat.api.wxmedia.MediaType}
	 *            提供的类型
	 * @param fileNamePath
	 *            上传的文件目录
	 * @return
	 * @throws WexinReqException
	 */
	public static UploadTempMediaResult uploadTempMedia(String accessToken, String type,
			String fileNamePath) throws WexinReqException {
		UploadTempMedia uploadMedia = new UploadTempMedia();
		uploadMedia.setAccess_token(accessToken);
		uploadMedia.addFile(fileNamePath);
		uploadMedia.setType(type);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				uploadMedia);
		return JSON.toJavaObject(result, UploadTempMediaResult.class);
	}

	/**
	 * 下载-临时多媒体
	 * 
	 * @param accessToken
	 * @param media_id
	 * @param filePath
	 *            路径格式为 E:\\test 无需加最后一个分割符号
	 * @return
	 * @throws WexinReqException
	 */
	public static DwonloadResult downTempMedia(String accessToken,
			String media_id, String filePath) throws WexinReqException {
		DownloadTempMedia downloadMedia = new DownloadTempMedia();
		downloadMedia.setAccess_token(accessToken);
		downloadMedia.setFilePath(filePath);
		downloadMedia.setMedia_id(media_id);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				downloadMedia);
		return JSON.toJavaObject(result, DwonloadResult.class);
	}
	
	/**
	 * 永久素材 上传文件接口-其他类
	 * 
	 * @param accessToken
	 * @param type
	 *            媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）可以使用
	 *            {@link com.xiaoshabao.framework.wechat.api.wxmedia.MediaType}
	 *            提供的类型
	 * @param fileNamePath
	 *            上传的文件目录
	 * @return
	 * @throws WexinReqException
	 */
	public static UploadMediaResult uploadMedia(String accessToken, String type,
			String fileNamePath) throws WexinReqException {
		UploadMedia upload = new UploadMedia();
		upload.setAccess_token(accessToken);
		upload.addFile(fileNamePath);
		upload.setType(type);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				upload);
		return JSON.toJavaObject(result, UploadMediaResult.class);
	}
	/**
	 * 上传永久图文-图片接口
	 * <P>本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下</P>
	 * @param accessToken
	 * @param filePath
	 *            上传文件路径
	 * @return 图片URL地址
	 * @throws WexinReqException
	 */
	public static String uploadNewsImg(String accessToken, String filePath)
			throws WexinReqException {
		UploadNewsImg upload = new UploadNewsImg();
		upload.setAccess_token(accessToken);
		upload.addFile(filePath);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				upload);
		return result.getString("url");
	}
	/**
	 * 上传永久图文消息素材
	 * @param accessToken 
	 * @param articles 上传的文本列表
	 * @return
	 * @throws WexinReqException
	 */
	public static String uploadNews(String accessToken, List<Article> articles)
			throws WexinReqException {
		UploadNews upload = new UploadNews();
		upload.setAccess_token(accessToken);
		upload.setArticles(articles);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				upload);
		return result.getString("media_id");
	}
	
	

}
