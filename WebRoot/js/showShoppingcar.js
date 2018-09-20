function showShopping(){
	$.ajax({
		url:"ShowShoppingCarServlet",
			type:"post",
			dataType:"json",
			data:{},
			success:function(data){
				$("#mainbox").html("");
				for (var i=0;i<data.length;i++){
					var goods =data[i];
					var htmlStr="<div id='out'>"+
							    "<div id='img'><input name='ok' type='checkbox'><img src='"+goods.image+"'/></div>" +
							    "<div id='goodname'>商品名称  ："+goods.gname+"</div>" +		
								"<div class='goodsms'>用户ID  ："+goods.uid+"</div>" +
								"<div class='goodsms'>商品ID ："+goods.gid+"</div>" +
								"<div class='goodsms'>商品价格  ："+goods.price+"</div>" +
								"<div class='goodsms'>购买数量  ："+goods.bnum+"</div>"+
								"<div class='goodsms'>订单编号  ："+goods.sid+"</div>"+
								"<button class='btn'>付款</button>" +
								"</div>";
					$("#mainbox").append(htmlStr);						
			
				     }
				
				
			}
	});
}
showShopping();