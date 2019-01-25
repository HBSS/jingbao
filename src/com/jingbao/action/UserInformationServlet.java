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
import javax.servlet.http.Part;

import com.jingbao.common.MyUtil;
import com.jingbao.dao.BaseDao;
import com.jingbao.dao.GoodsDao;
import com.jingbao.dao.UserDao1;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class UserInformationServlet
 */
@WebServlet("/userinformation")
public class UserInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformationServlet() {
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
		
		//从表单获得用户信息
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

	
		
		
	}
	
