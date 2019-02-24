package com.sjl.learn.service;

import com.sjl.learn.domain.base.DbUserType;

import java.util.List;

public interface UserTypeService {
    DbUserType selectByPrimaryKey(Integer id);

    List<DbUserType> selectByExample();

    int insert(DbUserType dbUserType);

    int deleteByPrimaryKey(Integer id);

    int updateUser(DbUserType dbUserType);
}
