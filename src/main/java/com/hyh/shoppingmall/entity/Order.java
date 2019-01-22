package com.hyh.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Order {

	private int id;
	private int userId;
	private BigDecimal price;
	private String recipient;
	private String address;
	private Date createTime;

}
