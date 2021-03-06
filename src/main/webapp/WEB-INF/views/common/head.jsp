<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${systemName}</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="/plugins/font-awesome/css/font-awesome.min.css">
<!-- jquery-confirm -->
<link rel="stylesheet" href="/plugins/jquery-confirm/jquery-confirm.min.css">
<!-- nice-validator -->
<link rel="stylesheet" href="/plugins/nice-validator/jquery.validator.css">
<!-- Select2 -->
<link rel="stylesheet" href="/plugins/select2/select2.min.css">
<!-- daterange picker -->
<link rel="stylesheet" href="/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet" href="/plugins/iCheck/all.css">
<!-- bootstrap-table -->
<link rel="stylesheet" href="/plugins/bootstrap-table/bootstrap-table.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/app/css/AdminLTE.css">
<link rel="stylesheet" href="/app/css/skins/skin-blue.css">

<!-- 自定义 css -->
<link rel="stylesheet" href="/css/custom.css">

<!-- REQUIRED JS SCRIPTS -->

<!--[if lt IE 9]>
<script src="/plugins/others/html5shiv.min.js"></script>
<script src="/plugins/others/respond.min.js"></script>
<![endif]-->

<!-- jQuery 2.2.3 -->
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="/plugins/iCheck/icheck.min.js"></script>
<!-- nice-validator -->
<script src="/plugins/nice-validator/jquery.validator.js"></script>
<script src="/plugins/nice-validator/local/zh-CN.js"></script>
<!--jquery-form  -->
<script src="/plugins/jquery-form/jquery.form.js"></script>
<!--jquery-confirm  -->
<script src="/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<!-- Select2 -->
<script src="/plugins/select2/select2.full.min.js"></script>
<!-- date -->
<script src="/plugins/daterangepicker/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<!-- jquery.cookie -->
<script src="/plugins/jquery.cookie.js"></script>

<!-- bootstrap-table -->
<script src="/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- layer -->
<script src="/plugins/layer/layer.js"></script>

<!-- AdminLTE App -->
<script src="/app/js/app.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/app/js/demo.js"></script>


<!-- 自定义系统初始化话JS -->
<script src="/js/custom/global_custom.js"></script>
<script src="/js/custom/curdtools.js"></script>

<script type="text/javascript">
    //todo
    var urlPrefix = '';
    initGlobalCustom(urlPrefix);
</script>