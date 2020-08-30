<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
<link rel="stylesheet" href="css/showcart.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<script src="js/imgs.js" type="text/javascript" charset="utf-8"></script>

<script>
    window.onload=function footer_img_non(){
      document.getElementById("footer_img").style.display="none";
    }
</script>
<script type="text/javascript"  src="js/jquery.js"></script>  
</head>
<body onload="money()">
	<div class="con">
		<div class="head">
			<a href="index.jsp"> <img src="img/logo_login.png" alt="" />
			</a>
		</div>
		<div class="shop_box">
			<div class="head_text_box">
				<span id="head_text"> 我的购物车 </span>
			</div>

			<div class="shop_title">
				<div id="st1">商品</div>
				<div id="st2">规格</div>
				<div id="st3">单价</div>
				<div id="st4">数量</div>
				<div id="st5">小计</div>
				<div id="st6">操作</div>
			</div>
		<c:forEach  items="${povos}"  var="povo">
			<div class="shop">
				<div class="s1">
					<div class="s1_img">
						<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${povo.fruit.fId }">
						<img src="img/fruits/${povo.fruit.fId}/(1).jpg" /></a>
					</div>
					<div class="s1_text">
						<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${povo.fruit.fId }">${povo.fruit.fName }</a>
					</div>
				</div>
				<div class="s2">${povo.fruit.fNorm }</div>
				<div class="s3">
					￥<span id="${povo.cart.cid}price">${povo.fruit.fPrice }</span>
				</div>
				<div class="s4">
					<div class="Unum">
						<span id="${povo.cart.cid}numl" class="numl" >-</span>
						<span id="${povo.cart.cid}num">${povo.cart.ccount }</span>
						<span id="${povo.cart.cid}numr" class="numr" >+</span>
					</div>
				</div>
				
				<div class="s5">
					￥<span id="${povo.cart.cid}subTotal" class="fsum">${povo.subTotal }</span>
				</div>

				<div class="s6">
					<a href="javascript:removeCartByCid('${povo.cart.cid }');">删除</a>
				</div>
			</div>
			</c:forEach>
			<script type="text/javascript">
				function  removeCartByCid(cid){
					
					if(confirm("确定删除该购物车条目吗》？？？")){
						
						location.href="/fruits/cart/RemoveCartByCidServlet?cid="+cid;
					}
					
				}
			</script>
			<div class="shop_footer">&nbsp;</div>
		</div>

		<div class="sum_mon">
			<div class="money">
				商品总金额：<span id="total"></span>
			</div>
			<br /> <input type="button" name="" id="addmon" value="订单结算" />
		</div>
	</div>
	<script type="text/javascript">
	//jia
		function   subtotal(cid){
			var   ccount  =parseInt($("#"+cid+"num").text());
			var   price  =  parseFloat($("#"+cid+"price").text());
			
			$("#"+cid+"subTotal").text((ccount*price).toFixed(2));
		
		}
	//jia
		$(".numr").click(function(){
			
			var  cid =  $(this).attr("id").substr(0,32);
			
			$.ajax({
				async: false,
				cache:false,
				type:"post",
				url:"/fruits/cart/ChangeCartByCidForCcountServlet",
				data:{cid:cid,value:1},
				dataType:'json',
				success:function(res){
					if(res){
						$("#"+cid+"num").text(parseInt($("#"+cid+"num").text())+1);
						subtotal(cid);
						total();
					}else{
						
						alert("请重新更新购物车！");
					}
				}
			});
		});
	$(".numl").click(function(){
			
			var  cid =  $(this).attr("id").substr(0,32);
			var  ccount =  parseInt($("#"+cid+"num").text());
			if(ccount==1){
				if(confirm("确定要删除该购物车条目吗?")){
					
					location.href="/fruits/cart/RemoveCartByCidServlet?cid="+cid;
					
				}
				return ;
				
			}
			$.ajax({
				async: false,
				cache:false,
				type:"post",
				url:"/fruits/cart/ChangeCartByCidForCcountServlet",
				data:{cid:cid,value:-1},
				dataType:'json',
				success:function(res){
					if(res){
						$("#"+cid+"num").text(parseInt($("#"+cid+"num").text())-1);
						//计算小计
						subtotal(cid);		
						//重新  计算总计
						total();
					}else{				
						alert("请重新更新购物车！");
					}	
				}
			});	
		});
		//   总计   total  
		function   total(){
			var  sum = 0 ;
			$(".fsum").each(function(){
				sum=sum+parseFloat($(this).text());
				
				
			});
			
			$("#total").text("¥"+sum);
		}
		//   页面上所有的  标签元素     文本和属性 都加载完毕之后，  自动调用的函数
		$(function(){
			total();
		});
	</script>
	
	
	<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
