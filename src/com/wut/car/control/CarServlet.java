package com.wut.car.control;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wut.car.model.Car;
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
			request.getRequestDispatcher("carList.jsp").forward(request, response);
			break;
		}
		case "add":
		{
			System.out.println("添加二手车的方法");
			String name=request.getParameter("name");
			String yanse=request.getParameter("yanse");
			String gonglishu=request.getParameter("gonglishu");
			String pingpai=request.getParameter("pingpai");
			String tupian=request.getParameter("tupian");
			//封装
			Car car=new Car();
			car.setName(name);
			car.setYanse(yanse);
			car.setGonglishu(Integer.parseInt(gonglishu));
			car.setPingpai(pingpai);
			//调用dao方法，将这个新添加的汽车信息插入到数据库
			boolean result=dao.addCar(car);
			//根据添加结果跳转页面
			if(result) {
				
			}else {
				
			}
					break;
		}
		case "delete":
		{
			System.out.println("删除二手车的方法");
			//获取页面超链接传过来的要删除掉的车辆id
			String carid=request.getParameter("carid");
			//调用dao的删除方法删除这个车辆信息
			boolean result=dao.deleteCar(Integer.parseInt(carid));
			//将删除操作的结果存储到request范围内，然后到页面判断结果提示用户
			request.setAttribute("deleteResult",result);
			//删除执行完毕，无论成功还是失败都要跳转到列表页面
			request.getRequestDispatcher("CarServlet?method=listAll").forward(request, response);
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
