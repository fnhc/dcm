/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    initSelectData();
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

                $("#pid").val('').trigger("change");
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

function testFunc() {
    parent.layer.open({
        type: 2,
        shade: 0.3,
        moveOut : true ,
        area: '500px',
        maxmin: true,
        content: '/system/dept/add',
        // zIndex: parent.layer.zIndex, //重点1
        success: function(layero){
            // parent.layer.setTop(layero); //重点2
        }
    });

}