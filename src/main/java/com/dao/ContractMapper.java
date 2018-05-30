package com.dao;

import com.entity.Contract;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper     
@Repository
public interface ContractMapper {
    @Delete({"delete from contract where id = #{id,jdbcType=INTEGER}"})
    int deleteByPrimaryKey(Integer id);

    @Insert({"insert into contract (id,date,publisher,name,descriptioin,address,type) values (#{id,jdbcType=INTEGER},#{date,jdbcType=VARCHAR},#{publisher,jdbcType=VARCHAR},#{name,jdbcType=VARCHAR},#{descriptioin,jdbcType=VARCHAR},#{address,jdbcType=VARCHAR},#{type,jdbcType=VARCHAR})"})
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Contract record);

    int insertSelective(Contract record);

    @Select({"select * from contract where id = #{id,jdbcType=INTEGER}"})
    @ResultMap("com.dao.ContractMapper.BaseResultMap")
    Contract selectByPrimaryKey(Integer id);

    @Select({"select * from contract"})
    @ResultMap("com.dao.ContractMapper.BaseResultMap")
    List<Contract> select();
    
    int updateByPrimaryKeySelective(Contract record);

    @Update({"update contract set date = #{date,jdbcType=VARCHAR},publisher = #{publisher,jdbcType=VARCHAR},name = #{name,jdbcType=VARCHAR},descriptioin = #{descriptioin,jdbcType=VARCHAR},address = #{address,jdbcType=VARCHAR},type = #{type,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}"})
    int updateByPrimaryKey(Contract record);
    
    //新增
    @Select({"select * from contract where publisher = #{publisher,jdbcType=VARCHAR}"})
    @ResultMap("com.dao.ContractMapper.BaseResultMap")
    List<Contract> selectByPrimaryPublisher(String publisher);
    
    @Select({"select * from contract where name = #{name,jdbcType=VARCHAR}"})
    @ResultMap("com.dao.ContractMapper.BaseResultMap")
    List<Contract> selectByPrimaryName(String name);
    
    @Select({"select * from contract where address = #{address,jdbcType=VARCHAR}"})
    @ResultMap("com.dao.ContractMapper.BaseResultMap")
    Contract selectByPrimaryAddress(String address);
}