<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/system/me/changePassword.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">

    <div class="tab-pane " id="tab_2">
        <div class="row">
            <div class="col-md-6">
                <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/system/me/doChangePwd">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="password">旧密码</label>
                            <input type="password" class="form-control" id="password"  name="password" placeholder="请输入旧密码" data-rule="旧密码: required;">
                        </div>
                        <div class="form-group">
                            <label for="newpassword">新密码</label>
                            <input type="password" class="form-control" id="newpassword"  name="newpassword" placeholder="请输入新密码" data-rule="新密码: required; length(6~16)">
                        </div>
                        <div class="form-group">
                            <label for="newpassword2">重复密码</label>
                            <input type="password" class="form-control" id="newpassword2"  name="newpassword2" placeholder="请重复输入新密码" data-rule="重复新密码: required;match(newpassword); length(6~16)">
                        </div>
                    </div><!-- /.box-body -->
                    <!--
                    <div class="box-footer">
                        <button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>
                    </div>
                    -->
                </form>
            </div>
        </div>
    </div><!-- /.tab-pane -->

</section><!-- /.content -->

</body>
</html>
