package com.example.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ElasticSearchController {

    @Autowired
    private ESUserInfoService eSUserInfoService;

    @RequestMapping(value = "/es/{id}", method = RequestMethod.POST)
    public UserInfo queryAccountInfo(@PathVariable("id") String id) {
        UserInfo accountInfo = eSUserInfoService.queryUserInfoById(id);
        return accountInfo;
    }

    @RequestMapping(value = "/es/query/{userName}", method = RequestMethod.POST)
    public UserInfo queryAccountInfoByAccountName(@PathVariable("userName") String userName) {
        UserInfo userInfo = eSUserInfoService.queryUserInfoByUserName(userName);
        return userInfo;
    }

    @RequestMapping(value = "/es/save", method = RequestMethod.POST)
    public UserInfo save(@Valid UserInfo accountInfo) {
        eSUserInfoService.save(accountInfo);
        return accountInfo;
    }
    
}
