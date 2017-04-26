<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <!-- bootstrap-table -->
    <link rel="stylesheet" href="/plugins/bootstrap-table/bootstrap-table.min.css">

    <!-- bootstrap-table -->
    <script src="/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <script src="/js/system/log/logList.js"></script>

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
                                        <input id="dateRangeId" type="text" name="daterange" value="${daterange}" class="form-control date" placeholder="开始日期  - 结束日期" style="width: 228px;">
                                    </div>
                                    <div class="input-group">
                                        <input id="searchKeyId" type="text" name="search" value="${search}" class="form-control" placeholder="日志操作">
                                        <div class="input-group-btn">
                                            <button id="queryBtnId" type="button" class="btn btn-primary btn-flat" ><i class="fa fa-search"></i> 查询</button>
                                        </div>
                                    </div>

                                </form>
                            </div>

                            <div class="box-body table-responsive no-padding">

                                <table id="systemLogTableId" class="table table-hover">
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

    <%--<%@include file="/WEB-INF/views/common/js.jsp" %>--%>

</body>
</html>
