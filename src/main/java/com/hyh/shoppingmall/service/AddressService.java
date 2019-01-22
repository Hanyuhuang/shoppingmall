package com.hyh.shoppingmall.service;

import java.util.List;

import com.hyh.shoppingmall.entity.Address;
import com.hyh.shoppingmall.entity.User;

public interface AddressService {

	List<Address> listAddress(User user);

	Address getAddress(int id);

    void addAddress(Address address);

	void deleteAddress(Address address);

	void updateAddress(Address address);
}
