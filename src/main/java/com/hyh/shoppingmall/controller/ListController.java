package com.hyh.shoppingmall.controller;

import java.util.List;

import com.hyh.shoppingmall.entity.*;
import com.hyh.shoppingmall.service.AttrService;
import com.hyh.shoppingmall.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ListController {

	@Autowired
	ListService listService;

	@Autowired
	AttrService attrService;

	@RequestMapping("getSku")
	public String getSku(AttrModel attrModel, int class2, ModelMap map) {
		// 根据属性查询列表的业务
		List<SkuVO> skuList = listService.getSku(attrModel.getAttrList(), class2);
		map.put("skuList", skuList);
		return "skuList";
	}

	@RequestMapping("listSku")
	public String listSku(int class2, ModelMap map) {
		// class2属性的集合
		List<AttrVO> attrList = attrService.listAttr(class2);
		// class2商品列表
		List<SkuVO> skuList = listService.listSku(class2);
		map.put("attrList", attrList);
		map.put("skuList", skuList);
		map.put("class2", class2);
		return "list";
	}
}
