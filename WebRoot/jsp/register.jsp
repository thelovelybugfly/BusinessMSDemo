<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="css/register.css" rel="stylesheet" type="text/css">
     <script type="text/javascript" src="js/jquery.1.9.1.js"></script>
</head>
<body>
<img src="image/woniuxy.png">
<h1>Book网用户登录系统</h1>
<div id="out">
        <h2>用户注册</h2>
        <div class="input"><input type="text"  placeholder="账户名称"  maxlength="11" id="user"></div>
        <div class="input"><input type="password" placeholder="用户密码"  maxlength="20" id="pass1"></div>
        <div class="input"><input type="password" placeholder="确认密码"   maxlength="20" id="pass2"></div>
        <div class="input"><input type="text" placeholder="注册验证码"   maxlength="4" id="code"></div>
        <div class="codemes"><img  src="" id="img" onclick="showcode()"/></div>
        <button class="button" onclick="register()">确认注册</button>
        <button class="button" onclick="intologin()">返回登录</button>
</div>
<script type="text/javascript" src="js/register.js"></script>
</body>
</html>
