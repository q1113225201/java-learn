package com.sjl.learn.service;

import com.sjl.learn.domain.UserBean;

import java.util.List;

public interface UserService {
    UserBean getUser(Long id);

    List<UserBean> getUserList();

    Long addUser(UserBean userBean);

    Long deleteUser(Long id);

    Long updateUser(UserBean userBean);
}
