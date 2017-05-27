var tableSelector = '#systemSettingTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: '/system/setting/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'settingCode',
            title: '配置编码',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'settingName',
            title: '配置名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'settingValue',
            title: '配置值',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'settingDesc',
            title: '配置描述',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'updateUserName',
            title: '更新人',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'updateTime',
            title: '更新时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editSetting(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteSetting(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
            }
        }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {searchKey : searchKeyVal};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addSetting() {
    add('新增组织机构','/system/setting/add');
}

function editSetting(id) {
    update('编辑系统配置','/system/setting/edit' , id );
}

function deleteSetting(id) {
    var url = "/system/setting/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}