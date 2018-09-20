package com.project.busniess.service;

import java.sql.Connection;

import com.project.busniess.dao.UsersDAO;
import com.project.busniess.tool.JDBCUntil;


public class LoginService {

	public String checkLogin(String account, String pass1, String code,
			Object imgCode) {
			Connection con = JDBCUntil.getCon();
			//执行表操作，调用用户信息表核对账户密码 进行登录验证
			UsersDAO usersDAO = new UsersDAO();
			//强转object类型的图片验证码为string 
			String realcode= (String) imgCode;
			String result="";
			//对比验证码 正确的话 开始进行数据库对比
			if(code.equalsIgnoreCase(realcode)){		
				//调用userDAO 里面的checklogin 方法 对比验证登录信息，获取登录验证通过的返回值
				int selectresult = usersDAO.checklogin(con,account,pass1);
				if(selectresult ==1){
					result ="登录成功";
				}else {
					result="密码错误";
				}
			}else {
				result="验证码错误";
			}
			
			JDBCUntil.closeCon(con);
			return result;
	}


}
