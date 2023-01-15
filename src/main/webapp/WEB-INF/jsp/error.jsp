<%--
  Created by IntelliJ IDEA.
  User: ztcly
  Date: 2021/6/14
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错了！</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css"><%--
    <style>
        div.col-md-4 col-lg-3 col-sm-6 col-xs-12{min-width: 350px;
            position:absolute;
            top:50%;
            left:50%;
            transform: translate(-50%, -50%);
            padding: 0;}
    </style>--%>
    <style>
        .errorinput{
            color:#000000
        }
    </style>
</head>
<body>
<div class="col-md-4 col-lg-3 col-sm-6 col-xs-12 login-box">
    <div class="panel panel-danger">
        <div class="panel-heading">
            <h3 class="panel-title">错误:${error.errortitle}</h3>
        </div>
        <div class="panel-body">
            <input class="errorinput" type="text" value="${error.errorinfo}" disabled/>
        </div>
        <div class="login-button">
            <a href="${error.nextpage}">
                <button type="button" class="btn btn-lg btn-danger">${error.nextpagetitle}</button>
            </a>

        </div>
    </div>
</div>
</body>
</html>
