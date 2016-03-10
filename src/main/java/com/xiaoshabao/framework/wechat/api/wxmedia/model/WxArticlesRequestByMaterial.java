package com.xiaoshabao.framework.wechat.api.wxmedia.model;

/**
 * 上传图文消息素材id
 */
public class WxArticlesRequestByMaterial {
	private String mediaId;

	
	public String getMediaId() {
		return mediaId;
	}


	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


	@Override
	public String toString() {
		return "WxArticlesRequestByMaterial [mediaId=" + mediaId + "]";
	}

}
