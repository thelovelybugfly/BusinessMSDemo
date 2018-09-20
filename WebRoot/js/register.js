function register(){
	$.ajax({
		  url:"RegisterServlet", //发送目标URL(servlet)
		  type:"post",//发送方式
		  dataType:"json",//期待服务器响应的数据类型
		  data:{
			  account:$("#user").val(), //获取页面上输入框的内容，以键值对的形式发送给服务器。
			  pass1:$("#pass1").val(),
			  pass2:$("#pass2").val(),
			  code:$("#code").val()
		  },
		  success:function(data){
			    alert(data);
			    window.location.href="jsp/register.jsp";		  	
		  }
		  
	});
}

//注册界面的转到登录界面
function intologin(){
	  window.location.href="jsp/login.jsp";
}


//设置图片验证码切换
function showcode(){
	document.getElementById("img").src="PictureCheckCodeServlet?a="+Math.random();
}
showcode();
