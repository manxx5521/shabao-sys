package com.xiaoshabao.wxweb.service.impl;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.SpringTest;

import com.xiaoshabao.wxweb.service.DemoService;

public class DemoServiceImplTest extends SpringTest{
	@Resource(name="demoService")
	private DemoService demoService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//测试sql
	@Test
	public void testTestSQL() throws Exception {
		try {
			demoService.testSQL();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

}
