package com.hyh.shoppingmall.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

	private int id;
	private String name;
	private String status;
	private int userId;
	private String recipient;
	private String tel;


}