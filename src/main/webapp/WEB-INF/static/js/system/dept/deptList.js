var tableSelector = '#systemDeptTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).bootstrapTable({
        url: '/system/dept/list',
        pagination : true ,
        sidePagination : 'server',
        queryParamsType : '',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'id',
            title: 'guid',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptName',
            title: '部门名称',
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
    add('新增部门','/system/dept/add');
}

function editDept(id) {
    update('编辑部门','/system/dept/edit' , id );
}

function deleteDept(id) {
    var url = "/system/dept/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}