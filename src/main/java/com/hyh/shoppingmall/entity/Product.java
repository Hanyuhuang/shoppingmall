package com.hyh.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {

	private int id;
	private String name;
	private String pic;
	private int class1;
	private int class2;
	private int brandId;
	private Date createTime;
	private String describes;

}