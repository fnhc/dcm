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
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:queryLogDetail(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 查看参数</a>";
               return editBtn ;
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

function queryLogDetail(id) {
    var url = '/system/log/params/'+ id ;

    $.post(url, function(str){
        layer.open({
            type: 1,
            title : '查看参数',
            area: ['300px', '180px'],
            fixed: false, //不固定
            content: str //注意，如果str是object，那么需要字符拼接。
        });
    });
}


