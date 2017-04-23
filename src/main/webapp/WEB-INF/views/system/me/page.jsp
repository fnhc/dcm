<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <link rel="stylesheet" href="/plugins/bootstrap-fileinput/css/fileinput.min.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 用户中心</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li id="userSettingLiId" class="active"><a href="#tab_1" data-toggle="tab">用户设置</a></li>
                            <li id="modifyPasswordLiId"><a href="#tab_2" data-toggle="tab">修改密码</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <div class="row">
                                    <div class="col-md-6">
                                        <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/system/me/doMeSetting.html">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <label for="userName">用户名</label>
                                                    <input id="userName" type="text" name="userName" value="${(sysUser.userName)}" class="form-control" readonly="readonly">
                                                </div>
                                                <div class="form-group">
                                                    <label for="systemLogo">头像</label>
                                                    <input name="systemLogo" type="file" class="file-loading" id="systemLogo">
                                                </div>
                                            </div><!-- /.box-body -->
                                            <div class="box-footer">
                                                <button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div><!-- /.tab-pane -->

                            <div class="tab-pane " id="tab_2">
                                <div class="row">
                                    <div class="col-md-6">
                                        <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/system/me/doChangePwd.html">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <label for="password">旧密码</label>
                                                    <input type="password" class="form-control" id="password"  name="password" placeholder="请输入旧密码" data-rule="旧密码: required; length(6~16)">
                                                </div>
                                                <div class="form-group">
                                                    <label for="newpassword">新密码</label>
                                                    <input type="password" class="form-control" id="newpassword"  name="newpassword" placeholder="请输入新密码" data-rule="新密码: required; length(6~16)">
                                                </div>
                                                <div class="form-group">
                                                    <label for="newpassword2">重复密码</label>
                                                    <input type="password" class="form-control" id="newpassword2"  name="newpassword2" placeholder="请重复输入新密码" data-rule="重复新密码: required;match(newpassword); length(6~16)">
                                                </div>
                                                <#if msg??>
                                                    <div class="form-group">
                                                        <div  class="alert alert-danger alert-dismissible">
                                                            <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle"></i> ${msg}</h4>
                                                        </div>
                                                    </div>
                                                </#if>
                                                <#if info??>
                                                    <div class="form-group">
                                                        <div  class="alert alert-success alert-dismissible">
                                                            <h4 style="margin-bottom: 0px;"><i class="fa fa-info"></i> ${info}</h4>
                                                        </div>
                                                    </div>
                                                </#if>
                                            </div><!-- /.box-body -->
                                            <div class="box-footer">
                                                <button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div><!-- /.tab-pane -->

                        </div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->
                </div>
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>

<%@include file="/WEB-INF/views/common/js.jsp" %>

<script src="/plugins/bootstrap-fileinput/js/fileinput.min.js"></script>
<script src="/plugins/bootstrap-fileinput/js/locales/zh.js"></script>
<script>
    //初始化fileinput控件（第一次初始化）
    function initFileInput(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);

        control.fileinput({

            initialPreview: [
                '${(sysUser.userImg)}'
            ],
            initialPreviewAsData: true,
            initialPreviewConfig: [
                {caption: "${(sysUser.userImg)}", size: 930321, width: "120px", key: '${(sysUser.id)}', showDelete: false}
            ],
            deleteUrl: "/file/delete",

            language: 'zh', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
            showUpload: false, //是否显示上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary"
        });
    }

    initFileInput("systemLogo", "/file/upload");

</script>
<script src="/js/page.js"></script>

</body>
</html>


