$(function () {
    var classroomlist =null;
    var questionreplylist;
    $.getJSON("studentindex.do",function (json) {
        console.info(json);
        classroomlist = json.data.student.classRoomList;
        questionreplylist = json.data.student.questionReplyList;
        for(var i = 0;i<classroomlist.length;i++){
            var roid = classroomlist[i].roId;
            var roname = classroomlist[i].roomname;
            var teachername = classroomlist[i].user.truename;
            var state="未进行"
            var news = 0
            if(classroomlist[i].classRoomCaseList.length>0){
                if(classroomlist[i].classRoomCaseList[classroomlist[i].classRoomCaseList.length-1].endTime==null){
                    state ="进行中"
                }
                for(var a=0;a<questionreplylist.length;a++){
                    if(questionreplylist[a].ccId==classroomlist[i].classRoomCaseList[classroomlist[i].classRoomCaseList.length-1].ccId){
                        if(questionreplylist[a].replyRecordList[questionreplylist[a].replyRecordList.length-1].userType=="1"
                            &&questionreplylist[a].replyRecordList[questionreplylist[a].replyRecordList.length-1].rstate=="0"){
                            news++;
                        }
                    }
                }
            }



            $("#classroomtable").append($("<tr></tr>")
                .append($("<td></td>").attr({"style":"text-align:center"}).text(roid))
                .append($("<td></td>").attr({"style":"text-align:center"}).append($("<a></a>").text(classroomlist[i].roId).hide()).append($("<a></a>").text(roname).attr({"href":"jumptostudentclassroom.do?roid="+roid})))
                .append($("<td></td>").attr({"style":"text-align:center"}).text(teachername))
                .append($("<td></td>").attr({"style":"text-align:center"}).text(state))
                .append($("<td></td>").attr({"style":"text-align:center"}).text(news)))
        }
    })

    $("#go").on("click",function (json) {
        var data={
            "secretkey":$("#input").val()
        }
        $.ajax({
            url:"joinclassroom.do",
            data:data,
            dataType:"json",
            type:"post",
            success:function (json) {
                console.info(json);
                if(json.code==2) {
                    alert("你已经加入课堂请勿反复加入");
                    $("#input").val("");
                }
                else if(json.code==1){
                    alert("加入课堂成功");
                    window.location.reload();
                }
            }
        })
    })
})