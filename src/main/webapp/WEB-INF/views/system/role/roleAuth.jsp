<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/9
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <link rel="stylesheet" href="/plugins/zTree/css/zTreeStyle/zTreeStyle.css">
    <script src="/plugins/zTree/js/jquery.ztree.all.js"></script>
    <script src="/js/system/role/roleAuth.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="/system/role/doAuth">
                        <input type="hidden" value="${id}" id="roleId" name="roleId" />
                        <input type="hidden" id="menuIds" name="menuIds" />
                        <div class="box-body">
                            <div class="form-group">
                                <label id="menu">菜单</label>
                                <ul id="treeObj" class="ztree"></ul>
                            </div>
                        </div>
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
