<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="data_list">
		<div class="data_list_title">
		<img src="/static/images/search_icon.png"/>
		Search result for keyword &nbsp;<font color="red">"${q}"</font>&nbsp; &nbsp;(Total:&nbsp;${resultTotal}&nbsp;records) </div>
		<div class="datas search">
		  <ul>
		  	<c:choose>
		  		<c:when test="${blogList.size()==0 }">
		  			<div align="center" style="padding-top: 20px">No records been found，try another keyword！</div>
		  		</c:when>
		  		<c:otherwise>
		  			<c:forEach var="blog" items="${blogList}">
		  				<li style="margin-bottom: 20px">
						  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id }.html" target="_blank">${blog.title }</a></span>
						  	<span class="summary">Summary:${blog.content }...</span>
						  	<span class="link"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id }.html">http://blog.java1234.com/blog/articles/${blog.id }.html</a>&nbsp;&nbsp;&nbsp;&nbsp;Publish date:${blog.releaseDateStr }</span>
						  </li>
		  			</c:forEach>
		  		</c:otherwise>
		  	</c:choose>
		  </ul>
		</div>
		
</div>
${pageCode}
