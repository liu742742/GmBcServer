package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        // TODO Auto-generated method stub
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        // TODO Auto-generated method stub
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> select() {
        // TODO Auto-generated method stub
        return userMapper.select();
    }

    
    @Override
    public int updateByPrimaryKeySelective(User record) {
        // TODO Auto-generated method stub
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        // TODO Auto-generated method stub
        return userMapper.updateByPrimaryKey(record);
    }
}
