package com.hyh.shoppingmall.mapper;

import com.hyh.shoppingmall.entity.SkuVO;

import java.util.HashMap;
import java.util.List;


public interface ListMapper {

	List<SkuVO> listSku(int class2);

	List<SkuVO> getSku(HashMap<Object, Object> hashMap);

}
