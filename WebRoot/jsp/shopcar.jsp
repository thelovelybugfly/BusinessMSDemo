<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->	
  </head>
  <link rel="stylesheet" type="text/css" href="css/shopcar.css">
	<script src="js/jquery.1.9.1.js"></script>
  <body>
  <div id="checkall">
  <input type="radio" name="radio" value="1">全选
  <input type="radio" name="radio" value="2">取消
  </div> 
  <div id="mainbox"></div>
  </body>
  <script src="js/showShoppingcar.js"></script>
</html>
