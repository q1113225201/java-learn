package com.sjl.learn;

import com.sjl.learn.domain.UserBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FirstController {

    @RequestMapping("/hello")
    public String say() {
        return "hello";
    }

    @RequestMapping("/user")
    public UserBean user() {
        UserBean userBean = new UserBean("jack", 20, true);
        return userBean;
    }

    @RequestMapping("/users")
    public List<UserBean> users() {
        List<UserBean> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserBean userBean = new UserBean("jack" + i, 20 + i, i % 2 == 0);
            list.add(userBean);
        }
        return list;
    }

    @RequestMapping("/helloUser")
    public String say(String name) {
        return "hello " + name;
    }
}
