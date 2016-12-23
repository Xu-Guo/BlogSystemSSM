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
	function formatTitle(val,row){
		return "<a target='_blank' href='${pageContext.request.contextPath}/blog/articles/"+row.id+".html'>"+val+"</a>";
	}
	
	function formatBlogType(val,row){
		return val.typeName;
	}
	
	function searchBlog(){
		$("#dg").datagrid('load',{
			"title":$("#s_title").val()			
		});
	}
	
	function deleteBlog(){
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert("System","Please select records to delete.");
			return;
		}
		var strIds=[];
		for(var i = 0; i<selectedRows.length; i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("System","Please confirm to delete <font color=red>"+selectedRows.length+"</font> records.", function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/admin/blog/delete.do", {ids:ids}, function(result){
					if(result.success){
						$.messager.alert("System","Records deleted!");
						$("#dg").datagrid("reload");
					}else{
						$$.messager.alert("System","Delete records failed!");
					}
				}, "json")
			}
		});
	}
	
</script>
</head>
<body style="margin : 1px">
<table id="dg" title="Manage Blog" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true" 
	url="${pageContext.request.contextPath}/admin/blog/list.do" fit="true" toolbar="#tb">
	<thead>
		<tr>
			<th field="cd" checkbox="true" align="center"></th>
			<th field="id" width="20" align="center">ID</th>
			<th field="title" width="200" align="center" formatter="formatTitle">Title</th>
			<th field="releaseDate" width="50" align="center">Publish Date</th>
			<th field="blogType" width="50" align="center" formatter="formatBlogType">Blog Type</th>
		</tr>
	</thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">Edit</a>
		<a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete</a>
	</div>
	<div>
		&nbsp;Title&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()"/>
		<a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">Search</a>
	</div>
</div>
</body>
</html>