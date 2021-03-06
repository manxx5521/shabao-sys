package com.xiaoshabao.wechat.util;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.SpringTest;

import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wechat.bean.TokenType;
import com.xiaoshabao.wechat.entity.AccessToken;
import com.xiaoshabao.wechat.util.TokenManager;

public class TokenManagerTest extends SpringTest {
	@Resource
	TokenManager tokenManager;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetToken() {
		try {
			AccessToken token=tokenManager.getToken(100000, TokenType.JSTOKEN);
			System.out.println(token.getAccess_token());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
