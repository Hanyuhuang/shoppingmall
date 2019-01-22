package com.hyh.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hyh.shoppingmall.entity.*;
import com.hyh.shoppingmall.service.AddressService;
import com.hyh.shoppingmall.service.CartService;
import com.hyh.shoppingmall.service.OrderService;
import com.hyh.shoppingmall.util.MyCartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	CartService cartService;

	@Autowired
	AddressService addressService;

	@RequestMapping("gotoCheckOrder")
	public String goto_checkOrder(HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		List<Cart> cartList = cartService.listCheckedCart(user);
		List<Address> addressList = addressService.listAddress(user);
		map.put("addressList", addressList);
		map.put("cartList", cartList);
		map.put("sum",MyCartUtil.getSum(cartList));
		return "checkOrder";
	}

	@RequestMapping("saveOrder")
	public String saveOrder(HttpSession session, Address address) {
		User user = (User) session.getAttribute("user");
		List<Cart> cartList = cartService.listCheckedCart(user);
		address=addressService.getAddress(address.getId());
		Order order = new Order();
		order.setUserId(user.getId());
		order.setPrice(MyCartUtil.getSum(cartList));
		order.setRecipient(address.getRecipient());
		order.setAddress(address.getName());
		// 调用保存订单的业务
		orderService.saveOrder(order,cartList);
		return "redirect:/orderSuccess";
	}

    @RequestMapping("orderSuccess")
    public String orderSuccess(ModelMap map) {
        return "orderSuccess";
    }
}
