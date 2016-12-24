<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Manage Blog</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-en.js"></script>
<script type="text/javascript">
	###
</script>
</head>
<body style="margin : 1px">
<table id="dg" title="Manage Blog Type" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true" 
	url="${pageContext.request.contextPath}/admin/blogType/list.do" fit="true" toolbar="#tb">
	<thead>
		<tr>
			<th field="cd" checkbox="true" align="center"></th>
			<th field="id" width="20" align="center">ID</th>
			<th field="typeName" width="100" align="center">Blog Type Name</th>
			<th field="orderNo" width="100" align="center">Order number</th>			
		</tr>
	</thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:openBlogTypeAddTab()" class="easyui-linkbutton" iconCls="icon-add" plain="true">New</a>
		<a href="javascript:openBlogTypeModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">Edit</a>
		<a href="javascript:deleteBlogType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete</a>
	</div>
</div>
</body>
</html>