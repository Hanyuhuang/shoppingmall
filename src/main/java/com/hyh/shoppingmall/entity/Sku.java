package com.hyh.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Sku {

	private int id;
	private int productId;
	private int number;
	private double price;
	private String name;
	private String address;
	private long sales;
	private Date createTime;

}