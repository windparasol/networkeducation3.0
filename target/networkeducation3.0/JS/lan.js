$(function () {
    var data = null
    $.getJSON("caseresources.do",function (json) {
        console.info(json);
        data = json.data;
        $("#p1").text(data.sceneDescrible).attr({"style":"line-height:30px;font-size:15px"});
    })
})
