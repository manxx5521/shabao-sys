package com.xiaoshabao.framework.web.springmvc.service;

import java.util.List;

import com.xiaoshabao.framework.web.springmvc.bean.PageValue;
import com.xiaoshabao.framework.web.springmvc.bean.PagingPrams;
import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
import com.xiaoshabao.framework.web.springmvc.exception.ServiceException;



/**
 * 基本sevice
 */
public interface BaseService {
	/**
	 * 分页方法
	 */
	public <T, P extends PagingPrams> PageValue<T> pagingQuery(Class<T> clasz,
			P pagingPrams);
	/**
	 * 更新方法
	 */
	public <T> void update(Class<T> clasz, T t, Object p)
			throws ServiceException;
	/**
	 * 添加方法
	 */
	public <T> void insert(Class<T> clasz, T t) throws ServiceException;
	/**
	 * 判断是否存在
	 */
	public <T> boolean exists(Class<T> clasz, T t) throws ServiceException;
	
	/**
	 * 查询
	 */
	public <T, P extends PagingPrams> List<T> queryModels(Class<T> clasz, P p)
			throws ServiceException;
	/**
	 * 根据类和参数获得多条数据
	 */
	public <T> List<T> getData(Class<T> clasz,Object params)
			throws DaoException;
	/**
	 * 根据sqlid获得多条数据
	 */
	public <T> List<T> getData(String sqlid, Object param) throws DaoException;
	
	/**
	 * 根据sqlid获得单条数据
	 */
	public <T> T getDataSingle(String sqlid, Object param) throws DaoException;
	
	public <T> T getDataSingle(Class<T> clazz, Object param) throws DaoException;

}