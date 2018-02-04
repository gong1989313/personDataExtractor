package com.gxq.learn.extractor.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtil {
	private static DataSource datasource;
	// 把配置文件部分放在静态代码块中，调用时直接加载
	static {
		try {
			// 加载文件
			InputStream is = DBCPUtil.class.getClassLoader().getResourceAsStream("config/dbcpconfig.properties");
			// 实例化properties集合
			Properties prop = new Properties();
			prop.load(is);
			// 首先加载核心类
			datasource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 提供获得数据源
	public static DataSource getDataSource() {
		return datasource;
	}

	// 提供获得连接
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
}