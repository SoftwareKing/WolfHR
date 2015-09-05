package com.wolf.hr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private static int pageSize = 5;

	// 读取配置文件，并初始化配置
	static {
		InputStream in = Configuration.class.getClassLoader().getResourceAsStream("configuration.properties");
		Properties props = new Properties();
		try {
			// 1，读取配置文件
			props.load(in);

			// 2，初始化配置
			pageSize = Integer.parseInt(props.getProperty("pageSize"));

			System.out.println("------- 配置文件加载完毕 ------");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private Configuration() {
	}

	public static int getPageSize() {
		return pageSize;
	}

}
