package com.hyh.shoppingmall.controller;

import com.hyh.shoppingmall.entity.Address;
import com.hyh.shoppingmall.entity.User;
import com.hyh.shoppingmall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("listAddress")
    public String listAddress(HttpSession session, ModelMap map){
        User user = (User) session.getAttribute("user");
        List<Address> addressList = addressService.listAddress(user);
        map.put("addressList",addressList);
        return "addressList";
    }

    @RequestMapping("gotoAddAddress")
    public String gotoAddAddress(){
        return "addressAdd";
    }

    @RequestMapping("addAddress")
    public String addAddress(Address address,HttpSession session){
        User user = (User) session.getAttribute("user");
        address.setUserId(user.getId());
        addressService.addAddress(address);
        return "redirect:/listAddress";
    }

    @RequestMapping("deleteAddress")
    public String deleteAddress(Address address){
        addressService.deleteAddress(address);
        return "redirect:/listAddress";
    }

    @RequestMapping("gotoUpdateAddress")
    public String gotoUpdateAddress(Address address,ModelMap map){
        address = addressService.getAddress(address.getId());
        map.put("address",address);
        return "addressUpdate";
    }

    @RequestMapping("updateAddress")
    public String updateAddress(Address address,HttpSession session){
        User user = (User) session.getAttribute("user");
        address.setUserId(user.getId());
        addressService.updateAddress(address);
        return "redirect:/listAddress";
    }
}
