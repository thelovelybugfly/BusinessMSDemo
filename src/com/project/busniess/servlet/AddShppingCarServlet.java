package com.project.busniess.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.busniess.service.AddShppingCarService;


/**
 * Servlet implementation class AddShppingCarServlet
 */
@WebServlet("/AddShppingCarServlet")
public class AddShppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShppingCarServlet() {
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
		//添加到购物车
		HttpSession session = request.getSession(true);
		Object accounts = session.getAttribute("account");
		String account = (String) accounts;
		String result ="";
		//获取商品id
		String gid = request.getParameter("gid");
		if(account==null){
			result = "您还未登录";
		}else{
		result = new AddShppingCarService().insertShopping(gid,account);
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
		
	}

}
