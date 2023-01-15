<%--
  Created by IntelliJ IDEA.
  User: ztcly
  Date: 2021/6/13
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="login-box">
        <div class="title"><h3>注册账户</h3></div>
        <div class="progress hidden" id="login-progress">
            <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                登入
            </div>
        </div>
        <div class="alert alert-success hidden" id="login-message" role="alert">
            <i class="fa fa-check"></i> 信息正在提交，请稍等...
        </div>
        <div class="box">
            <form id="login-form" action="/registercon" method="get">


                <div class="control">
                    <div class="label">用户名</div>
                    <input type="text" class="form-control" name="username" />
                </div>
                <div class="control">
                    <div class="label">密码</div>
                    <input type="password" class="form-control" name="password"/>
                </div>
                <div class="login-button">
                    <input type="submit" class="btn btn-orange" value="注册"></button>
                </div>
            </form>
        </div>
        <div class="info-box">
            <span class="text-left"><a href="loginpage">已有账户?点此登录</a></span>
            <div class="clear-both"></div>
        </div>
    </div>
</div>
<%--<script type="text/javascript">
    $(function() {
        $("#login-form").submit(function() {
            $("#login-progress").removeClass("hidden");

            setTimeout(function(){
                $("#login-progress").addClass("hidden");
                $("#login-message").removeClass("hidden");
                setTimeout(function(){
                    window.location.assign("index.html")
                },1000);
            },1000);
            return false;
        });
    });
</script>--%>
</body>
</html>
