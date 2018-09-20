package com.project.busniess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.busniess.po.GoodsMessagesPo;

public class GoodsMessagesDAO {
		//查询分页
	public List<GoodsMessagesPo> findByPage(int index, Connection con) {
		List<GoodsMessagesPo> list = new ArrayList<GoodsMessagesPo>();	
		// 准备查询的SQL语句 先查询看有没有存在的用户名
				String SQL = "SELECT * FROM goodsmessage WHERE flag=0 LIMIT ?,6;";
				// 创建预编译状态
				PreparedStatement state = null;
				ResultSet set = null;
				try {
					state = con.prepareStatement(SQL);
					state.setInt(1, index);
					//执行SQL
					set = state.executeQuery();
					while (set.next()) {
						GoodsMessagesPo po = new GoodsMessagesPo();
						po.setGid(set.getInt("gid"));
						po.setGnameString(set.getString("gname"));
						po.setPhotoaddress(set.getString("photoaddress"));
						po.setGdescribe(set.getString("gdescribe"));
						po.setPrice(set.getFloat("price"));
						list.add(po);
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
		
		return list;
	}
     //查询总页数
	public int findTotal(Connection con) {
		//定义总条数
		int total=0;	
		// 准备查询的SQL语句 先查询看有没有存在的用户名
		String SQL = "SELECT count(*) as num FROM goodsmessage WHERE flag=0";
		// 创建预编译状态
		PreparedStatement state = null;
		ResultSet set = null;
		try {
			state = con.prepareStatement(SQL);
			//执行SQL
			set = state.executeQuery();
			if (set.next()) {
				total=set.getInt("num");
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
		return total;
	}
	  //根据uid 查询所有商品信息
	public List<GoodsMessagesPo> goodsInfo(Connection con, int goodsid) {
		List<GoodsMessagesPo>  goodsinfo = new ArrayList<GoodsMessagesPo>();
		String sql ="SELECT * FROM goodsmessage WHERE gid=? AND flag=0";		
		PreparedStatement state =null;
		ResultSet set = null;		
		try {
			state = con.prepareStatement(sql);
			state.setInt(1, goodsid);
			set = state.executeQuery();
			while(set.next()){
			GoodsMessagesPo goodsinfopo= new GoodsMessagesPo();
			goodsinfopo.setGid(set.getInt("gid"));
			goodsinfopo.setGnameString(set.getString("gname"));
			goodsinfopo.setPhotoaddress(set.getString("photoaddress"));
			goodsinfopo.setGdescribe(set.getString("gdescribe"));
			goodsinfopo.setPrice(set.getFloat("price"));
				goodsinfo.add(goodsinfopo);							
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
		 
		return goodsinfo;
		
	}



}
