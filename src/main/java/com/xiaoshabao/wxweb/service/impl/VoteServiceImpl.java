package com.xiaoshabao.wxweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wxweb.entity.VotePlayerEntity;
import com.xiaoshabao.wxweb.service.VoteService;

@Service("voteServiceImpl")
public class VoteServiceImpl extends BaseServiceImpl implements VoteService {

	@Override
	public List<VotePlayerEntity> getVoteBluePlayer(Integer vote_id) throws ServiceException, DaoException {
		if(vote_id==null||vote_id==0){
			throw new ServiceException("投票帐号不存在");
		}
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("vote_id", vote_id);
		return this.baseDao.getData(VotePlayerEntity.class, param);
	}

	@Override
	public VotePlayerEntity getVoteBluePlayerById(Integer player_id)
			throws ServiceException, DaoException {
		if(player_id==null||player_id==0){
			throw new ServiceException("选手id不存在");
		}
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("player_id", player_id);
		List<VotePlayerEntity> list= this.baseDao.getData(VotePlayerEntity.class, param);
		
		if(list.isEmpty()){
			throw new ServiceException("没有此选手信息");
		}
		return list.get(0);
	}

	


}
