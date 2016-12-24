<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Blog System Administration Page-Powered by java1234</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	function openTab(text,url,iconCls){
		if($("#tabs").tabs("exists",text)){
			$("#tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/admin/"+url+"'></iframe>";
			$("#tabs").tabs("add",{
				title:text,
				iconCls:iconCls,
				closable:true,
				content:content
			});
		}
	}

</script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 120px;background-color: #E0ECFF">
	<table style="padding: 5px" width="100%">
		<tr>
			<td width="50%">
				<img alt="logo" src="/static/images/logo.png">
			</td>
			<td valign="bottom" align="right" width="50%">
				<font size="3">&nbsp;&nbsp;<strong>Welcome：</strong>${currentUser.userName }</font>
			</td>
		</tr>
	</table>
</div>

<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="Home" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 100px"><font color="red" size="10">Welcome</font></div>
		</div>
	</div>
</div>

<div region="west" style="width: 200px" title="Menu" split="true">
	<div class="easyui-accordion" data-options="fit:true,border:false">
		<div title="Common operations" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
			<a href="javascript:openTab('New Blog','writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">New Blog</a>
			<a href="javascript:openTab('View comments','commentReview.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">View comments</a>
		</div>
		<div title="Manage Blogs"  data-options="iconCls:'icon-bkgl'" style="padding:10px;">
			<a href="javascript:openTab('New Blog','writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">New Blog</a>
			<a href="javascript:openTab('Blog Information','blogManage.jsp','icon-bkgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">Manage Blogs</a>
		</div>
		<div title="Manage BlogType" data-options="iconCls:'icon-bklb'" style="padding:10px">
			<a href="javascript:openTab('Manage Blog Type','blogTypeManage.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">Manage Blog Type</a>
		</div>
		<div title="Manage Comments"  data-options="iconCls:'icon-plgl'" style="padding:10px">
			<a href="javascript:openTab('View Comments','commentReview.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">Review Comments</a>
			<a href="javascript:openTab('Manage Comments','commentManage.jsp','icon-plgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">Manage Comments</a>
		</div>
		<div title="Manage User Information"  data-options="iconCls:'icon-grxx'" style="padding:10px">
			<a href="javascript:openTab('Change User Information','modifyInfo.jsp','icon-grxxxg')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">Change User Information</a>
		</div>
		<div title="Manage System"  data-options="iconCls:'icon-system'" style="padding:10px">
		    <a href="javascript:openTab('Manage Friend Link','linkManage.jsp','icon-link')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">Manage Friend Link</a>
			<a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">Change Password</a>
			<a href="javascript:refreshSystem()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">Refresh System</a>
			<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">Log out</a>
		</div>
	</div>
</div>


<div region="south" style="height: 25px;padding: 5px" align="center">
	Copyright © 2012-2016 Xu-Guo

</body>
</html>