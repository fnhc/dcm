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
            <!-- general form elements -->
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="/system/menu/doEdit">
                        <input type="hidden" id="id" name="id" value="${id}"/>

                        <div class="box-body">
                            <div class="form-group">
                                <label>目录</label>
                                <select id="catalog" class="js-example-basic-single" style="width: 100%;"></select>
                            </div>
                            <div class="form-group">
                                <label>菜单</label>
                                <select id="pid" name="pid" class="js-example-basic-single"
                                        style="width: 100%;"></select>
                            </div>
                            <div class="form-group">
                                <label>功能名称</label>
                                <input type="text" id="menuName" name="menuName" class="form-control"
                                       placeholder="请输入功能名称" data-rule="功能名称:required;">
                            </div>
                            <div class="form-group">
                                <label>编码</label>
                                <input type="text" id="code" name="code" class="form-control"
                                       placeholder="请输入编码" data-rule="编码:required;">
                            </div>
                            <div class="form-group">
                                <label for="resourceName">权限资源</label>
                                <input type="text" id="resourceName" name="resourceName" class="form-control"
                                       placeholder="请输入权限资源名称" data-rule="权限资源:required;">
                            </div>
                            <div class="form-group">
                                <label>排序</label>
                                <input type="text" id="sort" name="sort" class="form-control"
                                       placeholder="请输入排序" data-rule="排序:required;integer[+0]">
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
