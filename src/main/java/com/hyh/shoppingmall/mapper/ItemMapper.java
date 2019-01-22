package com.hyh.shoppingmall.mapper;

import java.util.List;

import com.hyh.shoppingmall.entity.Sku;
import com.hyh.shoppingmall.entity.SkuVO;

public interface ItemMapper {

	SkuVO getSku(int id);

	List<Sku> listSku(int id);

}
