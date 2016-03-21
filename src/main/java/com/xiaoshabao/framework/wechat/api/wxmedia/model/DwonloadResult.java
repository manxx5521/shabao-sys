package com.xiaoshabao.framework.wechat.api.wxmedia.model;

/**
 * 下载素材返回结果类
 */
public class DwonloadResult {
	/**
	 * 文件名字
	 */
	private String filePath;

	/**
	 * 文件路径
	 */
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}