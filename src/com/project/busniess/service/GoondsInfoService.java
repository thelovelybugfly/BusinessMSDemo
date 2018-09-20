package com.project.busniess.service;


import java.sql.Connection;
import java.util.List;

import com.project.busniess.dao.GoodsMessagesDAO;
import com.project.busniess.po.GoodsMessagesPo;
import com.project.busniess.tool.JDBCUntil;



public class GoondsInfoService{
		
		public List<GoodsMessagesPo> goodsInfo(String gid) {
		Connection con = JDBCUntil.getCon();
		GoodsMessagesDAO goodsMessagesDAO = new GoodsMessagesDAO();
		int goodsid =Integer.parseInt(gid);
		List<GoodsMessagesPo> goodsinfo =goodsMessagesDAO.goodsInfo(con,goodsid);
		JDBCUntil.closeCon(con);
		return goodsinfo;
			
		}
}
