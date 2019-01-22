package com.hyh.shoppingmall.service;

import com.hyh.shoppingmall.entity.Cart;
import com.hyh.shoppingmall.entity.Order;

import java.util.List;

public interface OrderService {

	void saveOrder(Order order, List<Cart> cartList);

}
