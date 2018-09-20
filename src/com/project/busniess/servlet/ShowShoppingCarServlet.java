package com.project.busniess.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.busniess.po.VW_shopPO;
import com.project.busniess.service.ShowShoppingCarService;

/**
 * Servlet implementation class ShowShoppingCarServlet
 */
@WebServlet("/ShowShoppingCarServlet")
public class ShowShoppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowShoppingCarServlet() {
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
		//查看购物车
		//获取当前用户
		List<VW_shopPO> list =new ArrayList<VW_shopPO>();
		HttpSession session = request.getSession(true);
		Object accounts = session.getAttribute("account");
		String account = (String) accounts;	
		list= new ShowShoppingCarService().showShopping(account);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(),list);
		
		
	}

}
