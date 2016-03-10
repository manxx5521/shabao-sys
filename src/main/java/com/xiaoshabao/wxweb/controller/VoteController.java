package com.xiaoshabao.wxweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;
import com.xiaoshabao.wxweb.entity.VoteEntity;
import com.xiaoshabao.wxweb.entity.VotePlayerEntity;
import com.xiaoshabao.wxweb.service.VoteService;

@Controller
public class VoteController extends BaseController{
	
	@Resource(name="voteServiceImpl")
	private VoteService voteService;
	
	/**
	 * 文章管理端列表界面列表
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 */
	@RequestMapping(value="/wechat/vote")
	public ModelAndView getVote (ModelMap model) throws DaoException{
		
		return new ModelAndView ("/wechat/vote/vote");
	}
	
	/**
	 * 投票界面列表<br>
	 * <p>http://localhost:8080/shabao-sys/wechat/voteBlue.html?vote_id=10000001</p>
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 * @throws ServiceException 
	 */
	@RequestMapping(value="/wechat/voteBlue")
	public ModelAndView getVoteBlue (ModelMap model,Integer vote_id) throws DaoException, ServiceException{
		
		List<VotePlayerEntity> list=voteService.getVoteBluePlayer(vote_id);
		model.put("dataList", list);
		model.put("vote_id", vote_id);
		return new ModelAndView ("/wechat/voteBlue/voteBlue");
	}
	
	/**
	 * 获得选手详细信息
	 * @param map
	 * @param article_id
	 * @return
	 * @throws DaoException 
	 * @throws ServiceException 
	 */
	@RequestMapping(value="/wechat/voteBuleDetail")
	public ModelAndView getVoteBlueDetail (ModelMap model,Integer player_id) throws DaoException, ServiceException{
		VotePlayerEntity player=voteService.getVoteBluePlayerById(player_id);
		model.put("player", player);
		model.put("vote_id", player.getVote_id());
		return new ModelAndView ("/wechat/voteBlue/voteDetail");
	}
	
	/**
	 * 报名界面
	 */
	@RequestMapping(value="/wechat/voteBuleBaoMing")
	public ModelAndView getVoteBlueBaoMing (ModelMap model,Integer vote_id) throws DaoException, ServiceException{
		
		model.put("vote_id", vote_id);
		return new ModelAndView ("/wechat/voteBlue/baoMing");
	}
	
	/**
	 * 排行界面
	 */
	@RequestMapping(value="/wechat/voteBulePaiHang")
	public ModelAndView getVoteBluePaiHang (ModelMap model,Integer vote_id) throws DaoException, ServiceException{
		if(vote_id==null||vote_id==0)
			throw new ServiceException("投票活动不存在");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("vote_id", vote_id);
		List<VotePlayerEntity> list=this.voteService.getData("votopaihang", params);
		model.put("dataList", list);
		VoteEntity vote =this.voteService.getDataSingle(VoteEntity.class, params);
		model.put("vote", vote);
		Integer count=this.voteService.getDataSingle("votenumcount", params);
		model.put("count", count);
		return new ModelAndView ("/wechat/voteBlue/paiHang");
	}
}
