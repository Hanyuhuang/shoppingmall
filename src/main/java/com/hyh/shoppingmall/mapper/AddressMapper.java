package com.hyh.shoppingmall.mapper;

import java.util.List;

import com.hyh.shoppingmall.entity.Address;
import com.hyh.shoppingmall.entity.User;


public interface AddressMapper {

	List<Address> listAddress(User user);

	Address getAddress(int id);

    void addAddress(Address address);

	void deleteAddress(Address address);

	void updateAddress(Address address);
}
