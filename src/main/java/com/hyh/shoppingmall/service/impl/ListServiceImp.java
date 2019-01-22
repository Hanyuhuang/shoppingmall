package com.hyh.shoppingmall.service.impl;

import java.util.HashMap;
import java.util.List;

import com.hyh.shoppingmall.entity.AttrVO;
import com.hyh.shoppingmall.entity.Sku;
import com.hyh.shoppingmall.entity.SkuAttrValue;
import com.hyh.shoppingmall.entity.SkuVO;
import com.hyh.shoppingmall.mapper.ListMapper;
import com.hyh.shoppingmall.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ListServiceImp implements ListService {

	@Autowired
	ListMapper listMapper;

	public List<SkuVO> listSku(int class2) {
		List<SkuVO> skuList = listMapper.listSku(class2);
		return skuList;
	}

	public List<SkuVO> getSku(List<AttrVO> attrList, int class2) {
		StringBuffer subSql = new StringBuffer("");
		// 根据属性集合动态拼接条件过滤的sql语句
		subSql.append(" and sku.id in ( select sku0.sku_id from ");
		if (attrList != null && attrList.size() > 0) {
			for (int i = 0; i < attrList.size(); i++) {
				subSql.append(
						" (select sku_id from sku_attribute_value where attr_id = " + attrList.get(i).getId()
								+ " and value_id = " + attrList.get(i).getValueList().get(i).getId() + ") sku" + i + " ");
				if ((i + 1) < attrList.size() && attrList.size() > 1) {
					subSql.append(" , ");
				}
			}
			if (attrList.size() > 1) {
				subSql.append(" where ");
				for (int i = 0; i < attrList.size(); i++) {
					if ((i + 1) < attrList.size()) {
						subSql.append(" sku" + i + ".sku_id=" + "sku" + (i + 1) + ".sku_id");
						
						if(attrList.size()>2&&i  < (attrList.size()- 2)){
							subSql.append(" and ");
						}
					}
				}
			}

		}
		subSql.append(" ) ");
		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
		hashMap.put("class2", class2);
		hashMap.put("subSql", subSql.toString());
		return listMapper.getSku(hashMap);
	}

}
