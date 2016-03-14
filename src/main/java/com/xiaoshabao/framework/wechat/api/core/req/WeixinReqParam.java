package com.xiaoshabao.framework.wechat.api.core.req;

/**
 * 微信请求参数父类
 */
public class WeixinReqParam {

	/**
	 * 微信获取信息令牌
	 */
	private String access_token;

	/**
	 * 转换为http参数方法
	 * <p>
	 * 子类可以通过重写此方法，并将dataType="string"来解析参数。<br>
	 * 为了加快速度 组装字符串是可使用StringBuffer
	 * </p>
	 * 
	 * @return String 返回的参数为 key1=value1&key2=value2
	 */
	public String toParams() {
		return "access_token=" + access_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

}
