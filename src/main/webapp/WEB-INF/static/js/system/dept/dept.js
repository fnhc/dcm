jQuery(document).ready(function () {
    "use strict";

    var tableSelector = '#systemDeptTableId';
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
        query();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {searchKey : searchKeyVal};
    }

    function query() {
        $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
        $(tableSelector).data("bootstrap.table").refresh();
    }

});


//todo
function editDept(id) {
    // update('编辑窗口','/system/dept/edit' , id , null , null , true);
    layer.open({
        type: 2,
        title : '编辑部门',
        area: ['600px', '350px'],
        fixed: false, //不固定
        maxmin: false,
        content: '/system/dept/edit/' + id ,
        btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        yes : function () {

        } ,
        btn2 : function () {

        }
    });
}

function deleteDept(value) {
    //todo /system/dept/delete?id=${(dept.id)!}
}