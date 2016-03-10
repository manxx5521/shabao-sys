package com.xiaoshabao.wxweb.service;

import java.util.List;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.framework.web.springmvc.service.BaseService;
import com.xiaoshabao.wxweb.entity.WechatUserEntity;

public interface WechatUserService extends BaseService {

	/**
	 * 根据系统微信的id获得用户列表
	 * 
	 * @param account_id
	 *            系统中微信帐号id
	 * @return 用户列表
	 */
	public List<WechatUserEntity> getUserList(String account_id)
			throws ServiceException, DaoException;

}
