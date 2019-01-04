<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>登录</title>

    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" th:href="@{/css/bootstrap.min.css}"rel="stylesheet">
	  <link href="../../css/login.css"rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="container">
		<div class="col-md-4 location">
	      <div class="form-signin text-center">
	        <h2 class="form-signin-heading">请登录</h2>
	        <label for="inputUserName" class="sr-only">用户名</label>
	        <input type="text" id="username" class="form-control s-margin-2" placeholder="用户名" required="required" autofocus>
	        <label for="inputPassword" class="sr-only">密码</label>
	        <input type="password" id="password" class="form-control s-margin-1" placeholder="密码" >
	        <input class="form-control" type="text" id="yan" placeholder="请输入验证码" >
	        <a href="javascript:void(0);" title="点击更换验证码">
	  		<img id="captcha_img" alt="点击更换" title="点击更换" onclick="refresh()" src="/sys/getVerify" />
	  		</a>
	        <button class="btn btn-lg btn-primary btn-block s-margin-2" id="login">登录</button>
	      </div>
	      </div>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery.min.js" th:src="@{/js/jquery.min.js}"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js" th:src="@{/js/bootstrap.min.js}"></script>
	<script src="../../js/comm.js" th:src="@{/js/comm.js}"></script>
  	<script type="application/javascript">
  	 //获取验证码
	  function refresh() {
          document.getElementById('captcha_img').src="/sys/getVerify?"+Math.random();
    };
  	$(function(){
		$("#login").bind("click",function(){
			var username=document.getElementById("username").value;
			var password=document.getElementById("password").value;
			var yan=document.getElementById("yan").value;
			$.ajax({
				type:'Get',
				url:comm.ServerUrl+"admins/login",
				data:{
					username:username,
					password:password,
					yan:yan
				},
		 		contentType:'application/json',
		 		dataType : 'json',
				success:function(data){
					console.log(data);
					if(data.status == 200){
						window.location.href=comm.ServerUrl+"admin/index";
					}else{
						alert(data.msg);
					}
				}
			});
			
		});
	});
	</script>
  </body>
</html>