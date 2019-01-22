package com.hyh.shoppingmall.service.impl;

import java.util.List;

import com.hyh.shoppingmall.entity.Sku;
import com.hyh.shoppingmall.entity.SkuVO;
import com.hyh.shoppingmall.mapper.ItemMapper;
import com.hyh.shoppingmall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	ItemMapper itemMapper;
	
	public SkuVO getSku(int id) {
		return itemMapper.getSku(id);
	}

	public List<Sku> listSku(int id) {
		return itemMapper.listSku(id);
	}

}
