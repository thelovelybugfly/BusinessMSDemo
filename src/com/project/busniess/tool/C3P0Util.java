package com.project.busniess.tool;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util implements Runnable{
	//创建一个连接池对象
	private static ComboPooledDataSource pool = new ComboPooledDataSource("myc3p0xml");
//	static{
//		pool = new ComboPooledDataSource();
//		try {
//			//加载数据库驱动
//			pool.setDriverClass("com.mysql.jdbc.Driver");
//			//设置数据URL
//			pool.setJdbcUrl("jdbc:mysql://localhost:3306/girlcloset");
//			//设置用户名
//			pool.setUser("root");
//			//设置密码
//			pool.setPassword("123456");
//			//设置初始化连接数
//			pool.setInitialPoolSize(10);
//			//设置最大连接数
//			pool.setMaxPoolSize(20);
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//	}
	public static Connection getCon(){
		try {
			return pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void closeCon(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Thread(new C3P0Util()).start();
		Connection con1 = getCon();
		Connection con2 = getCon();
		Connection con3 = getCon();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeCon(con1);
		closeCon(con2);
		closeCon(con3);
	}
	@Override
	public void run() {
		while(true){
			try {
				System.out.println(pool.getNumIdleConnections());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
