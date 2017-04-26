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
                return '<a class="btn btn-primary btn-xs" data-tiggle="ajaxmodel" data-title="参数" data-url="/system/log/params/'+value+'">编辑</a>';
            }
        }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        query();
    });

    function setParams() {
        var dateRangeVal = $('#dateRangeId').val();
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {searchKey : searchKeyVal , dateRange : dateRangeVal};
    }

    function query() {
        $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
        $(tableSelector).data("bootstrap.table").refresh();
    }
});


