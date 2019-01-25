package com.jingbao.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDao{

	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "system";
			String password = "oracle";
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭statement
	 * 
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @discription 关闭所有连接有关的对象
	 * @param rs 结果集对象
	 * @param ps 预处理对象
	 * @param con 连接对象
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		closeStatement(rs,ps);
		closeConnection(con);
	}
	/**
	 * 总行数
	 */
	public int getUserListRowCount(String tableName) throws SQLException {
		int rowCount = 0;
		// SQL语句
		String find_sql = " SELECT count(*)  FROM " +  tableName;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = getConnection().prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				//根据每页条数计算列表总页数
				rowCount = rs.getInt(1);
			}
		} finally {
			closeStatement(rs, pstmt);
		}
		
		return rowCount;
	}
	/**
	 * 总页数
	 */
	public int getUserListPageCount(String tableName, int pageSize) throws SQLException {
		int res = 0;
		
		int rowCount = getUserListRowCount(tableName);
		if (rowCount%pageSize==0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		
		return res;
	}
	
	/**
	 * @discription 创建ID
	 * @return String
	 */
	public static String getStringID(){
		String id=null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		id=sdf.format(date);
		return id;
	}	
	/**
	 * md5加密
	 * @param s
	 * @return
	 */
	public final static String md5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
/**
 * 
 */
/**
 * @author Admin
 *
 */

