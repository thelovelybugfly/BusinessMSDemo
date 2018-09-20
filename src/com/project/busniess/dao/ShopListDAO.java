package com.project.busniess.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.busniess.po.VW_shopPO;

public class ShopListDAO {

        // 向购物车插入用户id：uid 。商品id： gid 以及购买数量bnum
	public String insertShopping(Connection con, int uid, int gid) {
		//添加到购物车,当购物车没这件商品时
		String result="";
		String sql = "insert into shoplist(uid,gid,bnum) values(?,?,1)";
		PreparedStatement state = null;
		
		try {
			//获取预编译状态
			state = con.prepareStatement(sql);
			state.setInt(1, uid);
			state.setInt(2, gid);
			int row = state.executeUpdate();
			if(row>0){
				result = "已加入购物车";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(state!=null)
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}


	//通过uid 查询视图 。  并将需要的信息存入到集合里面
	public List<VW_shopPO> showShopList(Connection con, int uid) {
		// 显示用户的购物车信息
		List<VW_shopPO> list =new ArrayList<VW_shopPO>();
		String sql = "select * from  vw_shop where uid=?";
		PreparedStatement state = null;
		ResultSet set = null;
		try {
			state = con.prepareStatement(sql);
			state.setInt(1, uid);
			set = state.executeQuery();
			
			while(set.next()){
		//		System.out.println("当前购物车id："+set.getInt("sid"));
				VW_shopPO po = new VW_shopPO();
				po.setGid(set.getInt("gid"));
				po.setUid(set.getInt("uid"));
				po.setGname(set.getString("gname"));
				po.setImage(set.getString("photoaddress"));
				po.setBnum(set.getInt("bnum"));
				po.setPrice(set.getDouble("price"));
				po.setSid(set.getInt("sid"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(set!=null)
				set.close();
				if(state!=null)
					state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

		
}
