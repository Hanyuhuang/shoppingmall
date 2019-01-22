package com.hyh.shoppingmall.controller;

import java.util.List;

import com.hyh.shoppingmall.entity.Sku;
import com.hyh.shoppingmall.entity.SkuAttrValue;
import com.hyh.shoppingmall.entity.SkuVO;
import com.hyh.shoppingmall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping("skuDetail")
	public String skuDetail(Sku sku, ModelMap map) {
		// 查询商品详细信息对象
		SkuVO skuVO = itemService.getSku(sku.getId());
		// 查询同spu下的相关的其他sku信息
		List<Sku> skuList = itemService.listSku(sku.getProductId());
		map.put("skuVO", skuVO);
		map.put("skuList", skuList);
		return "skuDetail";
	}

}
