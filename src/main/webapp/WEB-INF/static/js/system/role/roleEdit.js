/**
 * Created by zhanf on 2017/4/28.
 */

$(document).ready(function(){
    initEditPage();
});

//初始化编辑界面
function initEditPage(){
    var params = {id : $("#roleId").val()};
    $.post("/system/role/editLoad",
        params,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
                $("#roleName").val(vo.roleName);
                $("#roleDesc").text(vo.roleDesc);
                var status_selector = $("input[name='status']");
                vo.status == 1 ? status_selector.get(0).checked=true : status_selector.get(1).checked=true;
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