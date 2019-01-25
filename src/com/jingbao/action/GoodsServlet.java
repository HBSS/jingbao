package com.jingbao.action;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jingbao.common.MyUtil;
import com.jingbao.dao.BaseDao;
import com.jingbao.dao.GoodsDao;
import com.jingbao.daomain.Goods;
import com.jingbao.daomain.GoodsType;
import com.jingbao.daomain.User;
import com.jingbao.daomain.User1;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/goods")
@MultipartConfig(maxFileSize = 20*1024*1024)//设置上传文件的最大值
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//添加商品
		if("add".equals(action)){
			addGoods(request, response);
		}
		//修改商品
				
		if("updates".equals(action)){
			updatesGoods(request,response);
		}
				
		//删除商品
		if("deletes".equals(action)){
			deleteGoodsFromAll(request,response);
		}
		//查询商品
		if("select".equals(action)){
			selectGoods(request, response);
		}
		//删除先查询
		if("selects".equals(action)){
			selectAllGoods(request, response);
		}
		//修改先查询
		if("selectitem".equals(action)){
			selectAllGoodsItem(request, response);
		}
		//详情和修改查询
		if("detail".equals(action)){
			selectAgoods(request,response);
		}
		if("details".equals(action)){
		selectAgoodsFromAll(request,response);
		}
		if("condition".equals(action)){
			conditionSelect(request,response);
			}
		if("showgoods".equals(action)){
			showGoods(request,response);
			}
		//搜索查询
		
	}
	
	

	protected void showGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String goodsid=request.getParameter("goodsid");
		GoodsDao gd = new GoodsDao();
		try {
			Goods goods=gd.showAGoods(goodsid);
			request.setAttribute("goods", goods);
			MyUtil.requestDis(request, response, "index?action=selectshowgoods");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "cuowu.jsp");
		}
		
	}
	
	/**
	 * 添加商品
	 * @throws ServletException 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	protected void addGoods(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		//上传文件开始
		//指定上传的文件保存到服务器的uploadFiles目录中
		File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		
		//获得Part集合
		Collection<Part> parts = request.getParts();
		Iterator<Part> ite = parts.iterator();
		String newFileName[] = new String[5];
		int i = 0;
		while(ite.hasNext()){
			Part p = ite.next();
			if(p != null &&p.getName().contains("goodspicture")){
				
				//获得原始文件名
				String oldName = MyUtil.getFileName(p);
			
				if(oldName != null){
					newFileName[i] = BaseDao.getStringID() + oldName.substring(oldName.lastIndexOf("."));
					//上传到服务器的uploadFiles目录中
					p.write(uploadFileDir + File.separator + newFileName[i]);
				}
				i++;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (int j = 0; j < newFileName.length; j++) {
			System.out.println(newFileName[j]  + ";;;;;;;;;;;;;;;;" + j);
		}

		//上传文件结束
		//对应的信息保存到数据库中开始
		//从表单获得商品信息
		String goodsid = request.getParameter("goodsid");
		String goodsname = request.getParameter("goodsname");
		String goodstype = request.getParameter("goodstype");
		String goodsprice = request.getParameter("goodsprice");
		String left=request.getParameter("left");
		String description=request.getParameter("description");
		
		HttpSession se = request.getSession();
		User u = (User)se.getAttribute("auser");
		String userid = u.getId();
		
		//封装到商品对象中
		Goods g = new Goods();
		g.setGoodsid(goodsid);
		g.setGoodsname(goodsname);
		g.setGoodspicture(newFileName[0]);
		g.setGoodspicture1(newFileName[1]);
		g.setGoodspicture2(newFileName[2]);
		g.setGoodspicture3(newFileName[3]);
		g.setGoodspicture4(newFileName[4]);
		g.setGoodsprice(Double.parseDouble(goodsprice));
		g.setGoodstype(goodstype);
		g.setUserid(userid);
		g.setDescription(description);
		g.setLeft(Integer.parseInt(left));
		
		GoodsDao gd = new GoodsDao();
		try {
			if(gd.addGoods(g)){//成功
				MyUtil.requestDis(request, response, "goods?action=selects");
				System.out.println("aaa");
			}else{//失败
				MyUtil.requestDis(request, response, "goods/addgoods.jsp");
				System.out.println("bbb");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			System.out.println("ccc");
		}
		//对应的信息保存到数据库中结束
	}
	/**
	 *查询商品
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void selectGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession se = request.getSession();
		User u = (User)se.getAttribute("auser");
		String userid = u.getId();
		GoodsDao gd = new GoodsDao();
		
		String page = request.getParameter("page");
		if(page == null){
			page = "1";
		}
		int intPage = Integer.parseInt(page);
		
		try {
			ArrayList<Goods> allgoods = gd.getAllGoodsByUserID(userid,5,intPage);//3代表每一页显示的行数
			int maxPage = gd.getUserListPageCount("tab_goods",5);//最大页数
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("allgoods", allgoods);
			MyUtil.requestDis(request, response, "goods/selectGoodsByUserID.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
		}
	}
	
	/*
	 * 搜索出商品
	 */
	
	
	
	protected void selectAllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession se = request.getSession();
		User u = (User)se.getAttribute("auser");
		String userid = u.getId();
		GoodsDao gd = new GoodsDao();
		
		String page = request.getParameter("page");
		if(page == null){
			page = "1";
		}
		int intPage = Integer.parseInt(page);
		
		try {
			ArrayList<Goods> allgoods = gd.getAllGoodsByUserID(userid,5,intPage);//3代表每一页显示的行数
			int maxPage = gd.getUserListPageCount("tab_goods",5);//最大页数
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("allgoods", allgoods);
			MyUtil.requestDis(request, response, "goods/deletegoods.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	
	protected void  conditionSelect( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		GoodsDao gd = new GoodsDao();
		
		String goodsname=request.getParameter("goodsname");
		String goodstype=request.getParameter("goodstype");
		System.out.println("goodsname:" + goodsname);
		System.out.println("goodstype:" + goodstype);
		Goods g=new Goods();
		g.setGoodsname(goodsname);
		g.setGoodstype(goodstype);
		
		String page = request.getParameter("page");
		if(page == null){
			page = "1";
		}
		int intPage = Integer.parseInt(page);
		
		try {
			ArrayList<Goods> allgoods = gd.conditionSelect(g,5,intPage);//3代表每一页显示的行数
			int maxPage = gd.getUserListPageCount("tab_goods",5);//最大页数
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("allgoods", allgoods);
			MyUtil.requestDis(request, response, "index?action=showselect");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}

	
	protected void selectAllGoodsItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession se = request.getSession();
		User u = (User)se.getAttribute("auser");
		String userid = u.getId();
		GoodsDao gd = new GoodsDao();
		
		String page = request.getParameter("page");
		if(page == null){
			page = "1";
		}
		int intPage = Integer.parseInt(page);
		
		try {
			ArrayList<Goods> allgoods = gd.getAllGoodsByUserID(userid,5,intPage);//3代表每一页显示的行数
			int maxPage = gd.getUserListPageCount("tab_goods",5);//最大页数
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("allgoods", allgoods);
			MyUtil.requestDis(request, response, "goods/updateGoodsByDetail.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	/**
	 * 详情，修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectAgoods(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
		String goodsid=request.getParameter("goodsid");
		String flag=request.getParameter("flag");
		GoodsDao gd=new GoodsDao();
		try {
			Goods goods=gd.getAGoods(goodsid);
			request.setAttribute("goods", goods);
			if("update".equals(flag)){
			MyUtil.requestDis(request, response, "goods/update.jsp");
			}else{//return;
				MyUtil.requestDis(request, response, "goods/detail.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			//return;
		}
	}
	protected void selectAgoodsFromAll(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
		String goodsid=request.getParameter("goodsid");
		String flag=request.getParameter("flag");
		GoodsDao gd=new GoodsDao();
		try {
			Goods goods=gd.getAGoods(goodsid);
			request.setAttribute("goods", goods);
			if("updates".equals(flag)){
			MyUtil.requestDis(request, response, "goods/updates.jsp");
			}else{//return;
				MyUtil.requestDis(request, response, "goods/detail.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			//return;
		}
	}
	/**
	 * 删除商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void deleteGoodsFromAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String goodsids[]=request.getParameterValues("del");
		GoodsDao gd=new GoodsDao();
		try {
			gd.deleteGoodsFromAll(goodsids);
			MyUtil.requestDis(request, response, "goods?action=selects");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}

	/**
	 * 修改商品
	 * @param request
	 * @param response
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws ServletException
	 */
	
	protected void updatesGoods(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		//上传文件开始
	
		//if(!uploadFileDir2.exists()){//如果目录不存在，就创建目录
		//	uploadFileDir2.mkdir();
		//}
		//part.write(uploadFileDir2 + File.separator + newFilename);//上传文件
		//上传文件结束
		//对应的信息保存到数据库开始
		//从表单获得商品信息
		String goodsid=request.getParameter("goodsid");
		String goodsname=request.getParameter("goodsname");
		String goodstype=request.getParameter("goodstype");
		String goodsprice=request.getParameter("goodsprice");
		String left=request.getParameter("left");
		String description=request.getParameter("description");
		
		
		//封装到商品对象中
		Goods g=new Goods();
		g.setGoodsid(goodsid);
		g.setGoodsname(goodsname);
		g.setGoodsprice(Double.parseDouble(goodsprice));
		g.setGoodstype(goodstype);
		g.setLeft(Integer.parseInt(left));
		g.setDescription(description);
		
		GoodsDao gd=new GoodsDao();
		try {
			if(gd.updateGoods(g)){//成功
				MyUtil.requestDis(request, response, "goods?action=selectitem");
			}else{//失败
				MyUtil.requestDis(request, response, "goods/updates.jsp");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
		}
		//对应的信息保存到数据库结束
	}

	
}
