package com.xiaoshabao.wxweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController extends BaseController{
	
	/**
	 * 获得微信菜单
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/wechatMenu")
	public ModelAndView getWechatMenu(ModelMap model){
		
		return new ModelAndView("/admin/menu/wechatMenu",model);
	}
	

}
