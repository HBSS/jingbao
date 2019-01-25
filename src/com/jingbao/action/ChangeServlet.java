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

import com.jingbao.common.MyUtil;
import com.jingbao.dao.UserDao1;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/change")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		
		
		
		
		
		User1 u=new User1();
		u.setUsername(username);
		u.setPassword(UserDao1.md5(password));
		
		if(!password.equals(repassword)){
			request.setAttribute("msg","密码不一致，请重新输入！" );
			RequestDispatcher dis = request.getRequestDispatcher("user/passwordchange.jsp");
			dis.forward(request, response);
			return;
			
		}
	
		
		
		PrintWriter out = response.getWriter();//输出流对象 向浏览器端写数据
		/*
		 * 密码不一致
		 */
		UserDao1 ud=new UserDao1();
		try {
			
			if(ud.changepassword(u)){//修改成功
				out.print("修改成功，3秒后去登录");
				response.setHeader("refresh", "3;url=user/login.jsp");
				//response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}else{//注册失败
				//转发
				out.print("修改失败，返回上一步");
				response.setHeader("refresh", "2;url=user/forget.jsp");
				//response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
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
