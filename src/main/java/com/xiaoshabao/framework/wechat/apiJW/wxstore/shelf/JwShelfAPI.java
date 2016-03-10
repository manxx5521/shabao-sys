package com.xiaoshabao.framework.wechat.apiJW.wxstore.shelf;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.apiJW.core.common.WxstoreUtils;
import com.xiaoshabao.framework.wechat.apiJW.wxstore.shelf.model.Shelf;
import com.xiaoshabao.framework.wechat.apiJW.wxstore.shelf.model.ShelfRInfo;
import com.xiaoshabao.framework.wechat.apiJW.wxstore.shelf.model.ShelfRtnInfo;



/**
 * 微信小店 - 货架
 * @author zhangdaihao
 *
 */
public class JwShelfAPI {
	
	// 增加货架
	private static String create_shelf_url = "https://api.weixin.qq.com/merchant/shelf/add?access_token=ACCESS_TOKEN";
	
	// 根据货架ID获取货架信息
	private static String getid_shelf_url = "https://api.weixin.qq.com/merchant/shelf/getbyid?access_token=ACCESS_TOKEN";
	
	// 获取所有货架
	private static String getall_shelf_url = "https://api.weixin.qq.com/merchant/shelf/getall?access_token=ACCESS_TOKEN";
	
	// 修改货架
	private static String update_shelf_url = "https://api.weixin.qq.com/merchant/shelf/mod?access_token=ACCESS_TOKEN";
	
	// 删除货架
	private static String del_shelf_url = "https://api.weixin.qq.com/merchant/shelf/del?access_token=ACCESS_TOKEN";
	

	/**
	 * 增加货架
	 * @param postage
	 * @return
	 */
	public static ShelfRtnInfo doAddExpress(String newAccessToken, Shelf shelf) {
		if (newAccessToken != null) {
			String requestUrl = create_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String jsonString =JSON.toJSONString(shelf);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
			ShelfRtnInfo shelfRtnInfo = JSONObject.toJavaObject(result, ShelfRtnInfo.class);
			return shelfRtnInfo;
		}
		return null;
	}
	
	/**
	 * 修改货架
	 * @param postage
	 * @return
	 */
	public static ShelfRtnInfo doUpdateExpress(String newAccessToken, Shelf shelf) {
		if (newAccessToken != null) {
			String requestUrl = update_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String jsonString =JSON.toJSONString(shelf);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", jsonString);
			ShelfRtnInfo shelfRtnInfo = JSONObject.toJavaObject(result, ShelfRtnInfo.class);
			return shelfRtnInfo;
		}
		return null;
	}
	
	/**
	 * 删除货架
	 * @param shelf_id
	 * @return
	 */
	public static ShelfRtnInfo doDelShelfManager(String newAccessToken, Integer shelf_id) {
		if (newAccessToken != null) {
			String requestUrl = del_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"shelf_id\": "+shelf_id+"}";
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", json);
			ShelfRtnInfo shelfRtnInfo = JSONObject.toJavaObject(result, ShelfRtnInfo.class);
			return shelfRtnInfo;
		}
		return null;
	}
	
	/**
	 * 根据货架ID获取货架信息
	 * @param shelf_id
	 * @return
	 */
	public static ShelfRInfo getByShelfId(String newAccessToken, Integer shelf_id) {
		if (newAccessToken != null) {
			String requestUrl = getid_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"shelf_id\": "+shelf_id+"}";
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", json);
			// 正常返回
			ShelfRInfo shelfRInfo = null;
			shelfRInfo = JSONObject.toJavaObject(result, ShelfRInfo.class);
			return shelfRInfo;
		}
		return null;
	}
	
	/**
	 * 获取所有货架信息
	 * @return
	 */
	public static List<ShelfRInfo> getAllShelf(String newAccessToken) {
		if (newAccessToken != null) {
			String requestUrl = getall_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", null);
			// 正常返回
			List<ShelfRInfo> shelfRInfos = null;
			JSONArray info = result.getJSONArray("shelves");
			shelfRInfos=JSONArray.parseArray(info.toJSONString(), ShelfRInfo.class);
			return shelfRInfos;
		}
		return null;
	}
}
 