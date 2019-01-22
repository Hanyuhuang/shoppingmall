package com.hyh.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hyh.shoppingmall.entity.Cart;
import com.hyh.shoppingmall.entity.Sku;
import com.hyh.shoppingmall.entity.User;
import com.hyh.shoppingmall.service.CartService;

import com.hyh.shoppingmall.util.MyCartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("changeStatus")
	public String changeStatus(Integer pageNow,Cart cart, HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		int cartCount = cartService.countCart(user);
		int pageCount = (cartCount-1)/5+1;
        cart.setUserId(user.getId());
        cartService.updateCart(cart);
        List<Cart> cartList = cartService.listCart(user,pageNow);
		map.put("sum", MyCartUtil.getSum(cartList));
		map.put("pageNow",pageNow);
		map.put("pageCount", pageCount);
		map.put("cartList", cartList);
		return "cartListInner";
	}


	@RequestMapping("listCart")
	public String listCart(Integer pageNow, HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Cart> cartList = null;
			int cartCount = cartService.countCart(user);
			int pageCount = (cartCount-1)/5+1;
			if(pageNow==null){
				pageNow = 1;
				cartList = cartService.listCart(user,pageNow);
			}else {
				cartList = cartService.listCart(user,pageNow);
			}
			map.put("cartList", cartList);
			map.put("pageNow",pageNow);
			map.put("pageCount", pageCount);
			map.put("sum", MyCartUtil.getSum(cartList));
			return "cartList";
		}else {
			return "login";
		}
	}

	@RequestMapping("miniCart")
	public String miniCart(HttpSession session, ModelMap map) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            List<Cart> cartList = cartService.listCheckedCart(user);
            map.put("cartList", cartList);
			map.put("total", MyCartUtil.getTotal(cartList));
        }
        return "miniCartList";
	}
    @RequestMapping("deleteCart")
    public String deleteCart(Integer pageNow,Cart cart,HttpSession session, ModelMap map) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            cartService.deleteCart(cart);
            int cartCount = cartService.countCart(user);
			int pageCount = (cartCount-1)/5+1;
            List<Cart> cartList = cartService.listCart(user,pageNow);
            map.put("cartList", cartList);
			map.put("pageNow",pageNow);
			map.put("pageCount", pageCount);
            map.put("total", MyCartUtil.getTotal(cartList));
            map.put("sum",MyCartUtil.getSum(cartList));
        }
        return "cartList";
    }

    @RequestMapping("updateCart")
    public String updateCart(Integer pageNow,Cart cart,HttpSession session, ModelMap map) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            cart.setUserId(user.getId());
            cartService.updateCart(cart);
			int cartCount = cartService.countCart(user);
			int pageCount = (cartCount-1)/5+1;
            List<Cart> cartList = cartService.listCart(user,pageNow);
            map.put("cartList", cartList);
			map.put("pageNow",pageNow);
			map.put("pageCount", pageCount);
            map.put("total", MyCartUtil.getTotal(cartList));
            map.put("sum", MyCartUtil.getSum(cartList));
        }
        return "cartListInner";
    }
	@RequestMapping("addCart")
	public String addCart(Cart cart, HttpSession session, RedirectAttributes redirectAttributes) {
		User user = (User)session.getAttribute("user");
		if(user!=null){
			boolean b = cartService.checkCart(cart);
			if (b==false) {
                cart.setTotalPrice(cart.getUnitPrice()*cart.getNumber());
				cartService.addCart(cart);
			} else {
				cart.setTotalPrice(cart.getUnitPrice()*cart.getNumber());
				cartService.updateAddCart(cart);
			}
		}else {
			return "login";
		}
		redirectAttributes.addAttribute("id",cart.getSkuId());
		return "redirect:/cartSuccess";
	}


	@RequestMapping("cartSuccess")
	public String cartSuccess(Sku sku, ModelMap map) {
		map.put("id",sku.getId());
		return "cartSuccess";
	}

}