package com.honeypotato.homemanager.service.base;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * service层基础接口
 * Created by Lenovo on 2018/9/20.
 **/
public interface IService<T> {

    /**
     * 持久化
     * @param model 实体
     * @return 插入数量
     */
    Integer insert(T model);

    /**
     * 通过主鍵刪除
     * @param id 主键
     * @return 删除数量
     */
    Integer deleteById(String id);

    /**
     * 根据主键批量刪除
     * @param ids 用逗号分隔，eg“1,2,3,4”
     * @return 删除数量
     */
    Integer deleteByIds(String ids);

    /**
     * 更新数据
     * @param model 数据实体
     * @return 更新数量
     */
    Integer update(T model);

    /**
     * 通过ID查找
     * @param id 主键
     * @return 实体
     */
    T selectById(String id);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找
     * @param fieldName 字段
     * @param value value需符合unique约束
     * @return 实体
     * @throws TooManyResultsException 返回多于一条数据
     */
    T selectBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找
     * @param fieldName javabean定义的属性名，不是数据库里的属性名
     * @param value 字段值
     * @return 实体列表
     */
    List<T> selectListBy(String fieldName, Object value);

    /**
     * 通过多个ID查找
     * @param ids eg：ids -> “1,2,3,4”
     * @return 实体列表
     */
    List<T> selectListByIds(String ids);

    /**
     * 根据条件查找
     * @param condition 查询条件
     * @return 实体列表
     */
    List<T> selectByCondition(Condition condition);

    /**
     * 获取所有
     * @return 实体列表
     */
    List<T> selectAll();

    /**
     * 分页查询数据
     * @param page 页码
     * @param size 每页数量
     * @return 实体列表
     */
    List<T> selectByPage(int page, int size);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record 实体
     * @return 实体列表
     */
    List<T> select(T record);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record 实体
     * @return 实体
     */
    T selectOne(T record);
}
