<%--
  Created by IntelliJ IDEA.
  User: 低调大港哥
  Date: 2020/2/13
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>局域网</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/lan.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/JS/lan.js"></script>
</head>
<body style="background-color:papayawhip;">
<nav class="navbar navbar-inverse" id="nav">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li id="brand">
                    <a href="<%=request.getContextPath()%>/index.do">主页</a>
                </li>

                <li class="active">
                    <a href="javascript:void(0)">案例资源<span class="sr-only">(current)</span></a>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">关于我们 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"></a>
                        </li>
                        <li>
                            <a href="#">项目介绍</a>
                        </li>
                        <li>
                            <a href="#">加入我们</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="<%=request.getContextPath()%>/jumpcontentinput.do">课程输入测试</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <img src="<%=request.getContextPath()%>/HtmlImage/head.PNG" alt="..." class="img-circle"  id="Head_portrait"/>

                </li>


                <li class="dropdown">
                    <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenu1"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="margin-top: 8px;">
                        <%=session.getAttribute("username")%>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#" style="text-align: center;"><span class="glyphicon glyphicon-user" ></span>&nbsp;个人中心</a>
                        </li>
                        <li style="margin-top: 10px;">
                            <a href="#" style="text-align: center;"><span class="glyphicon glyphicon-edit"></span>&nbsp;课程反馈</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#" style="text-align: center;"><span class="glyphicon glyphicon-off"></span>&nbsp;返回到登录</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="row">
        <div class="col-sm-5 col-sm-offset-1">
            <div class="page-header">
                <h2 id="head" style="color: peru ;font-size: 40px">小型局域网的搭建</h2>
            </div>
            <p><small style="color:peru;margin-left: 25%">课程id：&nbsp01</small></p>
            <p ><small style="color: peru;margin-left: 25%">制作人：&nbspwindparasol</small></p>
        </div>
    </div>
</div>
<div class="container-fluid">

    <div class="row">
        <div class="col-sm-8 col-sm-offset-2" style="background-color: white;height: 650px;">
            <ul class="nav nav-pills" role="tablist" style="margin-left: 3%;margin-top: 3%;">
                <li role="presentation" class="active"><a href="#frist" aria-controls="frist" role="tab" data-toggle="tab">案例信息</a></li>
                <li role="presentation" ><a href="#second" aria-controls="second" role="tab" data-toggle="tab" id="newcom">基本知识点</a></li>
                <li role="presentation" ><a href="#second" aria-controls="second" role="tab" data-toggle="tab" id="video">实验内容</a></li>
            </ul>

            <div class="tab-content" style="border: lavender solid 1px;margin-top: 2%;padding-bottom: 3%">
                <div role="tabpanel" class="tab-pane active" id="frist">
                    <div class="row">
                        <div class="col-sm-4" style=" margin-top: 3%;margin-left: 3%">
                                <img src="<%=request.getContextPath()%>/img/timg.jpg" alt="..."class="img-thumbnail">
                        </div>
                        <div class="col-sm-6" style="height: 400px;">
                            <div class="row">
                                <div class="page-header">
                                    <h3 class="text-info"style="color:goldenrod">情景描述</h3>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-8" style="margin-left: 29%">
                                    <p id="p1" class="text-success">

                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div role="tabpanel" class="tab-pane" id="second">
                    <div class="row">
                        <div class="col-sm-6 ">
                            <div class="input-group input-group-lg" style="margin-top: 30px">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-list-alt"></span></span>
                                <input type="text" class="form-control"id="casetitile" placeholder="案例课程名" aria-describedby="sizing-addon1">
                            </div>
                        </div>
                    </div>

                    <div class="row"style="margin-top: 50px">
                        <div class="col-sm-6">
                            <label for="casedescrible" class="form-control-static">案例描述</label>
                            <textarea id="casedescrible" rows="6"class="form-control"></textarea>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <label for="aim" class="form-control-static">教学目标</label>
                            <textarea id="aim" rows="6" class="form-control"></textarea>
                        </div>
                    </div>

                    <div class="form-group" style="margin-top: 30px">
                        <div class="control-label"><label for="annex" style="font-size: 20px"><span style="top: 3px;" class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;可添加附件</label></div>
                        <div class="col-sm-7">
                            <div class="input-group">
                                <input id='location' class="form-control" onclick="$('#annex').click();">
                                <label class="input-group-btn">
                                    <input type="button" id="i-check" value="浏览文件" class="btn btn-success" onclick="$('#annex').click();">
                                </label>
                            </div>
                        </div>
                        <input type="file" name="file" id="annex"  accept=".png,.jpg,.docx,.pdf" onchange="$('#location').val($('#annex').val());" style="display: none">

                        <a class="btn btn-danger" style="margin-left: 54px" id="submit">提交</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>