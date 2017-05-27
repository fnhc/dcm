var tableSelector = '#systemUserTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: '/system/user/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'userName',
            title: '用户名',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'realName',
            title: '真实姓名',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'userType',
            title: '用户类型',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'userDesc',
            title: '描述',
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
            field: 'status',
            title: '用户状态',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var res;
                if(value === 1){
                    res = "启用";
                }
                else {
                    res = "禁用";
                }
                return res;
            }
        },{
            field: 'createName',
            title: '创建者',
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'createTime',
            title: '创建用户时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

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

function addUser() {
    add('新增用户','/system/user/add');
}

function editUser(id) {
    update('编辑用户','/system/user/edit' , id);
}

function deleteUser(id) {
    var url = "/system/user/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}