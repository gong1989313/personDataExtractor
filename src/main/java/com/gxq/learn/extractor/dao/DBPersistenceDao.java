package com.gxq.learn.extractor.dao;

import java.sql.Connection;
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
import com.gxq.learn.extractor.pojo.Person;

public class DBPersistenceDao {
	
	private final String insertSql = "insert into person(name, \r\n" + 
			"cardno, \r\n" + 
			"descriot, \r\n" + 
			"ctftp, \r\n" + 
			"ctfid, \r\n" + 
			"gender, \r\n" + 
			"birthday, \r\n" + 
			"address, \r\n" + 
			"zip, \r\n" + 
			"dirty, \r\n" + 
			"distrct1, \r\n" + 
			"distrct2, \r\n" + 
			"distrct3, \r\n" + 
			"distrct4, \r\n" + 
			"distrct5, \r\n" + 
			"distrct6, \r\n" + 
			"firstnm, \r\n" + 
			"lastnm, \r\n" + 
			"duty, \r\n" + 
			"mobile, \r\n" + 
			"tel, \r\n" + 
			"fax, \r\n" + 
			"email, \r\n" + 
			"nation, \r\n" + 
			"taste, \r\n" + 
			"education, \r\n" + 
			"company, \r\n" + 
			"ctel, \r\n" + 
			"caddress, \r\n" + 
			"czip, \r\n" + 
			"family, \r\n" + 
			"version, id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public /*synchronized */void batchInsert(List<Person> personList) {
		Object[][] params = new Object[personList.size()][33];
		QueryRunner qr = new QueryRunner();
		int size = personList.size();
		for(int i=0; i<size; i++) {
			Person p = personList.get(i);
			params[i][0] = p.getName();
			params[i][1] = p.getCardno();
			params[i][2] = p.getDescriot();
			params[i][3] = p.getCtftp();
			params[i][4] = p.getCtfid();
			params[i][5] = p.getGender();
			params[i][6] = p.getBirthday();
			params[i][7] = p.getAddress();
			params[i][8] = p.getZip();
			params[i][9] = p.getDirty();
			params[i][10] = p.getDistrct1();
			params[i][11] = p.getDistrct2();
			params[i][12] = p.getDistrct3();
			params[i][13] = p.getDistrct4();
			params[i][14] = p.getDistrct5();
			params[i][15] = p.getDistrct6();
			params[i][16] = p.getFirstnm();
			params[i][17] = p.getLastnm();
			params[i][18] = p.getDuty();
			params[i][19] = p.getMobile();
			params[i][20] = p.getTel();
			params[i][21] = p.getFax();
			params[i][22] = p.getEmail();
			params[i][23] = p.getNation();
			params[i][24] = p.getTaste();
			params[i][25] = p.getEducation();
			params[i][26] = p.getCompany();
			params[i][27] = p.getCtel();
			params[i][28] = p.getCaddress();
			params[i][29] = p.getCzip();
			params[i][30] = p.getFamily();
			params[i][31] = p.getVersion();
			params[i][32] = p.getId();
		}
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			qr.batch(conn, insertSql, params);
			System.out.println("Thread "+Thread.currentThread().getName()+" insert "+params.length+" successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close();
		}
	}

	/**
	 * 得到第一行数据，类型List<Object>
	 */
	public List<Object> getOneByArray(String sql) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Object result[] = (Object[]) qr.query(JdbcUtil.getConnection(), sql, new ArrayHandler());
		return Arrays.asList(result);
	}

	/**
	 * 得到每一行数据，类型List<Array>
	 */
	public List<Object[]> getAllByArray(String sql) throws SQLException {
		QueryRunner qr = new QueryRunner();
		List<Object[]> list = (List<Object[]>) qr.query(JdbcUtil.getConnection(), sql, new ArrayListHandler());
		return list;
	}

	/**
	 * 得到第一行数据，类型Map<String,Object>
	 */
	public Map<String, Object> getOneByMapHandler(String sql) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Map<String, Object> map = (Map<String, Object>) qr.query(JdbcUtil.getConnection(), sql, new MapHandler());
		return map;
	}

	/**
	 * 得到每一行数据，类型List<Map<String,Object>>
	 */
	public List<Map<String, Object>> getAllMapListHandler(String sql) throws SQLException {
		QueryRunner qr = new QueryRunner();
		List<Map<String, Object>> list = (List<Map<String, Object>>) qr.query(JdbcUtil.getConnection(), sql,
				new MapListHandler());
		return list;
	}

	/**
	 * 得到第一行数据，类型Bean.class
	 */
	@SuppressWarnings("unchecked")
	public <T> T find(String sql, final Class<T> type) throws SQLException {
		QueryRunner qr = new QueryRunner();
		T t = (T) qr.query(JdbcUtil.getConnection(), sql, new BeanHandler(type));
		return t;
	}

	/**
	 * 得到每一行数据，类型List<Bean.class>
	 */
	@SuppressWarnings("rawtypes")
	public <T> List<T> getAll(String sql, final Class<T> type) throws SQLException {
		QueryRunner qr = new QueryRunner();
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler(type));
		return list;
	}

	/**
	 * 得到总条数
	 */
	public Integer getScalarHandler(String sql) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Integer count = (Integer) qr.query(JdbcUtil.getConnection(), sql, new ScalarHandler(1));
		return count;
	}
}
