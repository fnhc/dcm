/**
 * Created by lenovo on 2017/5/9.
 */
var tableSelector = '#systemRoleTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: '/system/role/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'roleName',
            title: '角色名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'roleDesc',
            title: '描述',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'createTime',
            title: '创建时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'status',
            title: '状态',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var result = "启用";
                if(value == -1){
                    result = "<font color='red'> 禁用</font>"
                }
                return result;
            }
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                if(!value){
                    return "-";
                }
                $("#addRole").show();
                $("#deleteBatchRole").show();
                var authBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:authRole(\"" + value + "\")'><i class='fa fa-user'></i> 授权</a>";
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editRole(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteRole(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                return authBtn + OPERATION_SEPARATOR +  editBtn + OPERATION_SEPARATOR +  deleteBtn ;
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

function addRole() {
    add('新增角色','/system/role/add');
}

function editRole(id) {
    update('编辑角色','/system/role/edit' , id );
}

function deleteRole(id) {
    var url = "/system/role/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}

function deleteBatchRole() {
    var url = "/system/role/deleteBatch";
    deleteALLSelect(url , tableSelector);
}

function authRole(id){
    update('角色授权','/system/role/auth' , id );
}