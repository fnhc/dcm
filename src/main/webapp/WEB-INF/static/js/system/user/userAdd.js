/**
 * Created by zhanf on 2017/4/28.
 */

jQuery(document).ready(function () {
    initSelectData();
});

function initSelectData() {
    initDeptSelectDataList();
    initRoleNameList();

}

function initDeptSelectDataList(){
    $.commonAjax({
        url: "/system/dept/getDeptSelectDataList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#deptId").select2({
                    data: selectData
                });
            }
        }
    });
}

function initRoleNameList(){
    $.commonAjax({
        url: "/system/role/getRoleNameList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#roleIds").select2({
                    data: selectData
                });
            }
        }
    });
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