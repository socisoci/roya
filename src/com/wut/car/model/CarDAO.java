package com.wut.car.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

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
		
		
	}

}
