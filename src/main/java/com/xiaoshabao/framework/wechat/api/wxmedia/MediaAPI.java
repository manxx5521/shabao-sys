package com.xiaoshabao.framework.wechat.api.wxmedia;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.util.WeiXinReqService;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.DownloadTempMedia;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.DwonloadResult;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadResult;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadTempMedia;


/**
 * 微信-素材接口
 */
public class MediaAPI {
//	private static Logger logger = LoggerFactory.getLogger(MediaAPI.class);

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
	public static UploadResult uploadTempMedia(String accessToken, String type,
			String fileNamePath) throws WexinReqException {
		UploadTempMedia uploadMedia = new UploadTempMedia();
		uploadMedia.setAccess_token(accessToken);
		uploadMedia.addFile(fileNamePath);
		uploadMedia.setType(type);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				uploadMedia);
		return JSON.toJavaObject(result, UploadResult.class);
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
	public static DwonloadResult downTempMedia(String accessToken, String media_id,
			String filePath) throws WexinReqException {
		DownloadTempMedia downloadMedia = new DownloadTempMedia();
		downloadMedia.setAccess_token(accessToken);
		downloadMedia.setFilePath(filePath);
		downloadMedia.setMedia_id(media_id);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(
				downloadMedia);
		return JSON.toJavaObject(result, DwonloadResult.class);
	}


}
