
<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@   taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="head/css/head.css" />
</head>

<body>
	<div class="top">
		<div class="con">

			<div class="head_left">您好,欢迎来到天天果园！</div>

			<div class="head_left">您好,欢迎来到天天果园！</div>
			
			系统时间：<fmt:formatDate value="<%=new Date() %>"  timeStyle="short"  type="both"/>
			<div class="head_right noLink">
					<c:if test="${empty user  }">
						<a href="login.jsp">[ 登录 ]</a>&nbsp;&nbsp; 
					</c:if>
					<c:if test="${not empty user }">
						[ ${user.username }您好 ]
					</c:if>
				<a href="reg.jsp">
				[ 注册<span style="color: red;font-size: 12px;">有惊喜</span> ]
				</a>
			</div>
				<c:if test="${not empty user }">
			  		<div class="toStar"><a href="/fruits/star/GetStarsByUidServlet?uid=${user.uid}">我的关注</a></div>
				 </c:if>
          
		</div>
	</div>

	<%--网站图标、搜索框、购物车--%>
	<div class="head">
		<div class="con">

			<div class="logo">
				<a href="BSindex.jsp"> <img src="head/imgs/fdaylogo.png"
					alt="天天果园-水果网购首选品牌，水果，我们只挑有来头的！" />
				</a>
			</div>

			<div class="ser">
				<form action="/fruits/fruit/SelectFruitsBySwitchServlet"  method="get">
					<input  type="hidden"  name="pageNum"  value="1">
					<input type="text" name="fName" id="ser_border" value="苹果" /> 
					<input type="submit" name="ser_button" id="ser_button" value="搜索" />
				</form>
			</div>
				<c:if test="${not empty user }">
					<div class="shopcart">
						<div class="cart_img"></div>
						<div class="cart">
							<a href="/fruits/cart/GetCartFruitPovoByUidServlet?uid=${user.uid }">我的购物车</a>
							<div class="cart_num" id="cart_num">${fn:length(carts) }</div>
						</div>
						<div class="cart_to"></div>
					</div>
				</c:if>
		</div>
	</div>

	<%--网站菜单--%>
	<div class="head_menu">
		<div class="con">
			<ul class="hmenu_ul">
				<li><a href="index.jsp">首页</a></li>
				<li><a href="/fruits/fruit/SelectFruitsBySwitchServlet?pageNum=1">全部商品</a></li>
				<li><a href="/fruits/fruit/SelectFruitsBySwitchServlet?pageNum=1&fFlag=false">进口水果</a></li>
				<li><a href="/fruits/fruit/SelectFruitsBySwitchServlet?pageNum=1&fFlag=true">国货</a></li>
			</ul>
		</div>
	</div>

</body>
</html>
