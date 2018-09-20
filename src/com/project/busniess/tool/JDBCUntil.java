package com.project.busniess.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUntil {
	//要让服务器能够识别 数据库中的中文  在编码中URL 后面加上 ?useUnicode=true&characterEncoding=UTF-8
			private final static String URL="jdbc:mysql://localhost:3306/businessms?useUnicode=true&characterEncoding=UTF-8";
			private final static String USERNAME="root";
			private final static String PASSWORD="";
			static {				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {				
					e.printStackTrace();
				}
			}
			public static Connection getCon(){
				Connection con = null;
				try {
					con =DriverManager.getConnection(URL,USERNAME,PASSWORD);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return con;
			}
			
			public static void closeCon(Connection con){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
