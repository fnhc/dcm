<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/system/menu/menuAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="/system/menu/doAdd">
                        <div class="box-body">
                            <div class="form-group" id="menuTypeDiv">
                                <label>菜单类型</label>
                                <select id="menuType" name="menuType"
                                        class="form-control select2"
                                        style="width: 100%;"
                                        data-rule="菜单类型:required;"></select>
                            </div>
                            <div class="form-group" id="catalogDiv">
                                <label>目录</label>
                                <select id="catalog"
                                        class="form-control select2"
                                        style="width: 100%;"></select>
                            </div>
                            <div class="form-group" id="catalogIdDiv">
                                <label>目录</label>
                                <select id="catalogId"
                                        class="form-control select2"
                                        style="width: 100%;"></select>
                            </div>
                            <div class="form-group" id="menuDiv">
                                <label>菜单</label>
                                <select id="menu" name="pid" class="form-control select2"
                                        style="width: 100%;"></select>
                            </div>
                            <div class="form-group" id="menuNameDiv">
                                <label>名称</label>
                                <input type="text" name="menuName" class="form-control"
                                       placeholder="请输入名称" data-rule="名称:required;">
                            </div>
                            <div class="form-group" id="codeDiv">
                                <label>编码</label>
                                <input type="text" id="code" name="code" class="form-control"
                                       placeholder="请输入编码,如05"
                                       data-rule="required;number">
                                <%--data-rule-number="[/^\d{2}$/, '请输入2位数字编码']">--%>
                            </div>
                            <div class="form-group" id="urlDiv">
                                <label>菜单URL</label>
                                <input type="text" id="url" name="url" class="form-control"
                                       placeholder="请输入菜单URL"
                                       data-rule="菜单URL:required;">
                            </div>
                            <div class="form-group" id="sortDiv">
                                <label>排序</label>
                                <input type="text" name="sort" class="form-control"
                                       placeholder="请输入排序"
                                       data-rule="排序:required;integer[+0]">
                            </div>
                            <div class="form-group" id="iconDiv">
                                <label>图标</label>
                                <input type="text" id="icon" name="icon" value="fa-folder"
                                       class="form-control"
                                       placeholder="请输入图标,如:fa-user">
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
</section>
</body>
</html>