<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="/js/system/dept/deptAdd.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="/system/dept/doAdd">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="deptName">部门名称</label>
                                <input type="text" id="deptName" name="deptName" class="form-control"
                                       placeholder="请输入部门名称" data-rule="部门名称:required;deptname;">
                            </div>
                            <div class="form-group">
                                <label>部门描述</label>
                                <textarea class="form-control" name="deptDesc" rows="3"
                                          placeholder="请输入描述，最多300个字符 ..."></textarea>
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <%--<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <button type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->

</body>
</html>
