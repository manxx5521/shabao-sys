package com.xiaoshabao.wechat.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.web.springmvc.dao.BaseDao;
import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wechat.bean.TokenType;
import com.xiaoshabao.wechat.entity.AccessToken;
import com.xiaoshabao.wechat.http.HttpClientManager;

/**
 * 微信token管理类,通过appid和appsecret获取的方法
 */
public class TokenManagerAppID {
	private static Logger logger = LoggerFactory.getLogger(TokenManagerAppID.class);

	@Resource(name = "mybatisBaseDao")
	protected BaseDao baseDao;

	/**
	 * token静态类，使用内存缓存
	 */
	public static Map<String, AccessToken> accessTokens = new HashMap<String, AccessToken>();

	/**
	 * 获取token
	 * <p>
	 * 对外接口，可用来加锁
	 * </p>
	 * 
	 * @param appid
	 *            获取微信token的凭证
	 * @param appsecret
	 *            密钥
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public AccessToken getToken(String appid, String appsecret,
			TokenType tokenType) throws ServiceException {
		// WechatToken
		AccessToken token = null;
		switch (tokenType) {
		case TOKEN:
			token=getAccessToken(appid, appsecret, tokenType);
			AccessToken jstoken = getAccessToken(appid, appsecret, tokenType);
			token.setJsaccess_token(jstoken.getJsaccess_token());
			token.setJsexpires_in(jstoken.getJsexpires_in());
			token.setJsupdate_time(jstoken.getJsupdate_time());
			break;
		case ACCESSTOKEN:
			token = getAccessToken(appid, appsecret, tokenType);
			break;
		case JSTOKEN:
			token = getAccessToken(appid, appsecret, tokenType);
			break;
		}
		return token;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @param tokenType
	 *            token的枚举类型
	 * @return AccessToken token凭证
	 * @throws Exception
	 */
	public AccessToken getAccessToken(String appid, String appsecret,
			TokenType tokenType) throws ServiceException {
		logger.debug("开始获取accessToken");
		// 获得静态变量里缓存的token
		AccessToken accessToken = accessTokens.get(appid);
		long time_now_long = new java.util.Date().getTime();
		if (accessToken == null || accessToken.isTokenEmpty(tokenType)) {
			logger.debug("内存中不存在accessToken，要在数据库中获取");
			AccessToken realToken = getRealToken(appid, tokenType);
			if (realToken != null) {
				return realToken;
			}
		} else {
			logger.debug("内存中存在token值");
			if (time_now_long - accessToken.getTokenUpdateTime(tokenType) < accessToken
					.getTokenExpires_in(tokenType) * 1000 - 10000) {
				logger.debug("内存中的token在有效期内，直接返回");
				return accessToken;
			}
			logger.debug("内存中的token不在有效期内,在数据库获取获取");
			AccessToken realToken = getRealToken(appid, tokenType);
			if (realToken != null) {
				return realToken;
			}
		}
		logger.debug("在微信服务器获取accessToken");
		return getQQAccessToken(appid, appsecret, tokenType);
	}

	/**
	 * 获得数据库凭证
	 * 
	 * @param appid
	 *            凭证
	 * @return {@link com.xiaoshabao.wechat.entity.AccessToken
	 *         AccessToken} 从数据库获得的凭证
	 * @throws ServiceException
	 */
	public AccessToken getRealToken(String appid, TokenType tokenType)
			throws ServiceException {
		AccessToken token = null;
		try {
			token = this.baseDao.getDataSingle("getaccesstokensql", appid);
			if (token == null) {
				throw new ServiceException("数据库中不存在这个appid！->" + appid);
			}
			// 内存中不存在这个数据，把取出的数据放到内存中
			if (accessTokens.get(appid) == null) {
				accessTokens.put(appid, token);
			}
			if (!token.isTokenEmpty(tokenType)) {
				logger.debug("在数据库取出值，并且相关值不为空");
				// 如果在有效期内跳出
				if (new Date().getTime() - token.getTokenUpdateTime(tokenType) < token
						.getTokenExpires_in(tokenType) * 1000 - 10000) {
					logger.debug("数据库中的token在有效期内，直接返回");
					return token;
				}
				logger.debug("不在有效期，需要重新获取");
				return null;
			}
			logger.debug("没有取出值或值不对，需要重新获取");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("在数据库获取accessToken失败！");
		}
	}

	/**
	 * 从微信服务端获取access_token
	 * 
	 * @param appid
	 *            微信公众号的id
	 * @param appsecret
	 * @return {@link com.xiaoshabao.wechat.entity.AccessToken
	 *         AccessToken} 从服务器获得的凭证
	 * @throws ServiceException
	 */
	public AccessToken getQQAccessToken(String appid, String appsecret,
			TokenType tokenType) throws ServiceException {

		AccessToken accessToken;
		try {
			accessToken = accessTokens.get(appid);
			accessToken.setTokenUpdateTime(new Timestamp(new Date().getTime()),
					tokenType);// 提前创建有效时间，减少网速影响

			// 请求Token的URL
			String requestUrl = null;
			switch (tokenType) {
			case ACCESSTOKEN:
				requestUrl = tokenType.getToken_URL().replace("APPID", appid)
						.replace("APPSECRET", appsecret);
				break;
			case JSTOKEN:
				String temp_token = getAccessToken(appid, appsecret,
						TokenType.ACCESSTOKEN).getAccess_token();
				requestUrl = tokenType.getToken_URL().replace("ACCESS_TOKEN",
						temp_token);
				break;
			default:
				throw new ServiceException("要获得的token不在正确分类内");
			}

			JSONObject jsonObject = doHttps(requestUrl);

			// 在微信服务器返回资源
			if (null != jsonObject) {
				try {
					String tokenString = jsonObject.getString(tokenType
							.getToken_name());
					logger.info("调用微信服务，并返回Token为：" + tokenString);
					accessToken.setToken(tokenString, tokenType);
					accessToken.setExpires_in(jsonObject.getIntValue(tokenType
							.getExpires_in_name()), tokenType);
					// 修改数据库和内存
					saveAccessToken(accessToken, tokenType);
					accessTokens.put(appid, accessToken);
				} catch (Exception e) {
					accessToken = null;
					logger.info("在服务器获得token失败", e);
				}
			}
			return accessToken;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 用来发送post请求的 HTTPS连接
	 * 
	 * @param url
	 *            要访问的URL
	 * @return JSONObject JSON串
	 */
	private JSONObject doHttps(String url) {
		HttpClientManager httpClient = HttpClientManager.getInstance();
		String result = httpClient.doPostSSL(url);
		return JSON.parseObject(result);
	}

	/**
	 * 保存凭证
	 * 
	 * @param accessTocken
	 * @throws DaoException
	 */
	private void saveAccessToken(AccessToken accessTocken, TokenType tokenType)
			throws DaoException {
		AccessToken token = new AccessToken();
		token.setAppid(accessTocken.getAppid());
		switch (tokenType) {
		case ACCESSTOKEN:
			token.setAccess_token(accessTocken.getAccess_token());
			token.setExpires_in(accessTocken.getExpires_in());
			token.setUpdate_time(accessTocken.getUpdate_time());
			break;
		case JSTOKEN:
			token.setJsaccess_token(accessTocken.getJsaccess_token());
			token.setJsexpires_in(accessTocken.getJsexpires_in());
			token.setJsupdate_time(accessTocken.getJsupdate_time());
			break;
		default:
			break;
		}
		this.baseDao.update(AccessToken.class, token);
	}

}
