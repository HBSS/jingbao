package com.jingbao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jingbao.common.MyUtil;
import com.jingbao.dao.CartDao;
import com.jingbao.dao.SaveDao;
import com.jingbao.daomain.Cart;
import com.jingbao.daomain.Save;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("add".equals(action)){
			addSave(request, response);
		}
		if("select".equals(action)){
			selectSave(request, response);
		}
		if("delete".equals(action)){
			deleteSave(request, response);
		}
	}
	protected void addSave(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		if(u1==null){
			MyUtil.requestDis(request, response, "user/login.jsp");
		}else{
			String userid=u1.getId();
			request.setAttribute("nolog", userid);
			String goodsid=request.getParameter("goodsid");
			Save sv = new Save();
			sv.setGoodsid(goodsid);
			sv.setUserid(userid);
			
			PrintWriter out = response.getWriter();
			
			SaveDao sd = new SaveDao();
			try {
				sd.addSave(sv);
				out.print("<script language='javascript'>alert('收藏成功！');</script>");
				out.print("<script language='javascript'>history.go(-1);</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MyUtil.requestDis(request, response, "cart/cuowu.jsp");
			}
		}
		
		
	}
	protected void selectSave(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		
		String userid=u1.getId();
		
		SaveDao sd = new SaveDao();
		try {
			ArrayList<Save> allsave = sd.selectSave(userid);
			request.setAttribute("allsave", allsave);
			MyUtil.requestDis(request, response, "save/save.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
	}
	protected void deleteSave(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		String userid=u1.getId();
		
		String goodsid=request.getParameter("goodsid");
		Save sv = new Save();
		sv.setGoodsid(goodsid);
		sv.setUserid(userid);
		
		SaveDao sd = new SaveDao();
		try {
			sd.deleteSave(userid,goodsid);
			MyUtil.requestDis(request, response, "save?action=select");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
		
	}
	

}
