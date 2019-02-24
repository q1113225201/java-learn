package com.sjl.learn.service.impl;

import com.sjl.learn.dao.base.DbUserTypeMapper;
import com.sjl.learn.domain.base.DbUserType;
import com.sjl.learn.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    private DbUserTypeMapper dbUserTypeMapper;

    @Override
    public DbUserType selectByPrimaryKey(Integer id) {
        return dbUserTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DbUserType> selectByExample() {
        return dbUserTypeMapper.selectByExample(null);
    }

    @Override
    public int insert(DbUserType dbUserType) {
        return dbUserTypeMapper.insert(dbUserType);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dbUserTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUser(DbUserType dbUserType) {
        return dbUserTypeMapper.updateByPrimaryKey(dbUserType);
    }
}
