package com.xiaoshabao.framework.wechat.api.core.req.model.kfaccount;

import java.util.List;

/**
 * 取多媒体文件
 */
public class MsgNews {

	private List<MsgArticles> articles;

	public List<MsgArticles> getArticles() {
		return articles;
	}

	public void setArticles(List<MsgArticles> articles) {
		this.articles = articles;
	}
	
}
