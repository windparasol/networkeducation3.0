<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/JS/teacherindex.js"></script>

</head>
<body style="background-image: url(<%=request.getContextPath()%>/HtmlImage/teacher/teacher3.jpg);background-size:120%;-moz-user-select:-moz-none;" onselectstart="return false;">
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
                <li style="border-radius: 5px;background-color:rgba(255,255,255,0.8); ">
                    <a href="#">个人主页</a>
                </li>
                <li>
                    <a href="javascript:void(0)" class="createclassroom">课堂创建</a>
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

<div class="container" style="margin-top:150px;">

    <!--<div class="jumbotron"style=" background-color: rgba(255,255,255,0.5); padding-top:10px; padding-bottom: 10px; height: 260px">
        <div class="col-sm-5">
        <h2>新案例课堂创建</h2>
        <p>填写基本信息</p>
        <div class="row" style="margin-top: 40px">
            <div class="col-sm-4">
                <a class="btn btn-primary"role="button" href="jumptoclassroommanage.do"></span>立即创建</a>
            </div>
        </div>
        </div>
    </div>
    -->

    <div class="jumbotron"style=" background-color: rgba(255,255,255,0.8); padding-top:10px; padding-bottom: 10px; height: 260px">
        <div id="classroomdiv"class="col-sm-5">
            <h2 id="h1">课堂管理</h2>
            <p id="p1">点击课堂名进行管理</p>
        </div>
        <div class="col-sm-5" id="showdiv">
            <table class="table table-bordered table-hover" style="margin-top: 13px;background-color: rgba(255,255,255,0.3)">
                <thead>
                <tr>
                    <th style="text-align: center">课堂编号</th>
                    <th style="text-align: center">课堂名</th>
                </tr>
                </thead>
                <tbody id="classroombody">

                </tbody>
            </table>
        </div>

    </div>

    <div class="jumbotron"style=" background-color: rgba(255,255,255,0.8); padding-top:10px; padding-bottom: 10px; height: 260px">
        <h2>课程申请</h2>
        <p>提交课程申请或查看申请最新情况</p>
        <div class="row" style="margin-top: 50px">
            <div class="col-sm-4 ">
                <a class="btn btn-primary" id="application"role="button" href="javascript:void(0)"></span>查看&nbsp<span class="badge"></span></a>
            </div>
            <div class="col-sm-4 col-sm-offset-4">
            </div>

        </div>
    </div>

    <!--创建课堂模块窗口-->
    <div class="modal fade" id="classroomModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" style="margin-top: 250px" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">课堂创建</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-5 col-sm-offset-2">
                            <h4><span class="glyphicon glyphicon-star-empty"></span> 课堂信息填写</h4>
                        </div>
                        <div class="col-sm-8 col-sm-offset-2">
                            <div class="row" style="margin-top: 30px;">
                                <div class="col-sm-3">
                                    <label for="classroomname"class="control-label" style=" margin-top:5px;">课堂名</label>
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="classroomname"/>
                                </div>
                            </div>
                            <div class="row" style="margin-top: 30px;">
                                <div class="col-sm-3"><label for="classroomdescrible">课堂描述</label></div>
                                <div class="col-sm-9">
                                    <textarea id="classroomdescrible" rows="5"class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal" style="float: left">关闭</button>
                    <button type="button" class="btn btn-primary" id="cratesubmit">提交</button>
                </div>

            </div>
        </div>
    </div>
    <!--课程申请模态窗口部分-->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document" style="width: 1500px;">
            <div class="modal-content" style="height:900px;">
                <!--头部-->
                <div class="modal-header" style="height: 65px">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-5">
                            <h3 class="modal-title">课程申请</h3>
                        </div>
                        <div class="col-sm-3">
                            <p id="hide"></p>
                        </div>
                    </div>
                </div>
                <!--中间部分-->
                <div class="modal-body" style="height: 780px">

                    <div class="row">
                        <div class="col-sm-5 col-sm-offset-1" style="height: 750px">

                            <ul class="nav nav-pills" role="tablist">
                                <li role="presentation" class="active"><a href="#frist" aria-controls="frist" role="tab" data-toggle="tab">历史申请</a></li>
                                <li role="presentation" ><a href="#second" aria-controls="second" role="tab" data-toggle="tab" id="newcom">提交新申请</a></li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="frist"style="padding-top: 30px">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th style="text-align: center">申请编号</th>
                                            <th style="text-align: center">案例课程名</th>
                                            <th style="text-align: center">状态</th>
                                            <th style="text-align: center">时间</th>
                                            <th style="text-align: center">消息</th>
                                        </tr>
                                        </thead>
                                        <tbody id="table">

                                        </tbody>
                                    </table>
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
                        <div class="col-sm-5 col-sm-offset-1" id="hidediv" hidden="hidden">
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#third" aria-controls="third" role="tab" data-toggle="tab">历史交流</a></li>
                                <li role="presentation" ><a href="#fourth" aria-controls="fourth" role="tab" data-toggle="tab">修改提交</a></li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="third"style="padding-top: 30px">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th style="text-align: center">回复者</th>
                                            <th style="text-align: center">回复内容</th>
                                            <th style="text-align: center">状态</th>
                                            <th style="text-align: center">附件</th>
                                            <th style="text-align: center">时间</th>
                                        </tr>
                                        </thead>
                                        <tbody id="comtable">

                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="fourth">
                                    <div class="form-group">
                                        <label for="suggest"class="control-label" style="font-size: 20px" ><span class="glyphicon glyphicon-star-empty" style="top: 3px"></span>&nbsp;案例修改</label>
                                        <div ></div>
                                        <div>
                                            <textarea class="form-control"id="suggest"  rows="25"></textarea>
                                        </div>
                                        <div style="margin-top: 50px">
                                            <div class="form-group">
                                                <div class="control-label"><label for="newannex" style="font-size: 20px"><span style="top: 3px;" class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;可添加附件</label></div>
                                                <div class="col-sm-6">
                                                    <div class="input-group">
                                                        <input id='location0' class="form-control" onclick="$('#newannex').click();">
                                                        <label class="input-group-btn">
                                                            <input type="button" id="check" value="浏览文件" class="btn btn-success" onclick="$('#newannex').click();">
                                                        </label>
                                                    </div>
                                                </div>
                                                <input type="file" name="file" id='newannex'  accept=".png,.jpg,.docx,.pdf" onchange="$('#location0').val($('#newannex').val());" style="display: none">
                                                <div class="col-sm-1 col-sm-offset-4">
                                                    <a class="btn btn-danger" id="comsubmit">提交</a>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--尾部-->
                <div class="modal-footer" style="padding-top: 9px">
                    <button type="button"  class="btn btn-default" data-dismiss="modal" style="color:royalblue;float: right" id="close">关闭</button>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
