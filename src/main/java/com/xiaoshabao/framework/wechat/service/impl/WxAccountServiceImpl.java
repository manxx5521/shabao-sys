package com.xiaoshabao.framework.wechat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaoshabao.framework.web.springmvc.service.impl.AbstractServiceImpl;
import com.xiaoshabao.framework.wechat.service.WxAccountService;
import com.xiaoshabao.framework.wechat.util.TokenManager;

@Service("wxAccountService")
public class WxAccountServiceImpl extends AbstractServiceImpl implements
		WxAccountService {

	@Resource
	TokenManager tokenManager;

	

}