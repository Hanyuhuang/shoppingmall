package com.hyh.shoppingmall.mapper;

import com.hyh.shoppingmall.entity.Cart;
import com.hyh.shoppingmall.entity.User;

import java.util.List;
import java.util.Map;


public interface CartMapper {

	List<Cart> listCart(User user);

	List<Cart> listCart(Map map);

	void addCart(Cart cart);

	void updateCart(Cart cart);

	void updateAddCart(Cart cart);

	int checkCart(Cart cart);

    void deleteCart(Cart cart);

    List<Cart> listCheckedCart(User user);

    int countCart(User user);
}
