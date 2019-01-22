package com.hyh.shoppingmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPropertiesUtil {

	public static String getMyProperty(String properties, String key) {
		// TODO Auto-generated method stub

		Properties properties2 = new Properties();

		InputStream resourceAsStream = MyPropertiesUtil.class.getClassLoader().getResourceAsStream(properties);

		try {
			properties2.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String property = properties2.getProperty(key);

		return property;

	}

}
