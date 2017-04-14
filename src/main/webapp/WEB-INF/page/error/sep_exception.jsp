<%@page contentType="text/html; charset=utf-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path + "/";
%>
<html>
<head>
	<title>未处理错误</title>
    <link href="<%=basePath%>css/admin.css" type=text/css rel=stylesheet />
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" class="template_decoratormain">
  <tr>
    <td width="19" scope="row" class="template_decoratormain_l">&nbsp;</td>
    <td align="center" valign="top" class="template_decoratormain_r">
		<table border="0" cellspacing="0" cellpadding="0" class="template_decoratormain_inner">
		  <tr>
			<td height="30" align="left" valign="bottom" scope="row"  class="template_decoratormain_position">当前位置&nbsp;&gt;&nbsp; 未处理错误</td>
			<td height="20" align="left" valign="bottom" scope="row">&nbsp;</td>
		  </tr>
		  <tr>
			<td scope="row" align="left" valign="top">
			<div id="decorator_show">
				<div class="hintInfo">
				温馨提示：对不起，您要访问的页面暂时无法访问或程序错误！
				</div>
			</div>
			</td>
			<td width="15" scope="row">&nbsp;</td>
		  </tr>
		  <tr>
			<td height="20" scope="row">&nbsp;</td>
			<td height="20" scope="row">&nbsp;</td>
		  </tr>
		</table>
	</td>
  </tr>
</table>
</body>
</html>