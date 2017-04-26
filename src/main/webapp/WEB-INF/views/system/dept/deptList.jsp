<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/system/dept/dept.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@include file="/WEB-INF/views/common/menu.jsp" %>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    <small>系统管理 > 部门管理</small>
                </h1>
            </section>
            <!-- Main content -->
            <section class="content">
                <!-- Your Page Content Here -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            <form action="/system/dept/list" method="post" class="form-inline">
                                <div class="box-header">
                                    <%--<#if permissions?seq_contains('addDept')>--%>
                                        <div class="input-group">
                                            <a class="btn btn-primary" href="/system/dept/add.html"><i class="fa fa-plus"></i> 创建部门</a>
                                        </div>
                                    <%--</#if>--%>
                                    <div class="input-group">
                                        <input type="text" name="search" value="${search}" class="form-control" placeholder="Search">
                                        <div class="input-group-btn">
                                            <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                                            <a href="/system/dept/list" class="btn btn-default"><i class="fa fa-refresh"></i></a>
                                        </div>
                                    </div>
                                    <div class="input-group pull-right">
                                        <button type="button" class="btn btn-primary btn-flat" onclick="exportTo('部门数据');"><i class="fa fa-file-excel-o"></i> 导出</button>
                                    </div>
                                </div><!-- /.box-header -->
                            </form>

                            <div class="box-body table-responsive no-padding">
                                <table id="systemDeptTableId" class="table table-hover">

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
</body>
</html>
