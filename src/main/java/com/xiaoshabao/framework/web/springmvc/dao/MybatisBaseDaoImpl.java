package com.xiaoshabao.framework.web.springmvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.xiaoshabao.framework.web.springmvc.bean.MybatisValue;
import com.xiaoshabao.framework.web.springmvc.bean.PagingPrams;

/**
 * 通用的数据库操作组件
 * 
 * @param <T>
 * @param <P>
 */

@Repository("mybatisBaseDao")
public class MybatisBaseDaoImpl implements BaseDao {

	/**
	 * 目标对象类名称
	 */
	protected String clazzName;
	/**
	 * 查询数据库组件
	 */
	protected SqlSessionTemplate sqlSession;

	public MybatisBaseDaoImpl() {

	}

	@Override
	public <T, P extends PagingPrams> List<T> pagingqueryData(Class<T> clazz,
			P pageParams) {
		return sqlSession.<T> selectList(clazz.getSimpleName().toLowerCase()
				+ MybatisValue.IBATIS_PAGESQLID, pageParams);
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	@Resource(name = "sqlSession")
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public <P extends PagingPrams, T> Integer queryRowCount(Class<T> clasz,
			P pageValue) {
		return this.sqlSession.selectOne(clasz.getSimpleName().toLowerCase()
				+ MybatisValue.IBATIS_ROWCOUNTSQLID, pageValue);
	}

	@Override
	public <T> void update(Class<T> clazz, Object p) {
		this.sqlSession.update(clazz.getSimpleName().toLowerCase()
				+ MybatisValue.IBATIS_UPDATE, p);

	}

	@Override
	public <T> void insert(Class<T> clazz, T t) {
		this.sqlSession.insert(clazz.getSimpleName().toLowerCase()
				+ MybatisValue.IBATIS_INSERT, t);
	}

	@Override
	public <T> boolean exists(Class<T> clazz, T t) {
		List<T> result = this.sqlSession.<T> selectList(clazz.getSimpleName()
				.toLowerCase() + MybatisValue.IBATIS_EXISTS, t);
		if (result == null || result.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public <T> List<T> getData(Class<T> clazz, Object param) {
		return sqlSession.selectList(clazz.getSimpleName().toLowerCase()
				+ MybatisValue.IBATIS_GETDATA, param);
	}

	@Override
	public <T> void del(Class<T> clazz, T t) {
		this.sqlSession.delete(clazz.getSimpleName().toLowerCase()
				+ MybatisValue.IBATIS_DELETE, t);
	}

	@Override
	public <T> List<T> getData(String sqlid, Object param) {
		return this.sqlSession.selectList(sqlid, param);
	}

	@Override
	public <T> T getDataSingle(String sqlid, Object param) {
		return this.sqlSession.selectOne(sqlid, param);
	}

	@Override
	public <T> T getDataSingle(Class<T> clazz, Object param) {
		List<T> list = sqlSession.selectList(clazz.getSimpleName()
				.toLowerCase() + MybatisValue.IBATIS_GETONE, param);
		return list.isEmpty() ? null : list.get(0);
	}

}
