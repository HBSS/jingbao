package com.jingbao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import java.util.ArrayList;

import com.jingbao.dao.BaseDao;
import com.jingbao.daomain.User1;



public class UserDao1 extends BaseDao {
	
	public boolean register(User1 u) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="insert into TAB_user1 values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1, getStringID());//通配符的值
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());
		ps.setString(4, u.getQuestion());
		ps.setString(5, u.getQuestionan());
		ps.setString(6, u.getRealname());
		ps.setString(7, u.getIdnumber());
		ps.setString(8, u.getPost());
		ps.setString(9, u.getAddress());
		ps.setString(10, u.getPhone());
		ps.setString(11, u.getEmail());
		

		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);
		if(n>0){
			return true;
		}
		return false;
	}
	public boolean login(User1 u) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="insert into TAB_user1 values (?,?,?)";
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

	public boolean isExituser(User1 u) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="select *from TAB_user1 where username=?";
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
	public User1 isExit1user(User1 u) throws SQLException{
		User1 use=null;
		Connection con=getConnection();//与数据库建立连接
		String sql="select *from TAB_user1 where username=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1,u.getUsername());
		ps.setString(2,u.getPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){//重名
			//close(rs, ps, con);
			use= new User1();
			use.setId(rs.getString("id"));
			use.setUsername(rs.getString("username"));
			use.setPassword(rs.getString("password"));
			close(rs, ps, con);
			return use;
		}
		close(rs, ps, con);
		return use;
	}

	/*
	 * 密保问题是否正确
	 */
	public User1 isQuestionTrue(String username) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="select * from TAB_user1 where username=? ";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1, username);
		
		
		ResultSet rs=ps.executeQuery();
		User1 use=new User1();
		if(rs.next()){
			use.setUsername(rs.getString("username"));
			use.setQuestion(rs.getString("question"));
			use.setQuestionan(rs.getString("questionan"));
		}
		close(rs, ps, con);
		return use;
		
	}
	/*
	 * 修改密码
	 */
	
	public boolean  changepassword(User1 u) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_user1 set "+
		" password=? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		//替换通配符的值
		ps.setString(1, u.getPassword());
		
		
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
	}
	
	
	/*
	 * 修改个人信息
	 */
	public boolean updateuser(User1 u) throws SQLException{
		
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_user1 set "+
		" username=?, "+
		" question=?, "+
		" questionan=?, "+
		" realname=?, "+
		" idnumber=?, "+
		" post=?, "+
		" address=?, "+
		" phone=?, "+
		" email=? "+
		" where id=? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		//替换通配符的值
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getQuestion());
		ps.setString(3, u.getQuestionan());
		ps.setString(4, u.getRealname());
		ps.setString(5, u.getIdnumber());
		ps.setString(6, u.getPost());
		ps.setString(7, u.getAddress());
		ps.setString(8, u.getPhone());
		ps.setString(9, u.getEmail());
		ps.setString(10, u.getId());
		
		
		
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
		
		
		
		
	}
	
	
	/**
	 * 查询所有用户
	 * @throws SQLException 
	 */
	public ArrayList<User1> getAlluser1() throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="select *from TAB_user1 ";
		PreparedStatement ps=con.prepareStatement(sql);//预处LI 
		ResultSet rs=ps.executeQuery();
		ArrayList<User1> alluser=new ArrayList<User1>();
		//处理结果集
		while(rs.next()){
			User1 u1=new User1();
			u1.setId(rs.getString("id"));
			u1.setUsername(rs.getString("username"));
			u1.setPassword(rs.getString("password"));
			u1.setQuestion(rs.getString("question"));
			u1.setQuestionan(rs.getString("questionan"));
			u1.setRealname(rs.getString("realname"));
			u1.setIdnumber(rs.getString("idnumber"));
			u1.setPost(rs.getString("post"));
			u1.setAddress(rs.getString("address"));
			u1.setPhone(rs.getString("phone"));
			u1.setEmail(rs.getString("email"));
			alluser.add(u1);
			
		}
		close(rs, ps, con);
		return alluser;
	}
	
	
	
	/**
	 * 添加用户
	 */
	public boolean adduser(User1 u) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql="insert into TAB_user1 values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);//预处理SQL
		ps.setString(1, getStringID());//通配符的值
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());
		ps.setString(4, u.getQuestion());
		ps.setString(5, u.getQuestionan());
		ps.setString(6, u.getRealname());
		ps.setString(7, u.getIdnumber());
		ps.setString(8, u.getPost());
		ps.setString(9, u.getAddress());
		ps.setString(10, u.getPhone());
		ps.setString(11, u.getEmail());

		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
		
	}
	
	

	
	
	
	public ArrayList<User1> getAllUser1ByUserID(String userid, int pageSize, int page) throws SQLException{
		Connection con=getConnection();//与数据库建立连接
		String sql="select *from TAB_user1 ";
		PreparedStatement ps=con.prepareStatement(sql);//预处LI 
		ResultSet rs=ps.executeQuery();
		ArrayList<User1> allusers=new ArrayList<User1>();
		//处理结果集
		while(rs.next()){
			User1 u1=new User1();
			u1.setId(rs.getString("id"));
			u1.setUsername(rs.getString("username"));
			u1.setPassword(rs.getString("password"));
			u1.setQuestion(rs.getString("question"));
			u1.setQuestionan(rs.getString("questionan"));
			u1.setRealname(rs.getString("realname"));
			u1.setIdnumber(rs.getString("idnumber"));
			u1.setPost(rs.getString("post"));
			u1.setAddress(rs.getString("address"));
			u1.setPhone(rs.getString("phone"));
			u1.setEmail(rs.getString("email"));
			allusers.add(u1);
			
		}
		close(rs, ps, con);
		return allusers;
	}
	
	
	
	/**
	 * 查询详情
	 * @param goodsid
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<User1> getAllUsers() throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_User1 ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<User1> allusers	= new ArrayList<User1>();
		
		while(rs.next()){
			User1 u1=new User1();
			u1.setId(rs.getString("id"));
			u1.setUsername(rs.getString("username"));
			u1.setPassword(rs.getString("password"));
			u1.setQuestion(rs.getString("question"));
			u1.setQuestionan(rs.getString("questionan"));
			u1.setRealname(rs.getString("realname"));
			u1.setIdnumber(rs.getString("idnumber"));
			u1.setPost(rs.getString("post"));
			u1.setAddress(rs.getString("address"));
			u1.setPhone(rs.getString("phone"));
			u1.setEmail(rs.getString("email"));
			allusers.add(u1);
			
		}
		//释放资源
		close(rs, ps, con);
		return allusers;
	}
	
	
	
		//详情
		public User1 getAuser(String userid) throws SQLException{
			User1 u1=null;
			Connection con = getConnection();//与数据库建立连接
			String sql = " select * from tab_user1 where id=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				u1=new User1();
				u1.setId(rs.getString("id"));
				u1.setUsername(rs.getString("username"));
				u1.setPassword(rs.getString("password"));
				u1.setQuestion(rs.getString("question"));
				u1.setQuestionan(rs.getString("questionan"));
				u1.setRealname(rs.getString("realname"));
				u1.setIdnumber(rs.getString("idnumber"));
				u1.setPost(rs.getString("post"));
				u1.setAddress(rs.getString("address"));
				u1.setPhone(rs.getString("phone"));
				u1.setEmail(rs.getString("email"));
				
			}
			
			return u1;
		}
	/**
	/**
	
	/**
	 * 修改商品
	 */
	public boolean updateUsers(User1 u) throws SQLException {
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_user1 set "+
				" question=?, "+
				" questionan=?, "+
				" realname=?, "+
				" idnumber=?, "+
				" post=?, "+
				" address=?, "+
				" phone=?, "+
				" email=? ";
				
				PreparedStatement ps = con.prepareStatement(sql);
				//替换通配符的值
				ps.setString(1, u.getQuestion());
				ps.setString(2, u.getQuestionan());
				ps.setString(3, u.getRealname());
				ps.setString(4, u.getIdnumber());
				ps.setString(5, u.getPost());
				ps.setString(6, u.getAddress());
				ps.setString(7, u.getPhone());
				ps.setString(8, u.getEmail());
				
				
				
				int n=ps.executeUpdate();//n代表更新行数
				close(null,ps,con);//关闭释放资源
				if(n>0){
					return true;
				}
				return false;
	}
	public boolean deleteUsersFromAll(String[] ids) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " delete from tab_user1 where id in ( ";
		for (int i = 0; i < ids.length; i++) {
			sql = sql + ids[i] + ",";
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
	public ArrayList<User1> getAllUsersByUserID(String userid) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = "select * from tab_user1 ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<User1> allusers	= new ArrayList<User1>();
		

		while(rs.next()){
			User1 u1=new User1();
			u1.setId(rs.getString("id"));
			u1.setUsername(rs.getString("username"));
			u1.setPassword(rs.getString("password"));
			u1.setQuestion(rs.getString("question"));
			u1.setQuestionan(rs.getString("questionan"));
			u1.setRealname(rs.getString("realname"));
			u1.setIdnumber(rs.getString("idnumber"));
			u1.setPost(rs.getString("post"));
			u1.setAddress(rs.getString("address"));
			u1.setPhone(rs.getString("phone"));
			u1.setEmail(rs.getString("email"));
			
			allusers.add(u1);
		}
		//释放资源
		close(rs, ps, con);
		return allusers;
	}
	
	public boolean updatesUser(User1 u) throws SQLException{
		Connection con = getConnection();//与数据库建立连接
		String sql = " update tab_user1 set "+
		" question=?, "+
		" questionan=?, "+
		" realname=?, "+
		" idnumber=?, "+
		" post=?, "+
		" address=?, "+
		" phone=?, "+
		" email=? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		//替换通配符的值
		ps.setString(1, u.getQuestion());
		ps.setString(2, u.getQuestionan());
		ps.setString(3, u.getRealname());
		ps.setString(4, u.getIdnumber());
		ps.setString(5, u.getPost());
		ps.setString(6, u.getAddress());
		ps.setString(7, u.getPhone());
		ps.setString(8, u.getEmail());
		
		
		
		int n=ps.executeUpdate();//n代表更新行数
		close(null,ps,con);//关闭释放资源
		if(n>0){
			return true;
		}
		return false;
		
		
		
		
		
	}
	
//	public static void main(String args[]) throws SQLException{
//		UserDao1 dao=new UserDao1();
//		User1 u=new User1();
//		u.setId("1111");
//		u.setUsername("2222");
//		u.setPassword("3333");
//		u.setQuestion("4444");
//		u.setQuestionan("5555");
//		u.setRealname("6666");
//		u.setIdnumber("7777");
//		u.setPost("8888");
//		u.setAddress("9999");
//		u.setPhone("10101010");
//		System.out.println(dao.register(u));
//	}
	
}
