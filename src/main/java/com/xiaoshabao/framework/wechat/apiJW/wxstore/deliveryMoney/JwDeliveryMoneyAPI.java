package com.xiaoshabao.framework.wechat.apiJW.wxstore.deliveryMoney;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.apiJW.core.common.WxstoreUtils;
import com.xiaoshabao.framework.wechat.apiJW.wxstore.deliveryMoney.model.DeliveryMoney;
import com.xiaoshabao.framework.wechat.apiJW.wxstore.deliveryMoney.model.DeliveryMoneyRtnInfo;


/**
 * 微信小店 - 邮费模板
 *
 */
public class JwDeliveryMoneyAPI {
	// 增加邮费模板
	private static String create_postage_url = "https://api.weixin.qq.com/merchant/express/add?access_token=ACCESS_TOKEN";
	// 修改邮费模板
	private static String update_postage_url = "https://api.weixin.qq.com/merchant/express/update?access_token=ACCESS_TOKEN";
	// 获取指定ID的邮费模板
	private static String get_postage_url = "https://api.weixin.qq.com/merchant/express/getbyid?access_token=ACCESS_TOKEN";
	// 删除邮费模板
	private static String del_postage_url = "https://api.weixin.qq.com/merchant/express/del?access_token=ACCESS_TOKEN";
	// 获取所有邮费模板
	private static String getall_postage_url = "https://api.weixin.qq.com/merchant/express/getall?access_token=ACCESS_TOKEN";
		
	/**
	 * 增加邮费模板
	 * @param postage
	 * @return
	 */
	public static DeliveryMoneyRtnInfo doAddExpress(String newAccessToken, DeliveryMoney postage) {
		if (newAccessToken != null) {
			String requestUrl = create_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String jsonString =JSON.toJSONString(postage);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST",jsonString);
			DeliveryMoneyRtnInfo postageRtnInfo = JSONObject.toJavaObject(result, DeliveryMoneyRtnInfo.class);
			return postageRtnInfo;
		}
		return null;
	}

	/**
	 * 删除邮费模板
	 * @param template_id
	 * @return
	 */
	public static DeliveryMoneyRtnInfo doDelExpress(String newAccessToken, Integer template_id) {
		if (newAccessToken != null) {
			String requestUrl = del_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"template_id\": "+template_id+"}";
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", json);
			DeliveryMoneyRtnInfo postageRtnInfo = JSONObject.toJavaObject(result, DeliveryMoneyRtnInfo.class);
			return postageRtnInfo;
		}
		return null;
	}

	/**
	 * 修改邮费模板
	 * @param postage
	 * @return
	 */
	public static DeliveryMoneyRtnInfo doUpdateExpress(String newAccessToken, DeliveryMoney postage) {
		if (newAccessToken != null) {
			String requestUrl = update_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String jsonString =JSON.toJSONString(postage);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
			DeliveryMoneyRtnInfo postageRtnInfo = JSONObject.toJavaObject(result, DeliveryMoneyRtnInfo.class);
			return postageRtnInfo;
		}
		return null;
	}

	/**
	 * 获取指定ID的邮费模板
	 * @param template_id
	 * @return
	 */
	public static DeliveryMoney getByIdExpress(String newAccessToken, Integer template_id) {
		if (newAccessToken != null) {
			String requestUrl = get_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"template_id\": "+template_id+"}";
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", json);
			// 正常返回
			DeliveryMoney postage = null;
			JSONObject info = result.getJSONObject("template_info");
			postage = JSONObject.toJavaObject(info, DeliveryMoney.class);
			return postage;
		}
		return null;
	}
	
	/**
	 * 获取所有邮费模板
	 * @return
	 */
	public static List<DeliveryMoney> getAllExpress(String newAccessToken) {
		if (newAccessToken != null) {
			String requestUrl = getall_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "GET", "");
			// 正常返回
			List<DeliveryMoney> postages = null;
			JSONArray info = result.getJSONArray("templates_info");
			postages = JSONArray.parseArray(info.toJSONString(), DeliveryMoney.class);
			return postages;
		}
		return null;
	}
}
 