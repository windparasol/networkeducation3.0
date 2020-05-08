
$(function () {
    var result = null;
    var num=0;
    var sign=null;
    //获取资源
    $.getJSON("getteacherindexpageinfo.do",function (json) {
        console.info(json);
        if(json.code!=1)alert("获取资源失败");
        if(json.code==1)result=json.data;
        for(var i=0;i<result.listcaseplan.length;i++){
            if(result.listcaseplan[i].planDetailList!=0){
                if(result.listcaseplan[i].planDetailList[result.listcaseplan[i].planDetailList.length-1].cpType=="1"
                    &&result.listcaseplan[i].planDetailList[result.listcaseplan[i].planDetailList.length-1].state=="0")num++;
            }
        }
        if(result.listclassroom.length!=0){
            var roid =null;
            var roname = null;
            for(var i=0;i<result.listclassroom.length;i++){
                roid = result.listclassroom[i].roId;
                roname = result.listclassroom[i].roomname;
                $("#classroombody").append($("<tr></tr>").attr({"id":"tr"+i}).append($("<td></td>").attr({"style":"text-align:center"}).text("#"+roid))
                    .append($(("<td></td>")).attr({"style":"text-align:center"}).append($("<a></a>").text(roname).attr({"href":"jumptoclassroomdetail.do?roid="+(i+1)}))));
            }
        }
        else if(result.listclassroom.length==0){
            $("#showdiv").empty();
            $("#h1").text("课堂创建");
            $("#p1").text("你还没有课堂,是否立即创建？")
            $("#classroomdiv").append($("<a></a>").text("创建").attr({"class":"btn btn-primary createclassroom","style":"margin-top:50px"}))
        }
        $(".createclassroom").on("click",function () {
            $("#classroomModal").modal({backdrop:'static',keyboard:false,show: true});
        })
        $(".badge").text(num)
    })

    $("#cratesubmit").on("click",function () {
        var data ={
            "roomname":$("#classroomname").val(),
            "roomdescrible":$("#classroomdescrible").val()
        }
        $.ajax({
            url:"createclassroom.do",
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            data:data,
            type:"GET",
            success:function (json) {
                if(json.code==1){
                    alert("创建成功，邀请学生加入课堂开始案例教学吧！")
                    window.location.reload();
                }
            }
        })
    })


    $("#application").on("click",function () {
        for(var i = 0;i<result.listcaseplan.length;i++){
            var cpid = result.listcaseplan[i].cpId;
            var caseName = result.listcaseplan[i].caseName;
            var stime = result.listcaseplan[i].stime.replace("00:00:00","");
            var state = null;
            if(result.listcaseplan[i].state=="0") state="未受理";
            else if(result.listcaseplan[i].state=="1") state="交流中";
            else if(result.listcaseplan[i].state=="2") state="课程制作中";
            $("#table").append($("<tr></tr>").attr("id","mtr"+i)
                .append($("<td></td>").text(cpid).attr({"style":"text-align: center"}))
                .append($("<td></td>").text(caseName).attr({"style":"text-align: center"}))
                .append($("<td></td>").text(state).attr({"style":"text-align: center"}))
                .append($("<td></td>").text(stime)).attr({"style":"text-align: center"}))

            if(result.listcaseplan[i].planDetailList!=0){
                if(result.listcaseplan[i].planDetailList[result.listcaseplan[i].planDetailList.length-1].cpType=="1"
                    &&result.listcaseplan[i].planDetailList[result.listcaseplan[i].planDetailList.length-1].state=="0"){
                    $("#mtr"+i).append($("<td></td>").attr({"style":"text-align: center"})
                        .append($("<a></a>").text(i).hide())
                        .append($("<a></a>").attr({"class":"btn btn-danger detail"}).text("新消息")))
                }
                else{
                    $("#mtr"+i).append($("<td></td>").attr({"style":"text-align: center"})
                        .append($("<a></a>").text(i).hide())
                        .append($("<a></a>").attr({"class":"btn btn-danger detail"}).text("历史记录")))
                }
            }
            if(result.listcaseplan[i].planDetailList==0){
                $("#mtr"+i).append($("<td></td>").attr({"style":"text-align: center"}).text("无"))
            }
        }
        $("#myModal").modal({backdrop:'static',keyboard:false,show: true});

        $(".detail").on("click",function () {
            $("#comtable").empty();
            sign=$(this).siblings().text()
            console.info(sign);
            for(var a=0;a<result.listcaseplan[sign].planDetailList.length;a++){
                var responder=null;
                var replytext = result.listcaseplan[sign].planDetailList[a].replyText;
                var state = null;
                var time =result.listcaseplan[sign].planDetailList[a].stime.replace("00:00:00","");
                var annexurl=result.listcaseplan[sign].planDetailList[a].annexUrl;
                if(result.listcaseplan[sign].planDetailList[a].cpType=="1")responder = "负责人";
                else if(result.listcaseplan[sign].planDetailList[a].cpType=="2") responder = "教师";
                if(result.listcaseplan[sign].planDetailList[a].state==0)state="未读";
                else if(result.listcaseplan[sign].planDetailList[a].state==1)state="已读";
                $("#comtable").append($('<tr></tr>').attr("id","comtr"+a)
                    .append($('<td></td>').text(responder).attr("style","text-align: center"))
                    .append($('<td></td>').attr("style","text-align: center")
                        .append($("<button></button>").text("查看").attr({"class":"btn btn-info","title":"回复内容",
                            "data-container":"body","data-toggle":"popover", "data-placement":"bottom","data-trigger":"hover","data-content":replytext})))
                    .append($("<td></td>").text(state).attr("style","text-align: center")))
                if(annexurl==null||annexurl==""){
                    $("#comtr"+a).append($("<td></td>").text("无").attr("style","text-align: center"))
                        .append($("<td></td>").text(time).attr("style","text-align: center"))
                    $("[data-toggle='popover']").popover();
                }
                else if(annexurl!=null){
                    $("#comtr"+a).append($("<td></td>").attr("style","text-align: center")
                        .append($("<a></a>").text("下载").attr("href",annexurl))).append($("<td></td>").text(time).attr("style","text-align: center"))
                    $("[data-toggle='popover']").popover();
                }
            }
            var data={
                "cpid":result.listcaseplan[sign].cpId
            }
            $.ajax({
                url:"updataread.do",
                type:"post",
                dataType:"json",
                data:data,
                success:function(result) {
                    console.info(result);
                    console.info("更新读取进度成功");
                }
            })
            $("#hidediv").removeAttr("hidden");
        })
    })

    $("#comsubmit").on("click",function () {
        var formdata = new FormData();
        formdata.append("file", $("#newannex")[0].files[0]);
        formdata.append("replyText", $("#suggest").val());
        formdata.append("cpType", "2");
        formdata.append("cpId",result.listcaseplan[sign].cpId);
        $.ajax({
            url:"updatacourseapplication.do",
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

    $("#newcom").on("click",function () {
        $("#hidediv").attr("hidden","hidden");
})

    //文件上传校验
    $("#annex").on("change",function () {
        var fileObj = $(this).val();
        if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
            alert("请再次选择");
            return;
        }
    })
    //文件和其他数据一起提，使用到formdata对象
    $("#submit").on("click",function () {
        var formdata = new FormData();
        formdata.append("file", $("#annex")[0].files[0]);
        formdata.append("caseName", $("#casetitile").val());
        formdata.append("describle",$("#casedescrible").val())
        formdata.append("aim",$("#aim").val())
        $.ajax({
            url:"courseapplication.do",
            type:"post",
            dataType:"json",
            async:false,
            cache:false,
            processData:false,//不处理数据
            contentType: false,//不设置内容类型
            data:formdata,
            success:function (result) {
                console.info(result);
                alert("提交成功")
                $("#casedescrible").val("");
                $("#aim").val("");
                $("#location").val("");
                $("#casetitile").val("")

            }
        })
    })

    $("#close").on("click",function () {
        window.location.reload();
    })
})