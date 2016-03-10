package com.xiaoshabao.wxweb.entity;

import java.util.Date;

/**
 * 投票选手
 */
public class VotePlayerEntity {

	private Integer player_id;
	/**
	 * 投票编码
	 */
	private Integer vote_id;
	/**
	 * 选手名字
	 */
	private String player_name;
	/**
	 * 描述
	 */
	private String des;
	/**
	 * 选手编码，是几号选手
	 */
	private Integer player_num;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 投票数
	 */
	private Integer vote_num;
	/**
	 * 更新时间
	 */
	private Date update_time;
	
	public Integer getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(Integer player_id) {
		this.player_id = player_id;
	}
	public Integer getVote_id() {
		return vote_id;
	}
	public void setVote_id(Integer vote_id) {
		this.vote_id = vote_id;
	}
	
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Integer getPlayer_num() {
		return player_num;
	}
	public void setPlayer_num(Integer player_num) {
		this.player_num = player_num;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getVote_num() {
		return vote_num;
	}
	public void setVote_num(Integer vote_num) {
		this.vote_num = vote_num;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
}
