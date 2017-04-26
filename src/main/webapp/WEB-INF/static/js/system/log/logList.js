jQuery(document).ready(function () {
    "use strict";

    var tableSelector = '#systemLogTableId';
    var paramsObj = {};

    jQuery(tableSelector).bootstrapTable({
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
                return '<a class="btn btn-primary btn-xs" data-tiggle="ajaxmodel" data-title="参数" data-url="/system/log/params/'+value+'">查看参数</a>';
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

    //todo remove
    $(function () {
        var now = new Date();

        $('.date').daterangepicker({
            "showWeekNumbers": true,
            "showISOWeekNumbers": true,
            "ranges": {
                "今天": [
                    now,
                    now
                ],
                "昨天": [
                    getBoforeDate(1),
                    getBoforeDate(1)
                ],
                "最近7天": [
                    getBoforeDate(7),
                    now
                ],
                "最近30天": [
                    getBoforeDate(30),
                    now
                ],
                "本月": [
                    getBoforeMonth(0,1),
                    getBoforeMonth(0,31)
                ],
                "上个月": [
                    getBoforeMonth(1,1),
                    getBoforeMonth(1,31)
                ],
                "最近三个月": [
                    getBoforeMonth(2,1),
                    getBoforeMonth(0,31)
                ]
            },
            "locale": {
                "format": "YYYY/MM/DD",
                "separator": "-",
                "applyLabel": "应用",
                "cancelLabel": "取消",
                "fromLabel": "From",
                "toLabel": "To",
                "customRangeLabel": "自定义",
                "weekLabel": "W",
                "daysOfWeek": [
                    "日",
                    "一",
                    "二",
                    "三",
                    "四",
                    "五",
                    "六"
                ],
                "monthNames": [
                    "一月",
                    "二月",
                    "三月",
                    "四月",
                    "五月",
                    "六月",
                    "七月",
                    "八月",
                    "九月",
                    "十月",
                    "十一月",
                    "十二月"
                ],
                "firstDay": 1
            },
            "alwaysShowCalendars": true,
            "autoUpdateInput":false,
            "opens": "right",
            "buttonClasses": "btn btn-sm"
        }, function(start, end, label) {
            console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
        });

        $('.date').on('apply.daterangepicker', function(ev, picker) {
            $(this).val(picker.startDate.format('YYYY/MM/DD') + ' - ' + picker.endDate.format('YYYY/MM/DD'));
        });

        $('.date').on('cancel.daterangepicker', function(ev, picker) {
            $(this).val('');
        });

        //todo 加入工具类中
        function getBoforeDate(before){
            var now = new Date();
            now.setDate(now.getDate()-before);
            return now;
        }

        //todo 加入工具类中
        function getBoforeMonth(beforeMonth,day){
            var now = new Date();
            now.setDate(day);
            now.setMonth(now.getMonth()-beforeMonth);
            return now;
        }
    });
});


