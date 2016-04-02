package com.xiaoshabao.framework.wechat.api.wxmenu.result;

import com.xiaoshabao.framework.wechat.api.core.req.WeixinReqParam;
import com.xiaoshabao.framework.wechat.api.wxmenu.model.Button;

/**
 * 菜单实例，用来装button
 */
public class MenuGetResult extends WeixinReqParam{
	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}
}
