package com.project.busniess.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.busniess.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		//获取ajax 提交的注册界面 输入的数据
		String account = request.getParameter("account");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String code = request.getParameter("code");
		
		//获取产生的验证码字符串
		HttpSession session=request.getSession(true);
		Object imgCode = session.getAttribute("randCheckCode");
		String result = new RegisterService().addaccount(account,pass1, pass2 ,code,imgCode);
			//将service里面数据库返回的数据 返回到ajax的data里面
	     	 ObjectMapper om = new ObjectMapper();
	     	 om.writeValue(response.getOutputStream(),result);
	     	 
		}
	
	
	
	
	
	
	
	
	
}

