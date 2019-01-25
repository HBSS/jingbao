package com.jingbao.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jingbao.common.MyUtil;
import com.jingbao.dao.GoodsDao;
import com.jingbao.dao.UserDao1;
import com.jingbao.daomain.Goods;
import com.jingbao.daomain.User;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class AlluserServlet
 */
@WebServlet("/alluser1")
public class Alluser1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alluser1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		//查询所有用户
		//添加用户信息
		if("adduser".equals(action)){
			addUser1(request,response);
		}
		//修改用户信息
		//修改商品
				
		if("updates".equals(action)){
			updatesusers(request,response);
		}
				
		//删除商品
		if("deletes".equals(action)){
			deleteUsersFromAll(request,response);
		}
		//查询用户
		if("select".equals(action)){
			selectUsers(request, response);
		}
		//删除先查询
		if("selects".equals(action)){
			selectAllUsers(request, response);
		}
		//修改先查询
		if("selectitem".equals(action)){
			selectAllUsersItem(request, response);
		}
		//详情和修改查询
		if("detail".equals(action)){
			selectAuser(request,response);
		}
		if("details".equals(action)){
		selectAusersFromAll(request,response);
		}
		
	}
	
	protected void addUser1(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String question=request.getParameter("question");
		String questionan=request.getParameter("questionan");
		String realname=request.getParameter("realname");
		String idnumber=request.getParameter("idnumber");
		String post=request.getParameter("post");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		//封装到商品对象中

		User1 u=new User1();
		u.setUsername(username);
		u.setPassword(UserDao1.md5(password));
		u.setQuestion(question);
		u.setQuestionan(questionan);
		u.setRealname(realname);
		u.setIdnumber(idnumber);
		u.setPost(post);
		u.setAddress(address);
		u.setPhone(phone);
		u.setEmail(email);
		
		UserDao1 ud=new UserDao1();
		
		try {
			
			if(ud.adduser(u)){//成功
				MyUtil.requestDis(request, response, "alluser1?action=select");
			}else{//失败
				MyUtil.requestDis(request, response, "admin/adduser.jsp");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
		}
		//对应的信息保存到数据库结束
	}
	
	protected void updateUser1(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		
		//对应的信息保存到数据库中开始
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;");
		response.setCharacterEncoding("utf-8");
		String question=request.getParameter("question");
		String questionan=request.getParameter("questionan");
		String realname=request.getParameter("realname");
		String idnumber=request.getParameter("idnumber");
		String post=request.getParameter("post");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		
		
		
		User1 u=new User1();
		u.setQuestion(question);
		u.setQuestionan(questionan);
		u.setRealname(realname);
		u.setIdnumber(idnumber);
		u.setPost(post);
		u.setAddress(address);
		u.setPhone(phone);
		u.setEmail(email);
		
		PrintWriter out = response.getWriter();//输出流对象 向浏览器端写数据
		
		UserDao1 ud=new UserDao1();
		
		try {
			
			if(ud.updateuser(u)){
				out.print("修改成功！");
				response.setHeader("refresh", "1;url=user/updateuser.jsp");
				//response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}else{//注册失败
				//转发
				RequestDispatcher dis = request.getRequestDispatcher("user/updateuser.jsp");
				dis.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//转发
			RequestDispatcher dis = request.getRequestDispatcher("admin/cuowu.jsp");
			dis.forward(request, response);
		}
	}

	protected void deleteUser1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userids[]=request.getParameterValues("del");
		UserDao1 ud=new UserDao1();
		try {
			ud.deleteUsersFromAll(userids);
			MyUtil.requestDis(request, response, "alluser1?action=all");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}

	
	
	
	
	
	/**
	 *查询用户
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void selectUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession se = request.getSession();
		User u = (User)se.getAttribute("auser");
		String userid = u.getId();
		UserDao1 ud = new UserDao1();
		
		String page = request.getParameter("page");
		if(page == null){
			page = "1";
		}
		int intPage = Integer.parseInt(page);
		
		try {
			ArrayList<User1> allusers = ud.getAllUser1ByUserID(userid,3,intPage);//3代表每一页显示的行数
			int maxPage = ud.getUserListPageCount("tab_user1",3);//最大页数
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("allusers", allusers);
			MyUtil.requestDis(request, response, "admin/alluser1.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
		}
	}
	
	
	
	/*
	 * 删除先查询
	 */
	protected void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession se = request.getSession();
		User u = (User)se.getAttribute("auser");
		String userid = u.getId();
		UserDao1 ud = new UserDao1();
		
		String page = request.getParameter("page");
		if(page == null){
			page = "1";
		}
		int intPage = Integer.parseInt(page);
		
		try {
			ArrayList<User1> alluser = ud.getAllUser1ByUserID(userid,3,intPage);//3代表每一页显示的行数
			int maxPage = ud.getUserListPageCount("tab_user1",3);//最大页数
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("alluser", alluser);
			MyUtil.requestDis(request, response, "admin/deleteuser.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	
	/*
	 * 修改先查询
	 */
	protected void selectAllUsersItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession se = request.getSession();
		User u = (User)se.getAttribute("auser");
		String userid = u.getId();
		UserDao1 ud = new UserDao1();
		
		String page = request.getParameter("page");
		
		if(page == null){
			page = "1";
		}
		int intPage = Integer.parseInt(page);
		
		try {
			
			ArrayList<User1> allusers = ud.getAllUser1ByUserID(userid,3,intPage);//3代表每一页显示的行数
			int maxPage = ud.getUserListPageCount("tab_user1",3);//最大页数
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("allusers", allusers);
			
			MyUtil.requestDis(request, response, "admin/updateUsersByDetail.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	/**
	 * 详情，修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectAuser(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
		String goodsid=request.getParameter("goodsid");
		String flag=request.getParameter("flag");
		GoodsDao gd=new GoodsDao();
		try {
			Goods goods=gd.getAGoods(goodsid);
			request.setAttribute("goods", goods);
			if("update".equals(flag)){
			MyUtil.requestDis(request, response, "goods/update.jsp");
			}else{//return;
				MyUtil.requestDis(request, response, "goods/detail.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			//return;
		}
	}
	protected void selectAusersFromAll(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
		String id=request.getParameter("id");
		String flag=request.getParameter("flag");
		UserDao1 ud=new UserDao1();
		try {
			User1 user=ud.getAuser(id);
			request.setAttribute("user", user);
			if("updates".equals(flag)){
			MyUtil.requestDis(request, response, "admin/updates.jsp");
			}else{//return;
				MyUtil.requestDis(request, response, "admin/detail.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			//return;
		}
	}
	/**
	 * 删除商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void deleteUsersFromAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userids[]=request.getParameterValues("del");
		UserDao1 gd=new UserDao1();
		try {
			gd.deleteUsersFromAll(userids);
			MyUtil.requestDis(request, response, "alluser1?action=selects");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}

	/**
	 * 修改商品
	 * @param request
	 * @param response
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws ServletException
	 */
	
	protected void updatesusers(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		//对应的信息保存到数据库中开始
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;");
				response.setCharacterEncoding("utf-8");
				String id=request.getParameter("id");
				String username=request.getParameter("username");
				String question=request.getParameter("question");
				String questionan=request.getParameter("questionan");
				String realname=request.getParameter("realname");
				String idnumber=request.getParameter("idnumber");
				String post=request.getParameter("post");
				String address=request.getParameter("address");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				
				
				
				
				User1 u=new User1();
				u.setId(id);
				u.setUsername(username);
				u.setQuestion(question);
				u.setQuestionan(questionan);
				u.setRealname(realname);
				u.setIdnumber(idnumber);
				u.setPost(post);
				u.setAddress(address);
				u.setPhone(phone);
				u.setEmail(email);
				
				PrintWriter out = response.getWriter();//输出流对象 向浏览器端写数据
				
				UserDao1 ud=new UserDao1();
				
				try {
					
					if(ud.updateuser(u)){
						out.print("修改成功！");
						response.setHeader("refresh", "1;url=alluser1?action=select");
						//response.sendRedirect(request.getContextPath()+"/login.jsp");
						return;
					}else{//注册失败
						//转发
						out.print("修改失败！");
						RequestDispatcher dis = request.getRequestDispatcher("admin/updates.jsp");
						dis.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//转发
					RequestDispatcher dis = request.getRequestDispatcher("admin/cuowu.jsp");
					dis.forward(request, response);
				}
	}

	
	
}
