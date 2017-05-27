<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="/js/system/dept/deptEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/system/dept/doEdit">
                        <input type="hidden" id="deptId" value="${deptId}" name="id" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="pid">上级组织机构</label>
                                <select id="pid" name="pid" class="form-control select2" style="width: 100%;"></select>
                            </div>
                            <div class="form-group">
                                <label for="deptName">组织机构名称</label>
                                <input type="text" id="deptName" name="deptName" class="form-control" placeholder="请输入组织机构名称"  data-rule="组织机构名称:required;simpleName;remote(/system/dept/checkDeptName?deptId=${(dept.id)});">
                            </div>
                            <div class="form-group">
                                <label for="deptName">组织机构简称</label>
                                <input type="text" id="deptAlias" name="deptAlias" class="form-control"
                                       placeholder="请输入组织机构简称" data-rule="组织机构简称:simpleName;">
                            </div>
                            <div class="form-group">
                                <label for="deptName">组织机构编码</label>
                                <input type="text" id="deptCode" name="deptCode" class="form-control"
                                       placeholder="请输入组织机构编码" data-rule="组织机构编码:required;simpleCode;">
                            </div>
                            <div class="form-group">
                                <label for="deptName">联系人</label>
                                <input type="text" id="deptContactMan" name="deptContactMan" class="form-control"
                                       placeholder="请输入联系人" data-rule="联系人:simpleName;">
                            </div>
                            <div class="form-group">
                                <label for="deptName">联系电话</label>
                                <input type="text" id="deptContactNum" name="deptContactNum" class="form-control"
                                       placeholder="请输入联系电话" data-rule="mobile||tel;">
                            </div>
                            <div class="form-group">
                                <label for="deptName">地址</label>
                                <input type="text" id="deptAddress" name="deptAddress" class="form-control"
                                       placeholder="请输入地址" data-rule="地址:address;">
                            </div>
                            <div class="form-group">
                                <label>组织机构描述</label>
                                <textarea class="form-control" id="deptDesc" name="deptDesc" rows="3" placeholder="请输入描述，最多300个字符 ..." data-rule="length(~300);" ></textarea>
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
