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
	var url;
		
	function openBlogTypeAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","Add a new blog type...");
		url="${pageContext.request.contextPath}/admin/blogType/save.do";
	}
	
	function openBlogTypeModifyDialog(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("System","Please select a blog type to edit!");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","Edit blog Type!");
		$("#fm").form("load",row);
		url="${pageContext.request.contextPath}/admin/blogType/save.do?id="+row.id;
	}
	
	function saveBlogType(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("System","Blog type saved!");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("System","Saving blog type failed!");
					return;
				}
			}
		});
	}
	
	function resetValue(){
		$("#typeName").val("");
		$("#orderNo").val("");
	}
	
	function closeBlogTypeDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	
	function deleteBlogType(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert("System","Please select a blog type to delete!");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("System","Please confirm to delete <font color=red>"+selectedRows.length+"</font> blog type.",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/admin/blogType/delete.do",{ids:ids},function(result){
					if(result.success){
						if(result.exist){
							$.messager.alert("System",result.exist);
						}else{
							$.messager.alert("System","Blog type deleted!");							
						}
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("System","Delete blog type failed!");
					}
				},"json");
			}
		});
	}
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
		<a href="javascript:openBlogTypeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">New</a>
		<a href="javascript:openBlogTypeModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">Edit</a>
		<a href="javascript:deleteBlogType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete</a>
	</div>
</div>

<div id="dlg" class="easyui-dialog" style="width:500px; height:180px; padding:10px 20px" closed="true" buttons="#dlg-buttons">
	<form id="fm" method="post">
		<table cellspacing="8px">
			<tr>
				<td>Blog type name:</td>
				<td>
					<input type="text" id="typeName" name="typeName" class="easyui-validatebox" required="true"/>	
				</td>
			</tr>
			<tr>
				<td>Blog type order number:</td>
				<td>
					<input type="text" id="orderNo" name="orderNo" class="easyui-numberbox" required="true" style="width: 60px"/>&nbsp;(Order numbers are used for sorting blog types.)	
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons">
	<a href="javascript:saveBlogType()" class="easyui-linkbutton" iconCls="icon-ok">Save</a>
	<a href="javascript:closeBlogTypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">Cancel</a>
</div>
</body>
</html>