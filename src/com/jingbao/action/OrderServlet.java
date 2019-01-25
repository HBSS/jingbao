package com.jingbao.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.jingbao.dao.OrderDao;
import com.jingbao.dao.UserDao1;
import com.jingbao.daomain.Cart;
import com.jingbao.daomain.Goods;
import com.jingbao.daomain.Order;
import com.jingbao.daomain.Orderdetail;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		if("confirmorder".equals(action)){
			confirmOrder(request,response);
		}
		if("pay".equals(action)){
			payOrder(request,response);
		}
		if("paid".equals(action)){
			paidOrder(request,response);
		}
		if("cancel".equals(action)){
			cancelPay(request,response);
		}
		if("delete".equals(action)){
			deleteOrder(request,response);
		}
		if("beforpay".equals(action)){
			beforpayOrder(request,response);
		}
		if("select".equals(action)){
			selectAllOrder(request,response);
		}
		if("delete1".equals(action)){
			deleteOrder1(request,response);
		}
	}
	protected void confirmOrder (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession se=request.getSession();
		User1 u1=(User1)se.getAttribute("auser");
		String userid=u1.getId();
		Cart ct = new Cart();
		ct.setUserid(userid);
		UserDao1 ud= new UserDao1();
		CartDao cd = new CartDao();
		OrderDao od = new OrderDao();
		GoodsDao gd = new GoodsDao();
		try {
			User1 auser1 = ud.getAuser(userid);
			request.setAttribute("auser1", auser1);
			ArrayList<Cart> allct = cd.selectCart(userid);
			//总计开始
			double sum = 0;
			for (int i = 0; i < allct.size(); i++) {
				Cart c = allct.get(i);
				sum = sum + c.getSmallsum();
			}
			//总计结束
			Order or = new Order();
			or.setUserid(userid);
			or.setTotol(sum);
			
			String orderid =od.putOrders(or); 
			if(orderid != null){
				cd.clearAllCart(userid);
				request.setAttribute("orderid",orderid);
			  ArrayList<Goods> ordergoods = gd.selectOrderGoods(userid, orderid);
			  request.setAttribute("ordergoods", ordergoods);
			  double totol = or.getTotol();
			 request.setAttribute("totol", totol);
			MyUtil.requestDis(request, response, "cart/order.jsp");
			}
			else{
				MyUtil.requestDis(request, response, "cart/cuowu.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cart/cuowu.jsp");
		}
	}
	
	/**
	 * ss sssssssssssssssssssssssssss
	 * */
	
	protected void beforpayOrder (HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	
	String orderid=request.getParameter("orderid");
	request.setAttribute("orderid",orderid);
	MyUtil.requestDis(request, response, "cart/pay.jsp");
	
	
}
/**
 * 333333333333333333333333333333
 * */
	
	protected void payOrder (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	HttpSession se=request.getSession();
	User1 u1=(User1)se.getAttribute("auser");
	String userid=u1.getId();
	String orderid = request.getParameter("orderid");
	
	PrintWriter out = response.getWriter();//输出流对象 向浏览器端写数据
	
	OrderDao od = new OrderDao();
	GoodsDao gd = new GoodsDao();
	try {
		
		Order or = od.selectOrder(orderid);
		double ordersum=or.getTotol();
		se.setAttribute("ordersum", ordersum);
		od.paidOrder(orderid);
		gd.updateleft(orderid);
		out.print("付款成功，3秒后去已支付订单");
		response.setHeader("refresh", "3;url=order?action=paid&&orderid="+orderid);
		//MyUtil.requestDis(request, response, "order?action=paid");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MyUtil.requestDis(request, response, "cart/cuowu.jsp");
	}
	
}



	protected void paidOrder (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	HttpSession se=request.getSession();
	User1 u1=(User1)se.getAttribute("auser");
	String userid=u1.getId();
	String orderid = request.getParameter("orderid");
	System.out.println(orderid);
	
	GoodsDao gd = new GoodsDao();
	try {
		ArrayList<Goods>odt1=gd.selectpaidGoods(userid);
		request.setAttribute("odt1", odt1);
		
		MyUtil.requestDis(request, response, "cart/paidgoods.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MyUtil.requestDis(request, response, "cart/cuowu.jsp");
	}
	
}
	
	protected void cancelPay (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	HttpSession se=request.getSession();
	User1 u1=(User1)se.getAttribute("auser");
	String userid=u1.getId();
	String orderid = request.getParameter("orderid");
	
	OrderDao od = new OrderDao();
	GoodsDao gd = new GoodsDao();
	try {
		ArrayList<Goods>odt1=gd.selectpaidGoods(userid);
		request.setAttribute("odt1", odt1);
		
		request.setAttribute("orderid5",orderid);
		Order or1 = od.selectOrder(orderid);
		request.setAttribute("or1", or1);
		//double ordersum=or.getTotol();
		//se.setAttribute("ordersum1", ordersum);
		ArrayList<Goods> odt2=gd.selectnotpaidGoods(userid);
		request.setAttribute("odt2", odt2);
		MyUtil.requestDis(request, response, "cart/myorder.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MyUtil.requestDis(request, response, "cart/cuowu.jsp");
	}
	
}	
	protected void deleteOrder (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	String  orderid=request.getParameter("orderid");
	OrderDao od = new OrderDao();

	try {
		od.clearorder(orderid);
		MyUtil.requestDis(request, response, "order?action=cancel");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MyUtil.requestDis(request, response, "cart/cuowu.jsp");
	}
	
}	
	protected void selectAllOrder (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	OrderDao od = new OrderDao();

	try {
		ArrayList<Order> allorder = od.selectAllOrder();
		request.setAttribute("allorder", allorder);
		MyUtil.requestDis(request, response, "cart/allorder.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MyUtil.requestDis(request, response, "cart/cuowu.jsp");
	}
	
}	

	protected void deleteOrder1 (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	String  orderid=request.getParameter("orderid");
	OrderDao od = new OrderDao();

	try {
		od.clearorder(orderid);
		MyUtil.requestDis(request, response, "order?action=select");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MyUtil.requestDis(request, response, "cart/cuowu.jsp");
	}
}
}
