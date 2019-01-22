package com.hyh.shoppingmall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyh.shoppingmall.entity.*;
import com.hyh.shoppingmall.mapper.OrderMapper;
import com.hyh.shoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	OrderMapper orderMapper;

	public void saveOrder(Order order,List<Cart> cartList) {

		// 保存订单
		orderMapper.saveOrder(order);
		// 订单详情
        Map<Object, Object> orderDetailMap = new HashMap<Object, Object>();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for(Cart cart:cartList){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setSkuId(cart.getSkuId());
            orderDetail.setSkuName(cart.getSkuName());
            orderDetail.setSkuPrice(cart.getUnitPrice());
            orderDetail.setSkuNumber(cart.getNumber());
            orderDetail.setSkuAddress(cart.getAddress());
            orderDetailList.add(orderDetail);
        }
        orderDetailMap.put("orderDetailList",orderDetailList);
		orderMapper.saveOrderDetail(orderDetailMap);
		// 删除已经生成订单的购物车对象
		Map<Object, Object> cart = new HashMap<Object, Object>();
		cart.put("cartList", cartList);
		orderMapper.deleteCart(cart);
	}

}
