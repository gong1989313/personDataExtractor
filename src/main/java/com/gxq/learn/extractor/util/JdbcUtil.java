package com.gxq.learn.extractor.util;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	/**
	 * 获取Connection
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		// 从当前Thread获得conn
		Connection conn = threadLocal.get();
		if (conn == null) {
			// 第一次的时候，还没绑定，需要创建
			threadLocal.set(DBCPUtil.getConnection());
			conn = threadLocal.get();
		}
		return conn;
	}

	/**
	 * 开启事务
	 * 
	 * @throws SQLException
	 */
	public static void startTransaction() {
		try {
			Connection conn = threadLocal.get();
			if (conn == null) {
				conn = getConnection();
				// 将conn绑定到当前thread的局部变量
				threadLocal.set(conn);
			}
			// 开启事务
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 回滚事务
	 */
	public static void rollBack() {
		try {
			Connection conn = getConnection();
			if (conn != null) {
				// 回滚事务
				conn.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 提交事务
	 */
	public static void commit() {
		try {
			Connection conn = getConnection();
			if (conn != null) {
				// 提交事务
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public static void close() {
		try {
			Connection conn = getConnection();
			if (conn != null) {
				// 关闭连接
				conn.close();
				// 解除当前线程上绑定的conn
				threadLocal.remove();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
