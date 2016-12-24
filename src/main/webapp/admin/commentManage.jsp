<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment Management</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

 	function formatBlogTitle(val, row){
 		if(val==null){
 			return "<font color='red'>Blog has been deleted!</font>";
 		}else{
 			return "<a target='_blank' href='${pageContext.request.contextPath}/blog/articles/"+val.id+".html'>"+val.title+"</a>";
 		}
 	}
 	
 	function formatState(val, row){
 		if(val==0){
 			return "Not yet reviewed!"
 		}else if(val==1){
 			return "Review passed!"
 		}else{
 			return "Declined!"
 		}
 	}
 	
 	function deleteComment(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert("System","Please select comment to delete!");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("System","Please confirm to delete the selected <font color=red>"+selectedRows.length+"</font> comments.",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/admin/comment/delete.do",{ids:ids},function(result){
					if(result.success){
						$.messager.alert("System","Comments deleted!");							
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("System","Operation failed!");
					}
				},"json");
			}
		});
	}
 	
</script>
</head>
<body style="margin: 1px">
<table id="dg" title="Manage Comments" class="easyui-datagrid" 
  fitColumns="true" pagination="true" rownumbers="true"
  url="${pageContext.request.contextPath}/admin/comment/list.do" fit="true" toolbar="#tb">
  <thead>
  	<tr>
  		<th field="cb" checkbox="true" align="center"></th>
  		<th field="id" width="20" align="center">ID</th>
  		<th field="blog" width="200" align="center" formatter="formatBlogTitle">Blog Title</th>
  		<th field="userIp" width="100" align="center">User IP</th>
  		<th field="content" width="200" align="center">Comment</th>
  		<th field="commentDate" width="50" align="center">Publish Date</th>
  		<th field="state" width="50" align="center" formatter="formatState">Comment State</th>
  	</tr>
  </thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:deleteComment()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete</a>
	</div>
</div>


</body>
</html>