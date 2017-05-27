var tableSelector = '#systemMenuTableId';

jQuery(document).ready(function () {

    var menuId = $("#id").val();
    initFormData(menuId);
});

function initFormData(menuId){
    $.commonAjax({
        url: "/system/menu/editData",
        data: {id:menuId},
        success: function (json) {
            if (json.state) {
                var menu = json.content.sysMenu;
                if(menu){
                    var menuType = menu.menuType;
                    $("#menuName").val(menu.menuName);
                    $("#code").val(menu.code);
                    $("#sort").val(menu.sort);
                    if(menuType == 1){
                        $("#icon").val(menu.icon);
                    }else if(menuType == 2){
                        $("#url").val(menu.url);
                        $("#icon").val(menu.icon);
                        initCatalogSelect(menuId);
                    }else if(menuType == 3){
                        $("#resourceName").val(menu.resourceName);
                        initCatalogSelect(menuId);
                        initMenuSelect(menuId);
                        bindChangeEvent();
                    }

                }
            }
        }
    });
}


function initCatalogSelect(menuId){
    $.commonAjax({
        url: "/system/menu/menuSelect",
        data: {id:menuId,menuType:1},
        success: function (json) {
            if (json.state) {
                var catalogData = json.content.selectData;
                $("#catalog").select2({
                    data: catalogData
                });
            }
        }
    });
}

function initMenuSelect(menuId){
    $.commonAjax({
        url: "/system/menu/menuSelect",
        data: {id:menuId},
        success: function (json) {
            if (json.state) {
                var menuData = json.content.selectData;
                $("#pid").select2({
                    data: menuData
                });
            }
        }
    });
}

function bindChangeEvent(){
    $("#catalog").on('change',function(){
        var pid = $(this).val();
        $.post('/system/menu/menuSelect',{pid:pid},function(response){
            if(response.state){
                $("#pid").empty();
                $("#pid").select2({
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
