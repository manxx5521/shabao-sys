package com.xiaoshabao.framework.wechat.apiJW.coupon.qrcode;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshabao.framework.wechat.apiJW.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.apiJW.core.req.WeiXinReqService;
import com.xiaoshabao.framework.wechat.apiJW.coupon.qrcode.model.Getticket;
import com.xiaoshabao.framework.wechat.apiJW.coupon.qrcode.model.GetticketRtn;
import com.xiaoshabao.framework.wechat.apiJW.coupon.qrcode.model.QrcodeInfo;
import com.xiaoshabao.framework.wechat.apiJW.coupon.qrcode.model.QrcodeRtnInfo;


/**
 * 微信卡券 - 卡券投放
 * @author lihongxuan
 *
 */
public class JwQrcodeAPI {

	/**
	 * 创建二维码
	 * @throws WexinReqException 
	 */
	public static QrcodeRtnInfo doAddQrcode(String accesstoken,QrcodeInfo qrcodeInfo) throws WexinReqException {
		if (accesstoken != null) {
			qrcodeInfo.setAccess_token(accesstoken);
			JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(qrcodeInfo);
			QrcodeRtnInfo qrcodeRtnInfo = JSON.toJavaObject(result, QrcodeRtnInfo.class);
			return qrcodeRtnInfo;
		}
		return null;
	}

	/**
	 * 获取api_ticket
	 */
	public static GetticketRtn doGetticket(String accesstoken)throws WexinReqException {
		if (accesstoken != null) {
			Getticket gk = new Getticket();
			gk.setAccess_token(accesstoken);
			JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(gk);
			GetticketRtn getticketRtn = JSON.toJavaObject(result, GetticketRtn.class);
			return getticketRtn;
		}
		return null;
	}

}
 