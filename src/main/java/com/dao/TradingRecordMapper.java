package com.dao;

import com.entity.TradingRecord;

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
public interface TradingRecordMapper {
    @Delete({"delete from trading_record where id = #{id,jdbcType=INTEGER}"})
    int deleteByPrimaryKey(Integer id);

    @Insert({"insert into trading_record (id,date,sender,recepient,ammount,name,type) values (#{id,jdbcType=INTEGER},#{date,jdbcType=VARCHAR},#{sender,jdbcType=VARCHAR},#{recepient,jdbcType=VARCHAR},#{ammount,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR},#{type,jdbcType=VARCHAR})"})
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(TradingRecord record);

    int insertSelective(TradingRecord record);

    @Select({"select * from trading_record where id = #{id,jdbcType=INTEGER}"})
    @ResultMap("com.dao.TradingRecordMapper.BaseResultMap")
    TradingRecord selectByPrimaryKey(Integer id);
    
    @Select({"select * from trading_record"})
    @ResultMap("com.dao.TradingRecordMapper.BaseResultMap")
    List<TradingRecord> select();

    int updateByPrimaryKeySelective(TradingRecord record);

    @Update({"update trading_record set date = #{date,jdbcType=VARCHAR},sender = #{sender,jdbcType=VARCHAR},", "recepient = #{recepient,jdbcType=VARCHAR},ammount = #{ammount,jdbcType=VARCHAR},name = #{name,jdbcType=VARCHAR},type = #{type,jdbcType=VARCHAR}where id = #{id,jdbcType=INTEGER}"})
    int updateByPrimaryKey(TradingRecord record);
}