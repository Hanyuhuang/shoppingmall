package com.hyh.shoppingmall.mapper;

import com.hyh.shoppingmall.entity.Order;

import java.util.Map;



public interface OrderMapper {

	void saveOrder(Order order);

	void saveOrderDetail(Map<Object, Object> map);

	void deleteCart(Map<Object, Object> map);

}
