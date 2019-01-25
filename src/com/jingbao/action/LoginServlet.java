package com.jingbao.action;

import java.io.IOException;
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
import com.jingbao.dao.UserDao;
import com.jingbao.daomain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);//跳转到dopost
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
		
		String code=request.getParameter("code");//页面输入的验证码
		HttpSession se=request.getSession();
		String codese= (String)se.getAttribute("code");//session中存的验证码
		
		if(!code.equalsIgnoreCase(codese)){
			request.setAttribute("msg", "验证码错误");
			RequestDispatcher dis = request.getRequestDispatcher("admin/administratorlogin.jsp");
			dis.forward(request, response);
			return;
		}
		
		
		User u=new User();
		u.setUsername(username);
		u.setPassword(UserDao.md5(password));
		
		
		
	
		UserDao ud=new UserDao();
		try {
			User use=ud.isExit1(u);
			if(use!=null){
				//重名
				se.setAttribute("auser", use);//保存用户信息，方便跟踪用户
				GoodsDao gd=new GoodsDao();
				se.setAttribute("goodstype", gd.getAllGoodsType());
				
				MyUtil.requestDis(request, response, "admin/administratorMain.jsp");
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
			MyUtil.requestDis(request, response, "admin/administratorlogin.jsp");
			//RequestDispatcher dis = request.getRequestDispatcher("/error500.jsp");
			//dis.forward(request, response);
			return;
		}
	}
}
