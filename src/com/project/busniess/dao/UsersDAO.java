package com.project.busniess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.busniess.tool.MD5_Encoding;

public class UsersDAO {
	//注册用户名查询
	public int select(Connection con, String account) {
		// 准备查询的SQL语句 先查询看有没有存在的用户名
		String SQL = "SELECT * FROM users WHERE username=?";
		// 创建状态
		PreparedStatement state = null;
		ResultSet set = null;
		int selectresult = 0;
		try {
			state = con.prepareStatement(SQL);
			state.setString(1, account);
			set = state.executeQuery();
			if (set.next()) {
				selectresult = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 设置查询参数
		} finally {
			try {
				if(state != null){
					state.close();
					}
					if(set != null){
					set.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectresult;
	}
	// 注册 添加用户信息
	public int addaccount(Connection con, String account, String pass2) {
		// 准备插入SQL语句
		String SQL = "INSERT INTO users(username,password,flag) VALUES(?,?,?)";
		// 创建状态
		PreparedStatement state = null;
		int addresult = 0;
		try {
			state = con.prepareStatement(SQL);
			state.setString(1, account);
			// 正则表达式，要求同时有8-16位的字母数字，不能全是字母或全是数字
			// String key="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
			// 进行MD5 算法加密，将明文转换为密文再插入
			// if(pass2.matches(key)){
			String pass = MD5_Encoding.upperMD5(pass2);
			state.setString(2, pass);
			state.setInt(3, 0);
			// 提交更新
			addresult = state.executeUpdate();
			// }else {
			// addresult=2;
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(state != null){
					state.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		// 设置参数
		return addresult;
	}
	//检查登录
	public int checklogin(Connection con, String account, String pass1) {
		// 准备查询语句
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		// 创建状态
		PreparedStatement state = null;
		ResultSet set = null;
		int selectresult = 0;
		// 设置参数
		try {
			//加密后进行查询对比
			state = con.prepareStatement(sql);
			String pass = MD5_Encoding.upperMD5(pass1);
			state.setString(1, account);
			state.setString(2, pass);
			// 提交语句 
			set = state.executeQuery();			
			//处理结果集
			if (set.next()) {
				selectresult = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(state != null){
					state.close();
					}
					if(set != null){
					set.close();
					}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectresult;
	}

	//根据 用户名查询uid
	public int selectUser(Connection con, String account) {	
		String sql= "SELECT uid FROM users WHERE username=? AND flag=0";
		PreparedStatement state = null;
		ResultSet set = null;
		int uid=0;
		//System.out.println("当前登录的："+account);
		try {
			state = con.prepareStatement(sql);
			state.setString(1, account);
			set = state.executeQuery();
			if(set.next()){	
			//	System.out.println("获取的用户id"+set.getInt("uid"));
				 uid = set.getInt("uid");							
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(state != null){
					state.close();
					}
					if(set != null){
					set.close();
					}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return uid;			
	}
	
	
}
