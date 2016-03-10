package com.xiaoshabao.wxweb.entity;

import java.util.Date;

/**
 * 投票活动实体类
 */
public class VoteEntity {
	/**
	 * 投票id
	 */
	private Integer vote_id;
	/**
	 * 微信帐号id
	 */
	private Integer account_id;
	/**
	 * 投票活动名字
	 */
	private String vote_name;
	/**
	 * 描述
	 */
	private String des;
	/**
	 * 开始时间
	 */
	private Date start_time;
	/**
	 * 结束时间
	 */
	private Date end_time;
	/**
	 * 创建帐号
	 */
	private Integer create_staff;
	/**
	 * 创建时间
	 */
	private Date create_time;

	public Integer getVote_id() {
		return vote_id;
	}

	public void setVote_id(Integer vote_id) {
		this.vote_id = vote_id;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public String getVote_name() {
		return vote_name;
	}

	public void setVote_name(String vote_name) {
		this.vote_name = vote_name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Integer getCreate_staff() {
		return create_staff;
	}

	public void setCreate_staff(Integer create_staff) {
		this.create_staff = create_staff;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
