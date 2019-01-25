package com.jingbao.action;

import java.io.IOException;
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
import com.jingbao.dao.GoodsDao;
import com.jingbao.dao.UserDao1;
import com.jingbao.daomain.Cart;
import com.jingbao.daomain.Goods;
import com.jingbao.daomain.User;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		if("put".equals(action)){
			putCart(request,response);
		}
		if("select".equals(action)){
			selectCart(request,response);
		}
		if("add".equals(action)){
			addCart(request,response);
		}
		if("delete".equals(action)){
			deleteCart(request,response);
		}
		if("clear".equals(action)){
			clearCart(request,response);
		}
		
	}

	protected void putCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		if(u1==null){
			MyUtil.requestDis(request, response, "user/login.jsp");
		}else{
			String userid=u1.getId();
			request.setAttribute("nolog", userid);
			String goodsid=request.getParameter("goodsid");
			String shopnumber=request.getParameter("shopnumber");
			Cart ct = new Cart();
			ct.setGoodsid(goodsid);
			ct.setUserid(userid);
			ct.setShopnumber(Integer.parseInt(shopnumber));
			
			CartDao cd = new CartDao();
			try {
				cd.putCart(ct);
				MyUtil.requestDis(request, response, "cart?action=select");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MyUtil.requestDis(request, response, "cart/cuowu.jsp");
			}
		}
		
		
	}
	protected void selectCart (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		String userid=u1.getId();
		
		CartDao cd = new CartDao();
		
		try {
			ArrayList<Cart> allct = cd.selectCart(userid);
			request.setAttribute("allcart", allct);
			//总计开始
			double sum = 0;
			for (int i = 0; i < allct.size(); i++) {
				Cart c = allct.get(i);
				sum = sum + c.getSmallsum();
			}
			request.setAttribute("totol", sum);
			//总计结束
			MyUtil.requestDis(request, response, "cart/cart.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
	}
	protected void addCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		String userid=u1.getId();
		
		String goodsid=request.getParameter("goodsid");
		String shopnumber=request.getParameter("shopnumber");
		Cart ct = new Cart();
		ct.setGoodsid(goodsid);
		ct.setUserid(userid);
		ct.setShopnumber(Integer.parseInt(shopnumber));
		
		CartDao cd = new CartDao();
		try {
			cd.addCart(userid,goodsid,shopnumber);
			MyUtil.requestDis(request, response, "cart?action=select");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
		
	}
	protected void deleteCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		String userid=u1.getId();
		
		String goodsid=request.getParameter("goodsid");
		String shopnumber=request.getParameter("shopnumber");
		Cart ct = new Cart();
		ct.setGoodsid(goodsid);
		ct.setUserid(userid);
		ct.setShopnumber(Integer.parseInt(shopnumber));
		
		CartDao cd = new CartDao();
		try {
			cd.deleteCart(userid,goodsid,shopnumber);
			MyUtil.requestDis(request, response, "cart?action=select");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
		
	}
	protected void clearCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		String userid=u1.getId();
		
		String goodsid=request.getParameter("goodsid");
		Cart ct = new Cart();
		ct.setGoodsid(goodsid);
		ct.setUserid(userid);
		
		CartDao cd = new CartDao();
		try {
			cd.clearCart(userid,goodsid);
			MyUtil.requestDis(request, response, "cart?action=select");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
		
	}	
	
	protected void clearAllCart1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		String userid=u1.getId();
		
		Cart ct = new Cart();
		ct.setUserid(userid);
		
		CartDao cd = new CartDao();
		try {
			cd.clearAllCart(userid);
			MyUtil.requestDis(request, response, "cart?action=select");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
		
	}
	
	
}

