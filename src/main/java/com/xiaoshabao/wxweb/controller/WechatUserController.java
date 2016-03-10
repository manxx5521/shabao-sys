package com.xiaoshabao.wxweb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wxweb.service.WechatUserService;

/**
 * 微信用户信息controller
 */
@Controller
public class WechatUserController extends BaseController {

	@Resource(name = "wechatUserService")
	private WechatUserService userService;

	/**
	 * 获取当前帐号的id
	 * 
	 * @param model
	 * @param account_id
	 *            系统对应微信帐号id
	 * @return
	 * @throws DaoException
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/admin/wechatUserList")
	public ModelAndView getUserList(ModelMap model, String account_id)
			throws ServiceException, DaoException {
		model.put("dataList", userService.getUserList(account_id));
		return new ModelAndView("/admin//wechatUser/wechatUserList", model);
	}
}
