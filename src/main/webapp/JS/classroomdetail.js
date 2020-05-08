$(function () {
    var result= null
    var listcase=null
    var sign =null;
    var count =0;//没有课程时的提交的课程问题的数量
    var beingcase=null
    var student=null
    var replylist=null
    var quescount=null
    var classroomname=null;
    var classroomdescrible =null
    var classroomid =null
    $.getJSON("getclassroomdetail.do",function (json) {
        console.info(json);
        result=json.data;

        classroomname =result.classroom.roomname;
        classroomdescrible =result.classroom.roomdescrible;
        classroomid =result.classroom.roId;
        $("#classroomid").text("课程id："+classroomid);
        $("#classroomname").text("课堂名："+classroomname);
        $("#classroomdescrible").text(classroomdescrible);
        //没有课程的情况
        if((result.classroom.classRoomCaseList.length!=0&&result.classroom.classRoomCaseList[result.classroom.classRoomCaseList.length-1].endTime!=null)||
            result.classroom.classRoomCaseList.length==0){
            $("#studenttr").empty();
            $("#studenttr").append($("<th></th>").text("学号").attr({"style":"text-align: center"})).append($("<th></th>").text("姓名").attr({"style":"text-align: center"}))
            for(var i=0;i<result.classroom.studentList.length;i++){
                var id =result.classroom.studentList[i].usId;
                var truename = result.classroom.studentList[i].truename;
                $("#studentbody").append($("<tr></tr>").attr({"style":"text-align: center"})
                    .append($("<td></td>").text(id))
                    .append($("<td></td>").append($("<a></a>").text(truename).attr({"href":"javascript:void(0)","class":"sttd"})).append($("<a></a>").text(i).attr({"href":"javascript:void(0)"}).hide())));
            }
            //设置问题函数
            function setupquestion(a,question,note,score){
                $("#casebody").append($("<div></div>").attr({"class":"row","style":"margin-top: 20px"})
                    .append($("<div></div>").attr({"class":"col-sm-4 col-sm-offset-1"})
                        .append($("<label></label>").text("问题"+a).attr({"for":"question"+a,"class":"control-label","style":"font-size: 22px"}))
                        .append($("<textarea></textarea>").val(question).attr({"id":"question"+a,"row":"3","class":"form-control"})))
                    .append($("<div></div>").attr({"class":"col-sm-4"})
                        .append($("<label></label>").text("注意事项").attr({"for":"note"+a,"class":"control-label","style":"margin-top: 11px"}))
                        .append($("<textarea></textarea>").val(note).attr({"id":"note"+a,"row":"3","class":"form-control"})))
                    .append($("<div></div>").attr({"class":"col-sm-2"})
                        .append($("<label></label>").text("参考分值").attr({"for":"score"+a,"class":"control-label","style":"margin-top: 11px"}))
                        .append($("<input/>").val(score).attr({"type":"text","class":"form-control","id":"score"+a}))))
            }



            $("#casemanagediv").empty();
            $("#casemanagediv").append($("<h2></h2>").text("课程管理").attr({"style":"position:relative;left: 35%"})).append($("<h4></h4>").text("没有正在进行的课程！").attr({"style":"margin-top:30px;margin-left:5%"})).append($("<h4></h4>").text("请从下列开设案例课程中进行添加：").attr({"style":"margin-top:10px;margin-left:5%"}))
            $.getJSON("getcaselist.do",function (json) {
                console.info(json);
                listcase = json.data;
                for(var i=0;i<listcase.length;i++ ){
                    var csid =listcase[i].csId;
                    var csname = listcase[i].csName;
                    var teacher=listcase[i].teacher.truename;
                    var describle =listcase[i].sceneDescrible;
                    var pageurl =listcase[i].pageUrl;
                    $("#selectcasebody").append($("<tr></tr>").attr({"style":"text-align: center"}).append($("<td></td>").text(csid))
                        .append($("<td></td>").append($("<a></a>").text(csname).attr({"class":"coursetd","href":"javascript:void(0)","color":"black"})).append($("<a></a>").text(i).hide()))
                        .append($("<td></td>").text(teacher))
                        .append($("<td></td>").append($("<button></button>").text("查看").attr({"class":"btn btn-default","title":"情景描述",
                            "data-container":"body","data-toggle":"popover", "data-placement":"bottom","data-trigger":"hover","data-content":describle})))
                        .append($("<td></td>").append($("<span></span>").attr({"class":"glyphicon glyphicon-star","style":"top:8px"})).append($("<span></span>").attr({"class":"glyphicon glyphicon-star","style":"top:8px"})))
                        .append($("<td></td>").append($("<a></a>").text("进入").attr({"href":"jumpTocourseresource.do?csid="+csid}))))
                }

                $("[data-toggle='popover']").popover();
                $(".coursetd").on("click",function () {
                    sign = $(this).siblings().text();
                    console.info(sign);
                    count=listcase[sign].questionList.length;
                    for(var a =0;a<count;a++){
                        console.info(a)
                        var question =listcase[sign].questionList[a].question;
                        var note = listcase[sign].questionList[a].note;
                        var score =listcase[sign].questionList[a].questionScore;
                        setupquestion(a+1,question,note,score);
                    }
                    $("#caseModal").modal({backdrop:'static',keyboard:false,show: true});
                })
            })

            $("#addquestion").on("click",function () {
                setupquestion(count+1);
                count++;
            })

            $("#caseclose").on("click",function () {
                $("#casebody").empty();
                console.info("casebody已清空")
            })
            $("#casesubmit").on("click",function () {
                var questionlist =[]
                console.info(count)
                for(var b=0;b<count;b++){
                    questionlist[b]={question:$("#question"+(b+1)).val(),note:$("#note"+(b+1)).val(),score:$("#score"+(b+1)).val()}
                }
                var data={
                    actualQuestionList:questionlist,
                    csid:listcase[sign].csId
                }
                $.ajax({
                    url:"uploadcasequestions.do",
                    type:"post",
                    dataType:"json",
                    data:JSON.stringify(data),
                    contentType:"application/json;charset=utf-8",
                    success:function (json) {
                        if(json.code==1){
                            alert("添加课程成功，已开启案例教学，请及时通知学生！")
                            window.location.reload()
                        }
                    }
                })
            })

        }//有课程进行的情况
        else {//当前正在进行的课程的问题数量
            var questioncount = result.classroom.classRoomCaseList[result.classroom.classRoomCaseList.length-1].actualQuestionList.length;



            //计算当前学生课程进度百分比
            function sop(passcount, questioncount) {
                return (passcount/questioncount).toFixed(2)*100;
            }

            for(var i=0;i<result.classroom.studentList.length;i++){
                var judgenew = "暂无";
                var id =result.classroom.studentList[i].usId;
                var truename = result.classroom.studentList[i].truename;
                var passcount = 0;


                //计算回答问题数与是否有新的关卡问题回复
                if(result.classroom.studentList[i].questionReplyList.length!=0) {

                    //当判断是否有问题回复
                    if(result.classroom.studentList[i].questionReplyList[result.classroom.studentList[i].questionReplyList.length-1]
                        .replyRecordList[result.classroom.studentList[i].questionReplyList[result.classroom.studentList[i].questionReplyList.length-1].replyRecordList.length-1].userType=="2"&&
                        result.classroom.studentList[i].questionReplyList[result.classroom.studentList[i].questionReplyList.length-1]
                        .replyRecordList[result.classroom.studentList[i].questionReplyList[result.classroom.studentList[i].questionReplyList.length-1].replyRecordList.length-1].rstate=="0"){
                        judgenew = "问题"+(result.classroom.studentList[i].questionReplyList.length)+"有更新"
                    }
                    for (var a = 0; a < result.classroom.studentList[i].questionReplyList.length; a++){
                        if(result.classroom.studentList[i].questionReplyList[a].qstate=="1"){
                            passcount++;
                        }
                    }
                }
                //生成当前学生管理列表信息
                $("#studentbody").append($("<tr></tr>").attr({"style":"text-align: center"})
                    .append($("<td></td>").text(id))
                    .append($("<td></td>").append($("<a></a>").text(truename).attr({"href":"javascript:void(0)","class":"sttd"})).append($("<a></a>").text(i).attr({"href":"javascript:void(0)"}).hide()))
                    .append($("<td></td>").text(sop(passcount,questioncount)+"%"))
                    .append($("<td></td>").text(judgenew)));
            }
            //右边课程管理中的数据
            beingcase =result.classroom.classRoomCaseList[result.classroom.classRoomCaseList.length-1];
            $("#span1").text(beingcase.cases.csName).attr({"style":"color:red;font-size: 20px"})
            $("#casemanagea").attr({"class":"btn btn-primary","style":"margin-top:5%;margin-left:5%","href":"jumpTocourseresource.do?csid="+beingcase.csId})
            $("#caselistdiv").empty();
        }
        //加载单个学生详情的模态窗口
        $(".sttd").on("click",function () {
            console.info($(this).siblings().text())
            student=result.classroom.studentList[$(this).siblings().text()]

            //加载模态窗口中的学生个人信息
            $("#pid").text(student.usId)
            $("#pname").text(student.truename)
            $("#pnickname").text(student.nickname)
            $("#pphone").text(student.phone)
            $("#pemail").text(student.email)

            //加载模态窗内问题交流
            var acqlist = result.classroom.classRoomCaseList[result.classroom.classRoomCaseList.length-1].actualQuestionList
            if(student.questionReplyList.length==0){
                for(var a=0;a<acqlist.length;a++){
                    var ques = acqlist[a].question
                    var score = acqlist[a].score
                    var qscore = 0
                    var sop ="未开始"
                    $("#commubody").append($("<tr></tr>").attr({"style":"text-align: center"}).append($("<td></td>").text(a))
                        .append($('<td></td>').attr("style","text-align: center").append($("<button></button>").text("查看").attr({"class":"btn btn-default","title":"问题及其注释",
                            "data-container":"body","data-toggle":"popover", "data-placement":"bottom","data-trigger":"hover","data-content":ques})))
                        .append($("<td></td>").text(score)).append($("<td></td>").text(qscore)).append($("<td></td>").text(sop)))
                }

                $("[data-toggle='popover']").popover();
            }
            else if(student.questionReplyList.length!=0){
                for(var a=0;a<acqlist.length;a++){
                    var ques = acqlist[a].question
                    var score = acqlist[a].score
                    var qscore = 0
                    var sop ="未开始"
                    if(student.questionReplyList.length>=a+1){
                        console.info(student.questionReplyList[a].qstate)
                        if(student.questionReplyList[a].qstate=="1"){
                            sop="进行中"
                        }
                        else if(student.questionReplyList[a].qstate=="2"){
                            sop ="已完成"
                            score=student.questionReplyList[a].qscore
                        }
                    }
                    $("#commubody").append($("<tr></tr>").attr({"style":"text-align: center","id":"sttr"+a}).append($("<td></td>").text(a+1))
                        .append($('<td></td>').attr("style","text-align: center").append($("<button></button>").text("查看").attr({"class":"btn btn-default","title":"问题及其注释",
                            "data-container":"body","data-toggle":"popover", "data-placement":"bottom","data-trigger":"hover","data-content":ques})))
                        .append($("<td></td>").text(score)).append($("<td></td>").text(qscore)).append($("<td></td>").text(sop)))

                    $("#sttr"+a).on("click",function () {
                        if($(this).children()[4].innerText=="已完成"||$(this).children()[4].innerText=="进行中"){
                            $("#replytbody").empty();
                            replylist = student.questionReplyList[$(this).children()[0].innerText-1].replyRecordList;
                            quescount = $(this).children()[0].innerText-1

                            //设置当前问题编号
                            $("#nowquestion").text(quescount+1)
                            for(var b=0;b<replylist.length;b++){
                                var userType="学生"
                                var replytext = replylist[b].narration
                                var rstate=null
                                if(replylist[b].rstate==0&&replylist[b].userType=="2"){
                                    rstate="未读"
                                }
                                else if(replylist[b].rstate==0&&replylist[b].userType=="1"){
                                    rstate="对方未读"
                                }
                                else if(replylist[b].rstate==1&&replylist[b].userType=="1"){
                                    rstate="对方已读"
                                }
                                else if(replylist[b].rstate==1&&replylist[b].userType=="2"){
                                    rstate="已读"
                                }
                                if(replylist[b].userType=="1"){
                                    userType=="教师"
                                }
                                $("#replytbody").append($("<tr></tr>").attr({"style":"text-align: center","id":"replytr"+b})
                                    .append($("<td></td>").text(b+1)).append($("<td></td>").text(userType))
                                    .append($('<td></td>').attr("style","text-align: center").append($("<button></button>").text("查看").attr({"class":"btn btn-default","title":"回复内容",
                                        "data-container":"body","data-toggle":"popover", "data-placement":"bottom","data-trigger":"hover","data-content":replytext})))
                                    .append($("<td></td>").text(rstate)))
                                if(replylist[b].annexurl==null){
                                    $("#replytr"+b).append($("<td></td>").text("无"))
                                }
                                else if(replylist[b].annexurl!=null){
                                    $("#replytr"+b).append($("<td></td>").append($("<a></a>").text("下载").attr({"href":replylist[b].annexurl})))
                                }
                            }
                            $("[data-toggle='popover']").popover();
                            $("#right").removeAttr("hidden")
                        }
                    })
                }
                $("[data-toggle='popover']").popover();
            }

            //最后打开模态窗口
            $("#studentModal").modal({backdrop:'static',keyboard:false,show: true});
        })
        //模态窗口关闭时的数据提交
        $("#studentlose").on("click",function () {
            data={
                ccid:result.classroom.classRoomCaseList[result.classroom.classRoomCaseList.length-1].ccId,
                stid:student.usId
            }
            console.info(data)
            $.getJSON("updataquestionstate.do",data,function (json) {
                console.info(json)
            })
            window.location.reload()
        })

        //提交问题反馈
        $("#submit").on("click",function () {
            var formdata = new FormData();
            formdata.append("file", $("#newannex")[0].files[0]);
            formdata.append("narration", $("#suggest").val());
            formdata.append("qrId",replylist[quescount].qrId)
            $.ajax({
                url:"updataquestionreply.do",
                type:"post",
                dataType:"json",
                async:false,
                cache:false,
                processData:false,//不处理数据
                contentType: false,//不设置内容类型
                data:formdata,
                success:function (result) {
                    console.info(result);
                    if(result.code=="1"){
                        alert("提交成功");
                        $("#suggest").val("");
                        $("#location").val("")
                    }
                }
            })
        })



    })

})