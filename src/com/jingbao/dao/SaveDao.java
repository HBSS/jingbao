package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jingbao.daomain.Save;

public class SaveDao extends BaseDao{
	/**
	 * 添加收藏
	 */
	public boolean addSave(Save sv) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		String select = " select * from tab_save where userid=? and goodsid=? ";
		PreparedStatement ps1 = con.prepareStatement(select);
		ps1.setString(1, sv.getUserid());
		ps1.setString(2, sv.getGoodsid());
		ResultSet rs=ps1.executeQuery();
		if(rs.next()){
			return true;
		}else {
			String sql = " insert into tab_save values(?,?,?,sysdate) ";
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setString(1, getStringID());//替换通配符的值
			ps2.setString(2, sv.getUserid());
			ps2.setString(3, sv.getGoodsid());
			
			int n=ps2.executeUpdate();//n代表更新行数
			close(null,ps2,con);//关闭释放资源
			close(rs,ps1,null);//关闭释放资源
			if(n>0){
				return true;
			}
			return false;
		}
		
	}
	/**
	 * 查询收藏
	 */
	public ArrayList<Save> selectSave(String userid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " select ts.goodsid, "
				+ " tg.goodsname, "
				+ " tg.goodspicture, "
				+ " tg.goodsprice, "
				+ " ts.userid "
				+ " from tab_goods tg, tab_save ts "
				+ " where "
				+ " tg.goodsid=ts.goodsid "
				+ " and ts.userid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Save> allsave	= new ArrayList<Save>();
		
		while(rs.next()){
			System.out.println("aaa");
			Save sv=new Save();
			sv.setUserid(rs.getString("userid"));
			sv.setGoodsid(rs.getString("goodsid"));
			sv.setGoodsname(rs.getString("goodsname"));
			sv.setGoodspicture(rs.getString("goodspicture"));
			sv.setGoodsprice(rs.getString("goodsprice"));
			allsave.add(sv);
		}
		//释放资源
		close(rs, ps, con);
		return allsave;
	}
	
	
	
	
	
	public Save getAsave(String saveid) throws SQLException{
		Save s=null;
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_save tg "+" where tg.saveid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, saveid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			s=new Save();
			s.setSaveid(rs.getString("saveid"));
			s.setUserid(rs.getString("userid"));
			s.setGoodsid(rs.getString("goodsid"));
		}
		
		return s;
	}
	
	public boolean updatesave(Save s) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_save set "+
		" userid=?, "+
		" goodsid=? "
		+ "where saveid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		//替换通配符的值
		ps.setString(1, s.getUserid());
		ps.setString(2, s.getGoodsid());
		ps.setString(3, s.getSaveid());
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
		
	}

	
	
	
	public boolean deletesave(String saveid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " delete from TAB_save tg "+" where tg.saveid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,saveid);
		int n =ps.executeUpdate();
		close(null, ps, con);
		if(n>0){
			return true;
		}
		return false;
	}
	
	public boolean delete2save(String[] saveids) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " delete from TAB_save where saveid in ( ";
		for (int i = 0; i < saveids.length; i++) {
			sql = sql + saveids[i] + ",";
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
	public boolean deleteSave(String userid,String goodsid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		String sql = " delete from tab_save where userid=? and goodsid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, goodsid);
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
	}
}
