package com.xiaoshabao.framework.wechat.api.wxuser;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.xiaoshabao.framework.wechat.api.wxbase.TokenAPITest;
import com.xiaoshabao.framework.wechat.api.wxuser.result.UserOpenIDList;

public class UserAPITest {
	private String accessToken=TokenAPITest.accessToken;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//getUserOpenIdList(String accessToken)
	//获得用户列表-拉取10000条数据
	@Test
	public void testGetUserOpenIdListString() throws Exception {
		try {
			UserOpenIDList result=UserAPI.getUserOpenIdList(accessToken);
			System.out.println("测试通过");
			System.out.println("总计："+result.getTotal());
			System.out.println("第一个openid："+result.getOpenidList().get(0));
			System.out.println("返回json："+JSON.toJSONString(result));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	//拉取所有用户openId列表
	//UserOpenIDList getUserOpenIdList(String accessToken,String next_openid)
	@Test
	public void testGetUserOpenIdListStringString() throws Exception {
		try {
			UserOpenIDList result=UserAPI.getUserOpenIdList(accessToken,"oGMKNwnS1h3bcyKUu2WQsrFFNeZk");
			System.out.println("测试通过");
			System.out.println("总计："+result.getTotal());
			if(result.getCount()>0){
				System.out.println("第一个openid："+result.getOpenidList().get(0));
			}
			System.out.println("返回json："+JSON.toJSONString(result));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	// getUserOpenIdListAll(String accessToken)
	// 获得用户列表
	@Test
	public void testGetUserOpenIdListAllString() throws Exception {
		try {
			UserOpenIDList result = UserAPI.getUserOpenIdListAll(accessToken);
			System.out.println("测试通过");
			System.out.println("总计：" + result.getTotal());
			System.out.println("第一个openid：" + result.getOpenidList().get(0));
			System.out.println("返回json：" + JSON.toJSONString(result));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	// 拉取所有用户openId列表
	// UserOpenIDList getUserOpenIdListAll(String accessToken,String next_openid)
	@Test
	public void testGetUserOpenIdListAllStringString() throws Exception {
		try {
			UserOpenIDList result = UserAPI.getUserOpenIdListAll(accessToken,"oGMKNwnS1h3bcyKUu2WQsrFFNeZk");
			System.out.println("测试通过");
			System.out.println("总计：" + result.getTotal());
			if (result.getCount() > 0) {
				System.out.println("第一个openid"+result.getOpenidList().get(0));
			}
			System.out.println("返回json"+JSON.toJSONString(result));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	@Test
	public void testGetUserOpenIdListStringStringBoolean() {
		fail("Not yet implemented");
	}

}
