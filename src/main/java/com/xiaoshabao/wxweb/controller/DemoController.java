package com.xiaoshabao.wxweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.wxweb.service.DemoService;
import com.xiaoshabao.wxweb.shiro.SessionManager;
/**
 * 实例controller
 */
@Controller
@RequestMapping(value="demo")
public class DemoController extends BaseController{
	
	@Resource(name="demoService")
	private DemoService demoService;
	
	
	@RequestMapping(value="/map")
	public ModelAndView reqMap (ModelMap model) throws DaoException{
		Integer user_id=SessionManager.getInstance().getSeesionInfo().getUser_id();
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("user_id", user_id);
		return new ModelAndView ("/admin/article/articleList");
	}
	
}
