package com.sjl.learn.service.impl;

import com.sjl.learn.domain.DbUser;
import com.sjl.learn.mapper.DbUserMapper;
import com.sjl.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private DbUserMapper dbUserMapper;

    @Override
    public DbUser selectByPrimaryKey(Integer id) {
        return dbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DbUser> selectByExample() {
        return dbUserMapper.selectByExample(null);
    }

    @Override
    public int insert(DbUser userBean) {
        return dbUserMapper.insert(userBean);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dbUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUser(DbUser userBean) {
        return dbUserMapper.updateByPrimaryKey(userBean);
    }
}
