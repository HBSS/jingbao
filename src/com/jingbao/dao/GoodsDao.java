package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jingbao.daomain.Goods;
import com.jingbao.daomain.GoodsType;

public class GoodsDao extends BaseDao{
	/**
	 * 获得商品类型
	 * @throws SQLException 
	 */
	public ArrayList<GoodsType> getAllGoodsType() throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " select * from tab_goodstype  ";
		PreparedStatement ps = con.prepareStatement(sql);//预处理SQL
		ResultSet rs = ps.executeQuery();
		
		ArrayList<GoodsType> allgoodstype = new ArrayList<GoodsType>();
		//处理结果集
		while(rs.next()){
			GoodsType g = new GoodsType();
			g.setTypeid(rs.getString("typeid"));
			g.setTypename(rs.getString("typename"));
			allgoodstype.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoodstype;
	}
	
	/**
	 * 添加商品
	 */
	public boolean addGoods(Goods g) throws SQLException {
		Connection con = getConnection();//与数据库建立连接
		String sql = " insert into tab_goods values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);//预处理SQL
		ps.setString(1, g.getGoodsid());
		ps.setString(2, g.getGoodsname());
		ps.setString(3, g.getGoodstype());
		ps.setDouble(4, g.getGoodsprice());
		ps.setString(5, g.getGoodspicture());
		ps.setString(6, g.getGoodspicture1());
		ps.setString(7, g.getGoodspicture2());
		ps.setString(8, g.getGoodspicture3());
		ps.setString(9, g.getGoodspicture4());
		ps.setDouble(10, g.getLeft());
		ps.setString(11, g.getDescription());
		ps.setString(12, g.getUserid());
	
		int n = ps.executeUpdate();//n代表更新的行数
		close(null, ps, con);//关闭，释放资源
		if(n > 0){
			return true;
		}
		return false;
	}
	/**
	 * 查询商品
	 */
	public ArrayList<Goods> getAllGoodsByUserID(String userid, int pageSize, int page) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String find_sql = " select * from tab_goods tg, tab_goodstype tgy "
				+ " where tg.userid=? and tg.goodstype=tgy.typeid ";
		String sql = "select * from ( select a1.*,rownum rn from ("+find_sql+") a1 "
				+ " where rownum<="+page*pageSize+") where rn>= "+((page-1)*pageSize+1);
		PreparedStatement ps = con.prepareStatement(sql);//预处理SQL
		ps.setString(1, userid);
		ResultSet rs = ps.executeQuery();
		ArrayList<Goods> allgoods = new ArrayList<Goods>();
		//处理结果集
		while(rs.next()){
			Goods g = new Goods();
			g.setGoodsid(rs.getString("goodsid"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setGoodstype(rs.getString("goodstype"));
			g.setTypename(rs.getString("typename"));
			g.setUserid(rs.getString("userid"));
			g.setLeft(rs.getInt("left"));
			g.setDescription(rs.getString("description"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}
	
	
	
	/**
	 * 查询详情
	 * @param goodsid
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Goods> getAllGoods() throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_goods tg,tab_goodstype tgy where tg.goodstype=tgy.typeid";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Goods> allgoods	= new ArrayList<Goods>();
		
		while(rs.next()){
			Goods g=new Goods();
			g.setGoodsid(rs.getString("goodsid"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodstype(rs.getString("goodstype"));
			g.setTypename(rs.getString("typename"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setUserid(rs.getString("userid"));
			g.setLeft(rs.getInt("left"));
			g.setDescription(rs.getString("description"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}
	
	
	
		//详情
		public Goods getAGoods(String goodsid) throws SQLException{
			Goods g=null;
			Connection con = getConnection();//与数据库建立连接
			String sql = " select * from tab_goods tg, tab_goodstype tgy where tg.goodsid=? and tg.goodstype=tgy.typeid";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goodsid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				g=new Goods();
				g.setGoodsid(rs.getString("goodsid"));
				g.setGoodsname(rs.getString("goodsname"));
				g.setGoodstype(rs.getString("goodstype"));
				g.setTypename(rs.getString("typename"));
				g.setGoodsprice(rs.getDouble("goodsprice"));
				g.setGoodspicture(rs.getString("goodspicture"));
				g.setUserid(rs.getString("userid"));
				g.setLeft(rs.getInt("left"));
				g.setDescription(rs.getString("description"));
				
			}
			
			return g;
		}
	/**
	/**
	 * 删除商品
	 * @param goodsid
	 * @return
	 * @throws SQLException 
	 */
	public boolean deleteGoods(String goodsid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " delete from tab_goods where goodsid=? ";
		PreparedStatement ps = con.prepareStatement(sql);//预处理SQL
		ps.setString(1, goodsid);
		int n = ps.executeUpdate();//n代表更新的行数
		close(null, ps, con);//关闭，释放资源
		if(n > 0){
			return true;
		}
		return false;
	}
	/**
	 * 修改商品
	 */
	public boolean updateGoods(Goods g) throws SQLException {
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_goods set "
				+ "  goodsname=?,   "
				+ "  goodstype=?,   "
				+ "  goodsprice=?,   "
				+ "  left=?,   "
				+ "  description=?   ";
		if(g.getGoodspicture() != null){
			sql = sql + " , goodspicture=? ";
		}
		if(g.getGoodspicture1() != null){
			sql = sql + " , goodspicture1=? ";
		}
		if(g.getGoodspicture2() != null){
			sql = sql + " , goodspicture2=? ";
		}
		if(g.getGoodspicture3() != null){
			sql = sql + " , goodspicture3=? ";
		}
		if(g.getGoodspicture4() != null){
			sql = sql + " , goodspicture4=? ";
		}
		sql = sql + " where goodsid=? ";
		PreparedStatement ps = con.prepareStatement(sql);//预处理SQL
		ps.setString(1, g.getGoodsname());
		ps.setString(2, g.getGoodstype());
		ps.setDouble(3, g.getGoodsprice());
		ps.setDouble(4, g.getLeft());
		ps.setString(5, g.getDescription());
		
		if(g.getGoodspicture() != null){
			ps.setString(6, g.getGoodspicture());
			ps.setString(7, g.getGoodsid());
			if(g.getGoodspicture1() != null){
				ps.setString(6, g.getGoodspicture());
				ps.setString(7, g.getGoodspicture1());
				ps.setString(8, g.getGoodsid());
				if(g.getGoodspicture2() != null){
					ps.setString(6, g.getGoodspicture());
					ps.setString(7, g.getGoodspicture1());
					ps.setString(8, g.getGoodspicture2());
					ps.setString(9, g.getGoodsid());
					if(g.getGoodspicture3() != null){
						ps.setString(6, g.getGoodspicture());
						ps.setString(7, g.getGoodspicture1());
						ps.setString(8, g.getGoodspicture2());
						ps.setString(9, g.getGoodspicture3());
						ps.setString(10, g.getGoodsid());
						if(g.getGoodspicture4() != null){
							ps.setString(6, g.getGoodspicture());
							ps.setString(7, g.getGoodspicture1());
							ps.setString(8, g.getGoodspicture2());
							ps.setString(9, g.getGoodspicture3());
							ps.setString(10, g.getGoodspicture4());
							ps.setString(11, g.getGoodsid());
						}
					}
				}
			}
					
		}else{
			ps.setString(6, g.getGoodsid());
		}
	
		int n = ps.executeUpdate();//n代表更新的行数
		close(null, ps, con);//关闭，释放资源
		if(n > 0){
			return true;
		}
		return false;
	}
	public boolean deleteGoodsFromAll(String[] goodsids) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " delete from tab_goods where goodsid in ( ";
		for (int i = 0; i < goodsids.length; i++) {
			sql = sql + goodsids[i] + ",";
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
	public ArrayList<Goods> getAllGoodsByUserID(String userid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_goods tg,tab_goodstype tgy where tg.userid=?and tg.goodstype=tgy.typeid";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Goods> allgoods	= new ArrayList<Goods>();
		
		while(rs.next()){
			Goods g=new Goods();
			g.setGoodsid(rs.getString("goodsid"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodstype(rs.getString("goodstype"));
			g.setTypename(rs.getString("typename"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setUserid(rs.getString("userid"));
			g.setLeft(rs.getInt("left"));
			g.setDescription(rs.getString("description"));
			
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}
	
	public boolean updatesGoods(Goods g) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_goods set "+
		" goodsname=?, "+
		" goodstype=?, "+
		" goodsprice=?, "
		+ "  left=?,   "
		+ "  description=?   ";
		if(g.getGoodspicture()!=null){
			sql=sql+" ,goodspicture=? ";
		}
		sql=sql+" where goodsid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		//替换通配符的值
		ps.setString(1, g.getGoodsname());
		ps.setString(2, g.getGoodstype());
		ps.setDouble(3, g.getGoodsprice());
		ps.setDouble(4, g.getLeft());
		ps.setString(5, g.getDescription());
		if(g.getGoodspicture()!=null){
			ps.setString(6, g.getGoodspicture());
			ps.setString(7, g.getGoodsid());
		}else{
			ps.setString(6, g.getGoodsid());
		}
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
		
	}
	
	
	public ArrayList<Goods> conditionSelect(Goods gg, int pageSize, int page) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		
		
		StringBuffer find_sql = new StringBuffer(" select * from tab_goods tg, tab_goodstype tgy "
				+ " where tg.goodstype=tgy.typeid ");
		
		ArrayList<String> param = new ArrayList<String>();
		
		if(gg.getGoodsname().length()>0){
			find_sql.append(" and tg.goodsname like ? ");
			param.add( "%" + gg.getGoodsname() + "%");
		}
		if(!"all".equals(gg.getGoodstype())){
			find_sql.append(" and tg.goodstype = ? ");
			param.add(gg.getGoodstype());
		}
		
		String sql = "select * from ( select a1.*,rownum rn from ("+ find_sql.toString()+") a1 "
				+ " where rownum<="+page*pageSize+") where rn>= "+((page-1)*pageSize+1);
		PreparedStatement ps = con.prepareStatement(sql);//预处理SQL
		
		for (int i = 0; i < param.size(); i++) {
			ps.setString(i+1, param.get(i));
			
		}
		
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Goods> allgoods = new ArrayList<Goods>();
		//处理结果集
		while(rs.next()){
			Goods g = new Goods();
			g.setGoodsid(rs.getString("goodsid"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setGoodstype(rs.getString("goodstype"));
			g.setTypename(rs.getString("typename"));
			g.setLeft(rs.getInt("left"));
			g.setDescription(rs.getString("description"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}
	
	
	
	
	
	public Goods showAGoods(String goodsid) throws SQLException{
		Goods g=null;
		Connection con = getConnection();//与数据库建立连接
		String sql = " select * from tab_goods tg, tab_goodstype tgy where tg.goodsid=? and tg.goodstype=tgy.typeid";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, goodsid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			g=new Goods();
			g.setGoodsid(rs.getString("goodsid"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodstype(rs.getString("goodstype"));
			g.setTypename(rs.getString("typename"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setGoodspicture1(rs.getString("goodspicture1"));
			g.setGoodspicture2(rs.getString("goodspicture2"));
			g.setGoodspicture3(rs.getString("goodspicture3"));
			g.setGoodspicture4(rs.getString("goodspicture4"));
			g.setUserid(rs.getString("userid"));
			g.setLeft(rs.getInt("left"));
			g.setDescription(rs.getString("description"));
			
		}
		
		return g;
	}

	public ArrayList<Goods> getAllGoods1() throws SQLException {
		Connection con = getConnection();//与数据库建立连接
		String sql = " select * from tab_goods tg , tab_goodstype tgy where tg.goodstype=tgy.typeid and rownum <= 3 order by goodsid desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Goods> allgoods	= new ArrayList<Goods>();
		
		while(rs.next()){
			Goods g=new Goods();
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodspicture(rs.getString("goodspicture"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}
	/*
	 * 更新库存
	 */
	public boolean updateleft( String orderid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql1 = " select tod.goodsid,tod.shopnumber "
				+" from tab_orderdetail tod where tod.orderid=? ";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setString(1,orderid);
		ResultSet rs = ps1.executeQuery();
		
		String sql = " update tab_goods tg set tg.left=tg.left-? where tg.goodsid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		while(rs.next()){
			ps.setString(1,rs.getString("shopnumber"));
			ps.setString(2,rs.getString("goodsid"));
			ps.executeUpdate();
			
		}
		close(null, ps, null);
		close(rs, ps1, con);
		return true;
	}
	/*
	 * 查询订单中的商品信息
	 */
	public ArrayList<Goods> selectOrderGoods(String userid ,String orderid) throws SQLException {
		Connection con = getConnection();//与数据库建立连接
		String sql = " select tg.goodspicture , tg.goodsname , tg.goodsprice ,t.shopnumber ,"
				+" tg.goodsprice*t.shopnumber smallsum "
				+" from tab_goods tg , tab_orderdetail t , tab_order tod "
				+" where tg.goodsid=t.goodsid and "
				+" tod.userid=? and "
				+"tod.orderid=t.orderid and "
				+" tod.orderid=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, orderid);
		ResultSet rs=ps.executeQuery();
		ArrayList<Goods> allgoods	= new ArrayList<Goods>();
		while(rs.next()){
			Goods g=new Goods();
			g.setLeft(rs.getInt("shopnumber"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setSmallsum(rs.getDouble("smallsum"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}
	
	/*
	 * 查询买到的的商品信息
	 */
	public ArrayList<Goods> selectpaidGoods(String userid ) throws SQLException {
		Connection con = getConnection();//与数据库建立连接
		String sql = " select tg.goodspicture , tg.goodsname , tg.goodsprice ,t.shopnumber ,tod.totol, "
				+" tg.goodsprice*t.shopnumber smallsum "
				+" from tab_goods tg , tab_orderdetail t , tab_order tod "
				+" where tg.goodsid=t.goodsid and "
				+" tod.position=1 and "
				+" tod.userid=? and "
				+"tod.orderid=t.orderid order by tod.orderid desc ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		ArrayList<Goods> allgoods	= new ArrayList<Goods>();
		while(rs.next()){
			Goods g=new Goods();
			g.setTotol(rs.getDouble("totol"));
			g.setLeft(rs.getInt("shopnumber"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setSmallsum(rs.getDouble("smallsum"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}

	public ArrayList<Goods> selectnotpaidGoods(String userid ) throws SQLException {
		Connection con = getConnection();//与数据库建立连接
		String sql = " select tg.goodspicture , tg.goodsname , tg.goodsprice ,t.shopnumber ,tod.totol, "
				+ " tod.orderid, "
				+" tg.goodsprice*t.shopnumber smallsum "
				+" from tab_goods tg , tab_orderdetail t , tab_order tod "
				+" where tg.goodsid=t.goodsid and "
				+" tod.position=0 and "
				+" tod.userid=? and "
				+"tod.orderid=t.orderid order by tod.orderid desc ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		
		ResultSet rs=ps.executeQuery();
		ArrayList<Goods> allgoods	= new ArrayList<Goods>();
		while(rs.next()){
			Goods g=new Goods();
			g.setTotol(rs.getDouble("totol"));
			g.setOrderid(rs.getString("orderid"));
			g.setLeft(rs.getInt("shopnumber"));
			g.setGoodspicture(rs.getString("goodspicture"));
			g.setGoodsname(rs.getString("goodsname"));
			g.setGoodsprice(rs.getDouble("goodsprice"));
			g.setSmallsum(rs.getDouble("smallsum"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}}
