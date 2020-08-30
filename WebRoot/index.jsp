<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
<title>天天果园-水果网购首选品牌，水果，我们只挑有来头的！</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script src="js/imgs.js" type="text/javascript" charset="utf-8"></script>
<jsp:include page="head/head.jsp"></jsp:include>

</head>
<c:if test="${empty hotinfo }">
	<script type="text/javascript">
		location.href="/fruits/fruit/LoadIndexServlet?page=index.jsp&pageNum=1"
	</script>
</c:if>

<body onload="fimg()">
	<div class="imgs">
		<div class="con">
			<div id="p0" class="show">
				<a target="_blank"
					href="http://huodong.fruitday.com/sale/zhongqiu0906/pcsh.html"><img
					src="img/index/h0.jpg" alt="" /></a>
			</div>
			<div id="p1" class="non">
				<a target="_blank"
					href="http://huodong.fruitday.com/sale/midautumn/pc.html"><img
					src="img/index/h1.jpg" alt="" /></a>
			</div>
			<div id="p2" class="non">
				<a target="_blank"
					href="http://huodong.fruitday.com/sale/912_oh/pc.html"><img
					src="img/index/h2.jpg" alt="" /></a>
			</div>
			<div id="p3" class="non">
				<a target="_blank"
					href="http://subject.fruitday.com/sale/pg/pg.html"><img
					src="img/index/h3.jpg" alt="" /></a>
			</div>
			<div id="p4" class="non">
				<a target="_blank"
					href="http://huodong.fruitday.com/sale/Zespri_0901/PC.html"><img
					src="img/index/h4.jpg" alt="" /></a>
			</div>

			<ul class="imgul">
				<li id="l0" onmouseover="simg(this.innerHTML)" onmouseout="fimg()">1</li>
				<li id="l1" onmouseover="simg(this.innerHTML)" onmouseout="fimg()">2</li>
				<li id="l2" onmouseover="simg(this.innerHTML)" onmouseout="fimg()">3</li>
				<li id="l3" onmouseover="simg(this.innerHTML)" onmouseout="fimg()">4</li>
				<li id="l4" onmouseover="simg(this.innerHTML)" onmouseout="fimg()">5</li>
			</ul>
		</div>
	</div>

	<div class="fruitboxs">

		<div class="con">
			<div class="fhead">
				<div class="fhr"></div>
				<div class="ser_more">
					<div class="fser">热卖专区</div>
					<div class="fmore">
					<c:if test="${hotinfo.hasNextPage }">
						<a href="/fruits/fruit/LoadIndexServlet?page=index.jsp&pageNum=${hotinfo.pageNum+1 }">查看更多 ></a>
					</c:if>
					</div>
				</div>
			</div>
		<c:forEach  items="${hotinfo.list}"  var="hf">
			<div class="fruit_box">
				<div class="fruit_img">
					<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${hf.fId}">
					<img src="img/fruits/${hf.fId }/(1).jpg" /></a>
				</div>
				<div class="fruit_name">
					<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${hf.fId}">${hf.fName }</a>
				</div>
				<div class="fruit_num">${hf.fNorm }</div>
				<div class="fruit_mon">${hf.fPrice}</div>
			</div>
		</c:forEach>	

		</div>
	</div>

	<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>

<!--<script language="javascript">
function getData() {
window.location.href = "getDataServlet";
}
</script>
<BODY onload="getData()">-->

