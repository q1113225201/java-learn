package com.sjl.learn.controller;

import com.sjl.learn.domain.base.DbUserType;
import com.sjl.learn.entity.BaseResponse;
import com.sjl.learn.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @RequestMapping(value = "/userType", method = RequestMethod.GET)
    public BaseResponse getUserTypes() {
        List<DbUserType> list = userTypeService.selectByExample();
        return new BaseResponse(list.size() > 0, list.size() > 0 ? "success" : "failure", list);
    }

    @RequestMapping(value = "/userType/{id}", method = RequestMethod.GET)
    public BaseResponse getUserTypes(@PathVariable("id") int id) {
        DbUserType dbUserType = userTypeService.selectByPrimaryKey(id);
        return new BaseResponse(dbUserType != null, dbUserType != null ? "success" : "failure", dbUserType);
    }

    @RequestMapping(value = "/userType", method = RequestMethod.POST)
    public BaseResponse getUserTypes(@RequestBody DbUserType userType) {
        int result = userTypeService.insert(userType);
        return new BaseResponse(result > 0, result > 0 ? "success" : "failure", result);
    }
}
