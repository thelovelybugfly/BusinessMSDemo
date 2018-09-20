package com.project.busniess.service;

import java.sql.Connection;

import com.project.busniess.dao.UsersDAO;
import com.project.busniess.tool.JDBCUntil;


public class RegisterService {

	public String addaccount(String account, String pass1, String pass2,
			String code, Object imgCode) {

		Connection con = JDBCUntil.getCon();
		UsersDAO usersDAO = new UsersDAO();
		String result ="";
		String realcode = (String) imgCode;
		// 检查两次输入的密码是否一样，以及验证码是否一样（IgnoreCase不区分大小写）		
		if (pass1.equals(pass2) && code.equalsIgnoreCase(realcode)) {
			// 用户名正则，4到16位（字母，数字，下划线，减号）
			// String key="([a-zA-Z0-9]{6,12})";
			// if(account.matches(key)){
			int selectresult = usersDAO.select(con, account);
			int addresult = 0;
			if (selectresult == 1) {
				result = "账户已存在，请更换再试";
			} else {
				addresult=usersDAO.addaccount(con, account, pass2);
				if (addresult != 0) {
					result = "注册成功";
				} else {
					result = "密码不符合规则,请重新输入8-16位的字母数字，不能全是字母或全是数字";
				}
			}
			// }
		} else {
			result = "账户,密码或验证码不正确，请核对后输入";
		}
		JDBCUntil.closeCon(con);
		return result;
	}
}
