package com.hyh.shoppingmall.service.impl;

import com.hyh.shoppingmall.entity.User;
import com.hyh.shoppingmall.mapper.LoginMapper;
import com.hyh.shoppingmall.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;
    public User checkUser(String loginname, String password) {
        return loginMapper.checkUser(loginname,password);
    }

    public void addUser(User user) {
        loginMapper.addUser(user);
    }
}
