<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.11.3/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/JS/studentindex.js"></script>
</head>
<body style="background-image: url(<%=request.getContextPath()%>/HtmlImage/student/student.jpg);background-size:110% ;-moz-user-select:-moz-none;" onselectstart="return false;">
<nav class="navbar  navbar-fixed-top" style="background-color: rgba(223,240,216,1);">
    <div class="container">
        <div class="navbar-header" style="margin-left: 200px">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">基于案例的计算机网络教育平台</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">

            <ul class="nav navbar-nav" style="margin-left: 50px">
                <li style="border-radius: 5px;background-color:rgba(255,255,255,0.8); ">
                    <a href="#">个人主页</a>
                </li>

                <!--<li>
                    <a href="#">论坛中心</a>
                </li>
                -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">关于我们<span class="caret"></span></a>
                    <ul class="dropdown-menu">

                        <li>
                            <a href="#">项目介绍</a>
                        </li>
                        <li>
                            <a href="#">加入我们</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">其他</li>
                        <li>
                            <a href="#">项目测试专用</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <img src="<%=request.getContextPath()%>/HtmlImage/head.PNG" class="img-circle" id="Head_portrait" style="width: 40px;height: 40px;margin-top: 5px" />
                </li>

                <li class="dropdown" style="margin-left:10px;">
                    <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="margin-top: 8px;" id="user">
                        <%=session.getAttribute("username")%>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#" style="text-align: center;"><span class="glyphicon glyphicon-user"></span>&nbsp;个人信息</a>
                        </li>
                        <li style="margin-top: 10px;">
                            <a href="#" style="text-align: center;"><span class="glyphicon glyphicon-edit"></span>&nbsp;课程反馈</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="jumptologin.do" style="text-align: center;"><span class="glyphicon glyphicon-off"></span>&nbsp;返回到登录</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<div class="container" style="margin-top:100px;">

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron"style=" background-color: rgba(255,255,255,0.8); padding-top:10px; padding-bottom: 10px; height: 260px">
        <h2>加入课堂</h2>
        <p>加入即时性课堂，由教师发布案例教学内容引导问题研究，学生完成相应问题，实现实践操作，参与课后讨论</p>
        <div class="row" style="margin-top: 50px">
            <div class="col-sm-4 ">
                <a class="btn btn-primary"role="button" data-toggle="modal" data-target=".bs-example-modal-sm"></span>&nbsp浏览已加入课堂</a>
            </div>
            <div class="col-sm-4 col-sm-offset-4">
                <div class="input-group">
                    <input type="text" class="form-control" id="input"placeholder="请输入课堂密钥加入课堂">
                    <span class="input-group-btn">
                    <a class="btn btn-default" type="button" id="go">Go!</a>
                    </span>
                </div><!-- /input-group -->
            </div>

        </div>
    </div>


    <div class="jumbotron" style="background-color: rgba(255,255,255,0.8); margin-top:100px;padding-top:10px; padding-bottom: 10px;height: 260px">
        <h2>典型案例课程</h2>
        <p style="margin-top:25px;">平台精选案例，课程内容丰富</p>
        <p></p>
        <p style="margin-top:50px;">
            <a class="btn btn-primary"role="button"><span class="glyphicon glyphicon-th-list" style="top: 2px"></span>&nbsp课程案例选择</a>
        </p>
    </div>
    <!--模态窗口-->
    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog" style="margin-top: 250px" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="gridSystemModalLabel">已加入课堂</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-10 col-sm-offset-1">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th style="text-align: center">课堂id</th>
                                    <th style="text-align: center">课堂名</th>
                                    <th style="text-align: center">创建教师</th>
                                    <th style="text-align: center">课程进行</th>
                                    <th style="text-align: center">消息更新</th>
                                </tr>
                                </thead>
                                <tbody id="classroomtable">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
