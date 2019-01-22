package com.hyh.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hyh.shoppingmall.entity.AttrVO;
import com.hyh.shoppingmall.entity.SkuAttrValue;
import com.hyh.shoppingmall.service.AttrService;
import com.hyh.shoppingmall.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class IndexController {

	@Autowired
	AttrService attrService;

	@Autowired
	ListService listService;


	@RequestMapping("gotoLogout")
	public String goto_logout(HttpSession session) {
		session.invalidate();
		return "redirect:/gotoLogin";
	}


	@RequestMapping("gotoLogin")
	public String goto_login() {
		return "login";
	}
	@RequestMapping("gotoRegister")
	public String gotoRegister() {
		return "register";
	}


	@RequestMapping("index")
	public String index() {
		return "index";
	}

}
