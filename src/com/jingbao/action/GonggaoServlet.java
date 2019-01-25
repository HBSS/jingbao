package com.jingbao.action;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import com.jingbao.common.MyUtil;
import com.jingbao.dao.GonggaoDao;

import com.jingbao.daomain.Gonggao;





/**
 * Servlet implementation class GonggaoServlet
 */
@WebServlet("/gonggao")
public class GonggaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GonggaoServlet() {
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
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		//添加公告
		if("add".equals(action)){
			addGonggao(request,response);
		}
		
		//查询公告
		if("select".equals(action)){
			selectGonggao(request, response);
		}
		
		if("detail".equals(action)){
			detailGonggao(request,response);
		}
		if("update".equals(action)){
			updateGonggao(request,response);
		}
		if("update1".equals(action)){
			update1Gonggao(request,response);
		}
		if("delete".equals(action)){
			deleteGonggao(request,response);
		}
		if("delete1".equals(action)){
			delete1Gonggao(request,response);
		}
		if("delete2".equals(action)){
			delete2Gonggao(request,response);
		}
	}
	protected void addGonggao(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		String gonggaoid=request.getParameter("gonggaoid");
		String gonggaoname=request.getParameter("gonggaoname");
		String gonggaocontent=request.getParameter("gonggaocontent");
		//封装到商品对象中
		Gonggao g=new Gonggao();
		g.setGonggaoid(gonggaoid);
		g.setGonggaoname(gonggaoname);
		g.setGonggaocontent(gonggaocontent);
		
		GonggaoDao gd=new GonggaoDao();
		try {
			if(gd.addgonggao(g)){//成功
				MyUtil.requestDis(request, response, "gonggao?action=select");
			}else{//失败
				MyUtil.requestDis(request, response, "gonggao/addgonggao.jsp");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
		}
		//对应的信息保存到数据库结束
	}
	
	/**
	 *查询公告
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void selectGonggao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		GonggaoDao gd=new GonggaoDao();
		try {
			ArrayList<Gonggao> allgonggao=gd.getAllGonggao();
			request.setAttribute("allgonggao", allgonggao);
			MyUtil.requestDis(request, response, "gonggao/searchgonggao.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	
	protected void detailGonggao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String gonggaoid=request.getParameter("gonggaoid");
		String flag=request.getParameter("flag");
		GonggaoDao gd=new GonggaoDao();
		try {
			Gonggao gonggao=gd.getAgonggao(gonggaoid);
			request.setAttribute("gonggao", gonggao);
			if("update".equals(flag)){
			MyUtil.requestDis(request, response, "gonggao/update1.jsp");
			}else{//return;
				MyUtil.requestDis(request, response, "gonggao/gonggaodetail.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			//return;
		}
	}
		
	protected void updateGonggao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GonggaoDao gd=new GonggaoDao();
		try {
			ArrayList<Gonggao> allgonggao=gd.getAllGonggao();
			request.setAttribute("allgonggao", allgonggao);
			MyUtil.requestDis(request, response, "gonggao/updategonggao.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}	
	protected void update1Gonggao(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		
		String gonggaoid=request.getParameter("gonggaoid");
		String gonggaoname=request.getParameter("gonggaoname");
		String gonggaocontent=request.getParameter("gonggaocontent");
		
		//封装到商品对象中
		Gonggao g=new Gonggao();
		g.setGonggaoid(gonggaoid);
		g.setGonggaoname(gonggaoname);
		g.setGonggaocontent(gonggaocontent);
		
		GonggaoDao gd=new GonggaoDao();
		try {
			if(gd.updateGonggao(g)){//成功
				MyUtil.requestDis(request, response, "gonggao?action=update");
			}else{//失败
				MyUtil.requestDis(request, response, "gonggao/update1.jsp");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
		}
		//对应的信息保存到数据库结束
	}

	protected void deleteGonggao(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		GonggaoDao gd=new GonggaoDao();
		try {
			ArrayList<Gonggao> allgonggao=gd.getAllGonggao();
			request.setAttribute("allgonggao", allgonggao);
			MyUtil.requestDis(request, response, "gonggao/deletegonggao.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	protected void delete1Gonggao(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String gonggaoid=request.getParameter("gonggaoid");
		GonggaoDao gd=new GonggaoDao();
		try {
			gd.deleteGonggao(gonggaoid);
			MyUtil.requestDis(request, response, "gonggao?action=select");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	protected void delete2Gonggao(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String gonggaoids[]=request.getParameterValues("del");
		GonggaoDao gd=new GonggaoDao();
		try {
			gd.delete2Gonggao(gonggaoids);
			MyUtil.requestDis(request, response, "gonggao?action=delete");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyUtil.requestDis(request, response, "admin/cuowu.jsp");
			return;
		}
	}
	
	
	}

	

	
	
	

