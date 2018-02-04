package com.gxq.learn.extractor.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gxq.learn.extractor.util.JdbcUtil;

public class DBServiceDao {
	/**
	 * 得到第一行数据，类型List<Object>
	 */
	public List<Object> getOneByArray(String sql) throws SQLException{
		 QueryRunner qr = new QueryRunner();
		 Object result[] = (Object[]) qr.query(JdbcUtil.getConnection(), sql, new ArrayHandler());
		 return Arrays.asList(result);
	}

	/**
	 * 得到每一行数据，类型List<Array>
	 */
	public List<Object[]> getAllByArray(String sql) throws SQLException{
         QueryRunner qr = new QueryRunner();
         List<Object[]> list = (List<Object[]>) qr.query(JdbcUtil.getConnection(), sql, new ArrayListHandler());
         return list;
     }
	
	/**
	 * 得到第一行数据，类型Map<String,Object>
	 */
	public Map<String,Object> getOneByMapHandler(String sql) throws SQLException{
         QueryRunner qr = new QueryRunner();
         Map<String,Object> map = (Map<String,Object>) qr.query(JdbcUtil.getConnection(), sql, new MapHandler());
         return map;
     }
	
	/**
	 * 得到每一行数据，类型List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getAllMapListHandler(String sql) throws SQLException{
         QueryRunner qr = new QueryRunner();
         List<Map<String,Object>> list = (List<Map<String,Object>>) qr.query(JdbcUtil.getConnection(), sql, new MapListHandler());
         return list;
     }
		
	/**
	 * 得到第一行数据，类型Bean.class
	 */
	@SuppressWarnings("unchecked")
	public <T> T find(String sql,final Class<T> type) throws SQLException {
        QueryRunner qr = new QueryRunner();
		T t = (T) qr.query(JdbcUtil.getConnection(), sql,new BeanHandler(type));
        return t;
     }
	 
	 /**
	  * 得到每一行数据，类型List<Bean.class>
	  */
	 @SuppressWarnings("rawtypes")
	 public <T>List<T> getAll(String sql,final Class<T> type) throws SQLException {
         QueryRunner qr = new QueryRunner();
         @SuppressWarnings("unchecked")
         List<T> list = (List<T>) qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler(type));
         return list;
     }
	
	/**
	 * 得到总条数
	 */
    public Integer getScalarHandler(String sql) throws SQLException{
        QueryRunner qr = new QueryRunner();
		Integer count = (Integer) qr.query(JdbcUtil.getConnection(), sql, new ScalarHandler(1));
        return count;
    }
}
