package com.project.busniess.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.busniess.po.GoodsMessagesPo;
import com.project.busniess.service.GoondsInfoService;


/**
 * Servlet implementation class GoodsInfoServlet
 */
@WebServlet("/GoodsInfoServlet")
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsInfoServlet() {
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
		String gid = request.getParameter("gid");
		List<GoodsMessagesPo> goodsinfo = new GoondsInfoService().goodsInfo(gid);
		 ObjectMapper om = new ObjectMapper();
		 om.writeValue(response.getOutputStream(),goodsinfo);
		 
	}

}
