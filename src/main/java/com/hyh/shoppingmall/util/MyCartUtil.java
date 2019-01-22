package com.hyh.shoppingmall.util;

import com.hyh.shoppingmall.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

public class MyCartUtil {

    public static BigDecimal getSum(List<Cart> cartList) {
        BigDecimal sum = new BigDecimal("0");
        if(cartList!=null&&cartList.size()>0) {
            for (int i = 0; i < cartList.size(); i++) {
                if (cartList.get(i).getStatus().equals("1")) {
                    sum = sum.add(new BigDecimal(cartList.get(i).getTotalPrice() + ""));
                }
            }
            return sum;
        }
        return sum;
    }

    public static  int getTotal(List<Cart> cartList) {
        int total = 0;
        if(cartList!=null&&cartList.size()>0) {
            for (int i = 0; i < cartList.size(); i++) {
                if (cartList.get(i).getStatus().equals("1")) {
                    total += cartList.get(i).getNumber();
                }
            }
            return total;
        }
        return total;
    }
}
