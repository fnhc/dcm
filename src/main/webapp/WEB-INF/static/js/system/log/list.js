$(function () {
    "use strict";

    $('#systemLogTableId').DataTable({
        "searching": false,
        language: {
            "url": "/plugins/datatables/Chinese.json"
        },

        "ajax": {
            //todo
            "url": '/system/log/listData/1'
        }
        ,
        "columns": [
            {"data": 'id'},
            {"data": 'title'},
            {"data": 'userName'},
            {"data": 'url'},
            {"data": 'createTime'},
            {
                "data": 'id', "render": function (data, type, full, meta) {
                    //todo return '<a href="'+data+'">Download</a>';
                return '<a class="btn btn-xs" data-tiggle="ajaxmodel" data-title="参数" data-url="/system/log/params/'+data+'">查看参数</a>';
            }
            }
        ]
    });
});