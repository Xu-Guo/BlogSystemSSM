<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<title>Blogger home page</title>
<style>
	body{
		padding-top:40px;
		padding-bottom:40px;
	}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-4">
			<img alt="java blog system" src="${pageContext.request.contextPath}/static/images/logo.png">
		</div>
		<div class="col-md-8" style="padding-top:20px;">
			<span style='float: right; display:block !important; width: 488px; text-align: center; font-family: sans-serif; font-size: 12px;'>
			<a href='http://www.wunderground.com/cgi-bin/findweather/getForecast?query=San Francisco, CA' title='San Francisco, CA Weather Forecast'>
			<img src='http://weathersticker.wunderground.com/weathersticker/big2_cond/language/english/US/CA/San_Francisco.gif' alt='Find more about Weather in San Francisco, CA'/></a><br>
			<a href='http://www.wunderground.com' title='Get latest Weather Forecast updates' style='font-family: sans-serif; font-size: 12px;'>Click for weather forecast</a>
			</span>
		</div>
	</div>
	<div class="row" style="padding-top:20px;">
		<div class="col-md-12">
			<nav class="navbar navbar-default" role="navigation" >
			  <div class="container-fluid" >
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header" >
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#"><font color="black"><strong>Home Page</strong></font></a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
			      <ul class="nav navbar-nav">
			        <li ><a href="#"><font color="black"><strong>Author</strong></font></a></li>
			        <li ><a href="#"><font color="black"><strong>Source Code</strong></font></a></li>
			      </ul>
			      <form class="navbar-form navbar-right" role="search">
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="Search">
			        </div>
			        <button type="submit" class="btn btn-default">Search</button>
			      </form>
			      <ul class="nav navbar-nav navbar-right">
<!-- 			        <li><a href="#">Link</a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><a href="#">Action</a></li>
			            <li><a href="#">Another action</a></li>
			            <li><a href="#">Something else here</a></li>
			            <li class="divider"></li>
			            <li><a href="#">Separated link</a></li>
			          </ul>
			        </li> -->
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>			
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-9">
			<div class="data_list">
				<div class="data_list_title">Latest Article</div>
				<div class="datas">
					<ul>
						<li style="margin-bottom: 30px">
							<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/229.html">2016年12月03日</a></span>
						  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/229.html">Java多线程-多线程的引入</a></span>
						  	<span class="summary">摘要: Java多线程-多线程的引入定义：同时对多项任务加以控制；什么是多线程呢，我可以简单的理解成 一边吃饭，一边听音乐 这个是多线程；假如  吃完饭再听音乐，或者先听音乐再吃饭，这个是单线程。程序里同时执行多个任务并且加以控制 这个是java多线程的含义。同时干多个事，能充分利用cpu 内存等硬件设备，提高程序运...</span>
						  	<span class="img">
						  	
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/1.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/2.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/3.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
						  		
						  	</span>
						  	<span class="info">发表于 2016-12-03 16:45 阅读(108) </span>
						</li>
							<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
							<li style="margin-bottom: 30px">
							<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/229.html">2016年12月03日</a></span>
						  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/229.html">Java多线程-多线程的引入</a></span>
						  	<span class="summary">摘要: Java多线程-多线程的引入定义：同时对多项任务加以控制；什么是多线程呢，我可以简单的理解成 一边吃饭，一边听音乐 这个是多线程；假如  吃完饭再听音乐，或者先听音乐再吃饭，这个是单线程。程序里同时执行多个任务并且加以控制 这个是java多线程的含义。同时干多个事，能充分利用cpu 内存等硬件设备，提高程序运...</span>
						  	<span class="img">
						  	
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/1.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/2.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/3.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
						  		
						  	</span>
						  	<span class="info">发表于 2016-12-03 16:45 阅读(108) </span>
						</li>
							<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
							<li style="margin-bottom: 30px">
							<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/229.html">2016年12月03日</a></span>
						  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/229.html">Java多线程-多线程的引入</a></span>
						  	<span class="summary">摘要: Java多线程-多线程的引入定义：同时对多项任务加以控制；什么是多线程呢，我可以简单的理解成 一边吃饭，一边听音乐 这个是多线程；假如  吃完饭再听音乐，或者先听音乐再吃饭，这个是单线程。程序里同时执行多个任务并且加以控制 这个是java多线程的含义。同时干多个事，能充分利用cpu 内存等硬件设备，提高程序运...</span>
						  	<span class="img">
						  	
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/1.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/2.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/3.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
						  		
						  	</span>
						  	<span class="info">发表于 2016-12-03 16:45 阅读(108) </span>
						</li>
							<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
					</ul>
					
				</div>
			</div>
		</div>

		<div class="col-md-3">
		
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>
					Blogger Information
				</div>
				<div class="user_image">
					<img src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName}"/>
				</div>
				<div class="nickName">${blogger.nickName}</div>
				<div class="userSign">${blogger.sign}</div>
			</div>
		
	
		
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
					按日志类别
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="blogTypeCount" items="${blogTypeCountList}">
							<li><span><a href="#">${blogTypeCount.typeName}(${blogTypeCount.blogCount})</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
					按日志日期
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="blogCount" items="${blogCountList}">
							<li><span><a href="#">${blogCount.releaseDateStr}(${blogCount.blogCount})</a></span></li>
						</c:forEach>
							
					</ul>
				</div>
			</div>
		
		
			<div class="data_list">
				<div class="data_list_title">
				<img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
				友情链接
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="link" items="${linkList}">
							<li><span><a href="${link.linkUrl}" target="_blank">${link.linkName}</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
		
		
</div>
</body>
</html>
