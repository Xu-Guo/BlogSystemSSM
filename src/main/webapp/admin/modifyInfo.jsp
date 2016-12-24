<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Blogger Information</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>
<!-- Set English  -->
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/lang/en/en.js"></script>t>

<script type="text/javascript">
	

</script>
</head>
<body style="margin: 10px">

<div id="p" class="easyui-panel" title="Edit Information" style="padding: 10px">
	<form action="" method="post" enctype="multipart/form-data">
		<table cellspacing="20px">
			<tr>
				<td width="80px">User Name:</td>
				<td>
					<input type="hidden" id="id" name="id" value="${currentUser.id }"/>
					<input type="text" id="userName" name="userName" style="width: 200px" value="${currentUser.userName }" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>Nick Name</td>
				<td>
					<input type="text" id="nickName" name="nickName" style="width: 200px" value="${currentUser.nickName }" />
				</td>
			</tr>
			<tr>
				<td>Sign:</td>
				<td>
					<input type="text" id="sign" name="sign" style="width: 400px" value="${currentUser.sign }" />
				</td>
			</tr>
			<tr>
				<td>User Picture:</td>
				<td>
					<input type="file" id="imageFile" name="imageFile"/>
				</td>
			</tr>
			<tr>
				<td valign="top">User Information:</td>
				<td>
					<script id="profile" name="profile" type="text/plain" style="width:100%;height:500px;"></script>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">Submit</a>
				</td>
			</tr>
			
		</table>
	</form>
</div>


<script type="text/javascript">
    var ue = UE.getEditor('profile');
    
    ue.addListener("ready",function(){
    	// ajax request
    	UE.ajax.request("${pageContext.request.contextPath}/admin/blogger/find.do",
    			{
    				method:"post",
    				async:false,
    				data:{},
    				onsuccess:function(result){
    					result=eval("("+result.responseText+")");
    					UE.getEditor('profile').setContent(result.profile);
    				}
   			});
    });
</script>


</body>
</html>