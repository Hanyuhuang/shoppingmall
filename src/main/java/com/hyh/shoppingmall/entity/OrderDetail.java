package com.hyh.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class OrderDetail {

	private int id;
	private int orderId;
	private int skuId;
	private String skuName;
	private double skuPrice;
	private int skuNumber;
	private String skuAddress;
	private Date createTime;

}
