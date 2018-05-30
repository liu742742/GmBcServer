package com.service;

import java.util.List;

import com.entity.User;

/**
 * 用户
 * 
 * @author User742742
 *
 */
public interface UserService {

    /**
     * 根据id删除数据
     * 
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增数据，新增字段无法选择
     * 
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 新增数据，新增字段可以选择
     * 
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据id查询数据
     * 
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 查询所有数据
     * 
     * @return
     */
    List<User> select();

    /**
     * 根据id修改除id以外的字段值，修改字段可以选择
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据id修改除id以外的字段值，修改字段无法选择
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    // 新增
    /**
     * 根据username查询数据
     * 
     * @param username
     * @return
     */
    User selectByPrimaryUsername(String username);

    /**
     * 根据username和password查询数据
     * 
     * @param username
     * @param password
     * @return
     */
    User selectByPrimaryUsernameAndPassword(String username, String password);

}
