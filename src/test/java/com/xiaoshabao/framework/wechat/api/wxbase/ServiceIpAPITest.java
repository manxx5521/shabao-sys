package com.xiaoshabao.framework.wechat.api.wxbase;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;

public class ServiceIpAPITest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetServiceIpList() {
		try {
			List<String> s = ServiceIpAPI.getServiceIpList("KEieKdOdauVXoj2YcV-s2B5HaaZT4QV_74mRXDVGrlletQu5nkMDg5_Ky8GRxcDcAyc-bgo0xL5h_qh39V-A6_58bHVYqJ9uPaJfUqsVdhgR4jE0t1KIqIWWtxEJdm1pPBKhABAAMV");
			System.out.println(s);
		} catch (WexinReqException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
