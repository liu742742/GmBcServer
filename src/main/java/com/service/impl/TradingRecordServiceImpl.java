package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TradingRecordMapper;
import com.entity.TradingRecord;
import com.service.TradingRecordService;

@Service("TradingRecordService")
public class TradingRecordServiceImpl implements TradingRecordService {

    @Autowired
    TradingRecordMapper tradingRecordMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return tradingRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TradingRecord record) {
        // TODO Auto-generated method stub
        return tradingRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(TradingRecord record) {
        // TODO Auto-generated method stub
        return tradingRecordMapper.insertSelective(record);
    }

    @Override
    public TradingRecord selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return tradingRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TradingRecord> select() {
        // TODO Auto-generated method stub
        return tradingRecordMapper.select();
    }

    @Override
    public int updateByPrimaryKeySelective(TradingRecord record) {
        // TODO Auto-generated method stub
        return tradingRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TradingRecord record) {
        // TODO Auto-generated method stub
        return tradingRecordMapper.updateByPrimaryKey(record);
    }
}
