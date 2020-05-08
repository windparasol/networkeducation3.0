$(function () {
    /**5个变量分别表示五个控件的状态，是否符合规定，设置为全局方便提交时进行判断**/
    var testemail=false;
    var testsickname=false;
    var testtruename=false;
    var testphone=false;
    var testpwd=false;
    var testtype=false;
    /**相关的控件的正则表达式判断**/
    $("#email").bind("input",function () {
        var reg = new RegExp("^([a-zA-Z]|[0-9])(\\w|\\-)+@[a-zA-Z0-9]+\\.([a-zA-Z]{2,4})$");
        if(!reg.test($(this).val())){
            console.info($("#email").val());
            $("#judgeemail").empty();
           $("#judgeemail").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:red").attr("class","glyphicon glyphicon-remove")));
            $("#divemail").attr("class","row has-error");
            testemail = reg.test($(this).val());
        }
        else{
            $("#judgeemail").empty()
            $("#judgeemail").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:green").attr("class","glyphicon glyphicon-ok")));
            $("#divemail").attr("class","row has-success")
            testemail = reg.test($(this).val());
        }

    })
    $("#email").bind("blur",function () {
        if($(this).val()==""){
            $("#judgeemail").empty();
            $("#divemail").attr("class","row");
            testemail = false;
        }
        if(testemail){
            /**邮箱校验 web.UserController**/
            $.getJSON("judgemail.do",{email:$("#email").val()},function (result) {
                console.info(result);
                if(result==1){
                    $("#judgeemail").empty();
                    $("#judgeemail").append($("<p></p>").attr("style","margin-top:5px ; color :red").html("邮箱已被注册"));
                    $("#divemail").attr("class","row has-warning");
                    testemail = false;
                }
            })
        }
    })

    $("#sickname").bind("input",function () {
        var reg = new RegExp("^[a-zA-Z][a-zA-Z0-9_]{4,12}$")
        if(!reg.test($(this).val())){
            $("#judgesickname").empty();
            $("#judgesickname").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:red").attr("class","glyphicon glyphicon-remove")));
            $("#divsickname").attr("class","row has-error");
            testsickname = reg.test($(this).val());
        }
        else {
            $("#judgesickname").empty();
            $("#judgesickname").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:green").attr("class","glyphicon glyphicon-ok")));
            $("#divsickname").attr("class","row has-success");
            testsickname =reg.test($(this).val());
        }
    })
    $("#sickname").bind("blur",function () {
        if($(this).val()==""){
            $("#judgesickname").empty();
            $("#divsickname").attr("class","row");
            testsickname = false;
        }
    })
    $("#truename").bind("input",function () {
        var reg = new RegExp("^[\u0391-\uFFE5]+$")
        if(!reg.test($(this).val())){
            $("#judgetruename").empty();
            $("#judgetruename").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:red").attr("class","glyphicon glyphicon-remove")));
            $("#divtruename").attr("class","row has-error");
            testtruename = reg.test($(this).val());
        }
        else {
            $("#judgetruename").empty();
            $("#judgetruename").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:green").attr("class","glyphicon glyphicon-ok")));
            $("#divtruename").attr("class","row has-success");
            testtruename = reg.test($(this).val());
        }
    })
    $("#truename").bind("blur",function () {
        if($(this).val()==""){
            $("#judgetruename").empty();
            $("#divtruename").attr("class","row");
            testtruename = false;
        }
    })
    $("#phone").bind("input",function () {
        var reg = new RegExp("^1[3456789]\\d{9}$")
        if(!reg.test($(this).val())){
            $("#judgephone").empty();
            $("#judgephone").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:red").attr("class","glyphicon glyphicon-remove")));
            $("#divphone").attr("class","row has-error");
            testphone = reg.test($(this).val());
        }
        else {
            $("#judgephone").empty();
            $("#judgephone").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:green").attr("class","glyphicon glyphicon-ok")));
            $("#divphone").attr("class","row has-success");
            testphone = reg.test($(this).val());
        }
    })

    $("#phone").bind("blur",function () {
        if($(this).val()==""){
            $("#judgephone").empty();
            $("#divphone").attr("class","row");
            testphone = false;
        }
    })

    $("#pwd").bind("input",function () {
        var reg = new RegExp("^.{5,10}$")
        if(!reg.test($(this).val())){
            console.info($(this).val())
            $("#judgepwd").empty();
            $("#judgepwd").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:red").attr("class","glyphicon glyphicon-remove")));
            $("#divpwd").attr("class","row has-error");
            testpwd = reg.test($(this).val());
        }
        else {
            $("#judgepwd").empty();
            $("#judgepwd").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:green").attr("class","glyphicon glyphicon-ok")));
            $("#divpwd").attr("class","row has-success");
            testpwd = reg.test($(this).val());
        }
    })

    $("#pwd").bind("blur",function () {
        if($(this).val()==""){
            $("#judgepwd").empty();
            $("#divpwd").attr("class","row");
            testpwd = false;
        }
    })
    $("#repwd").bind("input",function () {
        if($(this).val()!=$("#pwd").val()){
            console.info($(this).val())
            $("#judgerepwd").empty();
            $("#judgerepwd").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:red").attr("class","glyphicon glyphicon-remove")));
            $("#divrepwd").attr("class","row has-error");
        }
        else {
            $("#judgerepwd").empty();
            $("#judgerepwd").append($("<p></p>").attr("style","margin-top:5px").append($("<span></span>").attr("style","color:green").attr("class","glyphicon glyphicon-ok")));
            $("#divrepwd").attr("class","row has-success");
        }
    })
    $("#repwd").bind("blur",function () {
        if ($(this).val() == "") {
            $("#judgerepwd").empty();
            $("#divrepwd").attr("class", "row");
        }
    })
    /**提交**/
    $("#submit").bind("click",function () {
        testtype = $("#usertype").val();
        console.info(testtype);
        if(testtype=="教师")
            testtype =1;
        if(testtype=="学生")
            testtype =2;
        if(testemail==false)
            alert("请改写你的email")
        else if(testsickname==false)
            alert("请完善你的昵称")
        else if (testtruename==false)
            alert("请填入真实姓名")
        else if(testphone==false)
            alert("请填入正确的手机号")
        else if(testpwd==false)
            alert("请斟酌正确的密码以提高安全性")
        else if(testtype=="请选择用户类型")
            alert("请选择用户类型")
        else if(testemail||testsickname||testtruename||testphone||testpwd){
            var username = $("#email").val();
                var data={
                    email:$("#email").val(),
                    nickname:$("#sickname").val(),
                    truename:$("#truename").val(),
                    phone:$("#phone").val(),
                    pwd:$("#pwd").val(),
                    userType:testtype
                }
                console.info(data)

            $.ajax({
                        url:"register.do",
                        data:data,
                        type:"post",
                        dataType:"json",
                        success:function (result) {
                            console.info(result);
                            if(result.code==1){
                                alert("注册教师成功");
                            }
                            if(result.code==2){
                                alert("注册学生成功");
                            }
                            $("#username").val(username);
                            $("#email").val("");
                            $("#sickname").val("");
                            $("#truename").val("");
                            $("#phone").val("");
                            $("#pwd").val("");
                            $("#repwd").val("");
                            $("#judgeemial").empty();
                            $("#divemail").attr("class","row");
                            $("#judgesickname").empty();
                            $("#divsickname").attr("class","row");
                            $("#judgetruename").empty();
                            $("#divtruename").attr("class","row");
                            $("#judgephone").empty();
                            $("#divphone").attr("class","row");
                            $("#judgepwd").empty();
                            $("#divpwd").attr("class","row");
                            $("#judgerepwd").empty();
                            $("#divrepwd").attr("class", "row");
                            $('#myModal').modal('toggle');
                        },
                        error:function () {
                            alert("注册失败");
                        }

                    })

        }
    })

})
