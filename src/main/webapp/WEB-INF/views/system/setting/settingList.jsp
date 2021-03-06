<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <%@include file="/WEB-INF/views/common/head.jsp" %>
  <script src="/js/system/setting/settingList.js"></script>

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
          <div class="box">
            <form action="/system/setting/list" method="post" class="form-inline">
              <div class="box-header">
                <div class="input-group">
                  <a class="btn btn-primary  btn-flat" onclick="javascript:addSetting()" > <i class="fa fa-plus"></i> 创建系统配置</a>
                </div>
                <div class="input-group">
                  <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="系统配置名称">
                  <div class="input-group-btn">
                    <button id="queryBtnId" type="button" class="btn btn-primary btn-flat" ><i class="fa fa-search"></i> 查询</button>
                  </div>
                </div>

              </div><!-- /.box-header -->
            </form>

            <div class="box-body table-responsive no-padding">
              <table id="systemSettingTableId" class="table table-hover">

              </table>
            </div><!-- /.box-body -->

          </div><!-- /.box -->
        </div>
      </div>
    </section><!-- /.content -->
  </div><!-- /.content-wrapper -->

  <%@include file="/WEB-INF/views/common/footer.jsp" %>
  <div class="control-sidebar-bg"></div>
</div>

</body>
</html>