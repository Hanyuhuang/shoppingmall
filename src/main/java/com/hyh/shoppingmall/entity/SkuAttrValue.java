package com.hyh.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SkuAttrValue {

    private int id;
	private Product spu;
	private Sku sku;
	private List<AttrValue> attrValueList;
	private Date createTime;

}
