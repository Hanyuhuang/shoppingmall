package com.hyh.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Value {

	private int id;
	private String value;
	private String status;
	private int attrId;
	private String name;
	private Date createTime;

}