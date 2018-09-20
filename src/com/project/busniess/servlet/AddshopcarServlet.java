package com.project.busniess.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.busniess.po.GoodsMessagesPo;
import com.project.busniess.service.GoondsInfoService;

/**
 * Servlet implementation class AddshopcarServlet
 */
@WebServlet("/AddshopcarServlet")
public class AddshopcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddshopcarServlet() {
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
		
		HttpSession session=request.getSession(true);
		//获取到当前用户账号信息
		Object account = session.getAttribute("account");
		String gid = request.getParameter("gid");
		List<GoodsMessagesPo> shopcar = new GoondsInfoService().goodsInfo(gid);
		 Map<String,Object>map = new HashMap<String, Object>();
		 map.put("account",account);
		 map.put("data", shopcar);
		 ObjectMapper om = new ObjectMapper();
		 om.writeValue(response.getOutputStream(),map);	
		
	}		
}


