<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>用户登陆 - 天天果园-水果网购首选品牌，水果，我们只挑有来头的！</title>
  <link rel="stylesheet" type="text/css" href="css/main.css"/>
  <link rel="stylesheet" type="text/css" href="css/rl.css"/>
  <script type="text/javascript"  src="js/jquery.js"></script>
  <script>
    window.onload=function footer_img_non(){
      document.getElementById("footer_img").style.display="none";
    }
  </script>
</head>
<body>
  <div class="con">
    <div class="box">
      <div class="head">
        <a href="index.jsp">
          <img src="img/logo_login.png" alt="" />
        </a>
      </div>

      <div class="text">
        <div class="text_head">
          <span class="h01">会员登录</span>
          <div class="xhr"></div>
        </div>
        <form action="/fruits/user/LoginServlet"  method="post"  id="loginfrm">
          <div class="text_box">
            <div class="main"><div class="name">邮箱/手机：</div>
              <input type="text" name="tel_email" placeholder="请输入邮箱或手机" id="tel_email" value="" />
              <label  id="tel_email_label"></label>
            </div>
            <div class="main"><div class="name">密码：</div>
              <input type="password" name="password" placeholder="请输入密码" id="password" value="" />
              <label  id="password_label"></label>
            </div>
            <div class="xbutton">
              <input type="button" name="login" id="login" value="登录" />
            </div>
            <div class="fpwd">
              <a href="">忘记密码 ></a>
            </div>
          </div>

        </form>
      </div>
	<script type="text/javascript">
		$(function(){
			$("#login").click(function(){
				var  res =  verifyTelEmail() && verifyPassword();
				if(res){
					$("#loginfrm").submit();  
					
				}else{
					
					alert("登录信息有错误。请检查！");
				}
				
				
			});
			function  verifyTelEmail(){
				var   value = $("#tel_email").val();
				if(value==""||value==null){
					$("#tel_email_label").text("手机\Email不能为空！");
					$("#tel_email_label").css({color:"red",border:"1px solid #ff9900"});
					$("#tel_email_label").show();
					return  false ; 
					//document.getElementById("tel_email_label").style.color="red";
					//document.getElementById("tel_email_label").style.border="1px solid red";
				}else{
					$("#tel_email_label").text("通过！");
					$("#tel_email_label").css({color:"green",border:"1px solid green"});
					$("#tel_email_label").show();
					return  true ; 
				
				}
				
			
			}
			function  verifyPassword(){
				var  value =  $("#password").val();
				if(value==""||value==null){
					$("#password_label").text("密码不能为空");
					$("#password_label").css({color:'red',border:"1px solid red"});
					$("#password_label").show();
					return false ; 
				}else{
					
					$("#password_label").text("通过！！！");
					$("#password_label").css({color:'green',border:"1px solid green"});
					$("#password_label").show();
					return   true ;
				}
			}
			
			
			///邮箱Tel  文本框   鼠标  丢失事件 
			$("#tel_email").blur(function(){
				var   value = $("#tel_email").val();
				if(value==""||value==null){
					$("#tel_email_label").text("手机\Email不能为空！");
					$("#tel_email_label").css({color:"red",border:"1px solid #ff9900"});
					$("#tel_email_label").show();
					return  false ; 
					//document.getElementById("tel_email_label").style.color="red";
					//document.getElementById("tel_email_label").style.border="1px solid red";
				}else{
					$("#tel_email_label").text("通过！");
					$("#tel_email_label").css({color:"green",border:"1px solid green"});
					$("#tel_email_label").show();
					return  true ; 
				}
				
			});
			// 邮箱Tel 文本框 鼠标  获取  焦点 事件
			$("#tel_email").focus(function(){
				
				$("#tel_email_label").hide();
				
			});
			
			
			//password  丢失焦点 
			$("#password").blur(function(){
				var  value =  $("#password").val();
				if(value==""||value==null){
					$("#password_label").text("密码不能为空");
					$("#password_label").css({color:'red',border:"1px solid red"});
					$("#password_label").show();
					return false ; 
				}else{
					
					$("#password_label").text("通过！！！");
					$("#password_label").css({color:'green',border:"1px solid green"});
					$("#password_label").show();
					return   true ;
				}
			});
			//  密码  获取焦点  
			$("#password").focus(function(){
				
				$("#password_label").hide();
				
			});
			
			
		});
	</script>
      <div class="jmp">
        <div class="jmpp">
          <p>还没有天天果园账号?</p>
          <p>注册赠时令鲜果1份</p>
        </div>
        <div class="jmpa_l">
          <a href="reg.jsp">立即注册&nbsp;></a>
        </div>
      </div>
    </div>

    <jsp:include page="footer/footer.jsp"></jsp:include>
  </div>
</body>
</html>
