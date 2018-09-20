package com.project.busniess.service;

import java.sql.Connection;

import com.project.busniess.dao.ShopListDAO;
import com.project.busniess.dao.UsersDAO;
import com.project.busniess.tool.JDBCUntil;


public class AddShppingCarService {

	public String insertShopping(String gids, String account) {
		//加入购物车
		String result="";
		int gid = Integer.parseInt(gids);
		Connection con = JDBCUntil.getCon();
		// 获取用户id
		int uid = new UsersDAO().selectUser(con, account);		
		//插入购物车
		result = new ShopListDAO().insertShopping(con,uid,gid);		
		JDBCUntil.closeCon(con);
		return result;
	}

}
