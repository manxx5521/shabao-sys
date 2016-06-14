package com.xiaoshabao.wxweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.wxweb.bean.SelectResult;
/**
 * 实例controller
 */
@Controller
@RequestMapping(value="/select")
public class SelectController extends BaseController{
	
	@RequestMapping(value="/demo")
	public ModelAndView reqMap (ModelMap model) throws DaoException{
		return new ModelAndView ("/customTag/select/selectTest");
	}
	
	/**
	 * 下拉列表
	 * @param modelMap
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/select")
	public Map<String,Object> getSelect(Long element_id,String json) {
		Map<String,Object> result=new HashMap<String, Object>();
		List<SelectResult>  items=new ArrayList<SelectResult>();
		if(element_id==12345678){
			items.add( new SelectResult("0471","呼和浩特"));
			items.add( new SelectResult("0472","包头"));
		}
		if(element_id==1234567){
			items.add( new SelectResult("A001","市区"));
			items.add( new SelectResult("A002","和林"));
		}
		result.put("items", items);
		return result;
	}
	
}
