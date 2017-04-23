<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

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
                            <form action="/system/dept/list/1.html" method="post" class="form-inline">
                                <div class="box-header">
                                    <#if permissions?seq_contains('addDept')>
                                        <div class="input-group">
                                            <a class="btn btn-primary" href="/system/dept/add.html"><i class="fa fa-plus"></i> 创建部门</a>
                                        </div>
                                    </#if>
                                    <div class="input-group">
                                        <input type="text" name="search" value="${search}" class="form-control" placeholder="Search">
                                        <div class="input-group-btn">
                                            <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                                            <a href="/system/dept/list/1.html" class="btn btn-default"><i class="fa fa-refresh"></i></a>
                                        </div>
                                    </div>
                                    <div class="input-group pull-right">
                                        <button type="button" class="btn btn-primary btn-flat" onclick="exportTo('部门数据');"><i class="fa fa-file-excel-o"></i> 导出</button>
                                    </div>
                                </div><!-- /.box-header -->
                            </form>
                            <div class="box-body table-responsive no-padding">
                                <table class="table table-hover">
                                    <tr>
                                        <th  width="100px"><input name="deptState" type="checkbox" class="minimal checkbox-toolbar"> 行号</th>
                                        <th>部门名称</th>
                                        <th>描述</th>
                                        <th width="120px">操作</th>
                                    </tr>
                                    <c:forEach items="${pageData.getRecords()}" var="dept">
                                        <tr>
                                            <td>
                                                <label>
                                                    <input type="checkbox" class="minimal checkbox-item">
                                                        ${((pageData.current-1)*pageData.size +dept_index+1)}
                                                </label>
                                            </td>
                                            <td>${(dept.deptName)}</td>
                                            <td>${(dept.deptDesc)}</td>
                                            <td>
                                                <!-- TODO -->
                                                <c:if test="${true}">
                                                    <a class="btn btn-primary btn-xs" href="/system/dept/edit/${(dept.id)}.html"> <i class="fa fa-pencil-square-o"></i> 编辑</a>
                                                    <a class="btn btn-danger btn-xs"
                                                       data-tiggle="ajax"
                                                       data-submit-url="/system/dept/delete?id=${(dept.id)}"
                                                       data-confirm="您确定要删除该条记录吗?"><i class="fa fa-times"></i> 删除</a>
                                                </c:if>
                                                    <%--<#if permissions?seq_contains('editDept')>

                                                        <#else>-</#if>
                                                    <#if permissions?seq_contains('deleteDept')>
                                                        <a class="btn btn-danger btn-xs"
                                                           data-tiggle="ajax"
                                                           data-submit-url="/system/dept/delete?id=${(dept.id)}"
                                                           data-confirm="您确定要删除该条记录吗?"><i class="fa fa-times"></i> 删除</a>
                                                        <#else>-</#if>--%>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </table>
                            </div><!-- /.box-body -->
                            <div class="box-footer row">
                                <%--<div class="col-md-6">--%>
                                    <%--<#include "/common/paginateBar.html" />--%>
                                    <%--<@paginate pageData=pageData actionUrl="/system/dept/list/" urlParas=".html?search=${search!}"  />--%>
                                <%--</div>--%>
                                <%--<div class="col-md-6 pull-left">--%>
                                    <%--<#include "/common/paginate.html" />--%>
                                    <%--<@paginate currentPage=pageData.getCurrent() totalPage=pageData.getPages() actionUrl="/system/dept/list/" urlParas=".html?search=${search!}&pageSize=${pageSize!}"  />--%>
                                <%--</div>--%>
                            </div>
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
