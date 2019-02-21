package com.sjl.learn.controller;

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
    public String addUser(@RequestBody UserBean userBean) {
        Long id = userService.addUser(userBean);
        if (id != null && id > 0) {
            return "success";
        } else {
            return "failure";
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserBean getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<UserBean> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Long id) {
        Long result = userService.deleteUser(id);
        if (result != null && result > 0) {
            return "success";
        } else {
            return "failure";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(@RequestBody UserBean userBean) {
        Long id = userService.updateUser(userBean);
        if (id != null && id > 0) {
            return "success";
        } else {
            return "failure";
        }
    }
}
