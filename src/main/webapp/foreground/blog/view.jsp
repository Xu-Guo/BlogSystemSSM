<!--HighLighter  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
    SyntaxHighlighter.all();
    
    function showOtherComment(){
    	$(".otherComment").show();
    }
    
    function loadimage(){
		document.getElementById("randImage").src="${pageContext.request.contextPath}/image.jsp?"+Math.random();
	}
    
    function submitData(){
    	var content=$("#content").val();
    	var imageCode=$("#imageCode").val();
    	if(content==null||content==""){
    		alert("Please input reply!");
    	}else if(imageCode==null||imageCode==""){
    		alert("Please input verify code!");
    	}else{
    		$.post("${pageContext.request.contextPath}/comment/save.do",{"content":content,'imageCode':imageCode,'blog.id':'${blog.id}'},function(result){
    			if(result.success){
    				alert("Comment submit success and will be displayed when pass the check!");
    			}else{
    				alert(result.errorInfo);
    			}
    		},"json");
    	}
    }

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
			<font><strong>Keyword:</strong></font>
			<c:choose>
				<c:when test="${keyWords==null}">
					&nbsp;&nbsp;No keyword.
				</c:when>
				<c:otherwise>
					<c:forEach var="keyWord" items="${keyWords}">
						&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/q.html?q=${keyWord}" target="_blank">${keyWord }</a>&nbsp;&nbsp;
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="blog_lastAndNextPage">
			${pageCode}
		</div>
	</div>	
</div>

<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/comment_icon.png"/>
		Comment Information
		<c:if test="${commentList.size()>10 }">
			<a href="javascript:showOtherComment()" style="float: right;padding-right: 40px;">Show all comments</a>
		</c:if>
	</div>
	<div class="commentDatas">
		<c:choose>
			<c:when test="${commentList.size()==0 }">
				No comments
			</c:when>
			<c:otherwise>
				<c:forEach var="comment" items="${commentList}" varStatus="status">
					<c:choose>
						<c:when test="${status.index<10 }">
							<div class="comment">
								<span><font>#${status.index+1 }&nbsp;&nbsp;&nbsp;&nbsp;${comment.userIp }：</font>${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate value="${comment.commentDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>&nbsp;]</span>			
							</div>
						</c:when>
						<c:otherwise>
							<div class="otherComment">
								<span><font>#${status.index+1 }&nbsp;&nbsp;&nbsp;&nbsp;${comment.userIp }：</font>${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate value="${comment.commentDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>&nbsp;]</span>			
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>


<div class="data_list" >
	<div class="data_list_title">
		<img src="/static/images/publish_comment_icon.png"/>
		Publish comment
	</div>
	<div class="publish_comment">
			<div>
				<textarea style="width: 100%" rows="3" id="content" name="content" placeholder="Say something..."></textarea>
			</div>
			<div class="verCode">
				Code：<input type="text" value="" name="imageCode"  id="imageCode" size="10" onkeydown= "if(event.keyCode==13)form1.submit()"/>&nbsp;<img onclick="javascript:loadimage();"  title="Refresh" name="randImage" id="randImage" src="/image.jsp" width="60" height="20" border="1" align="absmiddle"> 
			</div>
			<div class="publishButton">
				<button class="btn btn-primary" type="button" onclick="submitData()">Publish comment</button>
			</div>
		</form>
	</div>
</div>