package com.hyh.shoppingmall.service.impl;

import java.util.List;

import com.hyh.shoppingmall.entity.AttrVO;
import com.hyh.shoppingmall.mapper.AttrMapper;
import com.hyh.shoppingmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AttrServiceImp implements AttrService {

	@Autowired
	AttrMapper attrMapper;

	public List<AttrVO> listAttr(int class2) {
		List<AttrVO> attrList = attrMapper.listAttr(class2);
		return attrList;
	}

}
