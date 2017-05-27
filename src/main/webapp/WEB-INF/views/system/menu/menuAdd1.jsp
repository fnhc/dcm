<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/system/menu/menuAdd.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">创建菜单</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab_1" data-toggle="tab">添加目录</a></li>
                                    <li><a href="#tab_2" data-toggle="tab">添加菜单</a></li>
                                    <li><a href="#tab_3" data-toggle="tab">添加功能</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab_1">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                                                      method="post" action="/system/menu/doAddDir.html">
                                                    <div class="box-body">
                                                        <div class="form-group">
                                                            <label>目录名称</label>
                                                            <input type="text" name="menuName" class="form-control"
                                                                   placeholder="请输入目录名称" data-rule="目录名称:required;">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>编码</label>
                                                            <input type="text" name="code" class="form-control"
                                                                   placeholder="请输入编码,如05"
                                                                   data-rule="required;number"
                                                                   data-rule-number="[/^\d{2}$/, '请输入2位数字编码']">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>排序</label>
                                                            <input type="text" name="sort" class="form-control"
                                                                   placeholder="请输入排序"
                                                                   data-rule="排序:required;integer[+0]">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>图标</label>
                                                            <input type="text" name="icon" value="fa-folder"
                                                                   class="form-control"
                                                                   placeholder="请输入图标,如:fa-user">
                                                        </div>
                                                    </div>
                                                    <!-- /.box-body -->
                                                    <div class="box-footer">
                                                        <%--<button type="submit" class="btn btn-success"><i
                                                                class="fa fa-save"></i> 提 交
                                                        </button>--%>
                                                        <input type="submit" style="display:none;"/>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.tab-pane -->
                                    <div class="tab-pane" id="tab_2">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <form role="form"
                                                      data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                                                      method="post" action="/system/menu/doAddMenu.html">
                                                    <div class="box-body">
                                                        <div class="form-group">
                                                            <label>目录</label>
                                                            <select id="catalogId" name="pid"
                                                                    class="form-control select2"
                                                                    style="width: 100%;"
                                                                    data-rule="父级菜单:required;"></select>
                                                        </div>
                                                        <!-- /.form-group -->
                                                        <div class="form-group">
                                                            <label>菜单名称</label>
                                                            <input type="text" name="menuName" class="form-control"
                                                                   placeholder="请输入菜单名称" data-rule="菜单名称:required;">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>编码</label>
                                                            <input type="text" name="code" class="form-control"
                                                                   placeholder="请输入编码,如0501"
                                                                   data-rule="required;number"
                                                                   data-rule-number="[/^\d{4}$/, '请输入4位数字编码']">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>菜单URL</label>
                                                            <input type="text" name="url" class="form-control"
                                                                   placeholder="请输入菜单URL"
                                                                   data-rule="菜单URL:required;">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>排序</label>
                                                            <input type="text" name="sort" class="form-control"
                                                                   placeholder="请输入排序"
                                                                   data-rule="排序:required;integer[+0]">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>图标</label>
                                                            <input type="text" name="icon" value="fa-file"
                                                                   class="form-control"
                                                                   placeholder="请输入图标,如:fa-user">
                                                        </div>
                                                    </div>
                                                    <!-- /.box-body -->
                                                    <div class="box-footer">
                                                        <%--<button type="submit" class="btn btn-success"><i
                                                                class="fa fa-save"></i> 提 交
                                                        </button>--%>
                                                        <input type="submit" style="display:none;"/>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.tab-pane -->

                                    <div class="tab-pane" id="tab_3">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <form role="form"
                                                      data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                                                      method="post" action="/system/menu/doAddAction.html">
                                                    <div class="box-body">
                                                        <div class="form-group">
                                                            <label>目录</label>
                                                            <select id="catalog" class="form-control select2"
                                                                    style="width: 100%;"
                                                                    data-rule="目录:required;"></select>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>菜单</label>
                                                            <select id="pid" name="pid" class="form-control select2"
                                                                    style="width: 100%;"
                                                                    data-rule="菜单:required;"></select>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>功能名称</label>
                                                            <input type="text" name="menuName" class="form-control"
                                                                   placeholder="请输入目录名称" data-rule="目录名称:required;">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>编码</label>
                                                            <input type="text" name="code" class="form-control"
                                                                   placeholder="请输入编码,如050101"
                                                                   data-rule="required;number"
                                                                   data-rule-number="[/^\d{6}$/, '请输入6位数字编码']">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="resource">权限资源</label>
                                                            <input type="text" id="resource" name="resource"
                                                                   class="form-control" placeholder="请输入权限资源名称"
                                                                   data-rule="权限资源:required;">
                                                                   <%--data-rule="权限资源:required;remote[/system/menu/checkMenuResource.html]">--%>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>排序</label>
                                                            <input type="text" name="sort" class="form-control"
                                                                   placeholder="请输入排序"
                                                                   data-rule="排序:required;integer[+0]">
                                                        </div>
                                                    </div>
                                                    <!-- /.box-body -->
                                                    <div class="box-footer">
                                                        <%--<button type="submit" class="btn btn-success"><i
                                                                class="fa fa-save"></i> 提 交
                                                        </button>--%>
                                                        <input type="submit" style="display:none;"/>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.tab-pane -->

                                </div>
                                <!-- /.tab-pane -->
                            </div>
                            <!-- /.tab-content -->
                        </div>
                        <!-- nav-tabs-custom -->
                    </div>
                </div>
            </div>
            <!-- /.box -->
        </div>
        <!--/.col (left) -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
</body>
</html>