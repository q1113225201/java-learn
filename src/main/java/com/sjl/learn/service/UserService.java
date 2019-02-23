package com.sjl.learn.service;

import com.sjl.learn.domain.DbUser;

import java.util.List;

public interface UserService {
    DbUser selectByPrimaryKey(Integer id);

    List<DbUser> selectByExample();

    int insert(DbUser userBean);

    int deleteByPrimaryKey(Integer id);

    int updateUser(DbUser userBean);
}
