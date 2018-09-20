function showGoods(ppage){
	$.ajax({
		url:"ShowGoodsServlet",
		type:"post",
		dataType:"json",
		data:{
			page:ppage
		},
		success:function(data){
			$("#mainbox").html("");//获取页面商品展示的DIV 名称 并将其设置为空；
			//获取map集合里的元素，通过key 找到value;
			var currentpage = parseInt(data.currentpage);//当前页面
			var totalpage = data.totalpage;// 总页数
			var goodsList = data.goodsmessage;//数据库读取的商品列表
			//循环遍历列表， 获取商品列表里的具体属性
			//console.log(0000);网页上的控制台输出数据
 			//console.log(goodsList.length);
			for(var i = 0;i<goodsList.length;i++){
				// 一个商品的所有属性
				var goods=goodsList[i];
				// 操作每一个商品的具体div  将html 代码以字符拼接的形式 写入到jsp 页面动态生成商品信息
				var htmlStr ="<div class='goods' id='goods'>"+
							 "<div class='goodsimg' id='goodsimg'>"+									
							 "<img src='"+goods.photoaddress+"'/>"+
							 "<div class='goodsinfo'>"+									 
							 "<div class='goodsname' id='goodsname"+i+"'>"+
									   goods.gname+
							 "</div>"+
							 "<div class='gdescribe' id='gdescribe'>"+
									   goods.gdescribe+
							 "</div>"+
							 "<div class='goodsprice' id='goodsprice"+i+"'>"+
									   "价格 ：  "+goods.price+"元"+
							 "</div>"+
							 "<button class='add' id ='add'"+i+">"+
							 "<a href='jsp/goodsinfo.jsp?id="+goods.gid+"'>"+
							         "查看详情</a>"+									   
							 "</button>"+
							 "</div>"+
							 "</div>"+
							 "</div>";					
				$("#mainbox").append(htmlStr);
				$("#firstpage").html("<a href='javascript:showGoods("+1+")'>首页</a>");					
				if(currentpage > 1){
					$("#justnow").html("<a href ='javascript:showGoods("+ (currentpage-1)+")'>上一页</a>");
				}
				$("#currentpage").html("第" + currentpage+"/"+totalpage+"页");
				if(currentpage < totalpage){
					$("#next").html("<a href ='javascript:showGoods("+(currentpage+1)+")'>下一页</a>");
				}				
				$("#lastpage").html("<a href='javascript:showGoods("+totalpage+")'>末页</a>");	
			}
		}
	});
}
showGoods(1);