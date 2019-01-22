package com.hyh.shoppingmall.service;

import java.util.List;
import com.hyh.shoppingmall.entity.Cart;
import com.hyh.shoppingmall.entity.User;

public interface CartService {

	void addCart(Cart cart);

	boolean checkCart(Cart cart);

	void updateCart(Cart cart);

	void updateAddCart(Cart cart);

	List<Cart> listCart(User user,int pageNow);

    void deleteCart(Cart cart);

    List<Cart> listCheckedCart(User user);

    int countCart(User user);
}
