$(function () {
    var result =null;
    $.getJSON("getclassroomstudentinfo.do",function (json) {
        result = json.data;
        console.info(result);
    })
})