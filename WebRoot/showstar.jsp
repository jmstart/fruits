<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>我的关注</title>
<link rel="stylesheet" href="css/showcart.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script src="js/imgs.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript"  src="js/jquery.js"></script>


<script>
    window.onload=function footer_img_non(){
      document.getElementById("footer_img").style.display="none";
    }
  </script>
</head>
<body onload="money()">
	<div class="con">
		<div class="head">
			<a href="index.jsp"> <img src="img/logo_login.png" alt="" />
			</a>
		</div>
		<div class="shop_box">
			<div class="head_text_box">
				<span id="head_text"> 我的关注 </span>
			</div>

			<div class="shop_title">
				<div id="st1">商品</div>
				<div id="st2">规格</div>
				<div id="st3">单价</div>
				<div id="st4">数量</div>
				<div id="st5">小计</div>
				<div id="st6">操作</div>
			</div>
		<c:forEach  items="${starpovos}"  var="povo">
			<div class="shop">
				<div class="s1">
					<div class="s1_img">
						<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${povo.fruit.fId }">
						<img  src="img/fruits/${povo.fruit.fId }/(1).jpg" /></a>
					</div>
					<div class="s1_text">
						<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${povo.fruit.fId }">${povo.fruit.fName }</a>
					</div>
				</div>

				<div class="s2">${povo.fruit.fNorm }</div>

				<div class="s3">
					￥<span id="${povo.star.sid}price">${povo.fruit.fPrice }</span>
				</div>

				<div class="s4">
					<div class="Unum">
						<span id="${povo.star.sid}numl" class="numl" >-</span>
						<span id="${povo.star.sid}num">${povo.star.scount}</span>
						<span id="${povo.star.sid}numr" class="numr" >+</span>
					</div>
				</div>

				<div class="s5">
					￥<span id="${povo.star.sid}subTotal" class="fsum">${povo.subTotal }</span>
				</div>

				<div class="s6">
					<a href="<c:url  value='/star/RemoveStarBySidServlet?sid=${povo.star.sid }'/>">删除</a>
				</div>
			</div>
		</c:forEach>

			<div class="shop_footer">&nbsp;</div>
		</div>
		<script type="text/javascript"> 
			function  subTotal(sid){
				//获取  price  
				var   price  =  parseFloat($("#"+sid+"price").text());
				//获取  num  
				var   count  =   parseInt($("#"+sid+"num").text());
				//计算小计
				
				var    subtotal =   (price*count).toFixed(2) ; 
				$("#"+sid+"subTotal").text(subtotal);
			}
			
			//给所有  + 注册 点击 事件  Click    内置 循环   
			$(".numr").click(function(){
				//求每一个加号  id  属性对应 的值
				var  idvalue =  $(this).attr("id");
				// 截取  这个值  前  32 位 就是  每一个  star条目的   主见。  
				var  sid =   idvalue.substr(0,32);
				$.ajax({
					cache:false ,
					async:false ,
					type:"post",
					url :"/fruits/star/ChangeStarBySidForScountServlet",
					data:  {'sid':sid,value:1},
					dataType:"json",
					success:function(res){
						if(res){
							$("#"+sid+"num").text(parseInt($("#"+sid+"num").text())+1);
							//更新小计
							subTotal(sid);
						}else{	
							alert("请重新修改数量！");
						}	
					}		
				});
				
			});
			
			$(".numl").click(function(){
				//求每一个加号  id  属性对应 的值
				var  idvalue =  $(this).attr("id");
				// 截取  这个值  前  32 位 就是  每一个  star条目的   主见。  
				var  sid =   idvalue.substr(0,32);
				//如果   当前  num   =1  了   
				var  count   = parseInt($("#"+sid+"num").text());
				if(count==1){
					alert("最小商品关注的数量为1");
					return  ;
				}
				
				
				$.ajax({
					cache:false ,
					async:false ,
					type:"post",
					url :"/fruits/star/ChangeStarBySidForScountServlet",
					data:  {'sid':sid,value:-1},
					dataType:"json",
					success:function(res){
						if(res){
							$("#"+sid+"num").text(parseInt($("#"+sid+"num").text())-1);
							//更新小计
							subTotal(sid);
						}else{	
							alert("请重新修改数量！");
						}	
					}		
				});
				
			});
			
			
		</script>
	</div>
	<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
