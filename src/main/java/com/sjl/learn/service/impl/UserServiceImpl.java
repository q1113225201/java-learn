package com.sjl.learn.service.impl;

import com.sjl.learn.domain.UserBean;
import com.sjl.learn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<UserBean> list = new ArrayList<>();
    private Long id = 0l;

    @Override
    public UserBean getUser(Long id) {
        for (UserBean userBean : list) {
            if (id == userBean.getId()) {
                return userBean;
            }
        }
        return null;
    }

    @Override
    public List<UserBean> getUserList() {
        return list;
    }

    @Override
    public Long addUser(UserBean userBean) {
        id++;
        userBean.setId(id);
        list.add(userBean);
        return userBean.getId();
    }

    @Override
    public Long deleteUser(Long id) {
        Long result = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                result = list.get(i).getId();
                list.remove(i);
                break;
            }
        }
        return result;
    }

    @Override
    public Long updateUser(UserBean userBean) {
        Long result = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == userBean.getId()) {
                result = userBean.getId();
                list.remove(i);
                list.add(i,userBean);
                break;
            }
        }
        return result;
    }
}
