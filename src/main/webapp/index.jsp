<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/blog.css">
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<title>陈不二的博客</title>
<style type="text/css">
body {
	padding-top: 10px;
	padding-bottom: 40px;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="/pages/FE/template/header.jsp"></jsp:include>

		<jsp:include page="/pages/FE/template/navigator.jsp"></jsp:include>

		<div class="row">
			<div class="col-md-9">
				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/list_icon.png" />
						最新博客
					</div>

					<div class="datas">
						<ul>
							<c:forEach var="blog" items="${blogPageList }">

								<li style="margin-bottom: 30px">
								<span class="date">
									<a href="${pageContext.request.contextPath}/blog/articles/52.html">
										<fmt:formatDate pattern="yyyy年MM月dd日" value="${blog.releaseDate}"/>
									</a>
								</span>
									<span class="title"><a
										href="${pageContext.request.contextPath}/blog/articles/52.html">${blog.title }</a></span>
									<span class="summary">摘要:${blog.summary }...</span> 
									<!-- 
									<span class="img"> <a href="/blog/articles/52.html"><img
											src="${pageContext.request.contextPath}/static/userImages/a.jpg"
											alt="1455539511890048174.jpg"></a> &nbsp;&nbsp; <a
										href="/blog/articles/52.html"><img
											alt="QQ鎴浘20160215203213.jpg"
											src="${pageContext.request.contextPath}/static/userImages/b.jpg"
											title="1455539700734093102.jpg" width="667" height="264"
											style="width: 667px; height: 264px;"></a> &nbsp;&nbsp; <a
										href="/blog/articles/52.html"><img
											alt="QQ鎴浘20160215203317.jpg"
											src="${pageContext.request.contextPath}/static/userImages/c.jpg"
											title="1455539761187019902.jpg"></a> &nbsp;&nbsp;
									</span> 
								 -->
								<span class="info">发表于 <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${blog.releaseDate}"/>
								 阅读(${blog.clickHit }) 评论(${blog.replyHit }) </span></li>
								<hr
									style="height: 5px; border: none; border-top: 1px dashed gray; padding-bottom: 10px;" />
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>





			<div class="col-md-3">
				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/user_icon.png" />
						博主信息
					</div>
					<div class="user_image">
						<!-- <img src="${pageContext.request.contextPath}/static/userImages/20160202095456.png"/> -->
						<img
							src="http://www.sinaimg.cn/dy/slidenews/4_img/2014_39/704_1429733_253181.jpg" />
					</div>
					<div class="nickName">${blogger.userName }</div>
					<div class="userSign">${blogger.sign }</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/byType_icon.png" />
						按日志类别
					</div>
					<div class="datas">
						<ul>
							<c:forEach var="blogType" items="${blogTypeCountList }">
								<li><span><a href="/index.html?typeId=1">${blogType.typeName }(${blogType.blogCount })</a></span></li>
							</c:forEach>

						</ul>
					</div>
				</div>



				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/byDate_icon.png" />
						按日志日期
					</div>
					<div class="datas">
						<ul>
							<c:forEach items="${blogCountList }" var="blog">
								<li><span><a
										href="/index.html?releaseDateStr=2016年02月">${blog.releaseDateStr }(${blog.blogCount })</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/link_icon.png" />
						友情链接test
					</div>
					<div class="datas">
						<ul>

							<c:forEach items="${linkList }" var="link">
								<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>

			</div>
		</div>

		<jsp:include page="/pages/FE/template/footer.jsp"></jsp:include>


	</div>
</body>
</html>