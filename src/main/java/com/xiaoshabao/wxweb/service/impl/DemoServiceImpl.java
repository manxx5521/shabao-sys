package com.xiaoshabao.wxweb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wxweb.service.DemoService;

@Service("demoService")
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {
	
	//测试SQL
	@Override
	public void testSQL() throws ServiceException, DaoException {
		String sql="select a.menu_id name from td_m_menu a";
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("sql", sql);
		this.baseDao.getData("demotestsql", param);
	}

	

}
