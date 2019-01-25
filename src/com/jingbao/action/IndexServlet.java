package com.jingbao.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jingbao.common.MyUtil;
import com.jingbao.dao.GonggaoDao;
import com.jingbao.dao.GoodsDao;
import com.jingbao.dao.SaveDao;
import com.jingbao.daomain.Gonggao;
import com.jingbao.daomain.Goods;
import com.jingbao.daomain.GoodsType;
import com.jingbao.daomain.Save;
import com.jingbao.daomain.User;

import oracle.net.aso.e;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		if("select".equals(action)){
			selectGoodstype(request, response);
			selectNewgoods(request,response);
			
			selectGonggao(request,response);
		}
		if("showselect".equals(action)){
			selectGoodstype1(request, response);
		}
		if("selectshowgoods".equals(action)){
			selectGoodstype2(request, response);
		}
	}
			
	protected void selectGoodstype(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		GoodsDao gd = new GoodsDao();
		try {
			ArrayList<GoodsType> goodstype = gd.getAllGoodsType();
			request.setAttribute("goodstype", goodstype);
			//MyUtil.requestDis(request, response, "user/usermain.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	
	
	protected void selectGoodstype1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		GoodsDao gd = new GoodsDao();
		try {
			ArrayList<GoodsType> goodstype = gd.getAllGoodsType();
			request.setAttribute("goodstype", goodstype);
			MyUtil.requestDis(request, response, "showselect.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	
	
	
	protected void selectGoodstype2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		GoodsDao gd = new GoodsDao();
		try {
			ArrayList<GoodsType> goodstype = gd.getAllGoodsType();
			request.setAttribute("goodstype", goodstype);
			MyUtil.requestDis(request, response, "showGoods.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}



	protected void selectNewgoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		GoodsDao gd = new GoodsDao();
		try {
			ArrayList<Goods> allgoods= gd.getAllGoods1();
			request.setAttribute("allgoods", allgoods);
			//MyUtil.requestDis(request, response, "user/usermain.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}

	protected void selectGonggao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		GonggaoDao gd = new GonggaoDao();
		try {
			ArrayList<Gonggao> allgonggao = gd.getAllGonggao1();
			request.setAttribute("allgonggao", allgonggao);
			MyUtil.requestDis(request, response, "user/usermain.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}

}


