package com.hyh.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Cart {

	private int id;
	private String skuName;
	private double unitPrice;
	private int number;
	private double totalPrice;
	private int userId;
	private int productId;
	private Date createTime;
	private int skuId;
	private String productPic;
	private String status;
	private String address;

}