package com.project.busniess.service;

import java.sql.Connection;
import java.util.List;

import com.project.busniess.dao.GoodsMessagesDAO;
import com.project.busniess.po.GoodsMessagesPo;
import com.project.busniess.tool.JDBCUntil;


public class ShowGoodsService {

	public List<GoodsMessagesPo> showGoodsBypage(String spage) {
		int page = 1;
		try {
			page = Integer.parseInt(spage);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		int index = (page-1)*6;
		Connection con = JDBCUntil.getCon();
		List<GoodsMessagesPo> list = new GoodsMessagesDAO().findByPage(index,con);
		JDBCUntil.closeCon(con);
		return list;	
		
	}

	public int findTotalPage() {
		int totalpage=1;
		Connection con = JDBCUntil.getCon();
		int total = new GoodsMessagesDAO().findTotal(con);
		if(total % 6 ==0){
			totalpage = total / 6 ;
		}else {
			totalpage = (total / 6) + 1;
 		}
		JDBCUntil.closeCon(con);
		return totalpage;
	}

}
