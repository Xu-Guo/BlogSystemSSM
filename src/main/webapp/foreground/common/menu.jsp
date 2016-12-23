<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script type="text/javascript">
	
	function checkData(){
		var q=document.getElementById("q").value.trim();
		if(q==null || q==""){
			alert("请输入您要查询的关键字！");
			return false;
		}else{
			return true;
		}
	}

</script>
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
		      <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html"><font color="black"><strong>Home Page</strong></font></a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
		      <ul class="nav navbar-nav">
		        <li ><a href="${pageContext.request.contextPath}/blogger/aboutMe.html"><font color="black"><strong>Author</strong></font></a></li>
		        <li ><a href="${pageContext.request.contextPath}/download.html"><font color="black"><strong>Source Code</strong></font></a></li>
		      </ul>
		      <form action="${pageContext.request.contextPath}/blog/q.html" class="navbar-form navbar-right" role="search" method="post" onsubmit="return checkData()">
		        <div class="form-group">
		          <input type="text" id="q" name="q" value="${q}" class="form-control" placeholder="Search">
		        </div>
		        <button type="submit" class="btn btn-default">Search</button>
		      </form>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>			
	</div>
</div>