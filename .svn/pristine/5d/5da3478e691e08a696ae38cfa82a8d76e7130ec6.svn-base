package com.wonders.base.common;

import gov.util.jpa.BaseJpaService;
import gov.util.jpa.Query;

import java.util.Map;


/**
 * <p>Title: CommonService.java</p>
 * <p>Description: 公用业务层接口</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Wonders Information Co., Ltd</p>
 * <p>Created on: 2016-15-13</p>
 * @author zsl
 * @version 1.0
 */
public interface CommonService extends BaseJpaService{

	/**
	 * 执行查询sql语句
	 * @param sql
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map executeSqlQuery(String sql, int page, int rows);

	/**
	 * 删除
	 */
	public void delete(Query query);

	/**
	 * 查询count
	 * @param hql
	 * @param parameters
	 * @return
	 */
	public int countHql(String hql, Map<String, ?> parameters);


	/**
	 * 查询count
	 * @param parameters
	 * @return
	 */
	public int countSql(String sql, Map<String, ?> parameters);

}
