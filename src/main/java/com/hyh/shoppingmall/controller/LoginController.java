package com.hyh.shoppingmall.controller;


import javax.servlet.http.HttpSession;
import com.hyh.shoppingmall.entity.User;
import com.hyh.shoppingmall.mapper.LoginMapper;

import com.hyh.shoppingmall.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping("login")
	public String login(String loginname,String password, HttpSession session,ModelMap map) {
		 User user= loginService.checkUser(loginname,password);
         if(user!=null){
         	session.setAttribute("user",user);
         	return "redirect:/index";
		 }else {
         	map.put("msg","用户名或密码错误!");
         	return "login";
		 }
	}

	@RequestMapping("register")
	public String register(User user) {
        loginService.addUser(user);
		return "redirect:/gotoLogin";
	}

}
