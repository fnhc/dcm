<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/9
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/system/role/roleList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 角色管理</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form action="/system/role/list" method="post" class="form-inline">
                            <div class="box-header">
                                <%--<#if permissions?seq_contains('addRole')>--%>
                                <div class="input-group"  id="addRole" style="display: none;">
                                    <a class="btn btn-primary  btn-flat" onclick="javascript:addRole()" > <i class="fa fa-plus"></i> 创建角色</a>
                                </div>
                                <div class="input-group" id="deleteBatchRole" style="display: none;">
                                    <a class="btn btn-danger  btn-flat"  onclick="javascript:deleteBatchRole()" ><i class="fa fa-remove"></i> 批量删除选中</a>
                                </div>
                                <%--</#if>--%>
                                <div class="input-group">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="角色名称">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat" ><i class="fa fa-search"></i> 查询</button>
                                        </div>
                                </div>

                            </div><!-- /.box-header -->
                        </form>

                        <div class="box-body table-responsive no-padding">
                            <table id="systemRoleTableId" class="table table-hover">

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

</body>
</html>
