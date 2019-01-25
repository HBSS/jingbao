package com.jingbao.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jingbao.common.MyUtil;
import com.jingbao.dao.GoodsDao;
import com.jingbao.dao.UserDao1;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class ForgetServlet
 */
@WebServlet("/forget")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetServlet() {
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
		String question=request.getParameter("question");
		String questionan=request.getParameter("questionan");
		
		
		User1 u=new User1();
		u.setUsername(username);
		u.setQuestion(question);
		u.setQuestionan(questionan);
		
		
		
		UserDao1 ud=new UserDao1();
		
		try {
			User1 use=ud.isQuestionTrue(u.getUsername());
			
			if(question.equals(use.getQuestion())&&questionan.equals(use.getQuestionan())){
				//重名
				MyUtil.requestDis(request, response, "user/passwordchange.jsp");
				
				//RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
				//dis.forward(request, response);
				return;
			}else
			{
				request.setAttribute("msg", "密保信息有误！");
				MyUtil.requestDis(request, response, "user/forget.jsp");

				
			//	RequestDispatcher dis = request.getRequestDispatcher("/main.jsp");
			//	dis.forward(request, response);
				return;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", "用户名不存在！");
			e.printStackTrace();
			//转发
			MyUtil.requestDis(request, response, "user/forget.jsp");
			//RequestDispatcher dis = request.getRequestDispatcher("/error500.jsp");
			//dis.forward(request, response);
			return;
		}
	}
		
	}

