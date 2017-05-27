/**
 * Created by lenovo on 2017/5/9.
 */

$(document).ready(function(){
    var setting = {
        check: {
            enable: true,
            chkStyle:"checkbox",
            chkboxType : { "Y" : "ps", "N" : "ps" }
        },
        async: {
            enable: true,
            url:"/system/role/getAuth",
            // autoParam:["id", "name=n", "level=lv"],
            otherParam:{"id":$("#roleId").val()},
            dataFilter: filterFunc
        },
        callback:{
            onCheck : onCheckFunc,
            onAsyncError : onAsyncErrorFunc
        }
    };

//todo
    function filterFunc(treeId, parentNode, childNodes) {
        if (!childNodes || !childNodes.rows) return null;
        return childNodes.rows;
    }


    $.fn.zTree.init($("#treeObj"), setting);
    // setCheck();
});

function onCheckFunc(event, treeId, treeNode){

}

function runBeforeSubmit(form) {
    var treeObj = $.fn.zTree.getZTreeObj("treeObj");
    var nodes = treeObj.getCheckedNodes(true);
    var menuIds = [];
    for(var i in nodes){
        menuIds.push(nodes[i].id);
    }
    $("#menuIds").val(menuIds);
    return true ;
}

function onAsyncErrorFunc(){

}




// var code;
//
// function setCheck() {
//     var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
//         py = $("#py").attr("checked")? "p":"",
//         sy = $("#sy").attr("checked")? "s":"",
//         pn = $("#pn").attr("checked")? "p":"",
//         sn = $("#sn").attr("checked")? "s":"",
//         type = { "Y":py + sy, "N":pn + sn};
//     zTree.setting.check.chkboxType = type;
//     showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
// }
//
// function showCode(str) {
//     if (!code) code = $("#code");
//     code.empty();
//     code.append("<li>"+str+"</li>");
// }