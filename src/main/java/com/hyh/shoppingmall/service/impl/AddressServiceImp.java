package com.hyh.shoppingmall.service.impl;

import java.util.List;

import com.hyh.shoppingmall.entity.Address;
import com.hyh.shoppingmall.entity.User;
import com.hyh.shoppingmall.mapper.AddressMapper;
import com.hyh.shoppingmall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImp implements AddressService {

	@Autowired
	AddressMapper addressMapper;

	public List<Address> listAddress(User user) {
		return addressMapper.listAddress(user);
	}

	public Address getAddress(int id) {
		return addressMapper.getAddress(id);
	}

	public void addAddress(Address address) {
		addressMapper.addAddress(address);
	}

	public void deleteAddress(Address address) {
		addressMapper.deleteAddress(address);
	}

	public void updateAddress(Address address) {
		addressMapper.updateAddress(address);
	}

}
