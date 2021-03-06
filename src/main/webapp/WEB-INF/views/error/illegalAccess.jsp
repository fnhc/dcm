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
            <!-- Main content -->
            <section class="content">
                <div class="error-page">
                    <div>
                        <h2 class="headline text-yellow">  <i class="fa fa-warning text-yellow"></i> illegalAccess</h2>
                        <p> 资源地址: <a href="${url}">${url}</a>.
                        <p> 您没有访问权限,您可以点击这里 <a href="/index.html">返回首页</a>或刷新页面重试！
                        </p>
                    </div><!-- /.error-content -->
                </div><!-- /.error-page -->
            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->


        <%@include file="/WEB-INF/views/common/footer.jsp" %>
        <div class="control-sidebar-bg"></div>
    </div>

</body>
</html>
