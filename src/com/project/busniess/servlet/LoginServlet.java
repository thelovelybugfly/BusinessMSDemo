package com.project.busniess.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.busniess.service.LoginService;


/**
 *
 */
@WebServlet("/Loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		String pass1=request.getParameter("pass");
		String code=request.getParameter("code");
		
		//获取 随机产生的图片验证码
		HttpSession session = request.getSession(true);	   
		Object imgCode = session.getAttribute("randCheckCode");
		//调用service的检查登录方法，获取其返回值字符串，并且引用 用作输出
		String result = new LoginService().checkLogin(account,pass1,code,imgCode);
		//获取service 返回的数据， 并且写入到ajax的success 的data里面返回到js 中， 进行控制
		if(result.equals("登录成功")){
		session.setAttribute("account", account);
		}		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
	   					
	}

}
