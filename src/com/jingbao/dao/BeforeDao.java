package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jingbao.daomain.Goods;

public class BeforeDao extends BaseDao {
	public ArrayList<Goods> conditionSelect(Goods gg, int pageSize, int page) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		
		StringBuffer find_sql = new StringBuffer(" select * from tab_goods tg, tab_goodstype tgy "
				+ " where tg.userid=? and tg.goodstype=tgy.typeid ");
		
		ArrayList<String> param = new ArrayList<String>();
		
		param.add(gg.getUserid());
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
			g.setUserid(rs.getString("userid"));
			g.setLeft(rs.getInt("left"));
			g.setDescription(rs.getString("description"));
			allgoods.add(g);
		}
		//释放资源
		close(rs, ps, con);
		return allgoods;
	}
}
