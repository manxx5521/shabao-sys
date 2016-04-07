package com.xiaoshabao.framework.wechat.api.wxbase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;

/**
 * 微信token获取接口测试
 */
public class TokenAPITest{
	
	public final static String accessToken="hioJaiuuA6XkWNysRek3W5iVrEZ_C8fSvAOR8QnCu6h2MOtLaBLyzcBOCAnzVH29rx-ooe0GF9KOYElK_LX5KSG_JHcqn4vECU6dVoNZlVOQX_kERmoyXzn7coHFjQ0QSOTiAHADZE";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAccessToken() throws Exception {
		try {
			String s = TokenAPI.getAccessToken("wx07e34f9575809866","d8c5dae813951b0c31599c1a8aebf410");
			
			System.out.println(s);
			//i4NLqMizqTXaDLmD6m397hj1XTQfRFcRASb3HMi8TbLTvBS9wuKKvFf1fXWUB9mMjfw3fJNPwqoHIFTY3NVmDAgRJCz8Kx1tFEOxGmv3ydSkdCXCDZDZIdP695nUw0-bCHKiAHAWBE
		} catch (WexinReqException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

}
