package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ContractMapper;
import com.entity.Contract;
import com.service.ContractService;

@Service("ContractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractMapper contractMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return contractMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Contract record) {
        // TODO Auto-generated method stub
        return contractMapper.insert(record);
    }

    @Override
    public int insertSelective(Contract record) {
        // TODO Auto-generated method stub
        return contractMapper.insertSelective(record);
    }

    @Override
    public Contract selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Contract> select() {
        // TODO Auto-generated method stub
        return contractMapper.select();
    }

    @Override
    public int updateByPrimaryKeySelective(Contract record) {
        // TODO Auto-generated method stub
        return contractMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Contract record) {
        // TODO Auto-generated method stub
        return contractMapper.updateByPrimaryKey(record);
    }
}
