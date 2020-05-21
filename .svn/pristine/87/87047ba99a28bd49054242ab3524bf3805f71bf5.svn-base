package com.wonders.base.common;

import gov.util.jpa.BaseJpaDao;
import gov.util.jpa.Query;
import gov.util.jpa.impl.BaseJpaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: CommonServiceImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Wonders Information Co., Ltd</p>
 * <p>Created on: 2016-5-13</p>
 * @author zsl
 * @version 1.0
 */
@Service("common.CommonService")
public class CommonServiceImpl extends BaseJpaServiceImpl implements CommonService {


	@Autowired
	private CommonDao commonDao;

	@Override
	public BaseJpaDao getJpaDao() {
		// TODO Auto-generated method stub
		return commonDao;
	}

	@Override
	public Map executeSqlQuery(String sql, int page, int rows) {
		// TODO Auto-generated method stub
		int start=(page-1)*rows;
		int end=page*rows;
		List list = this.executeSqlQuery("select count(*) from ("+sql+")",null);
		Map countMap = (Map) list.get(0);
		String totalSize = countMap.get("COUNT(*)") + "";
		sql = "select * from ( select rownum num, t.* from ("+sql+") t where rownum<="+end+") where num>"+start;
		list = this.executeSqlQuery(sql, null);
		Map map = new HashMap();
		map.put("total",totalSize + "");
		map.put("rows",list);
		return map;
	}

	public void delete(Query query) {
		// TODO Auto-generated method stub
		commonDao.delete(query);
	}

	private String getCountHql( String hql ){
		String countHql = " select count(*) " ;
		if ( hql.indexOf("distinct" ) != -1 ){
			int start = hql.indexOf("distinct") ;
			int embraceStart = -1  ;
			int embraceEnd = -1  ;
			int embraceCount = 0 ;
			// 扫描左扩号
			for ( int i = start + "distinct".length() ; i < hql.length() ; i ++ ){
				if ( hql.charAt( i ) == '('){
					if ( embraceCount ==0 ){
						embraceStart = i ;
					}
					embraceCount ++ ;
				}
				if ( hql.charAt( i ) == ')')
					break;
			}
			// 匹配右扩号
			for ( int i = start + "distinct".length() ; i < hql.length() ; i ++ ){
				if ( hql.charAt( i ) == ')'){
					if ( embraceCount == 1 ){
						embraceEnd = i ;
						break;
					}
					else
						embraceCount -- ;
				}
			}
			if ( embraceEnd > -1 ){
				countHql = "select count( distinct " + hql.substring( embraceStart + 1, embraceEnd) + ") " ;
			}

		}
		return countHql ;
	}

	@Override
	public int countHql(String hql, Map<String, ?> parameters) {
		// TODO Auto-generated method stub
		int start = hql.indexOf("from");
		String from = hql.substring(start, hql.length());
		String count = this.getCountHql( hql ) ;
		List list = this.executeQuery(count +" "+ from, parameters);
		Object countMap = (Object) list.get(0);
		String totalSize = countMap + "";
		return Integer.parseInt(totalSize);
	}

	@Override
	public int countSql(String sql, Map<String, ?> parameters) {
		// TODO Auto-generated method stub
		List list = this.executeSqlQuery("select count(*) from ("+sql+") as total",parameters);
		Map countMap = (Map) list.get(0);
		String totalSize = countMap.get("count(*)") + "";
		return Integer.parseInt(totalSize);
	}

}
