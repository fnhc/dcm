<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <%@include file="/WEB-INF/views/common/head.jsp" %>

  <script src="/js/system/setting/settingAdd.js"></script>
</head>
<body>
<section class="content">
  <div class="row">
    <div class="col-md-12">
      <!-- form start -->
      <div class="row">
        <div class="col-md-6">
          <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                method="post" action="/system/setting/doAdd">
            <div class="box-body">
              <div class="form-group">
                <label for="settingCode">系统配置编码</label>
                <input type="text" id="settingCode" name="settingCode" class="form-control"
                       placeholder="请输入系统配置编码" data-rule="系统配置名称:required;">
              </div>
              <div class="form-group">
                <label for="settingName">系统配置名称</label>
                <input type="text" id="settingName" name="settingName" class="form-control"
                       placeholder="请输入系统配置名称" data-rule="系统配置名称:required;">
              </div>
              <div class="form-group">
                <label for="settingValue">系统配置值</label>
                <input type="text" id="settingValue" name="settingValue" class="form-control"
                       placeholder="请输入系统配置值" data-rule="系统配置值:required;">
              </div>
              <div class="form-group">
                <label>系统配置描述</label>
                <textarea class="form-control" name="settingDesc" rows="3"
                          placeholder="请输入描述，最多300个字符 ..."></textarea>
              </div>
            </div><!-- /.box-body -->
            <div class="box-footer">
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
