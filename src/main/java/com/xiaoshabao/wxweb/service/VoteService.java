package com.xiaoshabao.wxweb.service;

import java.util.List;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.framework.web.springmvc.service.BaseService;
import com.xiaoshabao.wxweb.entity.VotePlayerEntity;

public interface VoteService extends BaseService{
	
	/**
	 * 获得蓝色主题，投票选手信息
	 * @param account_id
	 * @return
	 */
	public List<VotePlayerEntity> getVoteBluePlayer(Integer vote_id) throws ServiceException, DaoException ;
	
	/**
	 * 获得蓝色主题，单个选手信息
	 * @param account_id
	 * @return
	 */
	public VotePlayerEntity getVoteBluePlayerById(Integer player_id) throws ServiceException, DaoException ;
	
}
