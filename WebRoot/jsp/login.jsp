<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Book网用户登录系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->	
  </head>
  	<link href="css/login.css" rel="stylesheet" type="text/css"> 
    <script type="text/javascript" src="js/jquery.1.9.1.js"></script>
 <body>
<img src="image/woniuxy.png">
<h1>Book网用户登录系统</h1>
 <div id="out">
         <h2>用户登录</h2>
     <div class="input"><input type="text"  placeholder="账户名称"  maxlength="11" id="user" ></div>
     <div class="input"><input type="password" placeholder="用户密码"  maxlength="20"id="pass"></div>
     <div class="input"><input type="text" placeholder="验证码"   maxlength="4"  id="code" ></div>
     <div class="codemes"><img  src="" id="img" onclick="showcode()"/></div>
     <button class="button" onclick="login()">登录</button>
     <a href="jsp/register.jsp"><button class="button">注册</button></a>
 </div>
<script type="text/javascript" src="js/login.js"></script>
  </body>
</html>
