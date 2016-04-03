package com.xiaoshabao.framework.wechat.api.wxuser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.core.util.WeiXinReqService;
import com.xiaoshabao.framework.wechat.api.wxuser.model.UserListGet;
import com.xiaoshabao.framework.wechat.api.wxuser.result.UserOpenIDList;
/**
 * 微信用户API
 */
public class UserAPI {
	
	/**
	 * 获得用户openId列表-拉取10000条数据
	 * @param accessToken
	 * @throws WexinReqException 
	 */
	public static UserOpenIDList getUserOpenIdList(String accessToken) throws WexinReqException{
		return getUserOpenIdList(accessToken,null,false);
	}
	/**
	 * 获得用户openId列表-拉取10000条数据
	 * @param accessToken
	 * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取，有值时从此id的下一个id开始拉取
	 * @throws WexinReqException 
	 */
	public static UserOpenIDList getUserOpenIdList(String accessToken,String next_openid) throws WexinReqException{
		return getUserOpenIdList(accessToken,next_openid,false);
	}
	/**
	 * 获所有用户openId列表
	 * @param accessToken
	 * @throws WexinReqException 
	 */
	public static UserOpenIDList getUserOpenIdListAll(String accessToken) throws WexinReqException{
		return getUserOpenIdList(accessToken,null,true);
	}
	/**
	 * 获得所有用户openId列表
	 * @param accessToken
	 * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取，有值时从此id的下一个id开始拉取
	 * @throws WexinReqException 
	 */
	public static UserOpenIDList getUserOpenIdListAll(String accessToken,String next_openid) throws WexinReqException{
		return getUserOpenIdList(accessToken,next_openid,true);
	}
	/**
	 * 拉取用户列表
	 * @param accessToken 凭证
	 * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取，有值时从此id的下一个id开始拉取
	 * @param isAll 是否拉取全部，true全部
	 * @throws WexinReqException
	 */
	public static UserOpenIDList getUserOpenIdList(String accessToken,String next_openid,boolean isAll) throws WexinReqException{
		UserListGet upload = new UserListGet();
		upload.setNext_openid(next_openid);
		upload.setAccess_token(accessToken);
		JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(upload);
		int total=result.getIntValue("total");//关注用户总数
		int count=result.getIntValue("count");//拉取用户数
		String strNextOpenId = result.getString("next_openid");
		List<String> openList=null;
		UserOpenIDList userList=new UserOpenIDList();
		userList.setTotal(total);
		userList.setCount(count);
		// 如果没有数据直接返回
		if (count < 1) {
			return userList;
		}
		JSONObject data = result.getJSONObject("data");
		String openStr=data.getString("openid");
		openList=JSONArray.parseArray(openStr, String.class);
		//如果拉取全部
		if(!isAll){
			userList.setOpenidList(openList);
			return userList;
		}
		
		if (strNextOpenId != null) {
			UserOpenIDList currentBean = getUserOpenIdList(accessToken,
					strNextOpenId, true);
			openList.addAll(currentBean.getOpenidList());
			count += currentBean.getCount();
		}
		userList.setCount(count);
		userList.setOpenidList(openList);
		return userList;
	}

}
