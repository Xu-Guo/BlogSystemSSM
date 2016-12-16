<!--HighLighter  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
    SyntaxHighlighter.all();
</script>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/blog_show_icon.png"/>
		Blog Information
	</div>
	<div>
		<div class="blog_title"><h3><strong>${blog.title }</strong></h3></div>
		<div class="blog_info">
			Published:[<fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>] &nbsp;&nbsp;BlogType:${blog.blogType.typeName }&nbsp;&nbsp;Read:(${blog.clickHit }) Reply:(${blog.replyHit })
		</div>
		<div class="blog_content">
		${blog.content }
		</div>
	</div>
</div>