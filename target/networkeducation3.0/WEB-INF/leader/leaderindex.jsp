<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/JS/courseapplicationmanage.js"></script>

</head>
<body style="background-image: url(<%=request.getContextPath()%>/HtmlImage/manager/mannager.jpg);background-size:100%;-moz-user-select:-moz-none;" onselectstart="return false;">
<nav class="navbar  navbar-fixed-top" style="background-color: rgba(223,240,216,1);">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#" style="margin-left: 150px">计算机网络教学平台管理者端</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">

            <ul class="nav navbar-nav" >
                <li style="border-radius: 5px;background-color:rgba(255,255,255,0.8); ">
                    <a href="#">主页</a>
                </li>
                <li>
                    <a href="#">流程管理</a>
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
                    <img src="<%=request.getContextPath()%>/HtmlImage/head.PNG" class="img-circle" id="Head_portrait" style="float:right;width: 40px;height: 40px;margin-top: 5px" />
                </li>

                <li class="dropdown" style="margin-left:10px;">
                    <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="margin-top: 10px;" id="user">
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
    <div class="row" style="margin-top:50px">
        <div class="col-sm-5"style="background-color: rgba(255,255,255,0.8);height: 550px">
            <h3>待审理课程</h3>
            <table class="table table-bordered table-hover" style="margin-top: 30px;">
                <thead>
                <tr>
                    <th style="text-align: center">编号</th>
                    <th style="text-align: center">申请课程名</th>
                    <th style="text-align: center">申请人</th>
                    <th style="text-align: center">发起时间</th>
                    <th style="text-align: center">附件</th>
                </tr>
                </thead>
                <tbody id="tbody1">

                </tbody>
            </table>
        </div>
        <div class="col-sm-6 col-sm-offset-1"style="background-color: rgba(255,255,255,0.8);height: 550px">
            <h3>历史申请</h3>
            <table class="table table-bordered table-hover"style="margin-top: 30px">
                <thead>
                <tr>
                    <th style="text-align: center">编号</th>
                    <th style="text-align: center">申请课程名</th>
                    <th style="text-align: center">申请人</th>
                    <th style="text-align: center">更新时间</th>
                    <th style="text-align: center">有未读信息？</th>
                </tr>
                </thead>
                <tbody id="tbody2">

                </tbody>
            </table>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="btn-group btn-group-sm" role="group" aria-label="..." style="margin-top: -35px;margin-left: 125px">
                <button type="button" class="btn btn-default" id="leftfristpage">第一页</button>
                <button type="button" class="btn btn-default" id="leftpreviouspage">上一页</button>
                <button type="button" class="btn btn-default" id="leftnextpage">下一页</button>
                <button type="button" class="btn btn-default" id="leftlastpage">最后页</button>
            </div>
        </div>
        <div class="col-sm-5 col-sm-offset-1">
            <div class="btn-group btn-group-sm" role="group" aria-label="..." style="margin-top: -35px;margin-left: 155px">
                <button type="button" class="btn btn-default" id="rightfristpage">第一页</button>
                <button type="button" class="btn btn-default" id="rightpreviouspage">上一页</button>
                <button type="button" class="btn btn-default" id="rightnextpage">下一页</button>
                <button type="button" class="btn btn-default" id="rightlastpage">最后页</button>
            </div>
        </div>

    </div>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document" style="width: 1500px;">
            <div class="modal-content" style="height:900px;">
                <!--头部-->
                <div class="modal-header" style="height: 65px">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-5">
                            <h3 class="modal-title">课程申请详情</h3>
                        </div>
                        <div class="col-sm-3">
                            <p id="hide"></p>
                        </div>
                    </div>
                </div>
                <!--中间部分-->
                <div class="modal-body" style="height: 780px">
                    <div class="row">
                        <div class="col-sm-5" style="height: 750px;margin-left: 50px">

                            <nav style="margin-top: 30px" id="navbar-example"role="navigation">
                                <div class="container-fluid">
                                    <div class="navbar-header">
                                        <button class="navbar-toggle" type="button" data-toggle="collapse"
                                                data-target=".bs-js-navbar-scrollspy">
                                            <span class="sr-only">切换导航</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                    </div>
                                    <div class="collapse navbar-collapse bs-js-navbar-scrollspy">
                                        <!--
                                        <ul class="nav navbar-nav">
                                            <li><a href="#case">案例课程名</a></li>
                                            <li><a href="#describle">课程描述</a></li>
                                            <li>
                                                <a href="#objective">教学目的</a></li>
                                            </li>
                                            <li>
                                                <a href="#annex">附件下载</a></li>
                                            </li>
                                        </ul>-->

                                        <ul class="nav nav-pills" role="tablist">
                                            <li><a href="#case" >案例课程名</a></li>
                                            <li><a href="#describle">课程描述</a></li>
                                            <li><a href="#aim">教学目的</a></li>
                                            <li><a href="#annex" >附件下载</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                            <div data-spy="scroll" data-target="#navbar-example" data-offset="0"
                                 style="height:650px;overflow:auto; position: relative;margin-top: 30px;margin-left: 30px">
                                <h3 id="case">案例课程名:</h3>
                                <p style="font-size: 20px;margin-top: 15px ;color: darkblue"  id="pcase">
                                </p>
                                <h3 id="describle" style="margin-top: 150px">课程描述:</h3>
                                <p style="font-size: 20px;margin-top: 15px ;color: darkblue" id="pdescrible">无</p>
                                <h3 id="aim"style="margin-top: 400px">教学目的</h3>
                                <p style="font-size: 20px;margin-top: 15px ;color: darkblue" id="paim">无</p>
                                <h3 id="annex"style="margin-top: 400px">附件下载地址</h3>
                                <a style="font-size: 15px;" id="pannex">无</a>
                                <div style="height: 500px"></div>
                            </div>

                        </div>
                        <div class="col-sm-5 col-sm-offset-1" id="divproposal" style="margin-top: 30px">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" id="lirecord" class="active"><a href="#record" aria-controls="record" role="tab" data-toggle="tab">历史沟通</a></li>
                                <li role="presentation" id="liproposal"><a href="#proposal" aria-controls="proposal" role="tab" data-toggle="tab">添加修改建议</a></li>
                                <li role="presentation" id="lipass"><a href="#pass" aria-controls="pass" role="tab" data-toggle="tab">给予通过</a></li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="record"style="padding-top: 30px">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th style="text-align: center">记录数</th>
                                            <th style="text-align: center">回复者</th>
                                            <th style="text-align: center">回复内容</th>
                                            <th style="text-align: center">状态</th>
                                            <th style="text-align: center">附件</th>
                                            <th style="text-align: center">时间</th>
                                        </tr>
                                        </thead>
                                        <tbody id="mtbody">
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="proposal">
                                    <div class="form-group">
                                        <label for="suggest"class="control-label" style="font-size: 20px" ><span class="glyphicon glyphicon-star-empty" style="top: 3px"></span>&nbsp;新的建议</label>
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
                                <div role="tabpanel" class="tab-pane"id="pass">
                                    <div class="row">
                                        <div class="col-sm-7 col-sm-offset-3" style="margin-top: 50px">
                                            <h3>确定予以通过开始页面制作？</h3>
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
