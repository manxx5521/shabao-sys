package com.xiaoshabao.wxweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wxweb.bean.UserAccountValue;
import com.xiaoshabao.wxweb.entity.AccountEntity;
import com.xiaoshabao.wxweb.entity.ArticleEntity;
import com.xiaoshabao.wxweb.service.ArticleService;
import com.xiaoshabao.wxweb.shiro.SessionManager;

@Controller
public class ArticleController extends BaseController{
	
	@Resource(name="articleServiceImpl")
	private ArticleService articleService;
	
	/**
	 * 文章管理端列表界面列表
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 */
	@RequestMapping(value="/admin/articleList")
	public ModelAndView initArticleList (ModelMap model) throws DaoException{
		Integer user_id=SessionManager.getInstance().getSeesionInfo().getUser_id();
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("user_id", user_id);
		List<ArticleEntity> list=this.articleService.getData(ArticleEntity.class, params);
		model.put("dataList", list);
		return new ModelAndView ("/admin/article/articleList");
	}
	
	/**
	 * 
	 * @param map
	 * @param article_id
	 * @return
	 */
	@RequestMapping(value="/admin/article")
	public ModelAndView initArticleCode (ModelMap map,String article_id){
		
		return new ModelAndView ("/admin/article/articleCode");
	}
	/**
	 * 添加文章初始化方法
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 */
	@RequestMapping(value="/admin/articleAddInit")
	public ModelAndView addArticleInit (ModelMap map,String article_id) throws DaoException{
		Integer user_id=SessionManager.getInstance().getUser_id();
		UserAccountValue param=new UserAccountValue();
		param.setUser_id(user_id);
		List<UserAccountValue> list=this.articleService.getData(UserAccountValue.class, param);
		map.put("dataList", list);
		return new ModelAndView ("/admin/article/articleAdd");
	}
	/**
	 * 添加文章方法
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 */
	@ResponseBody
	@RequestMapping(value="/admin/articleAdd")
	public  Map<String, Object> addArticle (ArticleEntity article,Integer[] account_ids) throws DaoException{
		Integer user_id=SessionManager.getInstance().getUser_id();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			this.articleService.addArticle(article,account_ids,user_id);
			returnMap.put("success", true);
		} catch (ServiceException e) {
			e.printStackTrace();
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
		}
		return returnMap;
	}
	
	/**
	 * 微信端文章显示
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 * @throws ServiceException 
	 */
	@RequestMapping(value="/wechat/article")
	public ModelAndView getWechatArticle (ModelMap model,Integer article_id ) throws DaoException, ServiceException{
		if(article_id==null||article_id==0)
			throw new ServiceException("文章id未识别");
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("article_id", article_id);
		ArticleEntity article=this.articleService.getDataSingle(ArticleEntity.class, params);
		AccountEntity pentity=new AccountEntity();
		pentity.setAccount_id(article.getAccount_id());
		AccountEntity account=this.articleService.getDataSingle(AccountEntity.class, pentity);
		model.put("appName", account.getApp_name());
		model.put("article", article);
		return new ModelAndView ("/wechat/article/article");
	}
	
	/**
	 * 添加文章初始化方法UE方式
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 */
	@RequestMapping(value="/admin/articleAddUe")
	public ModelAndView addArticleUeInit (ModelMap map,String article_id) throws DaoException{
		Integer user_id=SessionManager.getInstance().getUser_id();
		UserAccountValue param=new UserAccountValue();
		param.setUser_id(user_id);
		List<UserAccountValue> list=this.articleService.getData(UserAccountValue.class, param);
		map.put("dataList", list);
		return new ModelAndView ("/admin/article/articleAddByUe");
	}
}
