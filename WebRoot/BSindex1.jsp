<%--
  Created by IntelliJ IDEA.
  User: xi
  Date: 2015/10/18
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8" />
  <title></title>
  <link rel="stylesheet" type="text/css" href="css/BSindex.css"/>
  <link rel="stylesheet" type="text/css" href="css/main.css"/>
  <script src="js/BSindex.js" type="text/javascript" charset="utf-8"></script>

</head>
<body >
<div class="mean">
  <div class="logo">
    <a href="index.jsp"><img src="img/alogo.png" alt="" /></a>
  </div>

  <div class="mean_ul">
    <div class="mean_li" onclick="sss('u')">用户管理</div>
    <div class="user_list" id="user_list">
      <div class="mm"><a href="${pageContext.request.contextPath }/FindClientServlet">全部用户</a></div>
      <div class="mm"><a href="${pageContext.request.contextPath }/BSindex2.jsp">添加用户</a></div>
    </div>
    <div class="mean_li" onclick="sss('f')">商品管理</div>
    <div class="fruit_list" id="fruit_list">
      <div class="mm"><a href="${pageContext.request.contextPath }/FindFruitServlet">库存水果</a></div>
      <div class="mm"><a href="${pageContext.request.contextPath }/hotFruitServlet">热卖水果</a></div>
      <div class="mm"><a href="${pageContext.request.contextPath }/BSindex5.jsp">水果入库</a></div>
    </div>
  </div>

</div>

<div class="gong" id="x1">
  <div class="con">
    <div class="tit">
      <ul>
        <li>用户名</li>
        <li class="i">&nbsp;</li>
        <li>邮箱</li>
        <li class="i">&nbsp;</li>
        <li>手机</li>
        <li class="i">&nbsp;</li>
        <li>操作</li>
      </ul>
    </div>
	
	<c:forEach items="${client}" var="user">
    <div class="info">
      <ul>
        <li><a href="${pageContext.request.contextPath}/findUserServlet?uid=${user.uid}">${user.username}</a></li>
        <li class="i">&nbsp;</li>
        <li><a href="${pageContext.request.contextPath}/findUserServlet?uid=${user.uid}">${user.email}</a></li>
        <li class="i">&nbsp;</li>
        <li><a href="${pageContext.request.contextPath}/findUserServlet?uid=${user.uid}">${user.tel}</a></li>
        <li class="i">&nbsp;</li>
        <li><a href="${pageContext.request.contextPath}/delUserServlet?uid=${user.uid}">删除</a></li>
      </ul>
    </div>    
  	</c:forEach>
  
  </div>
</div>

</body>
</html>

