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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.busniess.po.GoodsMessagesPo;
import com.project.busniess.service.ShowGoodsService;

/**
 * Servlet implementation class ShowGoodsServlet
 */
@WebServlet("/ShowGoodsServlet")
public class ShowGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsServlet() {
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
		//获取ajax 提交的data 中的 page 属性 
		 String page = request.getParameter("page");
		 ShowGoodsService showGoodsService =  new ShowGoodsService();
		  //获取当前页商品信息
		 List<GoodsMessagesPo> list = showGoodsService.showGoodsBypage(page);
		 //获取总页数
		 int totalpage = showGoodsService.findTotalPage();
		 //创建一个map 集合 用于存放 页面数和该页面从数据库读取的商品的内容
		 Map<String,Object>map = new HashMap<String, Object>();
		 // 存放当前页面
		 map.put("currentpage", page);
		 // 存放商品
		 map.put("goodsmessage", list);
		//存放总页数
		 map.put("totalpage", totalpage);
		 //将响应的结果输出到js 的success 的data中，处理
		 ObjectMapper om = new ObjectMapper();
		 om.writeValue(response.getOutputStream(),map);
		
		
	}

}
