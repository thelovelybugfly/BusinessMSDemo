package com.project.busniess.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.project.busniess.dao.ShopListDAO;
import com.project.busniess.dao.UsersDAO;
import com.project.busniess.po.VW_shopPO;
import com.project.busniess.tool.JDBCUntil;


public class ShowShoppingCarService {
		
		//通过account 查询购物车
	public List<VW_shopPO>  showShopping(String account) {
		// 查询购物车
		List<VW_shopPO> list =new ArrayList<VW_shopPO>();
		//获取用户id
		Connection con = JDBCUntil.getCon();
		int uid = new UsersDAO().selectUser(con,account );
		
		//通过uid 显示他的购物车 返回购物车内容的集合
		list = new ShopListDAO().showShopList(con,uid);
		
		JDBCUntil.closeCon(con);
		return list;
	}

}
