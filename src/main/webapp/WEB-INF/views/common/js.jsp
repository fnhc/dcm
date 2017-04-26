<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 确认提示组件 -->
<div id="confirm-modal" class="modal fade" tabindex="-1" data-backdrop="static" data-keyboard="false" style="display: none;">
  <div class="modal-body">
    <p>您确定要删除该条记录吗?</p>
  </div>
  <div class="modal-footer">
    <button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
    <button type="button"  class="btn btn-primary del">删除</button>
  </div>
</div>


<script type="text/javascript">
 	
$(function(){
	//select2
	$(".select2").select2();
	//iCheck for checkbox and radio inputs
	$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
       checkboxClass: 'icheckbox_minimal-blue',
       radioClass: 'iradio_minimal-blue'
    });
    // Custom theme
    $.validator.setTheme('bootstrap', {
        validClass: 'has-success',
        invalidClass: 'has-error',
        bindClassTo: '.form-group',
        formClass: 'n-default n-bootstrap',
        msgClass: 'n-right'
    });
});
</script>


