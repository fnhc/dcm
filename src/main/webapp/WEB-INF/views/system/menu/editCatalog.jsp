<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="/js/system/menu/menuEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/system/menu/doEdit">
                        <input type="hidden" id="id" name="id" value="${id}"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="menuName">目录名称</label>
                                <input type="text" id="menuName" name="menuName" class="form-control" placeholder="请输入目录名称"  data-rule="目录名称:required;">
                            </div>
                            <div class="form-group">
                                <label for="code">编码</label>
                                <input type="text" id="code" name="code" class="form-control" placeholder="请输入编码,如05"  data-rule="编码:required;">
                            </div>
                            <div class="form-group">
                                <label for="sort">排序</label>
                                <input type="text" id="sort" name="sort" class="form-control" placeholder="请输入排序" >
                            </div>
                            <div class="form-group">
                                <label for="icon">图标</label>
                                <input type="text" id="icon" name="icon" class="form-control" placeholder="请输入图标,如fa-menu" >
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <%--<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <input type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->

</body>
</html>
