package com.hyh.shoppingmall.service;

import com.hyh.shoppingmall.entity.User;

public interface LoginService {

    User checkUser(String loginname,String password);

    void addUser(User user);
}
