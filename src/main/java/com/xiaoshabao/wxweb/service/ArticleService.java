package com.xiaoshabao.wxweb.service;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.framework.web.springmvc.service.BaseService;
import com.xiaoshabao.wxweb.entity.ArticleEntity;

public interface ArticleService extends BaseService{
	/**
	 * 添加文章
	 * @param article
	 * @param account_ids
	 * @param user_id
	 * @throws ServiceException
	 */
	public void addArticle(ArticleEntity article,Integer[] account_ids,Integer user_id)throws ServiceException, DaoException;
}
