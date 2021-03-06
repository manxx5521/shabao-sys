package com.xiaoshabao.wxweb.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import com.xiaoshabao.wxweb.entity.SessionUserInfo;
import com.xiaoshabao.wxweb.entity.UserEntity;
import com.xiaoshabao.wxweb.service.ShiroService;

public class MyRealm extends AuthorizingRealm {

	@Resource(name = "shiroService")
	private ShiroService shiroService;

	@Resource(name = "sessionUserInfo")
	private SessionUserInfo userSession; 

	/**
	 * 为当限前登录的用户授予角色和权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String userName = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(shiroService.getRoles(userName));
		authorizationInfo.setStringPermissions(shiroService
				.getPermissions(userName));
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		UserEntity user = shiroService.getByUserName(userName);
		if (user != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
					user.getLogin_name(), user.getUser_password(), "xx");
			// 当验证都通过后，把用户信息放在session里
			Session session = SecurityUtils.getSubject().getSession();
			userSession.setUser_id(user.getUser_id());
			userSession.setUser_name(user.getUser_name());
			session.setAttribute("userSession", userSession);
			return authcInfo;
		} else {
			throw new UnknownAccountException();// 没找到帐号
		}
	}

}
