<!--HighLighter  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
    SyntaxHighlighter.all();
</script>

<script type="text/javascript">var switchTo5x=true;</script>
<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">stLight.options({publisher: "9abc2874-524d-4bdf-aea6-fb9b29223c08", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>

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
		<div align="center";padding-bottom: 20px;>
			<span class='st_sharethis' displayText='ShareThis'></span>
			<span class='st_facebook' displayText='Facebook'></span>
			<span class='st_twitter' displayText='Tweet'></span>
			<span class='st_linkedin' displayText='LinkedIn'></span>
			<span class='st_pinterest' displayText='Pinterest'></span>
			<span class='st_email' displayText='Email'></span>
		</div>
		<div class="blog_info" >
			Published:[<fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>] &nbsp;&nbsp;BlogType:${blog.blogType.typeName }&nbsp;&nbsp;Read:(${blog.clickHit }) Reply:(${blog.replyHit })
		</div>
		<div class="blog_content">
			${blog.content }
			<div class="blog_keyWord">
				<font><strong>Key Word:</strong></font>
				<c:choose>
					<c:when test="${keyWords==null}">
						&nbsp;&nbsp;No keyword.
					</c:when>
					<c:otherwise>
						<c:forEach var="keyWord" items="${keyWords}">
							&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" target="_blank">${keyWord }</a>&nbsp;&nbsp;
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="blog_lastAndNextPage">
				${pageCode}
			</div>
		</div>
	</div>
</div>