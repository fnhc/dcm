$(document).ready(function(){
    initEditPage();
});

//初始化编辑界面
function initEditPage(){
    var params = {id : $("#settingId").val()};
    $.post("/system/setting/editLoad",
        params,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
                $("#settingCode").val(vo.settingCode);
                $("#settingName").val(vo.settingName);
                $("#settingValue").val(vo.settingValue);
                $("#settingDesc").val(vo.settingDesc);
            }
        }
    );
}
function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true ;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    //刷新主页面
    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}