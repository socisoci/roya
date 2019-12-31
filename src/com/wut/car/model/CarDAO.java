package com.wut.car.model;

import java.sql.DriverManager;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mysql.jdbc.Connection;

public class CarDAO {
	/**
	 * 这是查询显示所有的车辆的dao方法
	 * @return
	 */
	public List<Car> listAll()
	List<Car> cars=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Car","root","root");
		QueryRunner run = new QueryRunner();
		ResultSetHandler<List<Car>> h =new BeanHandler<Car>(Car.class);
		cars= run.query(connection,"SELECT * FORM car",h);
		
	}
	catch(Exception e){
		cars=new ArrayList<>();
		e.printStackTrace();
	}
	
		return cars;
		/**
		 * 这是删除车辆信息的dao方法
		 */
		public boolean deleteCar(int carid) {
			boolean result=false;
			try {
				Class.forName("com.mysql,jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Car","root","root");
				QueryRunner run = new QueryRunner();
				int count=run.update(connection, "delete from car where carid=?",carid);
				result=count>0?true:false;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return result;
	}
		
		/**
		 * 这是添加车辆信息的dao方法
		 */
		public boolean addCar(Car c) {
			boolean result=false;
			try {
				Class.forName("com.mysql,jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Car","root","root");
				QueryRunner run = new QueryRunner();
				int count=run.update(connection, "insert into (name,yanse,gonglishu,pingpai)car(?,?,?,?)",c.getName(),c.getYanse(),c.getGonglishu(),c.getPingpai());
				result=count>0?true:false;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return result;
	}

}
