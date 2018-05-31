package com.dao;

import com.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper     
@Repository
public interface UserMapper {
    @Delete({"delete from user where id = #{id,jdbcType=INTEGER}"})
    int deleteByPrimaryKey(Integer id);

    @Insert({"insert into user (id,username,password,address) values (#{id,jdbcType=INTEGER},#{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR},#{address,jdbcType=VARCHAR})"})
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(User record);

    int insertSelective(User record);

    @Select({"select * from user where id = #{id,jdbcType=INTEGER}"})
    @ResultMap("com.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);
    
    @Select({"select * from user"})
    @ResultMap("com.dao.UserMapper.BaseResultMap")
    List<User> select();
    
    int updateByPrimaryKeySelective(User record);

    @Update({"update user set username = #{username,jdbcType=VARCHAR}, password = #{password,jdbcType=VARCHAR}, address = #{address,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}"})
    int updateByPrimaryKey(User record);
    
    //新增
    @Select({"select * from user where username = #{username,jdbcType=VARCHAR}"})
    @ResultMap("com.dao.UserMapper.BaseResultMap")
    User selectByPrimaryUsername(String username);
    
    @Select({"select * from user where username = #{username,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}"})
    @ResultMap("com.dao.UserMapper.BaseResultMap")
    User selectByPrimaryUsernameAndPassword(@Param("username")String username,@Param("password")String password);
    
    @Select({"select * from user where address = #{address,jdbcType=VARCHAR}"})
    @ResultMap("com.dao.UserMapper.BaseResultMap")
    User selectByPrimaryAddress(String address);
}