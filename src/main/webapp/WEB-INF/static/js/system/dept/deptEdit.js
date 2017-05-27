/**
 * Created by zhanf on 2017/4/28.
 */
$(document).ready(function(){
    initSelectData();
    initEditPage();
});

function initSelectData() {
    initDeptSelectDataList();
}

function initDeptSelectDataList(){
    $.commonAjax({
        url: "/system/dept/getDeptSelectDataList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#pid").select2({
                    data: selectData,
                    allowClear: true
                });
            }
        }
    });
}

//初始化编辑界面
function initEditPage(){
    var params = {id : $("#deptId").val()};
    $.post("/system/dept/editLoad",
        params,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
                $("#deptName").val(vo.deptName);
                $("#deptAlias").val(vo.deptAlias);
                $("#deptCode").val(vo.deptCode);
                $("#deptContactMan").val(vo.deptContactMan);
                $("#deptContactNum").val(vo.deptContactNum);
                $("#deptAddress").val(vo.deptAddress);
                $("#deptDesc").text(vo.deptDesc);
                $("#pid").val(vo.pid).trigger("change");
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