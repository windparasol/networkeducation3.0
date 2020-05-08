<%--
  Created by IntelliJ IDEA.
  User: 低调大港哥
  Date: 2020/2/5
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.11.3/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/JS/login.js"></script>
    <style>
        #github:hover svg {
            width: 160px;
            height: 160px;
        }
    </style>
    <title>登录</title>
</head>
<body style="background-color:papayawhip;-moz-user-select:-moz-none;" onselectstart="return false;">

<div class="container" style="margin-top: 100px;height:500px;" >
    <div class="col-sm-8 col-sm-offset-2" style=" height:400px;border: 1px solid gray;margin-top: 70px;box-shadow:10px 6px 10px 5px #AAAAAA;border-radius: 10px 10px 10px 10px;background-image: url(HtmlImage/login01.PNG);">
        <div class="row" style="margin-top: 30px;">
            <div class="col-sm-6 col-sm-offset-4">
                <h4><span class="glyphicon glyphicon-star-empty"></span>&nbsp 欢迎登录计算机网络教育平台</h4>
            </div>
        </div>
        <div class="row" style="margin-bottom: 10px;margin-top: 50px">
            <div class="col-sm-7 col-sm-offset-3" style="padding-top: 10px;">
                <form class="form-horizontal" action="<%=request.getContextPath()%>/login.do" method="post">
                    <div class="form-group">
                        <label for="username"class="col-sm-3 control-label" ><span class="glyphicon glyphicon-envelope"></span> Email</label>
                        <div ></div>
                        <div class="col-sm-7 col-sm-offset-1">
                            <input type="text" class="form-control" id="username" name="email" placeholder="电子邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">Password</label>
                        <div class="col-sm-7 col-sm-offset-1">
                            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-5" style="margin-top: 30px">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 记住密码
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-4">
                            <button type="button" id="register" class="btn btn-warning" style="width: 80px"
                                    data-toggle="modal" data-target="#myModal">注册</button>
                        </div>
                        <div class="col-sm-offset-3 col-sm-4">
                            <button type="submit" class="btn btn-success" style="width: 80px" id="login">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!--模态窗口-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">注册</h4>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-5 col-sm-offset-2">
                        <h4><span class="glyphicon glyphicon-star-empty"></span> 个人信息填写</h4>
                    </div>
                    <div class="col-sm-8 col-sm-offset-3">
                        <div class="row" id="divemail" style="margin-top: 30px;">
                            <label for="email" class="control-label col-sm-2" style=" margin-top:5px;">电子邮箱</label>
                            <div class="col-sm-6">
                                <input type="email" class="form-control" id="email" pattern="[a-zA-Z0-9]+@[a-zA-Z0-9]+\.(com)"
                                       title="请输入如1214qwe@21qq.com格式的邮箱" />
                            </div>
                            <div class="col-sm-4" style="height: 30px;" id="judgeemail">
                            </div>
                        </div>
                        <div class="row" id="divsickname" style="margin-top: 30px;">
                            <label for="sickname" class="control-label col-sm-2"style=" margin-top:5px;">账号昵称</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="sickname" pattern="^[a-zA-Z][a-zA-Z0-9_]{4,15}$"
                                       title="请输入以字母开头的5~8个字符串"/>
                            </div>
                            <div class="col-sm-4" style="height: 30px;" id="judgesickname">
                            </div>
                        </div>
                        <div class="row" id="divtruename" style="margin-top: 30px;">
                            <label for="truename" class="control-label col-sm-2"style=" margin-top:5px;">真实姓名</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="truename"pattern="^[\u0391-\uFFE5]+$" title="请输入中文"/>
                            </div>
                            <div class="col-sm-4" style="height: 30px;" id="judgetruename">
                            </div>
                        </div>
                        <div class="row" id="divphone" style="margin-top: 30px;">
                            <label for="phone" class="control-label col-sm-2"style=" margin-top:5px;">电话号码</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="phone" pattern="^1[3456789]\d{9}$" title="请输入手机号码"/>
                            </div>
                            <div class="col-sm-4" style="height: 30px;" id="judgephone">
                            </div>
                        </div>
                        <div class="row" id="divpwd" style="margin-top: 30px;">
                            <label for="password" class="control-label col-sm-2"style=" margin-top:5px;" >密码</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="pwd" pattern="^.{5,10}$" title="请输入5到8位任意字符" />
                            </div>
                            <div class="col-sm-4" style="height: 30px;" id="judgepwd">
                            </div>
                        </div>
                        <div class="row" id="divrepwd" style="margin-top: 30px;">
                            <label for="repwd" class="control-label col-sm-2"style=" margin-top:5px;" >确认密码</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="repwd" pattern="^.{5,10}$" title="请保证与密码相同" />
                            </div>
                            <div class="col-sm-4" style="height: 30px;" id="judgerepwd">
                            </div>
                        </div>

                        <div class="row" id="divuser" style="margin-top: 30px;">
                            <label for="usertype"class="control-label col-sm-2"style=" margin-top:5px;">用户类型</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="usertype">
                                    <option>请选择用户类型</option>
                                    <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;教师</option>
                                    <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生</option>
                                </select>
                            </div>
                            <div class="col-sm-4 col-sm-offset-2" style="height: 30px;" id="judgeusertype">
                            </div>
                        </div>

                        <div class="row" style="margin-top: 50px;">
                            <div class="col-sm-4 col-sm-offset-3">
                                <input type="checkbox" /> 已阅读
                                <a href="www.baidu.com">用户手册</a>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submit">提交</button>
            </div>

        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/live2d/autoload.js"></script>
</body>
</html>
