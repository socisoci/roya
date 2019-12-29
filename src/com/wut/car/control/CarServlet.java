package com.wut.car.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		switch(method) {
		case "listAll":
		{
			System.out.println("查询显示有的后台");
			break;
		}
		case "add":
		{
			System.out.println("添加二手车的方法");
					break;
		}
		case "delete":
		{
			System.out.println("删除二手车的方法");
			break;
		}
		case "update":
		{
			System.out.println("修改二手车的方法");
			break;
		}
			
		}
	}

}
