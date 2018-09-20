<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>BOOK网图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
 <link href="css/index.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.1.9.1.js"></script>

<body>
<div id="top">
<%if(session.getAttribute("account")==null){ %>
    <div id="topin">欢迎光BOOK网，请<a href="jsp/login.jsp">&nbsp;&nbsp;登录/注册</a></div>
   <%}else{ %>
   <div id="newtopnin">
   <div id="login">欢迎 ：&nbsp;&nbsp;<a href="jsp/usermessage.jsp">${sessionScope.account}</a>&nbsp;&nbsp;回来  </div>
   <div id="exitlogin"><a href="jsp/index. 	jsp">注销</a></div>
   <div id="shopcar" onclick="showShopping()"><a href="jsp/shopcar.jsp">购物车</a></div>
     </div>
   <%} %>
</div>

<div class="topbanner"></div>

<div id="banner">
    <div id="list">
        <ul>
            <li><h1>图书分类</h1></li>
            <li><a href="#">电子书/网络文学/阅读器</a></li>
            <li><a href="#">小说/当代现代/中国古典</a></li>
            <li><a href="#">文艺/纪实文学/文学理论</a></li>
            <li><a href="#">青春/动漫/幽默</a></li>
            <li><a href="#">童书/中国儿童文学/外国儿童文学</a></li>
            <li><a href="#">教育/教材/考试/技术</a></li>
            <li><a href="#">人文社科/历史/文化/心理学</a></li>
            <li><a href="#">经管/管理/投资/理财</a></li>
            <li><a href="#">成功/励志/人生哲学</a></li>
            <li><a href="#">科技/科普读物/医学建筑</a></li>
            <li><a href="#">IT/网络/编程/人工智能</a></li>
            <li><a href="#">英文原版书/港澳台</a></li>
        </ul>
    </div>
<center>
    <div class="demo">
        <a class="control prev"></a><a class="control next abs"></a><!--自定义按钮，移动端可不写-->
        <div class="slider">
            <ul>
                <li><a href="#"><img src="image/banner/1.jpg" /></a></li>
                <li><a href="#"><img src="image/banner/2.jpg" /></a></li>
                <li><a href="#"><img src="image/banner/3.jpg" /></a></li>
                <li><a href="#"><img src="image/banner/4.jpg" /></a></li>
                <li><a href="#"><img src="image/banner/5.jpg" /></a></li>
            </ul>
        </div>
    </div> 
</center>
    <div id="enptydiv"><img src="image/enptydiv.png"/></div>
</div>

<div id="title">当代现代</div>

<div id="mainbox"></div>
<div id="page">
<div id="firstpage"></div>
<div id="justnow"></div>
<div id="currentpage"></div>
<div id="next"></div>
<div id="lastpage"></div>
</div>

<div id="foot">
    <div id="foot-left">
    <div class="buttom">
        <a href="#" class="title">BOOK首页</br></a>
        <a href="#">了解我们</br></a>
        <a href="#">公益中心</br></a>
    </div>
    <div class="buttom">
        <a href="#"  class="title">联系与合作</br></a>
        <a href="#">我要开店</br></a>
        <a href="#">我要推广</br></a>
        <a href="#">我要加盟</br></a>
    </div>
    <div class="buttom">
        <a href="#" class="title">移动客户端</br></a>
        <a href="#">BOOK iPhone版</br></a>
        <a href="#">BOOK Android版</br></a>
        <a href="#">BOOK HD</a>
    </div>
    <div id="foot-right">
        <h1><a href="#">关注我们</br></a></h1>
        <h2><a href="#">新浪微博：@book网</br></a></h2>
        <h2><a href="#">官方QQ ：1126144298</a></h2>
    </div>
    </div>
</div>

<div id="last">
    <h2>版权所有 @2018 布克公司或其关联公司</br></h2>
    <h3>网络文化经营许可证京网文[2015]0615-245 | 营业执照：91110105721471662U</h3>  
</div>
 <script src="js/banner.jQuery.min.js"></script>
 <script src="js/showGoods.js"></script>
  <!-- <script src="js/showShoppingcar.js"></script> -->
 
</body>
</html>
