package com.xiaoshabao.wxweb.service;

import com.xiaoshabao.framework.web.springmvc.service.BaseService;
import com.xiaoshabao.wxweb.entity.SessionUserInfo;

/**
 * 登录的service
 */
public interface LoginService extends BaseService {

	/**
	 * 管理界面登录
	 * 
	 * @param user_id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public SessionUserInfo adminLogin(String user_id, String password)
			throws Exception;

}
