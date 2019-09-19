package com.isea.clitoris.mybatis.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T extends Serializable> {

    /**
     * 保存对象数据
     *
     * @param t
     * @return
     */
    int insertByObj(T t);

    /**
     * 保存集合数据
     *
     * @param list
     * @return
     */
    int insertByList(List<T> list);

    // 删

    /**
     * 根据主键删除数据
     *
     * @param id
     * @return
     */
    int deleteById(Long id);


    // 改

    /**
     * 更新对象条件数据
     *
     * @param t
     * @return
     */
    int updateByObj(T t);

    /**
     * 批量更新数据
     *
     * @param list
     */
    int batchUpdate(List<T> list);

    // 查

    /**
     * 根据map条件查询对象
     *
     * @param params
     * @return
     */
    T findOne(Map<String, Object> params);

    /**
     * 查询所有数据对象的集合
     *
     * @return
     */
    List<T> findAllList();

    /**
     * 根据对象条件查询数据对象集合
     *
     * @param t
     * @return
     */
    List<T> findListByObj(T t);

    /**
     * 根据map条件查询数据对象集合
     *
     * @param
     * @return
     */
    List<T> findListByMap(Map<String, Object> params);
}
