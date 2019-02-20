package com.sjl.learn.controller;

import com.sjl.learn.domain.UserBean;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @RequestMapping("/user/add")
    public String addUser(ModelMap map,
                          @ModelAttribute @Valid UserBean userBean,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.toString();
        }
        return "success";
    }
}
