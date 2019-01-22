package com.hyh.shoppingmall.service;

import java.util.List;

import com.hyh.shoppingmall.entity.AttrVO;
import com.hyh.shoppingmall.entity.SkuAttrValue;
import com.hyh.shoppingmall.entity.SkuVO;

public interface ListService {

	List<SkuVO> listSku(int class2);

	List<SkuVO> getSku(List<AttrVO> attrList, int class2);

}
