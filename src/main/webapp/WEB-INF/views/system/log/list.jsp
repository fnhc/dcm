<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <!-- DataTables -->
    <link rel="stylesheet" href="/plugins/datatables/dataTables.bootstrap.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@include file="/WEB-INF/views/common/menu.jsp" %>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    <small>系统管理 > 日志查询</small>
                </h1>
            </section>
            <!-- Main content -->
            <section class="content">
                <!-- Your Page Content Here -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            <div class="box-header">
                                <form class="form-inline"  action="/system/log/list/1.html" method="post">
                                    <div class="form-group">
                                        <input type="text" name="daterange" value="${daterange}" class="form-control date" id="daterange" placeholder="开始日期  - 结束日期" style="width: 228px;">
                                    </div>
                                    <div class="input-group">
                                        <input type="text" name="search" value="${search}" class="form-control" placeholder="Search">
                                        <div class="input-group-btn">
                                            <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                                            <a href="/system/log/list/1.html" class="btn btn-default"><i class="fa fa-refresh"></i></a>
                                        </div>
                                    </div>
                                    <div class="input-group pull-right">
                                        <button type="button" class="btn btn-primary btn-flat" onclick="exportTo('日志数据');"><i class="fa fa-file-excel-o"></i> 导出</button>
                                    </div>
                                </form>
                            </div>
                            <div class="box-body">

                                <table id="systemLogTableId" class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>行号</th>
                                            <th>日志操作</th>
                                            <th>用户</th>
                                            <th>地址</th>
                                            <th>时间</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <%--<tbody>
                                    <c:forEach items="${pageData.getRecords()}" var="log" >
                                        <tr>
                                            <td>${((pageData.current-1)*pageData.size +log_index+1)}</td>
                                            <td>${(log.title)}</td>
                                            <td>${(log.userName)}</td>
                                            <td>${log.url}</td>
                                            <td>${(log.createTime)}</td>
                                            <td>
                                                <a class="btn btn-xs"
                                                   data-tiggle="ajaxmodel"
                                                   data-title="参数"
                                                   data-url="/system/log/params/${log.id}.html"
                                                >查看参数</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody> --%>


                                </table>
                            </div><!-- /.box-body -->

                        </div><!-- /.box -->
                    </div>
                </div>
            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->

        <%@include file="/WEB-INF/views/common/footer.jsp" %>
        <div class="control-sidebar-bg"></div>
    </div>

    <%@include file="/WEB-INF/views/common/js.jsp" %>
    <!-- DataTables -->
    <script src="/plugins/datatables/jquery.dataTables.js"></script>
    <script src="/plugins/datatables/dataTables.bootstrap.js"></script>

    <script src="/js/system/log/list.js"></script>

    <script>

        function getBoforeDate(before){
            var now = new Date();
            now.setDate(now.getDate()-before);
            return now;
        }

        function getBoforeMonth(beforeMonth,day){
            var now = new Date();
            now.setDate(day);
            now.setMonth(now.getMonth()-beforeMonth);
            return now;
        }

        $(function(){

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

        });
    </script>
</body>
</html>