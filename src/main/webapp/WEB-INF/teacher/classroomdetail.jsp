<%--
  Created by IntelliJ IDEA.
  User: 低调大港哥
  Date: 2020/4/14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>课堂管理页面</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.11.3/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/JS/classroomdetail.js"></script>
</head>
<body style="background-image: url(<%=request.getContextPath()%>/HtmlImage/teacher/juha.jpg);background-size:100% ;-moz-user-select:-moz-none;">
<div class="container-fluid"style="-moz-user-select:-moz-none;" onselectstart="return false;">
    <nav class="navbar  navbar-fixed-top" style="background-color: rgba(223,240,216,1);">
        <div class="container">
            <div class="navbar-header" style="margin-left: 150px">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">计算机网络教学平台教师端</a>
            </div>

            <div id="navbar" class="navbar-collapse collapse">

                <ul class="nav navbar-nav" style="margin-left: 30px">
                    <li>
                        <a href="jumptoteacherindex.do">个人主页</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" class="createclassroom" style="border-radius: 5px;background-color:rgba(255,255,255,0.8); ">课堂详情</a>
                    </li>
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
    <div class="row" style="margin-top: 70px">
        <div class="col-sm-2 col-sm-offset-1"style=" background-color: rgba(255,255,255,0.6); height: 40%">
            <div class="row">
                <div class="col-sm-12">
                    <h2 style="position:relative;left: 25%">课堂详情</h2>
                    <h4 style="margin-top: 10%" id="classroomid"></h4>
                    <h4 style="margin-top: 10%" id="classroomname"></h4>
                    <h4 style="margin-top: 10%">课堂描述：</h4>
                    <p id="classroomdescrible" style="font-size: 18px;margin-left: 32%"></p>
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-sm-offset-1" style=" background-color: rgba(255,255,255,0.6); height:600px">
            <div class="row">
                <div class="col-sm-10">
                <h2 style="position:relative;left: 38%">学生管理</h2>
                </div>
            </div>
            <div class="row" style="margin-top: 25px">
                <div class="col-sm-11">
                    <table class="table table-bordered table-hover" >
                        <thead>
                        <tr id="studenttr">
                            <th style="text-align: center">学号</th>
                            <th style="text-align: center">学生名</th>
                            <th style="text-align: center">关卡完成度</th>
                            <th style="text-align: center">问题更新</th>
                        </tr>
                        </thead>
                        <tbody id="studentbody">
                        </tbody>
                    </table>
                </div>

                <div class="btn-group btn-group-sm" role="group" aria-label="..." style="margin-top:320px;margin-left: 125px">
                    <button type="button" class="btn btn-default" id="leftfristpage">第一页</button>
                    <button type="button" class="btn btn-default" id="leftpreviouspage">上一页</button>
                    <button type="button" class="btn btn-default" id="leftnextpage">下一页</button>
                    <button type="button" class="btn btn-default" id="leftlastpage">最后页</button>
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-sm-offset-1" style="background-color: rgba(255,255,255,0.6);">
            <div class="row" id="casemanagediv">
            <h2 style="position:relative;left: 20%">课程管理</h2>
            <div style="margin-top:25px "><span style="font-size: 22px">正在进行的课程是：&nbsp&nbsp</span><span id="span1"></span></div>
            <p><a id="casemanagea">浏览课程资源</a></p>
            </div>
            <div class="row" style="margin-top: 30px" id="caselistdiv">
                <table class="table  table-bordered table-hover">
                    <thead>
                    <tr>
                        <th style="text-align: center">编号</th>
                        <th style="text-align: center">案例课程名</th>
                        <th style="text-align: center">制作人</th>
                        <th style="text-align: center">描述</th>
                        <th style="text-align: center">难度</th>
                        <th style="text-align: center">课堂资源</th>
                    </tr>
                    </thead>
                    <tbody id="selectcasebody">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="modal fade" id="caseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">案例问题设置</h4>
                </div>
                <div class="modal-body" id="casebody"style="padding-bottom: 40px">

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal" style="float: left" id="caseclose">关闭</button>
                    <button type="button" class="btn btn-primary" id="addquestion">添加问题</button>
                    <button type="button" class="btn btn-primary" id="casesubmit">提交</button>
                </div>

            </div>
        </div>
    </div>


    <div class="modal fade" id="studentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document" style="width: 1500px;">
            <div class="modal-content"style="height: 900px;">
                <div class="modal-header">
                    <h3 class="modal-title">学生详情</h3>
                </div>
                <div class="modal-body" id="stuentbody"style="padding-bottom: 40px;height: 770px">

                    <div class="row">
                        <div class="col-sm-5 col-sm-offset-1" id="divproposal" style="margin-top: 30px;border-right:1px solid gainsboro;height: 700px">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" id="lirecord" class="active"><a href="#leftfrist" aria-controls="leftfrist" role="tab" data-toggle="tab">学生信息</a></li>
                                <li role="presentation" id="liproposal"><a href="#leftsecond" aria-controls="leftsecond" role="tab" data-toggle="tab">问题交流</a></li>
                                <li role="presentation" id="lipass"><a href="#leftthird" aria-controls="leftthird" role="tab" data-toggle="tab">更多操作</a></li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="leftfrist"style="padding-top: 30px">
                                    <div class="row">
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <form class="form-horizontal" style="margin-top: 80px">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" style="font-size: 22px">id:</label>
                                                    <div class="col-sm-9">
                                                        <p class="form-control-static" id="pid" style="font-size: 22px">10</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"style="font-size: 22px">姓名</label>
                                                    <div class="col-sm-9">
                                                        <p class="form-control-static" id="pname"style="font-size: 22px">windparasol</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"style="font-size: 22px">昵称</label>
                                                    <div class="col-sm-9">
                                                        <p class="form-control-static" id="pnickname"style="font-size: 22px">email@example.com</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"style="font-size: 22px">电话</label>
                                                    <div class="col-sm-9">
                                                        <p class="form-control-static" id="pphone"style="font-size: 22px">email@example.com</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"style="font-size: 22px">电子邮箱</label>
                                                    <div class="col-sm-9">
                                                        <p class="form-control-static"id="pemail"style="font-size: 22px">email@example.com</p>
                                                    </div>
                                                </div>
                                            </form>

                                        </div>
                                    </div>

                                </div>

                                <div role="tabpanel" class="tab-pane" id="leftsecond">
                                    <table class="table table-striped table-bordered table-hover" style="margin-top: 30px">
                                        <thead>
                                        <tr>
                                            <th style="text-align: center">编号</th>
                                            <th style="text-align: center">关卡问题</th>
                                            <th style="text-align: center">分值</th>
                                            <th style="text-align: center">得分</th>
                                            <th style="text-align: center">状态</th>
                                        </tr>
                                        </thead>
                                        <tbody id="commubody">

                                        </tbody>
                                    </table>

                                </div>

                                <div role="tabpanel" class="tab-pane"id="leftthird">

                                </div>
                            </div>
                        </div>
                        <div class="col-sm-5" id="right" style="margin-top: 30px ;border-left-color:paleturquoise;" hidden="hidden">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation"class="active"><a href="#rightcom" aria-controls="rightcom" role="tab" data-toggle="tab">关卡沟通</a></li>
                                <li role="presentation"><a href="#rightsuggestion" aria-controls="rightsuggestion" role="tab" data-toggle="tab">问题引导</a></li>
                                <li role="presentation"><a href="#rightpass" aria-controls="rightpass" role="tab" data-toggle="tab">给予通过</a></li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="rightcom">
                                    <div class="row">
                                        <p3 style="margin-left: 20px;font-size: 22px">当前问题编号:&nbsp&nbsp</p3><span style="font-size: 20px" id="nowquestion"></span>
                                    </div>
                                    <div class="row">
                                        <table class="table table-striped table-bordered table-hover" style="margin-left: 10px">
                                            <thead>
                                            <tr>
                                                <th style="text-align: center">记录数</th>
                                                <th style="text-align: center">回复者</th>
                                                <th style="text-align: center">回复内容</th>
                                                <th style="text-align: center">状态</th>
                                                <th style="text-align: center">附件</th>
                                            </tr>
                                            </thead>
                                            <tbody id="replytbody">

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="rightsuggestion">
                                    <div class="form-group">
                                        <label for="suggest"class="control-label" style="font-size: 20px" ><span class="glyphicon glyphicon-star-empty" style="top: 3px"></span>&nbsp;问题引导建议</label>
                                        <div ></div>
                                        <div>
                                            <textarea class="form-control"id="suggest" style="margin-left: 18px" rows="25"></textarea>
                                        </div>
                                        <div style="margin-top: 50px">
                                            <div class="form-group">
                                                <div class="control-label"><label for="newannex" style="font-size: 20px"><span style="top: 3px;" class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;可添加附件</label></div>
                                                <div class="col-sm-7">
                                                    <div class="input-group">
                                                        <input id='location' class="form-control" onclick="$('#newannex').click();">
                                                        <label class="input-group-btn">
                                                            <input type="button" id="i-check" value="浏览文件" class="btn btn-success" onclick="$('#newannex').click();">
                                                        </label>
                                                    </div>
                                                </div>
                                                <input type="file" name="file" id='newannex'  accept=".png,.jpg,.docx,.pdf" onchange="$('#location').val($('#newannex').val());" style="display: none">
                                                <div class="col-sm-1 col-sm-offset-4">
                                                    <a class="btn btn-danger" style="margin-left: 54px" id="submit">提交</a>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div role="tabpanel" class="tab-pane"id="rightpass">
                                    <div class="row">
                                        <div class="col-sm-7 col-sm-offset-3" style="margin-top: 50px">
                                            <h3>给出分数通过关卡！</h3>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2 col-sm-offset-10" style="margin-top: 50px">
                                            <a class="btn btn-danger" id="coursepass">确定</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal" style="float: left" id="studentlose">关闭</button>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
