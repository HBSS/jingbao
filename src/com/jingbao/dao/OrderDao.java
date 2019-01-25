package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;

import com.jingbao.daomain.Order;
import com.jingbao.daomain.Orderdetail;

public class OrderDao extends BaseDao{
	/*创建订单
	 * 
	 */
	
	public String putOrders(Order or) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String orderid = getStringID();
		String sql = "insert into TAB_ORDER values(?,?,?,0,SYSDATE) ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, orderid);//替换通配符的值
		ps.setString(2, or.getUserid());
		ps.setDouble(3, or.getTotol());
		
		int n=ps.executeUpdate();
		String sql2 = "insert into TAB_ORDERDETAIL(orderid,goodsid,shopnumber) "
		+ " select '" + orderid + "',goodsid,shopnumber from TAB_CART where userid = ? ";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setString(1, or.getUserid());
		
		int n1=ps2.executeUpdate();
		
		close(null, ps, con);
		close(null, ps2, null);
		if(n > 0 && n1 > 0){
			return orderid;
			
		}
		return null;

	}
	/*查询订单
	 * 
	 */
	 
	public Order selectOrder(String orderid) throws SQLException{
		Order od = null;
		Connection con = getConnection();//与数据库建立连接
		String sql = "select  * "
				+ " from TAB_ORDER "
				+ " where ORDERID=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, orderid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			od=new Order();
			od.setOrderid(rs.getString("ORDERID"));
			od.setTotol(rs.getDouble("TOTOL"));
			od.setPosition(rs.getInt("POSITION"));
			od.setUserid(rs.getString("USERID"));
			
			
		
	}
		close(rs, ps, con);
		return od;
		
	
}
	public ArrayList<Orderdetail> selectOrderdetail(String orderid) throws SQLException{
		
		Connection con = getConnection();//与数据库建立连接
		String sql = "select to.goodsid , "
				+ " tg.goodsname , "
				+ " tg.goodspicture , "
				+ " tg.goodsprice , "
				+ " to.shopnumber  "
				+ " from tab_goods tg, TAB_ORDERDETAIL to "
				+ " where "
				+ " tg.goodsid=to.goodsid "
				+ " and to.orderid=? ";
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, orderid);
		ResultSet rs=ps.executeQuery();
		ArrayList<Orderdetail> odt = new ArrayList<Orderdetail>();
		while(rs.next()){
			Orderdetail	ot=new Orderdetail();
			ot.setGoodsid(rs.getString("goodsid"));
			ot.setShopnumber(rs.getInt("shopnumber"));
			ot.setGoodsname(rs.getString("goodsname"));
			ot.setGoodsprice(rs.getDouble("goodsprice"));
			ot.setGoodspicture(rs.getString("goodspicture"));
			ot.setOrderid(rs.getString("orderid"));
			odt.add(ot);
			close(rs, ps, con);
			
		
	}
		return odt;
		
	
}	
/*
 * 成功支付订单
 */
	public boolean paidOrder(String orderid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql =" update tab_order set position = 1 "
				+ " where orderid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, orderid);
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
	}
/*
 * 购买到的商品
 
	public String buyOrder(String userid) throws SQLException{
		Order o1=null;
		Connection con = getConnection();//与数据库建立连接
		String sql = " select * "
				+ " from tab_order "
				+ " where userid=? and position=1 ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		ArrayList<Order> or = new ArrayList<Order>();
		while(rs.next()){
			o1=new Order();
			o1.setOrderid(rs.getString("orderid"));
			o1.setTotol(rs.getDouble("totol"));
			o1.setPosition(rs.getInt("position"));
			o1.setTime(rs.getString("time"));
			o1.setUserid(rs.getString("userid"));
			or.add(o1);
			close(rs, ps, con);
			
		
	}
		return or;
}	*/

	/*
	 * 未付款的订单
	 */
		public Order notpaidOrder(String userid) throws SQLException{
			Order o1=null;
			Connection con = getConnection();//与数据库建立连接
			String sql = " select * "
					+ " from tab_order "
					+ " where userid=? and position=0 ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				o1=new Order();
				o1.setOrderid(rs.getString("orderid"));
				o1.setTotol(rs.getDouble("totol"));
				o1.setPosition(rs.getInt("position"));
				o1.setTime(rs.getString("time"));
				o1.setUserid(rs.getString("userid"));
				close(rs, ps, con);
				
			
		}
			return o1;
	}	
		public boolean clearorder(String orderid) throws SQLException{
			Connection con = getConnection();//与数据库建立连接
			
			String sql1 = " delete from tab_order where orderid=? ";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(1, orderid);
			int n=ps.executeUpdate();//n代表更新行数
			
			String sql2 = " delete from tab_orderdetail where orderid=? ";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, orderid);
			int n2=ps2.executeUpdate();//n代表更新行数
			close(null,ps2,null);//关闭释放资源
			close(null, ps, con);
			if(n>0&&n2>0){
				return true;
			}
			return false;
		}
	/*
	 * 	
	 */ 
		public ArrayList<Order> selectAllOrder() throws SQLException{
			
			Connection con = getConnection();//与数据库建立连接
			String sql = "select  * "
					+ " from TAB_ORDER ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<Order> allorder = new ArrayList<Order>();
			while(rs.next()){
				Order ao = new Order();
				ao.setOrderid(rs.getString("orderid"));
				ao.setPosition(rs.getInt("position"));
				ao.setTime(rs.getString("time"));
				ao.setTotol(rs.getDouble("totol"));
				ao.setUserid(rs.getString("userid"));
				allorder.add(ao);
				
			
		}	
			close(rs, ps, con);
			return allorder;
}
}
	