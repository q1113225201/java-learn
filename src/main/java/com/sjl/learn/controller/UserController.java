package com.sjl.learn.controller;

import com.sjl.learn.domain.BaseResponse;
import com.sjl.learn.domain.UserBean;
import com.sjl.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public BaseResponse addUser(@RequestBody UserBean userBean) throws Exception {
        if (userBean.getNickname() == null) {
            throw new Exception("nickname 为空");
        }
        Long id = userService.addUser(userBean);
        if (id != null && id > 0) {
            return new BaseResponse<String>(1, "success", null);
        } else {
            return new BaseResponse<String>(0, "failure", null);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public BaseResponse getUser(@PathVariable("id") Long id) {
        UserBean userBean = userService.getUser(id);
        if (id != null && id > 0) {
            return new BaseResponse<UserBean>(1, "success", userBean);
        } else {
            return new BaseResponse<UserBean>(0, "failure", userBean);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public BaseResponse getUserList() {
        List<UserBean> list = userService.getUserList();
        return new BaseResponse<List<UserBean>>(1, null, list);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public BaseResponse deleteUser(@PathVariable("id") Long id) {
        Long result = userService.deleteUser(id);
        if (result != null && result > 0) {
            return new BaseResponse<Long>(1, "success", result);
        } else {
            return new BaseResponse<Long>(1, "failure", result);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public BaseResponse updateUser(@RequestBody UserBean userBean) {
        Long id = userService.updateUser(userBean);
        if (id != null && id > 0) {
            return new BaseResponse<Long>(1, "success", id);
        } else {
            return new BaseResponse<Long>(1, "failure", id);
        }
    }
}
