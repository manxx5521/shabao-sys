package com.xiaoshabao.wxweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.wxweb.bean.ConfigBean;
import com.xiaoshabao.wxweb.bean.MenuListValue;
import com.xiaoshabao.wxweb.entity.MenuEntity;
import com.xiaoshabao.wxweb.service.IndexService;

@Service("indexServiceImpl")
public class IndexServiceImpl extends BaseServiceImpl implements IndexService {

	@Resource(name = "config")
	private ConfigBean config;
	
	//用来获取菜单
	@Override
	public List<MenuEntity> getMenuList(Integer user_id) throws DaoException {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("group_id", config.getGroup_id_admin());
		params.put("user_id", user_id);
		return this.getData(MenuEntity.class, params);
	}
	
	//这个原来获取菜单现在不用
	@Override
	public List<MenuListValue> adminIndexMenu(Integer user_id) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("menu_code", 1);
		List<MenuListValue> list = this.baseDao.getData("getadminmenulist",
				param);
		for (int i = 0; i < list.size(); i++) {
			MenuListValue menu = list.get(i);
			param.put("parent_menu_id", menu.getMenu_id());
			List<MenuEntity> listNext = this.baseDao.getData("getadminmenu",
					param);
			menu.setList(listNext);
		}
		return list;
	}

	
}
