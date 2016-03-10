package com.xiaoshabao.framework.wechat.apiJW.wxuser.user;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.apiJW.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.apiJW.core.req.WeiXinReqService;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.user.UserBaseInfoGet;
import com.xiaoshabao.framework.wechat.apiJW.core.req.model.user.UserInfoListGet;
import com.xiaoshabao.framework.wechat.apiJW.wxuser.user.model.Wxuser;

/**
 * 微信--用户
 * 
 * @author lizr
 * 
 */
public class JwUserAPI {


	/**
	 * 根据user_openid 获取关注用户的基本信息
	 * 
	 * @param shelf_id
	 * @return
	 * @throws WexinReqException
	 */
	public static Wxuser  getWxuser(String accesstoken,String user_openid) throws WexinReqException {
		if (accesstoken != null) {
			UserBaseInfoGet userBaseInfoGet = new UserBaseInfoGet();
			userBaseInfoGet.setAccess_token(accesstoken);
			userBaseInfoGet.setOpenid(user_openid);
			JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(userBaseInfoGet);
			// 正常返回
			Wxuser wxuser = null;
			wxuser = JSONObject.toJavaObject(result, Wxuser.class);
			return wxuser;
		}
		return null;
	}

	/**
	 * 获取所有关注用户信息信息
	 * 
	 * @return
	 * @throws WexinReqException 
	 */
	public static List<Wxuser> getAllWxuser(String accesstoken,String next_openid) throws WexinReqException {
		if (accesstoken != null) {
			UserInfoListGet userInfoListGet = new UserInfoListGet();
			userInfoListGet.setAccess_token(accesstoken);
			userInfoListGet.setNext_openid(next_openid);
			JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(userInfoListGet);
			List<Wxuser> lstUser = null;
			Wxuser mxuser = null;
			int total = result.getIntValue("total");
			int count = result.getIntValue("count");
			String strNextOpenId = result.getString("next_openid");
			JSONObject data = result.getJSONObject("data");
			lstUser = new ArrayList<Wxuser>(total);
			if (count > 0) {
				JSONArray lstOpenid = data.getJSONArray("openid");
				int iSize = lstOpenid.size();
				for (int i = 0; i < iSize; i++) {
					String openId = lstOpenid.getString(i);
					mxuser = getWxuser(accesstoken, openId);
					lstUser.add(mxuser);
				}
				if (strNextOpenId != null) {
					lstUser.addAll(getAllWxuser(accesstoken, strNextOpenId));
				}
			}
			return lstUser;
		}
		return null;
	}
	
}
