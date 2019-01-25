package com.jingbao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String code=request.getParameter("code");//页面输入的验证码
		HttpSession se=request.getSession();
		String codese= (String)se.getAttribute("code");//session中存的验证码
		
		if(!code.equalsIgnoreCase(codese)){
			request.setAttribute("msg", "验证码错误");
			RequestDispatcher dis = request.getRequestDispatcher("user/login.jsp");
			dis.forward(request, response);
			return;
		}
		
		
		User1 u=new User1();
		u.setUsername(username);
		u.setPassword(UserDao1.md5(password));
		
		PrintWriter out = response.getWriter();
		
	
		UserDao1 ud=new UserDao1();
		try {
			User1 use=ud.isExit1user(u);
			if(use!=null){
				//重名
				se.setAttribute("auser", use);//保存用户信息，方便跟踪用户
				GoodsDao gd=new GoodsDao();
				se.setAttribute("goodstype", gd.getAllGoodsType());
				out.print("<script language='javascript'>history.go(-2);</script>");
				response.setHeader("refresh", "1");
				//MyUtil.requestDis(request, response, "user/usermain.jsp");
				//request.setAttribute("msg", "用户名不存在");
				//RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
				//dis.forward(request, response);
				return;
			}//else
			//{
			//	RequestDispatcher dis = request.getRequestDispatcher("/main.jsp");
			//	dis.forward(request, response);
			//	return;
			//}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//转发
			MyUtil.requestDis(request, response, "user/login.jsp");
			//RequestDispatcher dis = request.getRequestDispatcher("/error500.jsp");
			//dis.forward(request, response);
			return;
		}
	}
	}


