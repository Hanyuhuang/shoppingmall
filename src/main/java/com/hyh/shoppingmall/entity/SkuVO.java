package com.hyh.shoppingmall.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SkuVO extends Sku {

	private Product spu;
	private List<ProductImage> imageList;
	private List<AttrValue> attrList;

}
