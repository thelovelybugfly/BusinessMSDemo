function goodsinfo(){
	$.ajax({
		url:"GoodsInfoServlet",
		type:"post",
		dataType:"json",
		data:{
			gid:$("#goodsid").val()
		},
		success:function(data){
			$("#maininfo").html("");
			for (var i=0;i<data.length;i++){
				var goods =data[i];
				var htmlStr="<div id='img'><img src='"+goods.photoaddress+"'/></div>" +
						    "<div class='goodsms'>商品名称  ："+goods.gname+"</div>" +
							"<div class='goodsms'>商品描述  ："+goods.gdescribe+"</div>" +
							"<div class='goodsms'>商品ID ："+goods.gid+"</div>" +
							"<div class='goodsms'>商品价格  ："+goods.price+"</div>" +
							"<button class='btn'>立刻购买</button>" +
							"<button class='btn' onclick='addshopcar("+goods.gid+")'>加入购物车</button>";														;
		
			}
			$("#maininfo").append(htmlStr);
		}
	});
	
}
goodsinfo();

function addshopcar(gids){
	$.ajax({
		url:"AddShppingCarServlet",
		type:"post",
		dataType:"json",
		data:{
			gid:gids
		},
		success:function(data){
		 if(data!=null){
			 alert(data);
			 window.location.href="jsp/index.jsp";
		 }	
		}
		
			
	});
	
}