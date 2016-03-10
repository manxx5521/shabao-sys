package com.xiaoshabao.wxweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.wxweb.entity.AccountEntity;
import com.xiaoshabao.wxweb.entity.SessionUserInfo;
import com.xiaoshabao.wxweb.service.WechatAccountService;
import com.xiaoshabao.wxweb.shiro.SessionManager;

/**
 * 微信系统帐号相关
 */
@Controller
public class WechatAccountController extends BaseController{
	
	@Resource(name = "wechatAccountService")
	private WechatAccountService accountService;
	/**
	 * 根据用户id拥有的微信帐号
	 * @param model
	 * @return
	 * @throws DaoException 
	 */
	@RequestMapping("admin/accountUser")
	public ModelAndView getUserAcountId(ModelMap model) throws DaoException{
		SessionUserInfo userInfo=SessionManager.getInstance().getSeesionInfo();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", userInfo.getUser_id());
		List<AccountEntity> list=accountService.getData("getaccountbyuser", map);
		//如果只有一条记录直接跳到用户界面
		if(!list.isEmpty()&&list.size()==1){
			return new ModelAndView("redirect:/admin/wechatUserList.html?account_id="+list.get(0).getAccount_id());
		}
		//帐号列表
		return new ModelAndView("/admin/accountList");
	}
}
