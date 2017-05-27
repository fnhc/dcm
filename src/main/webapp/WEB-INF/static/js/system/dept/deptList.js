var tableSelector = '#systemDeptTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: '/system/dept/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptName',
            title: '组织机构名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptAlias',
            title: '组织机构简称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptCode',
            title: '组织机构编码',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactMan',
            title: '联系人',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactNum',
            title: '联系电话',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptAddress',
            title: '地址',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptDesc',
            title: '描述',
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
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editDept(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteDept(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

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

function addDept() {
    // add('新增组织机构','/system/dept/add');

    layer.open({
        type: 2,
        shade: false,
        area: '500px',
        maxmin: true,
        content: '/system/dept/add',
        zIndex: layer.zIndex, //重点1
        success: function(layero){
            layer.setTop(layero); //重点2
        }
    });
}


function editDept(id) {
    update('编辑组织机构','/system/dept/edit' , id );
}

function deleteDept(id) {
    var url = "/system/dept/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}