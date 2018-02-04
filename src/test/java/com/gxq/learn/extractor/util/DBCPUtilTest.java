package com.gxq.learn.extractor.util;

import java.sql.SQLException;

import org.junit.Test;

public class DBCPUtilTest {

	@Test
	public final void testGetConnection() throws SQLException {
		DBCPUtil.getConnection();
	}

}
