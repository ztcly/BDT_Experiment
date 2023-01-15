<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<%
    String username = (String) session.getAttribute("username");
    String userid = (String) session.getAttribute("userid");
%>
<!DOCTYPE html>
<html>
<head>
    <title>商品页面</title>
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
    <script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/js/dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="/js/main.js"></script>
</head>

<body class="flat-blue sidebar-collapse">
<div class="sidebar">
    <div class="menu-control toggle-sidebar">
        <a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i>商城</a>
        <i class="fa fa-bars navicon"></i>
    </div>
    <ul class="menu">
        <li class="submenu">
            <a href="goodindexpage" class="active">
                <div>
                    <i class="menu-icon fa fa-th-large"></i>
                    <span class="menu-title">商品界面</span>
                </div>
            </a>
        </li>
        <li class="submenu">

            <div>

                <span class="menu-title">店铺与资料</span>
            </div>

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
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-expanded="false"><%out.print(username);%><span class="caret"></span></a>
                        <ul class="dropdown-menu user-info" style="display: none;">
                            <li class="dropdown-title-bar">
                                <img src="images/profile.jpg" class="profile-img">
                            </li>
                            <li>
                                <div class="navbar-login">
                                    <h4 class="user-name"><%out.print(username);%></h4>
                                    <p><%out.print(userid);%></p>
                                    <div class="btn-group margin-bottom-2x" role="group">
                                        <a href="/profilepage"> <button type="button" class="btn btn-default"><i class="fa fa-user"></i> 管理
                                        </button></a>
                                        <button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> 登出
                                        </button>
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
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="content-block">
            <div class="block-title">Datatable</div>
            <div class="block-content">
                <div id="example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="example" class="table table-striped dataTable no-footer" cellspacing="0"
                                   width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
                                <thead>
                                <tr role="row">
                                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1"
                                        aria-label="Name: activate to sort column ascending" style="width: 137px;">商品名称
                                    </th>
                                    <th class="sorting_desc" tabindex="0" aria-controls="example" rowspan="1"
                                        colspan="1" aria-label="Position: activate to sort column ascending"
                                        style="width: 212px;" aria-sort="descending">商品图片
                                    </th>
                                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1"
                                        aria-label="Office: activate to sort column ascending" style="width: 95px;">
                                        商店
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${empty glist}">
                                        <tr><th>暂时没有货物</th></tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${glist}" var="in">
                                            <c:out value="<tr>" escapeXml="false"></c:out>
                                            <c:out value="<th>${in.goodname}</th>" escapeXml="false"></c:out>
                                            <c:out value="<th><img src=\"/image/${in.goodimage}\" /></th>" escapeXml="false"></c:out>
                                            <c:out value="<th>${in.shopid}</th>" escapeXml="false"></c:out>
                                            <c:out value="</tr>" escapeXml="false"></c:out>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
<%--

                                <tr role="row" class="odd">
                                    <td class="">Prescott Bartlett</td>
                                    <td class="sorting_1">Technical Author</td>
                                    <td>London</td>
                                    <td>27</td>
                                    <td>2011/05/07</td>
                                    <td class="">$145,000</td>
--%>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#example').DataTable();
    });
</script>
<footer class="footer">
    <span><i class="fa fa-copyright"></i> 2021/06/14</span>
</footer>


</body>
</html>
