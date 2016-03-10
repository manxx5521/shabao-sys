package com.xiaoshabao.wxweb.service.impl;

import org.springframework.stereotype.Service;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.framework.web.springmvc.util.StringUtil;
import com.xiaoshabao.wxweb.entity.ArticleEntity;
import com.xiaoshabao.wxweb.service.ArticleService;

@Service("articleServiceImpl")
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService {

	@Override
	public void addArticle(ArticleEntity article, Integer[] account_ids,
			Integer user_id) throws ServiceException, DaoException  {
		if(account_ids==null||account_ids.length<1)
			throw new ServiceException("帐号为空");
		if(StringUtil.isEmpty(article.getTitle()))
			throw new ServiceException("标题不能为空");
		if(StringUtil.isEmpty(article.getContent()))
			throw new ServiceException("内容不能为空");
		
		for (Integer account_id:account_ids){
			article.setAccount_id(account_id);
			article.setCreate_staff(user_id);
			article.setUpdate_staff(user_id);
			this.baseDao.insert(ArticleEntity.class,article);
		}
	}

}
