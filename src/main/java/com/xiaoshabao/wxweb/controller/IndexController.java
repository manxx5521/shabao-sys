package com.xiaoshabao.wxweb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.wxweb.bean.MenuListValue;
import com.xiaoshabao.wxweb.entity.MenuEntity;
import com.xiaoshabao.wxweb.service.IndexService;
import com.xiaoshabao.wxweb.shiro.SessionManager;

/**
 * 主页
 */
@Controller
public class IndexController {

	@Resource(name = "indexServiceImpl")
	private IndexService indexService;

	/**
	 * 首页frame跳转
	 * 
	 * @param model
	 * @return
	 * @throws DaoException 
	 */
	@RequestMapping(value = "/admin/index1", method = { RequestMethod.GET })
	public ModelAndView adminIndex(ModelMap model) throws DaoException {
//		Integer user_id=SessionManager.getInstance().getSeesionInfo().getUser_id();
		
		return new ModelAndView("/admin/index/index1", model);
	}
	
	/**
	 * 主页跳转,登录后跳转main.jsp方法
	 * 
	 * @param model
	 * @return
	 * @throws DaoException 
	 */
	@RequestMapping(value = "/admin/index", method = { RequestMethod.GET })
	public ModelAndView adminIndex1(ModelMap model) throws DaoException {
		Integer user_id=SessionManager.getInstance().getSeesionInfo().getUser_id();
		
		//取出左侧菜单
		List<MenuEntity> menuList=indexService.getMenuList(user_id);
		model.put("menuList", JSON.toJSONString(menuList));
		
		return new ModelAndView("/admin/index/main", model);
	}

	/**
	 * 后台管理，头部菜单
	 * 
	 * @param model
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "/admin/top", method = { RequestMethod.GET })
	public ModelAndView adminTop(ModelMap model) {
		return new ModelAndView("/admin/login/top", model);
	}

	/**
	 * 后台管理，最先显示的右侧菜单
	 * 
	 * @param model
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "/admin/right", method = { RequestMethod.GET })
	public ModelAndView adminIndexinfo(ModelMap model) {
		return new ModelAndView("/admin/login/index", model);
	}

	/**
	 * 后台管理，主页菜单
	 * 
	 * @param model
	 * @param user_id
	 * @param password
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "/admin/indexMenu", method = { RequestMethod.GET })
	public ModelAndView adminIndexMenu(ModelMap model) throws Exception {
		Integer user_id =  (Integer) SecurityUtils.getSubject().getSession()
				.getAttribute("userId");
		List<MenuListValue> list = indexService.adminIndexMenu(user_id);
		model.put("list", list);
		return new ModelAndView("/admin/login/left", model);
	}
}
