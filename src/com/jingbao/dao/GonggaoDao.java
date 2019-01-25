package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jingbao.daomain.Gonggao;





public class GonggaoDao extends BaseDao {

	/**
	 * 添加公告
	 */
	public boolean addgonggao(Gonggao g) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "insert into tab_gonggao values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, g.getGonggaoid());//替换通配符的值
		ps.setString(2, g.getGonggaoname());
		ps.setString(3, g.getGonggaocontent());
		

		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
		
	}
	/**
	 * 查询公告
	 */
	public ArrayList<Gonggao> getAllGonggao() throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_gonggao   ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Gonggao> allgonggao	= new ArrayList<Gonggao>();
		
		while(rs.next()){
			Gonggao g=new Gonggao();
			g.setGonggaoid(rs.getString("gonggaoid"));
			g.setGonggaoname(rs.getString("gonggaoname"));
			g.setGonggaocontent(rs.getString("gonggaocontent"));
			allgonggao.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgonggao;
	}
	
	public ArrayList<Gonggao> getAllGonggao1() throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_gonggao where rownum <= 5 order by gonggaoid desc ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Gonggao> allgonggao	= new ArrayList<Gonggao>();
		
		while(rs.next()){
			Gonggao g=new Gonggao();
			g.setGonggaoid(rs.getString("gonggaoid"));
			g.setGonggaoname(rs.getString("gonggaoname"));
			g.setGonggaocontent(rs.getString("gonggaocontent"));
			allgonggao.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgonggao;
	}
	
	
	public Gonggao getAgonggao(String gonggaoid) throws SQLException{
		Gonggao g=null;
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_gonggao tg "+" where tg.gonggaoid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gonggaoid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			g=new Gonggao();
			g.setGonggaoid(rs.getString("gonggaoid"));
			g.setGonggaoname(rs.getString("gonggaoname"));
			g.setGonggaocontent(rs.getString("gonggaocontent"));
		}
		
		return g;
	}
	
	public boolean updateGonggao(Gonggao g) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_gonggao set "+
		" gonggaoname=?, "+
		" gonggaocontent=? "
		+ "where gonggaoid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		//替换通配符的值
		ps.setString(1, g.getGonggaoname());
		ps.setString(2, g.getGonggaocontent());
		ps.setString(3, g.getGonggaoid());
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
		
	}

	
	
	
	public boolean deleteGonggao(String gonggaoid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " delete from TAB_GONGGAO tg "+" where tg.gonggaoid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,gonggaoid);
		int n =ps.executeUpdate();
		close(null, ps, con);
		if(n>0){
			return true;
		}
		return false;
	}
	public boolean delete2Gonggao(String[] gonggaoids) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " delete from TAB_GONGGAO where gonggaoid in ( ";
		for (int i = 0; i < gonggaoids.length; i++) {
			sql = sql + gonggaoids[i] + ",";
		}
		sql = sql.substring(0,sql.length()-1);
		sql = sql + " )";
		PreparedStatement ps = con.prepareStatement(sql);
		
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;



	}
}

	
	
	
	

