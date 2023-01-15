<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ztcly
  Date: 2021/6/14
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,com.ztcly.shop.Service.NetdiskService,com.ztcly.shop.model.Good" %>

<%


    String username = (String)session.getAttribute("username");
    String userid = (String)session.getAttribute("userid");
    String shopid =(String)session.getAttribute("shopid");

%>
<html>
<head>
    <title>云盘</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Free Flat Admin Bootstrap Themes">
    <meta name="author" content="Charuwit Nodthaisong">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet" type="text/css">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="css/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" type="text/css" href="css/select2.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/Chart.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body class="flat-blue sidebar-collapse">
<div class="sidebar">
    <div class="menu-control toggle-sidebar">
        <a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i>商城</a>
        <i class="fa fa-bars navicon"></i>
    </div>
    <ul class="menu">
        <li class="submenu">
            <a href="goodindexpage" >
                <div>
                    <i class="menu-icon fa fa-th-large"></i>
                    <span class="menu-title">商品界面</span>
                </div>
            </a>
        </li>
        <li class="submenu">
            <a href="element.html" class="active">
                <div>

                    <span class="menu-title">店铺与资料</span>
                </div>
            </a>
        </li>
        <li class="submenu">
            <a href="shop">
                <div>
                    <i class="menu-icon fa fa-table"></i>
                    <span class="menu-title">店铺</span>
                </div>
            </a>
        </li>
        <li class="submenu">
            <a href="/profilepage">
                <div>
                    <i class="menu-icon fa fa-file-text-o"></i>
                    <span class="menu-title">资料</span>
                </div>
            </a>
        </li>

        <li class="submenu dropdown">

            <ul class="dropdown-menu" style="display: none;">
                <li>
                    <a href="custom-dashboard.html">
                        <div>
                            <i class="menu-icon fa fa-bar-chart"></i>
                            <span class="menu-sub-title">商品</span>
                        </div>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
</div>
<div class="content-container wrap">
    <nav class="navbar navbar-default">
        <div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i>商城</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">

                        <ul class="dropdown-menu" style="display: none;">
                            <li class="dropdown-title-bar">
                                Notification ( 0 )
                            </li>
                            <li class="message">
                                No new notification
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown notification-alert">

                        <ul class="dropdown-menu" style="display: none;">
                            <li class="dropdown-title-bar">
                                Notification ( 3 )
                            </li>
                            <li>
                                <ul class="notification-list">
                                    <li>
                                        <a href="#">
                                            <div class="noti-icon noti-alert">
                                                <i class="fa fa-exclamation-circle fa-2x"></i>
                                            </div>
                                            <div class="noti-message">1 new registration</div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="noti-icon noti-success">
                                                <i class="fa fa-check fa-2x"></i>
                                            </div>
                                            <div class="noti-message">3 new orders</div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="noti-icon noti-primary">
                                                <i class="fa fa-comments fa-2x"></i>
                                            </div>
                                            <div class="noti-message">2 customers messages</div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><%out.print(username);%><span class="caret"></span></a>
                        <ul class="dropdown-menu user-info" style="display: none;">
                            <li class="dropdown-title-bar">
                                <img src="images/profile.jpg" class="profile-img">
                            </li>
                            <li>
                                <div class="navbar-login">
                                    <h4 class="user-name"><%out.print(username);%></h4>
                                    <p><%out.print(userid);%></p>
                                    <div class="btn-group margin-bottom-2x" role="group">
                                        <a href="/profilepage"><button type="button" class="btn btn-default"><i class="fa fa-user"></i> 管理</button></a>
                                        <button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> 登出</button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12">
                <span class="page-title red"><h2>云盘</h2></span>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">

                <ol class="breadcrumb">
                    <li><a href="/shop">主页</a>
                    </li>
                    <li class="active">云盘
                    </li>
                </ol>
            </div>
        </div>



    </div>
    <div class="container-fluid">
        <div class="block-content">
            <div class="form-group">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">文件列表</h3>
                    </div>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>文件</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
<%--                            表格正文--%>
                       <%-- <%
                            if((boolean) session.getAttribute("goodlistisempty"))    {
                                out.print("<tr><th>暂时没有货物</th></tr>");
                            }
                            else{
                               out.print("");
                            }
                        %>--%>
                        <c:choose>
                            <c:when test="${empty filelist}">
                                <tr><th>暂时没有文件</th></tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${filelist}" var="in">
                                    <c:out value="<tr>" escapeXml="false"></c:out>
                                    <c:out value="<th>${in}</th>" escapeXml="false"></c:out>
<%--                                    <c:out value="<th><img src=\"/image/${in.goodimage}\" /></th>" escapeXml="false"></c:out>--%>
                                    <c:out value="<th><button type=\"button\" class=\"btn btn-sm btn-info\" onclick=\"Delete('${in}')\">删除</button><button type=\"button\" class=\"btn btn-sm btn-info\" onclick=window.open(\"/download/${in}\")>下载</button></th>" escapeXml="false"></c:out>
<%--                                    <c:out value="<th></th>" escapeXml="false"></c:out>--%>
                                    <c:out value="</tr>" escapeXml="false"></c:out>
                              </c:forEach>
                            </c:otherwise>
                        </c:choose>

                        </tbody>
                    </table>

                </div>
                <div class="form-group">
                    <form action="/uploadfile" method="post" enctype="multipart/form-data">
<%--                        <label for="goodnameinput">上传文件</label>--%>
<%--                        <input type="text" class="form-control" id="goodnameinput" placeholder="输入商品名称" name="goodname">--%>
                        <label for="exampleInputFile">上传文件</label>
                        <input type="file" accept="*" id="exampleInputFile" name="file">
                        <p class="help-block">在这里上传文件</p>
                        <button type="submit" class="btn btn-primary">上传文件</button>
                    </form>
                </div>
            </div>


        </div>
    </div>
</div>
<script type="text/javascript">
    function Delete(id){
        $.ajax({
            url:'/deletefile',
            data:{file:id},
            type : 'POST',
            dataType : 'json',
            success:function(data){

            },

        })
        location.reload();
    }
    function Download(id){
        $.ajax({
            url:'/download',
            data:{file:id},
            type : 'POST',
            dataType : 'json',
            success:function(data){

            },

        })
        location.reload();
    }
    function open_win(filename) {
        window.open("");
    }
</script>
</body>
</html>
