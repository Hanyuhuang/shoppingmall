package com.hyh.shoppingmall.mapper;

import com.hyh.shoppingmall.entity.User;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

	User checkUser(@Param("loginname") String loginname, @Param("password") String password);

    void addUser(User user);
}
