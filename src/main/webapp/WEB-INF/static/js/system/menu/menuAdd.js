
var defaultCatalogId;

jQuery(document).ready(function () {
    initMenuTypeSelect();
    initCatalogSelect();
    initMenuSelect();
});


function initMenuTypeSelect(){
    $.commonAjax({
        url: "/system/menu/menuTypeList",
        async:false,
        success: function (json) {
            if (json.state) {
                var menuTypeData = json.content.menuType;
                $("#menuType").select2({
                    data: menuTypeData
                });
                $("#menuType").on('change',function(){
                    var menuType = $(this).val();
                    changeDivForMenuType(menuType);
                });
                //初始化界面
                if(menuTypeData && menuTypeData.length>0){
                    changeDivForMenuType(menuTypeData[0].id)
                }
            }
        }
    });
}


function changeDivForMenuType(menuType){
    if(menuType == 1){
        $("#catalogDiv").hide();
        $("#catalogIdDiv").hide();
        $("#menuDiv").hide();
        $("#urlDiv").hide();
        $("#url").removeAttr("data-rule");
        //$("#code").attr("data-rule-number", "[/^\d{2}$/, '请输入2位数字编码']");
    }else if(menuType == 2){
        $("#catalogDiv").show();
        $("#catalog").attr("name", "pid");
        $("#catalogIdDiv").hide();
        $("#menuDiv").hide();
        $("#menu").removeAttr("name");
        $("#urlDiv").show();
        //$("#code").attr("data-rule-number", "[/^\d{4}$/, '请输入4位数字编码']");
    }else if(menuType == 3){
        $("#catalogDiv").hide();
        $("#catalog").removeAttr("name");
        $("#catalogIdDiv").show();
        $("#menuDiv").show();
        $("#menu").attr("name", "pid");
        $("#urlDiv").hide();
        $("#url").removeAttr("data-rule");
        $("#iconDiv").hide();
        $("#icon").removeAttr("data-rule");
        //$("#code").attr("data-rule-number", "[/^\d{6}$/, '请输入6位数字编码']");
        bindChangeEvent();
    }
}


function initCatalogSelect(){
    $.commonAjax({
        url: "/system/menu/menuSelect",
        data: {menuType:1},
        async: false,
        success: function (json) {
            if (json.state) {
                var catalogData = json.content.selectData;
                $("#catalog").select2({
                    data: catalogData
                });
                $("#catalogId").select2({
                    data: catalogData
                });
                if(catalogData && catalogData.length>0){
                    defaultCatalogId = catalogData[0].id;
                }
            }
        }
    });
}

function initMenuSelect(){
    $.commonAjax({
        url: "/system/menu/menuSelect",
        data: {pid:defaultCatalogId},
        async:false,
        success: function (json) {
            if (json.state) {
                var menuData = json.content.selectData;
                $("#menu").select2({
                    data: menuData
                });
            }
        }
    });
}

function bindChangeEvent(){
    $("#catalogId").on('change',function(){
        var pid = $(this).val();
        $.post('/system/menu/menuSelect',{pid:pid},function(response){
            if(response.state){
                $("#menu").empty();
                $("#menu").select2({
                    data:response.content.selectData
                });
            }
        });
    });
}



function runAfterSubmitSuccess(response) {
    //刷新主页面
    parent.reloadTable();
}
