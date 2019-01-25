package com.jingbao.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
public class MyUtil {
	/**
	 * 转发方法
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void requestDis(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException{
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
	/**
	 * @discription 从Part中获得原始文件名
	 * @return String
	 */
	public static String getFileName(Part part){
		if(part == null)
			return null;
		//fileName形式为：form-data; name="resPath"; filename="20140920_110531.jpg"
		String fileName = part.getHeader("content-disposition");
		//没有选择文件
		if(fileName.lastIndexOf("=") + 2 == fileName.length() - 1)
			return null;
		return fileName.substring(fileName.lastIndexOf("=") + 2, fileName.length() - 1);
	}
}
