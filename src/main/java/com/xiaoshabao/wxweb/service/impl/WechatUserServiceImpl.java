package com.xiaoshabao.wxweb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.framework.web.springmvc.util.StringUtil;
import com.xiaoshabao.wxweb.entity.WechatUserEntity;
import com.xiaoshabao.wxweb.service.WechatUserService;

@Service("wechatUserService")
public class WechatUserServiceImpl extends BaseServiceImpl implements
		WechatUserService {

	// 根据系统微信的id获得用户列表
	@Override
	public List<WechatUserEntity> getUserList(String account_id)
			throws ServiceException, DaoException {
		if (StringUtil.isEmpty(account_id)) {
			throw new ServiceException("系统帐号不能为空");
		}
		return this.baseDao.getData(WechatUserEntity.class,
				new HashMap<String, String>().put("account_id", account_id));
	}

}
