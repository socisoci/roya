package com.wut.car.control;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wut.car.model.CarDAO;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private CarDAO dao=new CarDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		switch(method) {
		case "listAll":
		{
			System.out.println("查询显示有的后台");
			//调用dao方法查询所有的车辆信息
			List<Car> cars=dao.listAll();
			
			System.out.println(cars.size());
			//将查询出来的数据存储在request范围内
			request.setAttribute("cars", cars);
			//跳转到显示所有车辆的jsp页面
			request.getRequestDispatcher("").forward(request, response);
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
