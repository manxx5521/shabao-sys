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
			List<String> s = ServiceIpAPI.getServiceIpList("ZxzjSV6twdEatza1fR-ai_VNtFUIhzfcHcPEWlEVUzdU8-dsisFIfOQmkaeBzeKxXxxhXJKoCq_wHz4mwUnjBDOUUFVXZKbry9bMjllxIQxd-_jBUdYeqFBKqf0VyuG1QBGdABAZKP");
			System.out.println(s);
		} catch (WexinReqException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
