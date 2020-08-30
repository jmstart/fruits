<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
  <meta charset="utf-8" />
  <title>水果信息</title>
  <link rel="stylesheet" type="text/css" href="css/imgs.css"/>
  <link rel="stylesheet" type="text/css" href="css/main.css"/>
  <script type="text/javascript"  src="js/jquery.js"></script>
  <script src="js/imgs.js" type="text/javascript" charset="utf-8"></script>
</head>
<body onload="show()">
<jsp:include page="head/head.jsp"></jsp:include>

<div class="fruit_info">
  <div class="img_box">
  	<c:forEach  begin="1"  end="${fruit.fImgcount}"  var="i">
  		<c:if test="${i eq 1 }">
  			 <div id="p${i-1 }" class="show"><img src="img/fruits/${fruit.fId }/(${i}).jpg" /></div>
  		</c:if>
  		
  		<c:if test="${i!=1}">
  			<div id="p${i-1 }" class="non"><img src="img/fruits/${fruit.fId }/(${i}).jpg" /></div>
  		</c:if>
  	</c:forEach>
  
  
    <!-- <div id="p0" class="show"><img src="img/fruits/1/(1).jpg" /></div>
	<div id="p1" class="non"><img src="img/fruits/1/(2).jpg" /></div>
	<div id="p2" class="non"><img src="img/fruits/1/(3).jpg" /></div> -->


    <div class="img_to">
      <ul >
      		<c:forEach  begin="1"   end="${fruit.fImgcount}"  var="i">
             <li><img src="img/fruits/${fruit.fId}/(${i}).jpg" id="s${i-1}" onMouseMove="himg(this.id,${fruit.fImgcount})"/></li>
             </c:forEach>
          <!--    <li><img src="img/fruits/1/(2).jpg" id="s1" onMouseMove="himg(this.id)"/></li>
             <li><img src="img/fruits/1/(3).jpg" id="s2" onMouseMove="himg(this.id)"/></li> -->

      </ul>
    </div>
  </div>

  <div class="fruit_text">
    <div class="fname">${fruit.fName }</div>
    <p>&nbsp;</p>
    <div class="spec">
    <input type="radio" checked="checked" name="fnum_radio" value="fnum_radio" />${fruit.fNorm }</div>
    <div class="up">￥${fruit.fPrice }</div>
    <div class="fid">商品编号:${fruit.fId}</div>

    <hr />
<form  id="ffrm"   action="/fruits/star/AddStarServlet">
    <div class="fform">
        <div class="fform1">
      <div class="Uaddress">配送至 :
        <select name="address" id="sel">
          <option value="上海">上海</option>
          <option value="吉林">吉林</option>
          <option value="山西">山西</option>
          <option value="北京">北京</option>
        </select>
      </div>
      <div class="Unum">
      		<span id="numl"  >-</span>
      		<span id="number">1</span>
      		<span id="numr" >+</span>
      </div>
     <script type="text/javascript">
     	$("#numl").click(function(){
     		var  text =  $("#number").html();
     		text =  parseInt(text);
     		if(text<=1){
     			
     			location.href="index.jsp";
     		}else{
     			
     			$("#number").html(parseInt($("#number").html())-1);
     		}
     		
     		
     	});
     
     //id 选择器    元素   标签  document.getElementById("numr");  
     	$("#numr").click(function (){
     		//    定位到id=number 这个控件上   html() 把这个控件中间的文本取出来
     		var   res =  $("#number").html();
     		res  =parseInt(res)+1;
     		//把  增加后的  结果   写入到   id=number  这个控件span  的 文本中
     		$("#number").html(res);
     	});
     	
     </script>
     
      </div>
       <c:if test="${not empty user }">
          <div class="Uadd">
          	<input type="button" name="add" id="cart" value="加入购物车"  />
          </div>
          <div class="starbutton">
          	<c:if test="${empty  star  }">
          		<input type="button" name="add" id="star" value="关注" onclick="myAddStar()"/>
          	</c:if>
          	<c:if test="${not  empty  star  }">
          		<input type="button" name="add" id="star" value="已关注" onclick="javascript:alert('该商品已关注！！');"/>
          	</c:if>
          </div>
      </c:if>
      </div>
     <input  type="hidden"  name="scount"  value=""  id="scount" >
     <input  type="hidden"  name="fid"  value="${fruit.fId }"  id="fid">
 </form>
	<script type="text/javascript">
		function  myAddStar(){
			var  scount    =  document.getElementById("number").innerHTML;
			var   ffrm =   document.getElementById("ffrm");
			document.getElementById("scount").value=scount;
			ffrm.submit();
		}		
	</script>
    <hr />
    <div class="finfo">
      <h3>商品简介</h3>
      <p id="finfo_text">${fruit.fSummary}</p>

    </div>
    <hr />
    <div class="fpro">
      <h3>温馨提示</h3>
      <p id="fpro_text">${fruit.fPrompt}</p>

    </div>
    <hr />
  </div>

  <div class="fruit_hot" >
    <div class="hf_title"><span class="ht_l">热卖商品</span><span class="ht_r">
    	<a href="/fruits/fruit/LoadIndexServlet?page=fruit_info.jsp&pageNum=${hotinfo.pageNum+1 }">MORE+</a></span></div>
     
     <div class="hot_fruit">
     <c:forEach  items="${hotinfo.list }"  var="hf">
      <div class="hf_img">
      	<a href="/fruits/fruit/SelectFruitByFidServlet?fId=${hf.fId}">
      		<img src="img/fruits/${hf.fId }/(1).jpg" />
      	</a>
      </div>
      
      
	      <div class="hf_text">
	        <div class="hf_name"><a href="/fruits/fruit/SelectFruitByFidServlet?fId=${hf.fId}">${hf.fName }</a></div>
	        <div class="hf_mon">现货：￥<span>${hf.fPrice }</span></div>
	      </div>
      </c:forEach>   
    </div>
    

  </div>
</div>
<script type="text/javascript">
	$("#cart").click(function(){
		
		var  ccount = $("#number").text()  ;
		var  fid =  '${fruit.fId}'; 
		var   uid =   '${user.uid}';
		location.href=
			"/fruits/cart/AddCartServlet?uid="+uid+"&fid="+fid+"&ccount="+ccount;
	});

</script>
<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
