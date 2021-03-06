package com.xiaoshabao.framework.web.springmvc.dao;

import java.util.List;

import com.xiaoshabao.framework.web.springmvc.bean.PagingPrams;
import com.xiaoshabao.framework.web.springmvc.exception.DaoException;

/**
 * 基本DAO
 * 
 * @param <T>
 *            业务数据类型
 * @param <P>
 *            参数类型
 */
public interface BaseDao {
	/**
	 * 分页查询业务数据
	 * 
	 * @param pageValue
	 * @return
	 */
	public <T, P extends PagingPrams> List<T> pagingqueryData(Class<T> clasz,
			P pageValue);

	/**
	 * 查询业务数据行数
	 * 
	 * @param pageValue
	 * @return
	 */
	public <P extends PagingPrams, T> Integer queryRowCount(Class<T> clasz,
			P pageValue);

	/**
	 * 修改一个实体
	 * 
	 * @param t
	 * @param params
	 * @throws DaoException
	 */
	public <T> void update(Class<T> clasz, Object params);

	/**
	 * 新增实体
	 * 
	 * @param t
	 * @throws DaoException
	 */
	public <T> void insert(Class<T> clasz, T t);

	/**
	 * 校验是否存在
	 * 
	 * @param t
	 * @return
	 * @throws DaoException
	 */
	public <T> boolean exists(Class<T> clasz, T t);

	/**
	 * 按一定条件获取T类型的数据
	 * 
	 * @param params
	 * @return
	 * @throws DaoException
	 */
	public <T> List<T> getData(Class<T> clasz, Object param);

	/**
	 * 删除实体 T
	 * 
	 * @param t
	 * @throws DaoException
	 */
	public <T> void del(Class<T> clasz, T t);

	/**
	 * 通过sqlid获取数据
	 * 
	 * @param sqlid
	 * @param param
	 * @return
	 * @throws DaoException
	 */
	public <T> List<T> getData(String sqlid, Object param);

	/**
	 * 通过sqlid获得单条数据
	 * 
	 * @param sqlid
	 * @param param
	 * @return
	 * @throws DaoException
	 */
	public <T> T getDataSingle(String sqlid, Object param);

	/**
	 * 通过实体T 和参数获得唯一记录<br/>
	 * 多条取第一条
	 * 
	 * @param clazz
	 * @param param
	 * @return
	 * @throws DaoException
	 */
	public <T> T getDataSingle(Class<T> clazz, Object param);

}
