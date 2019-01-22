package com.hyh.shoppingmall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyh.shoppingmall.entity.Cart;
import com.hyh.shoppingmall.entity.User;
import com.hyh.shoppingmall.mapper.CartMapper;
import com.hyh.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImp implements CartService {

	@Autowired
	CartMapper cartMapper;
	
	public void addCart(Cart cart) {
        cartMapper.addCart(cart);
	}

	public boolean checkCart(Cart cart) {
		boolean b = false;
		int i = cartMapper.checkCart(cart);
		if (i > 0) {
			b = true;
		}
		return b;
	}

	public void updateCart(Cart cart) {
		cartMapper.updateCart(cart);
	}

	public void updateAddCart(Cart cart) {
		cartMapper.updateAddCart(cart);
	}

	public List<Cart> listCart(User user, int pageNow) {
		Map map = new HashMap<>();
		int pageSize = 5;
		int startIndex = (pageNow-1)* pageSize;
		map.put("user",user);
		map.put("pageNow",pageNow);
		map.put("startIndex",startIndex);
		map.put("pageSize",pageSize);
		return cartMapper.listCart(map);
	}

	public void deleteCart(Cart cart) {
		cartMapper.deleteCart(cart);
	}

	public List<Cart> listCheckedCart(User user) {
		return cartMapper.listCheckedCart(user);
	}

	public int countCart(User user) {
		return cartMapper.countCart(user);
	}

}
