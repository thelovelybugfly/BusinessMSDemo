<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->	
   <link href="css/goodsinfo.css" rel="stylesheet" type="text/css">
  </head>
   <script src="js/jquery.1.9.1.js"></script>
  
  <body>
  <!-- 获取页面的id 用来传到servlet中进行对应的数据库查询  -->
  <input type="hidden" value="${param.id }" id="goodsid"/>
  <div id="maininfo"></div>
 
  </body>
   <script type="text/javascript" src="js/goodsinfo.js"></script>
</html>
