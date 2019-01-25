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



import com.jingbao.dao.UserDao;
import com.jingbao.dao.UserDao1;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/userregister")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		String question=request.getParameter("question");
		String questionan=request.getParameter("questionan");
		String realname=request.getParameter("realname");
		String idnumber=request.getParameter("idnumber");
		String post=request.getParameter("post");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		
		
		
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
		
		
		
		
		PrintWriter out = response.getWriter();//输出流对象 向浏览器端写数据
		/*
		 * 密码不一致
		 */
		UserDao1 ud=new UserDao1();
		try {
			if(!ud.isExituser(u)){
				//重名
				request.setAttribute("msg", "用户名重名");
				RequestDispatcher dis = request.getRequestDispatcher("user/userregister.jsp");
				dis.forward(request, response);
				return;
			}
			
			if(ud.register(u)){//注册成功
				out.print("注册成功，3秒后去登录");
				response.setHeader("refresh", "3;url=user/login.jsp");
				//response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}else{//注册失败
				//转发
				RequestDispatcher dis = request.getRequestDispatcher("user/userregister.jsp");
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


