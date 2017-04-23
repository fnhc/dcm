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
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    <small>系统管理 > 系统配置</small>
                </h1>
            </section>
            <!-- Main content -->
            <section class="content">
                <!-- Your Page Content Here -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="nav-tabs-custom">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab_1" data-toggle="tab">系统设置</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab_1">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/system/setting/doSetting.html">
                                                <div class="box-body">
                                                    <c:forEach items="${list}" var="st" >
                                                        <div class="form-group">
                                                            <label for="${st.sysKey}">${st.sysName}</label>
                                                            <input type="hidden" name="id" value="${st.id}" />
                                                            <input type="text" id="${st.sysKey}" name="sysValue" value="${st.sysValue}" class="form-control"  data-rule="${st.sysName}:required;">
                                                            <p class="help-block" style="color: #dd4b39;">${st.sysDesc}</p>
                                                        </div>
                                                    </c:forEach>
                                                    <c:if test="${info != null}">
                                                        <div  class="alert alert-success alert-dismissible">
                                                            <h4 style="margin-bottom: 0px;"><i class="fa fa-check-circle"></i> ${info}</h4>
                                                        </div>
                                                    </c:if>

                                                </div><!-- /.box-body -->
                                                <div class="box-footer">
                                                    <button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>
                                                    <a  class="btn btn-default" href="/system/menu/list/1.html"><i class="fa fa-close"></i>  取消</a>
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
</body>
</html>
