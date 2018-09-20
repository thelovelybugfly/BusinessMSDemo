function login(){
	$.ajax({
		  url:"Loginservlet", //发送目标URL(servlet)
		  type:"post",//发送方式
		  dataType:"json",//期待服务器响应的数据类型
		  data:{
			  account:$("#user").val(), //获取页面上输入框的内容，以键值对的形式发送给服务器。
			  pass:$("#pass").val(),
			  code:$("#code").val()
		  },
		  success:function(data){
			  alert(data);
			  if(data=="登录成功"){
				  //servlet返回data 登录状态字符串				      
						 window.location.href="jsp/index.jsp";	
					 }else{
						 window.location.href="jsp/login.jsp";	
					 }			  
			  }
				  
	});
}





//设置图片验证码切换
function showcode(){
	document.getElementById("img").src="PictureCheckCodeServlet?a="+Math.random();
}
showcode();
