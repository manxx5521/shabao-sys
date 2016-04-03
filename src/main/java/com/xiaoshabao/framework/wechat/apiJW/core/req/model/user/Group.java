package com.xiaoshabao.framework.wechat.apiJW.core.req.model.user;


/**
 * 取多媒体文件
 */
public class Group {
	/**
	 * 分组名字
	 * <p>创建分组时，只需要传入名字</p>
	 */
	private String name;
	
	private String id;
	
	private String count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	
}
