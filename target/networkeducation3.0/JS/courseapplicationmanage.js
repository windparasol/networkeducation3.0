
$(function () {
    var unread=new Array();
    var update=new Array();
    var data=null;
    /**进入页面后获取新的申请数据**/
    $.getJSON("courseapplicationmanage.do",null,function (result) {
        console.info(result);
        data=result.data;
        var a=0;
        var b=0;
        if(data==null)return 0;
        for(var i =0;i<result.data.length;i++){
            if(result.data[i].state=="0"){
                unread[a]=result.data[i];
                a++;
            }
            else if(result.data[i].state=="1"){
                update[b]=result.data[i];
                b++;
            }
        }
        /**新增申请**/
        for(var i=0;i<unread.length;i++){
            var cpid=unread[i].cpId;
            var casename = unread[i].caseName;
            var tcname = unread[i].user.truename;
            var stime =unread[i].stime.replace("00:00:00","");
            var str ="td1"+i;
            $('#tbody1').append($('<tr></tr>').attr('id',str).append($('<td></td>').text(cpid).attr("style","text-align: center"))
                .append($('<td></td>').attr({"style":"text-align: center"}).append($("<a></a>").text(i).hide()).append($('<a></a>').text(casename).attr({"class":"unreadplandetail","href":"Javascript:void(0)"})))
                .append($('<td></td>').attr("style","text-align: center").text(tcname)).append($('<td></td>').attr("style","text-align: center").text(stime)));
            if(unread[i].annexUrl!=null&&unread[i].annexUrl!=""){
                $("#"+str).append($('<td></td>').attr("style","text-align: center").text("有"));
            }
            else {
                $("#"+str).append($('<td></td>').attr("style","text-align: center").text("无"));
            }
        }
        /**之前的申请进度更新**/
        for(var i=0;i<update.length;i++){
            var cpid=update[i].cpId;
            var casename = update[i].caseName;
            var tcname = update[i].user.truename;
            var stime =update[i].planDetailList[update[i].planDetailList.length-1].stime.replace("00:00:00","");
            var str ="td2"+i;
            var news = "否";
            if((update[i].planDetailList[update[i].planDetailList.length-1].state=="0")&&(update[i].planDetailList[update[i].planDetailList.length-1].cpType=="2"))news="是"
            $('#tbody2').append($('<tr></tr>').attr('id',str).append($('<td></td>').text(cpid).attr("style","text-align: center"))
                .append($('<td></td>').attr("style","text-align: center")
                    .append($("<a></a>").text(i).hide()).append($('<a></a>').text(casename).attr({"class":"updataplandetail","href":"Javascript:void(0)"})))
                .append($('<td></td>').attr("style","text-align: center").text(tcname))
                .append($('<td></td>').attr("style","text-align: center").text(stime))
                .append($('<td></td>').attr("style","text-align: center").text(news)));
        }
        /**点击一条申请后弹出模态窗口，在模态创建之前先更新里面的数据**/
        $(".updataplandetail").on("click",function () {
            var i =$(this).siblings().text();
            console.info(i)
            $("#pcase").text(update[i].caseName);
            $("#paim").text(update[i].aim);
            $("#pdescrible").text(update[i].describle);
            $("#hide").text(update[i].cpId).hide();
            if(update[i].annexUrl==null){
                $("#pannex").text("无").attr("href","#");
            }
            else {
                $("#pannex").text(update[i].annexUrl).attr("href",update[i].annexUrl);
            }
            console.info(update[i].planDetailList.length);
            if(update[i].planDetailList.length==0){
                $("#record").empty();
                $("#record").append($("<h3></h3>").text("暂无"));
            }
            else if(update[i].planDetailList.length>=0){
                for(var a=0;a<update[i].planDetailList.length;a++){
                    var responder=null;
                    var replytext = update[i].planDetailList[a].replyText;
                    var state = null;
                    var time =update[i].planDetailList[a].stime.replace("00:00:00","");
                    var annexurl=update[i].planDetailList[a].annexUrl;
                    if(update[i].planDetailList[a].cpType=="1")responder = "负责人";
                    else if(update[i].planDetailList[a].cpType=="2") responder = "教师";
                    if(update[i].planDetailList[a].state==0&&update[i].planDetailList[a].cpType=="1")state="对方未读取";
                    else if(update[i].planDetailList[a].state==1&&update[i].planDetailList[a].cpType=="1")state="对方已读取";
                    else if(update[i].planDetailList[a].state==0&&update[i].planDetailList[a].cpType=="2")state="我还未读取";
                    else if(update[i].planDetailList[a].state==1&&update[i].planDetailList[a].cpType=="2")state="我已经读取";
                    console.info(update[i].planDetailList[a].replyText);
                    $("#mtbody").append($('<tr></tr>').attr("id","tr"+a)
                        .append($('<td></td>').text(a+1).attr({"style":"text-align: center","id":"sign"+a}))
                        .append($('<td></td>').text(responder).attr("style","text-align: center"))
                        .append($('<td></td>').attr("style","text-align: center")
                            .append($("<button></button>").text("查看").attr({"class":"btn btn-info","title":"回复内容",
                                "data-container":"body","data-toggle":"popover", "data-placement":"bottom","data-trigger":"hover","data-content":replytext})))
                        .append($("<td></td>").text(state).attr("style","text-align: center")))
                    if(annexurl==null||annexurl==""){
                        $("#tr"+a).append($("<td></td>").text("无").attr("style","text-align: center"))
                            .append($("<td></td>").text(time).attr("style","text-align: center"))
                        $("[data-toggle='popover']").popover();
                    }
                    else if(annexurl!=null){
                        $("#tr"+a).append($("<td></td>").attr("style","text-align: center")
                            .append($("<a></a>").text("下载").attr("href",annexurl))).append($("<td></td>").text(time).attr("style","text-align: center"))
                        $("[data-toggle='popover']").popover();
                    }

                }
            }
            /**打开模态窗口**/
            $("#myModal").modal({backdrop:'static',keyboard:false,show: true});
        })

        $(".unreadplandetail").on("click",function () {
            var i =$(this).siblings().text();
            console.info(i)
            $("#pcase").text(unread[i].caseName);
            $("#paim").text(unread[i].aim);
            $("#pdescrible").text(unread[i].describle);
            $("#hide").text(unread[i].cpId).hide();
            if(unread[i].annexUrl==null){
                $("#pannex").text("无").attr("href","#");
            }
            else {
                $("#pannex").text(unread[i].annexUrl).attr("href",unread[i].annexUrl);
            }
            console.info(unread[i].planDetailList.length);
            if(unread[i].planDetailList.length==0){
                $("#record").empty();
                $("#record").append($("<h3></h3>").text("暂无"));
            }
            else if(unread[i].planDetailList.length>=0){
                for(var a=0;a<unread[i].planDetailList.length;a++){
                    var responder=null;
                    var replytext = unread[i].planDetailList[a].replyText;
                    var state = null;
                    var time =unread[i].planDetailList[a].stime.replace("00:00:00","");
                    var annexurl=unread[i].planDetailList[a].annexUrl;
                    if(unread[i].planDetailList[a].cpType=="1")responder = "负责人";
                    else if(unread[i].planDetailList[a].cpType=="2") responder = "教师";
                    if(unread[i].planDetailList[a].state==0)state="未读";
                    else if(unread[i].planDetailList[a].state==1)state="已读";
                    console.info(unread[i].planDetailList[a].replyText);
                    $("#mtbody").append($('<tr></tr>').attr("id","tr"+a)
                        .append($('<td></td>').text(a+1).attr({"style":"text-align: center","id":"sign"+a}))
                        .append($('<td></td>').text(responder).attr("style","text-align: center"))
                        .append($('<td></td>').attr("style","text-align: center")
                            .append($("<button></button>").text("查看").attr({"class":"btn btn-info","title":"回复内容",
                                "data-container":"body","data-toggle":"popover", "data-placement":"bottom","data-trigger":"focus","data-content":replytext})))
                        .append($("<td></td>").text(state).attr("style","text-align: center")))
                    if(annexurl==null||annexurl==""){
                        $("#tr"+a).append($("<td></td>").text("无").attr("style","text-align: center"))
                            .append($("<td></td>").text(time).attr("style","text-align: center"))
                        $("[data-toggle='popover']").popover();
                    }
                    else if(annexurl!=null){
                        $("#tr"+a).append($("<td></td>").attr("style","text-align: center")
                            .append($("<a></a>").text("下载").attr("href",annexurl))).append($("<td></td>").text(time).attr("style","text-align: center"))
                        $("[data-toggle='popover']").popover();
                    }

                }
            }
            /**打开模态窗口**/
            $("#myModal").modal({backdrop:'static',keyboard:false,show: true});
        })

        $("#submit").on("click",function () {
            var formdata = new FormData();
            formdata.append("file", $("#newannex")[0].files[0]);
            formdata.append("replyText", $("#suggest").val());
            formdata.append("cpType", "1");
            formdata.append("cpId", $("#hide").text());
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

        $("#close").on("click",function () {
            var data={
                "cpid":$("#hide").text()
            }
            console.info(data);
            $.ajax({
                url:"updataread.do",
                type:"post",
                contentType:"application/json;charset=utf-8",
                dataType:"json",
                data:data,
                success:function(result) {
                    console.info(result);
                    console.info("更新读取进度成功");
                    window.location.reload();
                }
            })
        })
        //给予通过
        $("#coursepass").on("click",function () {
            var data={
                "cpid":$("#hide").text()
            }
            $.getJSON("applicationpass.do",data,function (result) {
                console.info(result);
                if(result.code==1){
                    alert("已通过，请尽快开始页面制作");
                }
            })
        })
    })

})