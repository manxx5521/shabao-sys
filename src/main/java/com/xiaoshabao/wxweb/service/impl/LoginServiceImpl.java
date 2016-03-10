package com.xiaoshabao.wxweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wxweb.entity.SessionUserInfo;
import com.xiaoshabao.wxweb.entity.UserEntity;
import com.xiaoshabao.wxweb.service.LoginService;

@Service("loginServiceImpl")
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {
	@Resource(name = "sessionUserInfo")
	private SessionUserInfo sessionUserInfo;

	// @Transactional(rollbackFor = Exception.class)
	@Override
	public SessionUserInfo adminLogin(String login_name, String password)
			throws Exception {
		if (login_name == null || login_name.equals("")) {
			throw new ServiceException("登录名不能为空！");
		}
		if (password == null || password.equals("")) {
			throw new ServiceException("密码不能为空！");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("login_name", login_name);
		param.put("user_password", password);
		List<UserEntity> list = this.baseDao.getData(UserEntity.class, param);
		if (list.size() != 1) {
			throw new ServiceException("用户名或密码不正确！");
		}
		UserEntity user = list.get(0);
		sessionUserInfo.setUser_id(user.getUser_id());
		sessionUserInfo.setUser_name(user.getUser_name());
		return sessionUserInfo;
	}

}
