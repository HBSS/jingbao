package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jingbao.daomain.Cart;

public class CartDao extends BaseDao {
	/**
	 * 加入购物车
	 * @param g
	 * @return
	 * @throws SQLException
	 */
	public boolean putCart(Cart ct) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		String select = " select * from tab_cart where userid=? and goodsid=? ";
		PreparedStatement ps1 = con.prepareStatement(select);
		ps1.setString(1, ct.getUserid());
		ps1.setString(2, ct.getGoodsid());
		ResultSet rs=ps1.executeQuery();
		if(rs.next()){
			String update = " update tab_cart set shopnumber = shopnumber+? "
					+ " where userid=? and goodsid=? ";
			PreparedStatement ps3 = con.prepareStatement(update);
			ps3.setInt(1, ct.getShopnumber());//替换通配符的值
			ps3.setString(2, ct.getUserid());
			ps3.setString(3, ct.getGoodsid());
			
			int n=ps3.executeUpdate();//n代表更新行数
			close(null,ps3,con);//关闭释放资源
			close(rs,ps1,null);//关闭释放资源
			if(n>0){
				return true;
			}
			return false;
		}else {
			String sql = " insert into tab_cart values(?,?,?,?) ";
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setString(1, getStringID());//替换通配符的值
			ps2.setString(2, ct.getGoodsid());
			ps2.setInt(3, ct.getShopnumber());
			ps2.setString(4, ct.getUserid());
			
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
	 * 查询购物车
	 */
	public ArrayList<Cart> selectCart(String userid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "select tc.goodsid , "
				+ " tg.goodsname , "
				+ " tg.goodspicture , "
				+ " tg.goodsprice , "
				+ " tc.shopnumber , "
				+ " tg.goodsprice*tc.shopnumber smallsum "
				+ " from tab_goods tg, tab_cart tc "
				+ " where "
				+ " tg.goodsid=tc.goodsid "
				+ " and tc.userid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Cart> allCart	= new ArrayList<Cart>();
		//处理结果
		while(rs.next()){
			Cart c = new Cart();
			c.setGoodsid(rs.getString("goodsid"));
			c.setGoodsname(rs.getString("goodsname"));
			c.setGoodspicture(rs.getString("goodspicture"));
			c.setGoodsprice(rs.getDouble("goodsprice"));
			c.setSmallsum(rs.getDouble("smallsum"));
			c.setShopnumber(rs.getInt("shopnumber"));
			allCart.add(c);
		}
		//
		close(rs, ps, con);
		return allCart;
	}
	public boolean addCart(String userid,String goodsid,String shopnumber) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		String sql = " update tab_cart set shopnumber = shopnumber+1"
				+ " where userid=? and goodsid=? ";
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
	public boolean deleteCart(String userid,String goodsid,String shopnumber) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		String sql = " update tab_cart set shopnumber = shopnumber-1"
				+ " where userid=? and goodsid=? ";
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
	public boolean clearCart(String userid,String goodsid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		String sql = " delete from tab_cart where userid=? and goodsid=? ";
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
	public boolean clearAllCart(String userid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		String sql = " delete from tab_cart where userid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
	}
}
