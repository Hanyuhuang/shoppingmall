package com.hyh.shoppingmall.service;

import java.util.List;

import com.hyh.shoppingmall.entity.Sku;
import com.hyh.shoppingmall.entity.SkuAttrValue;
import com.hyh.shoppingmall.entity.SkuVO;

public interface ItemService {

	SkuVO getSku(int id);

	List<Sku> listSku(int id);

}
