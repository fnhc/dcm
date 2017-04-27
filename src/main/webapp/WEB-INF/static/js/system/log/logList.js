$(document).ready(function () {
    "use strict";

    var tableSelector = '#systemLogTableId';
    var paramsObj = {};

    $(tableSelector).bootstrapTable({
        url: '/system/log/list',
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
            field: 'title',
            title: '日志操作',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'userName',
            title: '用户',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'url',
            title: '地址',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'createTime',
            title: '时间',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
               return '<a class="btn btn-xs" data-tiggle="ajaxmodel" data-title="参数" data-url="/system/log/params/${log.id}.html" >查看参数</a>' ;
                // return '<a class="btn btn-primary btn-flat btn-xs" data-tiggle="ajaxmodel" data-title="参数" data-url="/system/log/params/'+value+'">查看参数</a>';
            }
        }]
    });

    $('#dateRangeId').customDateRangePicker();

    $('#queryBtnId').click(function () {
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


