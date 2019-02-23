package com.sjl.learn.controller;

import com.sjl.learn.domain.DbUser;
import com.sjl.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public DbUser getUser(@PathVariable("id") Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<DbUser> getUserList() {
        return userService.selectByExample();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public int addUser(@RequestBody DbUser userBean) {
        return userService.insert(userBean);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public int updateUser(@RequestBody DbUser userBean) {
        return userService.updateUser(userBean);
    }
}
