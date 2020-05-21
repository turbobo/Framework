/*
package com.wonders.govern.example.dao;

import com.wonders.govern.example.entity.ExampleEntity;
import com.wonders.govern.example.vo.ExampleVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

*/
/**
 * @author ：swq
 * @date ：Created in 2020/2/26 13:09
 * @description：声明式dao
 * @modified By：
 * @version: v1.0$
 *//*

public interface ExampleDao extends JpaRepository<ExampleEntity,String> {

    */
/**
     * 方式1 执行hql 或者 jpql 查询
     * @param stName
     * @return
     *//*

    @Query("from ExampleEntity ex where ex.stName=:stName")
    public ExampleEntity findName(@Param("stName") String stName);

    */
/**
     * 方式1 执行sql
     * @param stName
     * @return
     *//*

    @Query(nativeQuery = true,value = "select count(*) from example ex where ex.ST_NAME=:stName")
    public ExampleEntity findNameSql(@Param("stName") String stName);


    */
/**
     * 方式1 hql支持多表联合查询
     * @param stName
     * @return
     *//*

    @Query("select ex from ExampleEntity ex left join ExampleRelEntity exr on ex.id = exr.stExampleId and ex.stName=:stName")
    public ExampleEntity selectAll(@Param("stName") String stName);
    */
/**
     * 方式二 声明式
     * @param stName
     * @return
     *//*

    public ExampleEntity findExamplesByStName(String stName);

    */
/**
     * 关联查询
     * 分页查询
     * @return
     *//*

    @Query(value = "select new com.wonders.govern.example.vo.ExampleVo(ex,exr) from ExampleEntity ex,ExampleRelEntity exr where ex.id = exr.stExampleId and ex.stName=:stName")
    Page<ExampleVo> findCityAndHotelAllSelf(@Param("stName") String stName, Pageable pageable);


    @Query(value = "select new com.wonders.govern.example.vo.ExampleVo(ex,exr) from ExampleEntity ex,ExampleRelEntity exr where ex.id = exr.stExampleId and ex.stName=:stName")
    List<ExampleVo> findExampleVoResultList(@Param("stName") String stName);

    */
/**
     * 自定义查询
     * @param sql
     * @param entityManager
     * @return
     *//*

    default List customQuery(String sql, EntityManager entityManager) {
        return entityManager.createQuery(sql).getResultList();
    }
}
*/
