package com.xiaoshabao.framework.wechat.api.core.req.model.media;

import com.xiaoshabao.framework.wechat.api.core.annotation.ReqType;
import com.xiaoshabao.framework.wechat.api.core.req.model.WeixinReqParam;

/**
 * 下载-临时多媒体文件
 */
@ReqType("downTempMedia")
public class DownloadTempMedia extends WeixinReqParam {

	/**
	 * 媒体信息id
	 */
	private String media_id;
	/**
	 * 下载存储的文件目录
	 */
	private String filePath;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
