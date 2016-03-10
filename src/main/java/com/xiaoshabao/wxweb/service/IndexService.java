package com.xiaoshabao.wxweb.service;

import java.util.List;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.service.BaseService;
import com.xiaoshabao.wxweb.bean.MenuListValue;
import com.xiaoshabao.wxweb.entity.MenuEntity;

/**
 * 主页面的service
 */
public interface IndexService extends BaseService {
	
	
	public List<MenuEntity> getMenuList(Integer user_id)throws DaoException;
	/**
	 * 管理界面跳转主页面
	 * 
	 * @param user_id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public List<MenuListValue> adminIndexMenu(Integer user_id) throws Exception;

}
