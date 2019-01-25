package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jingbao.dao.BaseDao;
import com.jingbao .daomain.User;

public class UserDao extends BaseDao{
	
	public boolean register(User u) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="insert into TAB_ADNIMISTRATOR values (?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1, getStringID());//通配符的值
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());

		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);
		if(n>0){
			return true;
		}
		return false;
	}
	public boolean login(User u) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="insert into TAB_ADNIMISTRATOR values (?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1, getStringID());//通配符的值
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);
		if(n>0){
			return true;
		}
		return false;
	}


//验证用户名是否可用
	public boolean isExit(User u) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="select *from TAB_ADNIMISTRATOR where username=?";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1, u.getUsername());
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()){//重名
			close(rs, ps, con);
			return false;
		}
		close(rs, ps, con);
		return true;
	}
	/*
	 * 是否重名
	 */
	public User isExit1(User u) throws SQLException{
		User use=null;
		Connection con=getConnection();//与数据库建立连接
		String sql="select *from TAB_ADNIMISTRATOR where username=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1,u.getUsername());
		ps.setString(2,u.getPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){//重名
			//close(rs, ps, con);
			use= new User();
			use.setId(rs.getString("id"));
			use.setUsername(rs.getString("username"));
			use.setPassword(rs.getString("password"));
			close(rs, ps, con);
			return use;
		}
		close(rs, ps, con);
		return use;
	}
	/**
	 * 查询所有管理员
	 * @throws SQLException 
	 */
	public ArrayList<User> getAlluser() throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="select *from TAB_ADNIMISTRATOR ";
		PreparedStatement ps=con.prepareStatement(sql);//预处LI 
		ResultSet rs=ps.executeQuery();
		ArrayList<User> alluser=new ArrayList<User>();
		//处理结果集
		while(rs.next()){
			User u=new User();
			u.setId(rs.getString("id"));
			
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			alluser.add(u);
			
		}
		close(rs, ps, con);
		return alluser;
	}
	

}

