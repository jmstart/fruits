<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<title>天天果园-水果网购首选品牌，水果，我们只挑有来头的！</title>
<link rel="stylesheet" type="text/css" href="css/sel.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript"  src="js/jquery.js"></script>
<script src="js/sel.js"></script>

<jsp:include page="head/head.jsp"></jsp:include>
</head>
<body style="position: relative;">
	<div class="fruit_info">
		<div class="fruit_hot">
			<div class="hf_title">
				<span class="ht_l">热卖商品</span><span class="ht_r">
				<c:if test="${hotinfo.hasNextPage }">
				<a href="/fruits/fruit/LoadIndexServlet?page=sel.jsp&pageNum=${hotinfo.pageNum+1 }">MORE+</a></span>
				</c:if>
			</div>
			<c:forEach  items="${hotinfo.list}"  var="hf">
			<div class="hot_fruit">
				<div class="hf_img">
					<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${hf.fId}">
					<img  src="img/fruits/${hf.fId}/(1).jpg" /></a>
				</div>
				<div class="hf_text">
					<div class="hf_name">
						<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${hf.fId}">
						${hf.fName }
						</a>
					</div>
					<div class="hf_mon">
						￥<span>${hf.fPrice}</span>
					</div>
				</div>
			</div>
			</c:forEach>
			
		</div>


		<div class="sel">
			<div class="selfruits">
				<ul class="selfruits_ul">
					<li class="selfruits_li">品类： 
						<a href="/fruits/fruit/SelectFruitsBySwitchServlet" class="selkey" name="abc">不限</a> 
						<!-- select * from  fruit where  c_id = ? -->
						<c:forEach  items="${categorys }"  var="category">
							<a href="/fruits/fruit/SelectFruitsBySwitchServlet?cId=${category.cId}" 
							class="selkey" name="abc">${category.cName }</a> 
						</c:forEach>	
						
						
					</li>
					
					<li class="selfruits_li">价格： 
						<a  href="/fruits/fruit/SelectFruitsBySwitchServlet" class="selkey" name="abc">不限</a>
						<a href="/fruits/fruit/SelectFruitsByPriceServlet?max=100" class="selkey" name="abc">100以下</a>
						<a href="/fruits/fruit/SelectFruitsByPriceServlet?min=100&max=300" name="abc">100~300</a>
						<a href="/fruits/fruit/SelectFruitsByPriceServlet?min=300" class="selkey" name="abc">300以上</a>
					</li>
					
					
				</ul>
				<script type="text/javascript">
					/*  把当前页面中，所有的属性为 name的 并且值等于abc的  元素， 全部选中*/
					/* 所有JQuery中  内置了 循环 */
					/*  hover   鼠标的移入和移出事件*/
					$("[name='abc']").hover(
						//鼠标移入控件后 执行什么
						function(){
							$(this).addClass("sgreen");
						}		
						,
						//鼠标移出 控件后  执行什么
						function(){
							$(this).removeClass("sgreen");
						}
					);
				</script>

			</div>
			<div class="fruitboxs">
				<c:forEach items="${info.list }"   var="fruit">
					<div class="fruit_box">
						<div class="fruit_img">
							<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${fruit.fId }"><img
								src="img/fruits/${fruit.fId }/(1).jpg" /></a>
						</div>
						<div class="fruit_name">
							<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${fruit.fId }">${fruit.fName }</a>
						</div>
						<div class="fruit_spec">${fruit.fNorm }</div>
						<div class="fruit_up">￥${fruit.fPrice }</div>
						<div class="flogo">
							<img src="img/flogo.png" />
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<br>
		<div  style="text-align: center;">
				<c:if test="${info.hasPreviousPage}">
					<a  href="${url}&pageNum=${info.pageNum-1}">上一页</a>
				</c:if>
				<c:if test="${info.hasNextPage}">
					<a  href="${url}&pageNum=${info.pageNum+1}">下一页</a>
				</c:if>
		</div>
				
</body>
</html>
