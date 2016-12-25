<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Manage Links</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-en.js"></script>
<script type="text/javascript">
	var url;
		
	function openLinkAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","Add a new link...");
		url="${pageContext.request.contextPath}/admin/link/save.do";
	}
	
	function openLinkModifyDialog(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("System","Please select a link to edit!");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","Edit link!");
		$("#fm").form("load",row);
		url="${pageContext.request.contextPath}/admin/link/save.do?id="+row.id;
	}
	
	function saveLink(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("System","Link type saved!");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("System","Saving Link failed!");
					return;
				}
			}
		});
	}
	
	function resetValue(){
		$("#linkName").val("");
		$("#linkUrl").val("");
		$("#orderNo").val("");
	}
	
	function closeLinkDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	
	function deleteLink(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert("System","Please select a link to delete!");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("System","Please confirm to delete <font color=red>"+selectedRows.length+"</font> link.",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/admin/link/delete.do",{ids:ids},function(result){
					if(result.success){
						$.messager.alert("System","Link deleted!");							
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("System","Delete link failed!");
					}
				},"json");
			}
		});
	}
</script>
</head>
<body style="margin : 1px">
<table id="dg" title="Manage Link" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true" 
	url="${pageContext.request.contextPath}/admin/link/list.do" fit="true" toolbar="#tb">
	<thead>
		<tr>
			<th field="cd" checkbox="true" align="center"></th>
			<th field="id" width="20" align="center">ID</th>
			<th field="linkName" width="200" align="center">Link Name</th>
			<th field="linkUrl" width="200" align="center">Link Address</th>
			<th field="orderNo" width="100" align="center">Order number</th>			
		</tr>
	</thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:openLinkAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">New</a>
		<a href="javascript:openLinkModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">Edit</a>
		<a href="javascript:deleteLink()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete</a>
	</div>
</div>

<div id="dlg" class="easyui-dialog" style="width:500px; height:200px; padding:10px 20px" closed="true" buttons="#dlg-buttons">
	<form id="fm" method="post">
		<table cellspacing="8px">
			<tr>
				<td>Link name:</td>
				<td>
					<input type="text" id="LinkName" name="LinkName" class="easyui-validatebox" required="true"/>	
				</td>
			</tr>
			<tr>
				<td>Link Url:</td>
				<td>
					<input type="text" id="LinkUrl" name="LinkUrl" class="easyui-validatebox" validType="url" required="true" style="width: 250px"/>	
				</td>
			</tr>
			<tr>
				<td>Link order number:</td>
				<td>
					<input type="text" id="orderNo" name="orderNo" class="easyui-numberbox" required="true" style="width: 60px"/>&nbsp;(Order numbers are used for sorting links.)	
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons">
	<a href="javascript:saveLink()" class="easyui-linkbutton" iconCls="icon-ok">Save</a>
	<a href="javascript:closeLinkDialog()" class="easyui-linkbutton" iconCls="icon-cancel">Cancel</a>
</div>
</body>
</html>