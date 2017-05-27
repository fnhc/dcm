/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    var userId = $("#userId").val();

    initDeptSelectDataList();
    initRoleNameList();
    initFormerDate(userId);
});

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

//初始化用户信息
function initFormerDate(userId) {
    $.commonAjax({
        url: "/system/user/loadEditData",
        data: {id:userId},
        success: function (result) {
            if (result.state) {
                var user = result.content.user;
                if(user){

                    $("#userName").val(user.userName);
                    $("#realName").val(user.realName);
                    $("#userType").val(user.userType);
                    $("#telephoneNumber").val(user.telephoneNumber);
                    $("#cellPhoneNumber").val(user.cellPhoneNumber);
                    $("#email").val(user.email);
                    $("#deptId").val(user.deptId).trigger("change");
                    $("#roleIds").val(user.roleIds).trigger("change");

                    $("#userDesc").val(user.userDesc);

                    var status = user.status;
                    if (status == 1) {
                        $("#status1").attr("checked", "checked");
                        $("#status2").attr("checked", false);
                    }
                    if (status == -1) {
                        $("#status1").attr("checked", false);
                        $("#status2").attr("checked", "checked");
                    }

                }
            }
        }
    });
}
//加载角色菜单列表
function initRoleNameList(){
    $.commonAjax({
        url: "/system/role/getRoleNameList",
        success: function (result) {
            if (result.state) {
                var roleNames = result.content.selectData;
                $("#roleIds").select2({
                    data: roleNames
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