package com.xiaoshabao.wxweb.service;

import java.util.Set;

import com.xiaoshabao.framework.web.springmvc.service.BaseService;
import com.xiaoshabao.wxweb.entity.UserEntity;

public interface ShiroService extends BaseService{
	
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public UserEntity getByUserName(String LoginName);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String LoginName);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String LoginName);

}
