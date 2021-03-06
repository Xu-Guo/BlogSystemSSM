<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit Blog</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-en.js"></script>

<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>
<!-- Set English  -->
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/lang/en/en.js"></script>

<script type="text/javascript">
	
	function submitData(){
		var title=$("#title").val();
		var blogTypeId=$("#blogTypeId").combobox("getValue")
		var content=UE.getEditor('editor').getContent()
		var keyWord=$("#keyWord").val();
		
		if(title==null || title==''){
			alert("Please input title!");
		}else if(blogTypeId==null || blogTypeId==''){
			alert("Please select a blog type!");
		}else if(content==null || content==''){
			alert("Please write some content!");
		}else{
			$.post("${pageContext.request.contextPath}/admin/blog/save.do",{'id':'${param.id}','title':title,'blogType.id':blogTypeId,
				'contentNoTag':UE.getEditor('editor').getContentTxt(),
				'content':content,'summary':UE.getEditor('editor').getContentTxt().substr(0,155),'keyWord':keyWord},function(result){
				if(result.success){
					alert("Edit blog success!");
				}else{
					alert("Edit blog failed!");
				}
			},"json");
		}
	}
	

</script>
</head>
<body style="margin: 10px">

<div id="p" class="easyui-panel" title="Edit Blog" style="padding: 10px">
	<table cellspacing="20px">
		<tr>
			<td width="80px">Blog Title:</td>
			<td>
				<input type="text" id="title" name="title" style="width: 400px"/>
			</td>
		</tr>
		<tr>
			<td>Blog Type:</td>
			<td>
				<select class="easyui-combobox" style="width: 154px" id="blogTypeId" name="blogType.id" editable="false" panelHeight="auto">
					<option value="">Please select a blog type...</option>
					<c:forEach var="blogType" items="${blogTypeCountList }">
						<option value="${blogType.id }">${blogType.typeName }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td valign="top">Content:</td>
			<td>
				<script id="editor" name="content" type="text/plain" style="width:100%;height:500px;"></script>
			</td>
		</tr>
		<tr>
			<td>Keyword:</td>
			<td>
				<input type="text" id="keyWord" name="keyWord" style="width: 400px"/>&nbsp; Use "space" between multiple keywords.
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">Publish Blog</a>
			</td>
		</tr>
	</table>
</div>

<!-- instance uedit -->
<script type="text/javascript">
    var ue = UE.getEditor('editor');
    
    ue.addListener("ready",function(){
    	// ajax request data
    	UE.ajax.request("${pageContext.request.contextPath}/admin/blog/findById.do",
			{
				method:"post",
				async:false,
				data:{"id":"${param.id}"},
				onsuccess:function(result){
					result=eval("("+result.responseText+")");
					$("#title").val(result.title);
					$("#keyWord").val(result.keyWord);
					$("#blogTypeId").combobox("setValue",result.blogType.id);
					UE.getEditor('editor').setContent(result.content);
				}
			});
    });
</script>



</body>
</html>